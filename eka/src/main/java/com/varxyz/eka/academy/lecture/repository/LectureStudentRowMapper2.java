package com.varxyz.eka.academy.lecture.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.lecture.command.LectureStudentCommand;
import com.varxyz.eka.student.domain.Student;

public class LectureStudentRowMapper2 implements RowMapper<LectureStudentCommand> {
	
	@Override
	public LectureStudentCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
		LectureStudentCommand student = new LectureStudentCommand();
		
		student.setName(rs.getString("name"));
		student.setSid(rs.getLong("sid"));
		student.setScore(0);
		return student;
	}
}
