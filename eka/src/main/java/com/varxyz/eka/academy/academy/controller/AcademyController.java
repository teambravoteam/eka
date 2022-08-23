package com.varxyz.eka.academy.academy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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
import com.varxyz.eka.auth.service.AuthService;

@Controller
public class AcademyController {
	@Autowired
	private AcademyServiceImp acdemyService;
	@Autowired
	private AuthService authService;

	@GetMapping("/eka_main/main") // 확인용 메인페이지
	public String main(Model model) {
		model.addAttribute("main", new AcademyManager());
		return "eka_main/main";
	}

	@GetMapping("eka_main/add_academy")
	public String addacademy() {
		return "eka_main/add_academy";
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

		List<String> latList = new ArrayList();
		List<String> lonList = new ArrayList();
		List<String> nameList = new ArrayList();
		List<String> addressList = new ArrayList();
		List<String> detailAddressList = new ArrayList();
		String[] categoryList = {"전체","간호보조기술","경영·사무관리","국제","기예(중)","기타(중)","독서실","독서실(중)","보통교과","산업기반기술","산업서비스","산업응용기술","예능(중)","외국어","인문사회(중)","일반서비스","진학지도","컴퓨터"};
	
		String selectedCategory = categoryList[categoryNum];
		
		List<Academy> allAcademyList = null;
		
		if (selectedCategory.equals("전체")) {
			allAcademyList = acdemyService.findAllAcademies();
		} else {
			allAcademyList = acdemyService.findAcademiesByCategory(selectedCategory);		
		}
		
		List<String> allNameList = allAcademyList.stream().map(Academy::getName).collect(Collectors.toList());
		System.out.println("allNameList 완료");
		List<String> allAddressList = allAcademyList.stream().map(Academy::getAddress).collect(Collectors.toList());
		System.out.println("allAddressList 완료");
		List<String> allDetailAddressList = allAcademyList.stream().map(Academy::getDetailaddress).collect(Collectors.toList());
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
				System.out.println(distance);
				
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
		List<Academy> academyList = acdemyService.findAcademiesByAddress(address);

		model.addAttribute("academyList",academyList);
		model.addAttribute("address",address);
		return "eka_main/add_academy";
	}
	
	@PostMapping("eka_main/signed_eka_academy")
	public String signedEkaAcademy(HttpSession session ,Model model, @RequestParam String address,
			@RequestParam String name, @RequestParam String phone1,
			@RequestParam String phone2, @RequestParam String phone3,
			@RequestParam String service, @RequestParam String runday,
			@RequestParam String startruntime, @RequestParam String endruntime,
			@RequestParam String introduction) { 
		String[] namelist = name.split(",");
		name = namelist[0];		
		
		String[] phone1list = phone1.split(",");
		phone1 = phone1list[0];		
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		String[] srt = startruntime.split(",");
		String shour = srt[0].split("시")[0];
		
		String smin = srt[1].split("분")[0];		
		startruntime = shour + ":" + smin;
		
		
		String[] ert = endruntime.split(",");
		String ehour = ert[0].split("시")[0];
		String emin = ert[1].split("분")[0];		
		endruntime = ehour + ":" + emin;		
		
		Academy academy= acdemyService.findAcademyByAddressAndName(address,name);
		
		academy.setPhone(phone);
		academy.setAcademyservice(service);
		academy.setRunday(runday);
		academy.setIntroduction(introduction);
		academy.setStartruntime(startruntime);
		academy.setEndruntime(endruntime);
		academy.setSignedacademy("가입");		
		
		acdemyService.signEkaAcademy(academy);
		
		AcademyManager a = (AcademyManager) session.getAttribute("manager");
		a.setAcademyId(academy.getAid());
		
		authService.updateAcademId(a.getAid(), a);
		session.setAttribute("manager", a);
		
		return "eka_main/main";
	}

	@GetMapping("eka_main/academy/main")
	public String academyMain() {
		return "eka_main/academy/main";
	}

	@GetMapping("eka_main/academy/register")
	public String academyRegister() {
		return "eka_main/academy/register";
	}

	@GetMapping("eka_main/academy/write")
	public String academyWrite() {
		return "eka_main/academy/write";
	}

	@GetMapping("eka_main/academy/search")
	public String academySearch() {
		return "eka_main/academy/search";
	}

	@PostMapping("eka_main/academy/search")
	public String Search() {
		return "eka_main/academy/search";
	}

	@GetMapping("eka_main/academy/xml")
	public String academyXml() {
		return "eka_main/academy/xml";
	}

}
