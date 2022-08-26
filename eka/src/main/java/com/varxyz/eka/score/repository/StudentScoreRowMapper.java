package com.varxyz.eka.score.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.lecture.command.LectureStudentCommand;

public class StudentScoreRowMapper implements RowMapper<LectureStudentCommand> {
	
	@Override
	public LectureStudentCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		LectureStudentCommand student = new LectureStudentCommand();
		
		student.setName(rs.getString("studentName"));
		student.setSid(rs.getLong("studentId"));
		student.setScore(rs.getDouble("testScore"));
		return student;
	}
}
