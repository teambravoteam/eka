package com.varxyz.eka.review.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.review.domain.Review;

@Repository("ReviewDao")
public class ReviewDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ReviewDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 리뷰 추가
	public void addReview(Review review) {
		String sql = "INSERT Review(academyId, ekaUserId, reviewScore, comment) VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sql, review.getAcademyId(), review.getEkaUserId(), review.getReviewScore(),
				review.getComment());
	}

	// 리뷰 수정
	public void updateReview(Review review) {
		String sql = "UPDATE Review SET comment = ?, reviewScore = ? WHERE rid = ?";
		jdbcTemplate.update(sql, review.getComment(), review.getReviewScore(), review.getRid());
	}

	// 리뷰 삭제
	public void deleteReview(long rid) {
		String sql = "DELETE FROM Review WHERE rid = ?";
		jdbcTemplate.update(sql, rid);
	}

	// 학원 별 리뷰 조회
	public List<Review> findReviewByAcademyId(Long academyId) {
		String sql = "SELECT * FROM Review WHERE academyId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Review>(Review.class), academyId);
	}
	
	// 유저 별 리뷰 조회
	public List<Review> findReviewByekaUserId(Long ekaUserId) {
		String sql = "SELECT * FROM Review WHERE ekaUserId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Review>(Review.class), ekaUserId);
	}
}
