package com.varxyz.eka.academy.academy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("eka_main/detail_page")
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
		List<Date> reviewRegDateList = reviewList.stream().map(Review::getRegDate).collect(Collectors.toList());

		model.addAttribute("academy", asservice.findAcademyByAid(academy.getAid()));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("reviewRidList", reviewRidList);
		model.addAttribute("reviewEkaUserLameList", reviewEkaUserLameList);
		model.addAttribute("reviewCommentList", reviewCommentList);
		model.addAttribute("reviewScoreList", reviewScoreList);
		model.addAttribute("reviewRegDateList", reviewRegDateList);
		model.addAttribute("checkManager", checkManager);
		model.addAttribute("checkStudent", checkStudent);
		return "eka_main/academy/detail_page";
	}
}
