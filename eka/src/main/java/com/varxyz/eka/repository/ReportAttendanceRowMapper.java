package com.varxyz.eka.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.report.command.ReportAttendanceCommand;

public class ReportAttendanceRowMapper implements RowMapper<ReportAttendanceCommand> {
	@Override
	public ReportAttendanceCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportAttendanceCommand attendance = new ReportAttendanceCommand();
		
		attendance.setChecking(rs.getString("checking"));
		attendance.setLectureDate(rs.getString("lectureDate"));
		attendance.setLectureName(rs.getString("name"));
		
		return attendance;
	}
}
