package com.varxyz.eka.score.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.score.domain.Score;

@Repository
public class ScoreDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ScoreDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 시험정보 등록
	public void addAcademyScoreCategory(Score score) {
		String sql = "INSERT INTO AcademyScore(academyId, lecturename, testname, testdate) "
				+ " VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, score.getAcademyId(), score.getLecturename(),
				score.getTestname(), score.getTestdate());
	}
	
	public List<Score> findTestName(long aid, String lecturename) {
		String sql = "SELECT lecturename, testname, testdate  FROM AcademyScore WHERE academyId=? AND lecturename=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Score>(Score.class) , aid, lecturename);
	}
	
	
}
