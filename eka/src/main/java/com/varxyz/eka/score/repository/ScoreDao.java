package com.varxyz.eka.score.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.domain.ScoreCategory;

@Repository
public class ScoreDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ScoreDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 시험정보 등록
	public void addAcademyScoreCategory(ScoreCategory scoreCategory) {
		String sql = "INSERT INTO AcademyTestCategory(academyId, lectureName, testName, testDate) "
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, scoreCategory.getAcademyId(), scoreCategory.getLectureName(),
				scoreCategory.getTestName(), scoreCategory.getTestDate());
	}
	
	// 시험목록
	public List<ScoreCategory> findTestName(long aid, String lecturename) {
		String sql = "SELECT * FROM AcademyTestCategory WHERE academyId=? AND lectureName=?";
		return jdbcTemplate.query(sql, new TestInfoRowMapper() , aid, lecturename);
	}
	
	// 시험성적 등록
	public void addScore(long scid, String name, int sid, double score) {
		String sql = "INSERT INTO AcademyScore(testCategoryId, studentName, studentId, testScore)"
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, scid, name, sid, score);
	}
	
	public List<Score> findListByAtcid(long atcid) {
		String sql = "SELECT * FROM AcademyScore WHERE testCategoryId =?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Score>(Score.class),atcid);
	}
	
	
}
