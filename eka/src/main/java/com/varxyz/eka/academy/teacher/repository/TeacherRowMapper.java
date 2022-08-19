package com.varxyz.eka.academy.teacher.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.teacher.domain.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Teacher t = new Teacher();
		Academy a = new Academy();
		a.setAid(rs.getLong("academyId"));
		
		t.setTid(rs.getLong("tid"));
		t.setAcademy(a);
		t.setName(rs.getString("name"));
		t.setGender(rs.getString("gender"));
		t.setSsn(rs.getString("ssn"));
		t.setPhone(rs.getString("phone"));
		t.setSubject(rs.getString("subject"));
		t.setEducation(rs.getString("education"));
		t.setCareer(rs.getString("career"));
		t.setImage(rs.getString("image"));
		t.setForeigner(rs.getString("foreigner"));
		
		return t;
	}
}
