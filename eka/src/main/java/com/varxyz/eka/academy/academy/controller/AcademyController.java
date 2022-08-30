package com.varxyz.eka.academy.academy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;
import com.varxyz.eka.auth.service.AuthService;
import com.varxyz.eka.review.domain.Review;
import com.varxyz.eka.review.service.ReviewServiceImp;
import com.varxyz.eka.student.domain.Student;

@Controller
public class AcademyController {
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private AuthService authService;
	@Autowired
	private ReviewServiceImp reviewService;

	@GetMapping("/eka_main/myPage")
	public ModelAndView myPageGet(HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println("<script>alert('로그인을 해주세요'); </script>");
		out.flush();
		mav.setViewName("eka_main/main");

		return mav;
	}

	@PostMapping("/eka_main/myPage")
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		String academyId = request.getParameter("academyId");
		String ekauserId = request.getParameter("ekauserId");
		String academyName = null;

		if (academyId != null && academyId != "") {
			Long academyIdL = Long.parseLong(academyId);

			if (!academyId.equals("0")) {
				academyName = academyService.findAcademyByAid(academyIdL).getName();
			}

			mav.addObject("academyName", academyName);
			mav.setViewName("eka_main/myPage");
		} else if (ekauserId != null && ekauserId != "") {
			List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
			List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
			List<String> academyNameList = new ArrayList<String>();

			for (int i = 0; i < academyIdList.size(); i++) {
				academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
			}

			mav.addObject("academyNameList", academyNameList);
			mav.setViewName("eka_main/myPage_ekaUser");
		}

		return mav;
	}

	@PostMapping("/eka_main/myPage_update")
	public ModelAndView myPage_update(HttpServletRequest request, HttpSession session, AcademyManager academyManager,
			EkaUser ekaUser) {

		ModelAndView mav = new ModelAndView();

		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String aid = request.getParameter("aid");
		String eid = request.getParameter("eid");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String academyName = request.getParameter("academyName");

		if (aid != null && eid == null || eid == "") {
			authService.updateAcademyManager(password, name, ssn, phone, aid);
			academyManager.setUserId(userId);
			academyManager.setUserPw(userPw);
			session.setAttribute("manager",
					authService.loginManager(academyManager.getUserId(), academyManager.getUserPw()));

			mav.addObject("academyName", academyName);
			mav.setViewName("eka_main/myPage");

		} else {
			authService.updateEkaUser(password, name, ssn, phone, email, eid);
			ekaUser.setUserId(userId);
			ekaUser.setUserPw(userPw);
			session.setAttribute("ekauser", authService.loginEkaUsers(ekaUser.getUserId(), ekaUser.getUserPw()));

			mav.addObject("academyNameList", academyName);
			mav.setViewName("eka_main/myPage_ekaUser");
		}

		return mav;
	}

	@GetMapping("/eka_main/ekaUser_list")
	public ModelAndView ekaUser_list(HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println("<script>alert('정상적인 경로로 접근 해주세요'); </script>");
		out.flush();
		mav.setViewName("eka_main/main");

		return mav;
	}

	@PostMapping("/eka_main/ekaUser_list")
	public ModelAndView ekaUser_list(HttpServletResponse response, HttpServletRequest request) {

		String ekauserId = request.getParameter("ekauserId");
		String ekauserEid = request.getParameter("ekauserEid");
		Long ekauserEidL = Long.parseLong(ekauserEid);

		ModelAndView mav = new ModelAndView();

		List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
		List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
		List<String> academyNameList = new ArrayList<String>();

		for (int i = 0; i < academyIdList.size(); i++) {
			academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
		}

		List<Review> reviewList = reviewService.findReviewByekaUserId(ekauserEidL);
		List<Long> reviewRidList = reviewList.stream().map(Review::getRid).collect(Collectors.toList());
		List<Long> reviewAcademyIdList = reviewList.stream().map(Review::getAcademyId).collect(Collectors.toList());

		List<String> reviewAcademyNameList = new ArrayList<String>();
		for (int i = 0; i < reviewAcademyIdList.size(); i++) {
			reviewAcademyNameList.add(academyService.findAcademyByAid(reviewAcademyIdList.get(i)).getName());
		}

		List<String> reviewCommentList = reviewList.stream().map(Review::getComment).collect(Collectors.toList());
		List<Integer> reviewScoreList = reviewList.stream().map(Review::getReviewScore).collect(Collectors.toList());
		List<Date> reviewRegDateList = reviewList.stream().map(Review::getRegDate).collect(Collectors.toList());

		mav.addObject("academyNameList", academyNameList);
		mav.addObject("academyIdList", academyIdList);
		mav.addObject("reviewRidList", reviewRidList);
		mav.addObject("reviewAcademyIdList", reviewAcademyIdList);
		mav.addObject("reviewAcademyNameList", reviewAcademyNameList);
		mav.addObject("reviewCommentList", reviewCommentList);
		mav.addObject("reviewScoreList", reviewScoreList);
		mav.addObject("reviewRegDateList", reviewRegDateList);

		mav.setViewName("eka_main/myPage_ekaUser_list");

		return mav;
	}

	@PostMapping("/eka_main/logOut")
	public String logOut(HttpSession session, HttpServletResponse response) {
		session.invalidate();

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0L);

		return "eka_main/main";
	}

	@GetMapping("/eka_main/main")
	public String main() {
		return "eka_main/main";
	}

	@PostMapping("/eka_main/main")
	public String postMain() {
		return "eka_main/main";
	}

	@GetMapping("eka_main/notice")
	public String notice() {
		return "eka_main/notice";
	}

	@GetMapping("eka_main/add_academy")
	public String addacademy() {
		return "eka_main/add_academy";
	}

	@GetMapping("/eka_main/find_academy")
	public ModelAndView find_academy(HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println("<script>alert('정상적인 경로로 접근 해주세요'); </script>");
		out.flush();
		mav.setViewName("eka_main/main");

		return mav;
	}

	@PostMapping("/eka_main/find_academy")
	public ModelAndView find_academy(HttpSession session, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		String sLat = request.getParameter("lat");
		Double dLat = Double.parseDouble(sLat);
		String sLon = request.getParameter("lon");
		Double dLon = Double.parseDouble(sLon);

		ModelAndView mav = new ModelAndView();

		List<Academy> allAcademyList = academyService.findAcademyByName(keyword);

		List<Long> allAidList = allAcademyList.stream().map(Academy::getAid).collect(Collectors.toList());
		System.out.println("allAidList 완료");

		List<BigDecimal> averageScoreList = new ArrayList<>();
		List<Integer> reviewNumList = new ArrayList<>();
		for (int i = 0; i < allAidList.size(); i++) {
			List<Review> reviewList = reviewService.findReviewByAcademyId(allAidList.get(i));
			List<Integer> reviewScoreList = reviewList.stream().map(Review::getReviewScore)
					.collect(Collectors.toList());

			double allScore = 0.0;

			for (int j = 0; j < reviewScoreList.size(); j++) {
				if (reviewScoreList.get(j) == 5) {
					allScore += reviewScoreList.get(j);
				} else if (reviewScoreList.get(j) == 4) {
					allScore += reviewScoreList.get(j);
				} else if (reviewScoreList.get(j) == 3) {
					allScore += reviewScoreList.get(j);
				} else if (reviewScoreList.get(j) == 2) {
					allScore += reviewScoreList.get(j);
				} else if (reviewScoreList.get(j) == 1) {
					allScore += reviewScoreList.get(j);
				}
			}
			
			reviewNumList.add(reviewScoreList.size());
			

			BigDecimal reviewScoreListB = null;
			BigDecimal allScoreB = null;
			BigDecimal averageScore = null;

			if (allScore != 0.0) {
				allScoreB = new BigDecimal(String.valueOf(allScore));
				reviewScoreListB = new BigDecimal(String.valueOf(reviewScoreList.size()));

				averageScore = allScoreB.divide(reviewScoreListB, 1, BigDecimal.ROUND_CEILING);
			}
			
			averageScoreList.add(averageScore);
		}

		List<String> allNameList = allAcademyList.stream().map(Academy::getName).collect(Collectors.toList());
		System.out.println("allNameList 완료");
		List<String> allAddressList = allAcademyList.stream().map(Academy::getAddress).collect(Collectors.toList());
		System.out.println("allAddressList 완료");
		List<String> allDetailAddressList = allAcademyList.stream().map(Academy::getDetailaddress)
				.collect(Collectors.toList());
		List<String> allLatList = allAcademyList.stream().map(Academy::getLat).collect(Collectors.toList());
		System.out.println("allLatList 완료");
		List<String> allLonList = allAcademyList.stream().map(Academy::getLon).collect(Collectors.toList());
		System.out.println("allLonList 완료");

		List<Double> distanceList = new ArrayList<>();

		// 킬로미터(Kilo Meter) 단위
		for (int i = 0; i < allLatList.size(); i++) {
			distanceList.add(academyService.distance(dLat, dLon, Double.parseDouble(allLatList.get(i)), Double.parseDouble(allLonList.get(i)), "kilometer"));
		}

		System.out.println();

		mav.addObject("user_lat", sLat);
		mav.addObject("user_lon", sLon);
		mav.addObject("allAidList", allAidList);
		mav.addObject("averageScoreList", averageScoreList);
		mav.addObject("reviewNumList", reviewNumList);
		mav.addObject("allNameList", allNameList);
		mav.addObject("allAddressList", allAddressList);
		mav.addObject("allLatList", allLatList);
		mav.addObject("allLonList", allLonList);
		mav.addObject("allDetailAddressList", allDetailAddressList);
		mav.addObject("distanceList", distanceList);
		mav.addObject("keyword", keyword);
		mav.setViewName("eka_main/find_academy");

		return mav;
	}

	@GetMapping("eka_main/list_academy")
	public String getListAcademy(HttpServletRequest request) {
		return "eka_main/list_academy";
	}

	@PostMapping("eka_main/list_academy")
	public ModelAndView listAcademy(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String sLat = request.getParameter("lat");
		String sLon = request.getParameter("lon");
		double clat = Double.parseDouble(sLat);
		double clon = Double.parseDouble(sLon);

		String sAddr = request.getParameter("addr");
		String categoryNumString = request.getParameter("categoryNum");
		int categoryNum = Integer.parseInt(categoryNumString);

		List<Long> aidList = new ArrayList();
		List<String> latList = new ArrayList();
		List<String> lonList = new ArrayList();
		List<String> nameList = new ArrayList();
		List<String> addressList = new ArrayList();
		List<String> detailAddressList = new ArrayList();
		String[] categoryList = { "전체", "간호보조기술", "경영·사무관리", "국제", "기예(중)", "기타(중)", "독서실", "독서실(중)", "보통교과", "산업기반기술",
				"산업서비스", "산업응용기술", "예능(중)", "외국어", "인문사회(중)", "일반서비스", "진학지도", "컴퓨터" };

		String selectedCategory = categoryList[categoryNum];

		List<Academy> allAcademyList = null;

		if (selectedCategory.equals("전체")) {
			allAcademyList = academyService.findAllAcademies();
		} else {
			allAcademyList = academyService.findAcademiesByCategory(selectedCategory);
		}

		List<Long> allAidList = allAcademyList.stream().map(Academy::getAid).collect(Collectors.toList());
		System.out.println("allAidList 완료");
		List<String> allNameList = allAcademyList.stream().map(Academy::getName).collect(Collectors.toList());
		System.out.println("allNameList 완료");
		List<String> allAddressList = allAcademyList.stream().map(Academy::getAddress).collect(Collectors.toList());
		System.out.println("allAddressList 완료");
		List<String> allDetailAddressList = allAcademyList.stream().map(Academy::getDetailaddress)
				.collect(Collectors.toList());
		System.out.println("allDetailAddressList 완료");
		List<String> allLatList = allAcademyList.stream().map(Academy::getLat).collect(Collectors.toList());
		System.out.println("allLatList 완료");
		List<String> allLonList = allAcademyList.stream().map(Academy::getLon).collect(Collectors.toList());
		System.out.println("allLonList 완료");

		for (int i = 0; i < allNameList.size(); i++) { // 괄호 안에 조건 넣어주기

			// 하버사인 공식 (검색지점으로부터의 거리 계산)
			double distance;
			double radius = 6371; // 지구 반지름(km)
			double toRadian = Math.PI / 180;

			double locationlat = Double.parseDouble(allLatList.get(i));
			double locationlng = Double.parseDouble(allLonList.get(i));

			double deltaLatitude = Math.abs(clat - locationlat) * toRadian;
			double deltaLongitude = Math.abs(clon - locationlng) * toRadian;

			double sinDeltaLat = Math.sin(deltaLatitude / 2);
			double sinDeltaLng = Math.sin(deltaLongitude / 2);
			double squareRoot = Math.sqrt(sinDeltaLat * sinDeltaLat
					+ Math.cos(clat * toRadian) * Math.cos(locationlat * toRadian) * sinDeltaLng * sinDeltaLng);

			distance = 2 * radius * Math.asin(squareRoot);

			// 검색기준지점으로부터 하버사인 거리가 1km 미만인 클래스만 카카오맵에 출력

			if (distance < 1) {
//				System.out.println(distance);

				aidList.add(allAidList.get(i));
				latList.add(allLatList.get(i));
				lonList.add(allLonList.get(i));
				nameList.add(allNameList.get(i));
				addressList.add(allAddressList.get(i));
				detailAddressList.add(allDetailAddressList.get(i));
			}
		}

		mav.addObject("user_lat", sLat);
		mav.addObject("user_lon", sLon);
		mav.addObject("user_address", sAddr);
		mav.addObject("aidList", aidList);
		mav.addObject("latList", latList);
		mav.addObject("lonList", lonList);
		mav.addObject("nameList", nameList);
		mav.addObject("addressList", addressList);
		mav.addObject("detailAddressList", detailAddressList);
		mav.addObject("categoryNum", categoryNum);
		mav.setViewName("eka_main/list_academy");

		return mav;
	}

	@PostMapping("eka_main/select_academies_by_address")
	public String selectAcademiesByAddress(Model model, @RequestParam String address) {
		List<Academy> academyList = academyService.findAcademiesByAddress(address);

		model.addAttribute("academyList", academyList);
		model.addAttribute("address", address);
		return "eka_main/add_academy";
	}

	@PostMapping("eka_main/signed_eka_academy")
	public String signedEkaAcademy(HttpSession session, Model model, @RequestParam String address,
			@RequestParam String name, @RequestParam String phone1, @RequestParam String phone2,
			@RequestParam String phone3, @RequestParam String service, @RequestParam String runDay,
			@RequestParam String startRunTime, @RequestParam String endRunTime, @RequestParam String coDay,
			@RequestParam String startCoTime, @RequestParam String endCoTime, @RequestParam String introduction) {
		String[] namelist = name.split(",");
		name = namelist[0];

		String[] phone1list = phone1.split(",");
		phone1 = phone1list[0];
		String phone = phone1 + "-" + phone2 + "-" + phone3;

		System.out.println("운영 시간 : " + startRunTime + "/" + endRunTime);
		System.out.println("상담 시간 : " + startCoTime + "/" + endCoTime);

		Academy academy = academyService.findAcademyByAddressAndName(address, name);

		academy.setPhone(phone);
		academy.setIntroduction(introduction);
		academy.setAcademyservice(service);
		academy.setRunday(runDay);
		academy.setStartruntime(startRunTime);
		academy.setEndruntime(endRunTime);
		academy.setConsultableday(coDay);
		academy.setStartconsultabletime(startCoTime);
		academy.setEndconsultabletime(endCoTime);
		academy.setSignedacademy("가입");

		academyService.signEkaAcademy(academy);

		AcademyManager a = (AcademyManager) session.getAttribute("manager");
		a.setAcademyId(academy.getAid());

		authService.updateAcademId(academy.getAid(), a);
		session.setAttribute("manager", a);
		System.out.println(a);

		return "eka_main/main";
	}
}
