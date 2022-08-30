package com.varxyz.eka.review.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private ReviewServiceImp reviewService;
	@Autowired
	private AcademyServiceImp academyService;

	@PostMapping("/eka_main/add_review")
	public ModelAndView add_review(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Review review = new Review();

		// id name 리스트
		String ekauserId = request.getParameter("ekauserId");
		
		List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
		List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
		List<String> academyNameList = new ArrayList<String>();
		
		for (int i = 0; i < academyIdList.size(); i++) {
			academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
		}

		mav.addObject("academyNameList", academyNameList);
		mav.addObject("academyIdList", academyIdList);

		// 컨텐츠 리스트
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
		
		reviewService.addReview(review);
	
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

		mav.addObject("reviewRidList", reviewRidList);
		mav.addObject("reviewAcademyIdList", reviewAcademyIdList);
		mav.addObject("reviewAcademyNameList", reviewAcademyNameList);
		mav.addObject("reviewCommentList", reviewCommentList);
		mav.addObject("reviewScoreList", reviewScoreList);
		mav.addObject("reviewRegDateList", reviewRegDateList);

		mav.setViewName("eka_main/myPage_ekaUser_list");

		return mav;
	}

	@PostMapping("/eka_main/update_Review")
	public ModelAndView update_Review(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Review review = new Review();

		// id name 리스트
		String ekauserId = request.getParameter("ekauserId");
		
		List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
		List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
		List<String> academyNameList = new ArrayList<String>();
		
		for (int i = 0; i < academyIdList.size(); i++) {
			academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
		}

		mav.addObject("academyNameList", academyNameList);
		mav.addObject("academyIdList", academyIdList);

		// 컨텐츠 리스트
		String reviewRid = request.getParameter("reviewRid");
		Long reviewRidL = Long.parseLong(reviewRid);
		String reviewCotent = request.getParameter("reviewCotent");
		String reviewScore = request.getParameter("reviewScore");
		int reviewScoreI = Integer.parseInt(reviewScore);

		review.setRid(reviewRidL);
		review.setComment(reviewCotent);
		review.setReviewScore(reviewScoreI);
		
		reviewService.updateReview(review);

		// 이전 내용 불러오기
		String ekauserEid = request.getParameter("ekauserEid");
		Long ekauserEidL = Long.parseLong(ekauserEid);

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

		mav.addObject("reviewRidList", reviewRidList);
		mav.addObject("reviewCommentList", reviewCommentList);
		mav.addObject("reviewAcademyNameList", reviewAcademyNameList);
		mav.addObject("reviewScoreList", reviewScoreList);
		mav.addObject("reviewRegDateList", reviewRegDateList);

		mav.setViewName("eka_main/myPage_ekaUser_list");

		return mav;
	}
	

	@PostMapping("/eka_main/delete_Review")
	public ModelAndView delete_review(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		Review review = new Review();

		// id name 리스트
		String ekauserId = request.getParameter("ekauserId");
		
		List<Student> academyList = academyService.findStudentsByEkaUserId(ekauserId);
		List<Long> academyIdList = academyList.stream().map(Student::getAcademyId).collect(Collectors.toList());
		List<String> academyNameList = new ArrayList<String>();
		
		for (int i = 0; i < academyIdList.size(); i++) {
			academyNameList.add(academyService.findAcademyByAid(academyIdList.get(i)).getName());
		}

		mav.addObject("academyNameList", academyNameList);
		mav.addObject("academyIdList", academyIdList);

		// 컨텐츠 리스트
		String reviewRid = request.getParameter("reviewRid");
		Long reviewRidL = Long.parseLong(reviewRid);

		reviewService.deleteReview(reviewRidL);

		// 이전 내용 불러오기
		String ekauserEid = request.getParameter("ekauserEid");
		Long ekauserEidL = Long.parseLong(ekauserEid);

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

		mav.addObject("reviewRidList", reviewRidList);
		mav.addObject("reviewCommentList", reviewCommentList);
		mav.addObject("reviewAcademyNameList", reviewAcademyNameList);
		mav.addObject("reviewScoreList", reviewScoreList);
		mav.addObject("reviewRegDateList", reviewRegDateList);

		mav.setViewName("eka_main/myPage_ekaUser_list");

		return mav;
	}
}
