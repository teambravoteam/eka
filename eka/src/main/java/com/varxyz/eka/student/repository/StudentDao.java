package com.varxyz.eka.student.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	
	public boolean addStudent(Student student) {
		try {
			String sql = "INSERT INTO Student(schoolcate,gradecate,name,"
					+ "gender,ssn,phone,ekaSignUp,parentName,parentType,parentPhone) VALUES(?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, new BeanPropertyRowMapper<Student>(Student.class),student);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
