package com.varxyz.eka.review.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.auth.domain.EkaUser;
import com.varxyz.eka.review.domain.Review;

/*
 * 리뷰서비스는 관리는 학원관리자가 하지만, 동시에 조회는 학생유저들도 가능해야 한다
 * */
public interface ReviewService {
	//학생 유저는 리뷰를 등록할 수 있어야 한다
	public boolean addReview(Review review);
	
	//학생 유저는 리뷰를 수정 할 수 있어야 한다
	public boolean updateReview(Review review);
	
	//학생 유저는 리뷰를 삭제 할 수 있어야 한다
	public boolean deleteReview(Review review);
	
	/*
	 * 학생 유저는 리뷰를 확인할 수 있어야 한다
	 * */
	
	// EKA유저는 자신의 모든 리뷰를 확인이 가능한다
	public List<Review> findAllReview(EkaUser ekaUser);
	// EKA유저는 자신의 리뷰중 특정 학원의 리뷰를 확인이 가능해야 한다
	public List<Review> findReivewByAcademy(EkaUser ekaUser, Academy academy);
	
}
