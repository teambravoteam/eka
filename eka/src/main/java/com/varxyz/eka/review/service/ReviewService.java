package com.varxyz.eka.review.service;

import java.util.List;

import com.varxyz.eka.review.domain.Review;

/*
 * 리뷰서비스는 관리는 학원관리자가 하지만, 동시에 조회는 학생유저들도 가능해야 한다
 * */
public interface ReviewService {
	//유저는 리뷰를 등록할 수 있어야 한다
	public void addReview(Review review);
	
	//유저는 리뷰를 수정 할 수 있어야 한다
	public void updateReview(Review review);
	
	//유저는 리뷰를 삭제 할 수 있어야 한다
	public void deleteReview(Long rid);

	// 학원 별로 리뷰를 조회할 수 있어야 한다
	public List<Review> findReviewByAcademyId(Long academyId);
	
	// 유저 별로 리뷰를 조회할 수 있어야 한다
	public List<Review> findReviewByekaUserId(Long ekaUserId);
	
}
