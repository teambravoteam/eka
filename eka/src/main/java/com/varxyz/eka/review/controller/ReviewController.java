package com.varxyz.eka.review.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.review.domain.Review;
import com.varxyz.eka.review.service.ReviewServiceImp;
import com.varxyz.eka.student.domain.Student;

@Controller
public class ReviewController {
	@Autowired
	private ReviewServiceImp reviewServiceImp;
	@Autowired
	private AcademyServiceImp academyService;

	@PostMapping("/eka_main/add_review")
	public ModelAndView myPage(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Review review = new Review();

		String ekauserId = request.getParameter("ekauserId");
		
		List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
		List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
		List<String> academyNameList = new ArrayList<String>();
		
		for (int i = 0; i < academyIdList.size(); i++) {
			academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
		}

		mav.addObject("academyNameList", academyNameList);
		mav.addObject("academyIdList", academyIdList);

		String academyAid = request.getParameter("academyAid");
		Long academyAidL = Long.parseLong(academyAid);
		String ekauserEid = request.getParameter("ekauserEid");
		Long ekauserEidL = Long.parseLong(ekauserEid);
		String reviewScore = request.getParameter("reviewScore");
		int reviewScoreI = Integer.parseInt(reviewScore);
		String reviewCotent = request.getParameter("reviewCotent");

		review.setAcademyId(academyAidL);
		review.setEkaUserId(ekauserEidL);
		review.setReviewScore(reviewScoreI);
		review.setComment(reviewCotent);
		
		reviewServiceImp.addReview(review);

		mav.setViewName("eka_main/myPage_ekaUser_list");

		return mav;
	}

}
