package com.varxyz.eka.report.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.report.command.ReportScoreCommand;

public class ReportScoreRowMapper implements RowMapper<ReportScoreCommand> {
	@Override
	public ReportScoreCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportScoreCommand score = new ReportScoreCommand();
		
		score.setLectureName(rs.getString("lectureName"));
		score.setTestDate(rs.getString("testDate"));
		score.setTestName(rs.getString("testName"));
		score.setTestScore(rs.getDouble("testScore"));
		
		return score;
	}
}
