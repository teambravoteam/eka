package com.varxyz.eka.academy.lecture.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.student.domain.Student;

public class LectureStudentRowMapper implements RowMapper<Student> {
	
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		
		student.setAcademyId(rs.getLong("academyId"));
		student.setEkaUserId(rs.getString("ekaUserId"));
		student.setGender(rs.getString("gender"));
		student.setGradecate(rs.getString("gradecate"));
		student.setName(rs.getString("name"));
		student.setParentName(rs.getString("parentName"));
		student.setParentPhone(rs.getString("parentPhone"));
		student.setParentType(rs.getString("parentType"));
		student.setPhone(rs.getString("phone"));
		student.setRegDate(rs.getDate("regDate"));
		student.setSchoolcate(rs.getString("schoolcate"));
		student.setSid(rs.getLong("sid"));
		student.setSsn(rs.getDate("ssn"));
		return student;
	}
}
