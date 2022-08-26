package com.varxyz.eka.attendence.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.attendence.domain.Attendence;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.service.StudentServiceImpl;

public class AttendanceRowMapper implements RowMapper<Attendence> {

	
	
	
	@Override
	public Attendence mapRow(ResultSet rs, int rowNum) throws SQLException {
		Attendence att = new Attendence();
		Student student = new Student();
		Lecture l = new Lecture();
		Academy a = new Academy();
		a.setAid(rs.getLong("a.academyId"));
		l.setLid(rs.getLong("a.lectureId"));
		
		student.setAcademyId(rs.getLong("b.academyId"));
		student.setEkaUserId(rs.getString("b.ekaUserId"));
		student.setGender(rs.getString("b.gender"));
		student.setGradecate(rs.getString("b.gradecate"));
		student.setName(rs.getString("b.name"));
		student.setParentName(rs.getString("b.parentName"));
		student.setParentPhone(rs.getString("b.parentPhone"));
		student.setParentType(rs.getString("b.parentType"));
		student.setPhone(rs.getString("b.phone"));
		student.setRegDate(rs.getDate("b.regDate"));
		student.setSchoolcate(rs.getString("b.schoolcate"));
		student.setSid(rs.getLong("b.sid"));
		student.setSsn(rs.getDate("b.ssn"));
		
		att.setAid(rs.getLong("a.aid"));
		att.setAcademy(a);
		att.setStudent(student);
		att.setLecture(l);
		
		att.setChecking(rs.getString("checking"));
		att.setRegDate(rs.getDate("lectureDate"));
		return att;
	}

}
