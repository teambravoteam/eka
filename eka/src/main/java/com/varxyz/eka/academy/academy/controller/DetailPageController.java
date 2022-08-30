package com.varxyz.eka.academy.academy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;
import com.varxyz.eka.auth.service.AuthService;
import com.varxyz.eka.review.domain.Review;
import com.varxyz.eka.review.service.ReviewServiceImp;

@Controller
public class DetailPageController {

	@Autowired
	private AcademyServiceImp asservice;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private ReviewServiceImp rservice;
	@Autowired
	private AuthService auservice;

	@GetMapping("/eka_main/detail_page")
	public ModelAndView detail_page(HttpServletResponse response) {

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
	
	@PostMapping("eka_main/detail_page")
	public String detailPage(Model model, HttpSession session, @RequestParam String academyAid) {
		long aid = Integer.parseInt(academyAid);
		Academy academy = asservice.findAcademyByAid(aid);
		long checkManager = 0;
		long checkStudent = 0;

		// 원장 로그인여부 체크
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		if (am == null) {
			checkManager = 1;
		} else {
			checkManager = 0;
		}

		// 학생 로그인여부 체크
		EkaUser as = (EkaUser) session.getAttribute("ekauser");
		if (as == null) {
			checkStudent = 1;
		} else {
			checkStudent = 0;
		}

		System.out.println(asservice.findAcademyByAid(academy.getAid()));
		System.out.println(tservice.findAllAcademyTeacher(academy));

		// 학원 별 리뷰 구현
		List<Review> reviewList = rservice.findReviewByAcademyId(aid);
		List<Long> reviewRidList = reviewList.stream().map(Review::getRid).collect(Collectors.toList());
		List<Long> reviewEkaUserList = reviewList.stream().map(Review::getEkaUserId).collect(Collectors.toList());

		List<String> reviewEkaUserLameList = new ArrayList<String>();
		for (int i = 0; i < reviewEkaUserList.size(); i++) {
			reviewEkaUserLameList.add(auservice.findEkaUserByekaUserId(reviewEkaUserList.get(i)).getName());
		}

		List<String> reviewCommentList = reviewList.stream().map(Review::getComment).collect(Collectors.toList());
		List<Integer> reviewScoreList = reviewList.stream().map(Review::getReviewScore).collect(Collectors.toList());

		double allScore = 0.0;
		int allScoreNum = 0;
		int score_5 = 0;
		int score_4 = 0;
		int score_3 = 0;
		int score_2 = 0;
		int score_1 = 0;

		for (int i = 0; i < reviewScoreList.size(); i++) {
			if (reviewScoreList.get(i) == 5) {
				score_5 += 1;
				allScore += reviewScoreList.get(i);
			} else if (reviewScoreList.get(i) == 4) {
				score_4 += 1;
				allScore += reviewScoreList.get(i);
			} else if (reviewScoreList.get(i) == 3) {
				score_3 += 1;
				allScore += reviewScoreList.get(i);
			} else if (reviewScoreList.get(i) == 2) {
				score_2 += 1;
				allScore += reviewScoreList.get(i);
			} else if (reviewScoreList.get(i) == 1) {
				score_1 += 1;
				allScore += reviewScoreList.get(i);
			}
		}
		
		allScoreNum = score_1 + score_2 + score_3 + score_4 + score_5;
		
		BigDecimal reviewScoreListB = null;
		BigDecimal allScoreB = null;
		BigDecimal averageScore = null;
		BigDecimal averageScore0 = null;
		
		if (allScore != 0.0) {
			reviewScoreListB = new BigDecimal(String.valueOf(reviewScoreList.size()));
			allScoreB = new BigDecimal(String.valueOf(allScore));
			
			averageScore = allScoreB.divide(reviewScoreListB, 1, BigDecimal.ROUND_CEILING);
			averageScore0 = allScoreB.divide(reviewScoreListB, 0, BigDecimal.ROUND_HALF_UP);
		}
		
		double score_5L = 0.0;
		double score_4L = 0.0;
		double score_3L = 0.0;
		double score_2L = 0.0;
		double score_1L = 0.0;
		
		score_5L = rservice.percent(score_5, allScoreNum);
		score_4L = rservice.percent(score_4, allScoreNum);
		score_3L = rservice.percent(score_3, allScoreNum);
		score_2L = rservice.percent(score_2, allScoreNum);
		score_1L = rservice.percent(score_1, allScoreNum);

		List<Date> reviewRegDateList = reviewList.stream().map(Review::getRegDate).collect(Collectors.toList());

		model.addAttribute("academy", asservice.findAcademyByAid(academy.getAid()));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("reviewRidList", reviewRidList);
		model.addAttribute("reviewEkaUserLameList", reviewEkaUserLameList);
		model.addAttribute("reviewCommentList", reviewCommentList);
		model.addAttribute("reviewScoreList", reviewScoreList);
		model.addAttribute("allScoreNum", allScoreNum);
		model.addAttribute("score_1", score_1);
		model.addAttribute("score_2", score_2);
		model.addAttribute("score_3", score_3);
		model.addAttribute("score_4", score_4);
		model.addAttribute("score_5", score_5);
		model.addAttribute("score_1L", score_1L);
		model.addAttribute("score_2L", score_2L);
		model.addAttribute("score_3L", score_3L);
		model.addAttribute("score_4L", score_4L);
		model.addAttribute("score_5L", score_5L);
		model.addAttribute("averageScore", averageScore);
		model.addAttribute("averageScore0", averageScore0);
		model.addAttribute("reviewRegDateList", reviewRegDateList);
		model.addAttribute("checkManager", checkManager);
		model.addAttribute("checkStudent", checkStudent);
		return "eka_main/academy/detail_page";
	}
}
