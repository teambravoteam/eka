package com.varxyz.eka.student.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.student.domain.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void addStudent(Student student) { // 학생추가
		String sql = "INSERT INTO Student(academyId,schoolcate,gradecate,name,gender,ssn,phone,ekaUserId,parentName,parentType,parentPhone) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, student.getAcademyId() ,student.getSchoolcate(), student.getGradecate(),
				student.getName(), student.getGender(), student.getSsn(), student.getPhone(),
				student.getEkaUserId(), student.getParentName(), student.getParentType(),
				student.getParentPhone());	
	}

}
