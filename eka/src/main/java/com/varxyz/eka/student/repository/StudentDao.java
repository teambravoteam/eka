package com.varxyz.eka.student.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 학생추가
	public void addStudent(Student student) { 
		String sql = "INSERT INTO Student(academyId,schoolcate,gradecate,name,gender,ssn,phone,ekaUserId,parentName,parentType,parentPhone) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, student.getAcademyId() ,student.getSchoolcate(), student.getGradecate(),
				student.getName(), student.getGender(), student.getSsn(), student.getPhone(),
				student.getEkaUserId(), student.getParentName(), student.getParentType(),
				student.getParentPhone());	
	}
	
	//모든 학원의 학생정보 가져오기
	public List<Student> findAllAcademyStudent(){
		String sql = "SELECT * FROM Student";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
	}

	// 갓 수현 첨삭중
	// 하나의 학원에 포함된 학생들의 모든 정보를 불러온다
	public List<Student> findAllAcademyStudentByAcademy(Academy academy) {
		String sql = "SELECT * FROM Student WHERE academyId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class),academy.getAid());
	}
	
	// 상세정보를 불러온다
	public Student detailedInformation(String name, String phone) {
		String sql = "SELECT * FROM Student WHERE name = ? AND phone = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class),name,phone);
	}

}
