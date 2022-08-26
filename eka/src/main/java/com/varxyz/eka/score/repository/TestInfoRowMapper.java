package com.varxyz.eka.score.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.score.domain.ScoreCategory;

public class TestInfoRowMapper implements RowMapper<ScoreCategory> {
	
	@Override
	public ScoreCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ScoreCategory test = new ScoreCategory();
		test.setAcademyId(rs.getLong("academyId"));
		test.setAtcid(rs.getLong("atcid"));
		test.setLectureName(rs.getString("lectureName"));
		test.setTestDate(rs.getString("testDate"));
		test.setTestName(rs.getString("testName"));
		return test;
	}
	
}
