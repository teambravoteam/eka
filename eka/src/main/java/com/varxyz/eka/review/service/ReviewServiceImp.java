
package com.varxyz.eka.review.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.review.domain.Review;
import com.varxyz.eka.review.repository.ReviewDao;

@Service("ReviewServiceImp")
public class ReviewServiceImp implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	public ReviewServiceImp(DataSource dataSource) {
		reviewDao = new ReviewDao(dataSource);
	}

	@Override
	public void addReview(Review review) {
		reviewDao.addReview(review);
	}

	@Override
	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}

	@Override
	public void deleteReview(Review review, Long rid) {
		reviewDao.deleteReview(review, rid);
	}

	@Override
	public List<Review> findReviewByAcademyId(Review review, Long academyId) {
		return reviewDao.findReviewByAcademyId(review, academyId);
	}

	@Override
	public List<Review> findReviewByekaUserId(Review review, Long ekaUserId) {
		return reviewDao.findReviewByekaUserId(review, ekaUserId);
	}
}
