package com.varxyz.eka.student.studentcategory.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.student.studentcategory.command.GradeCategoryCommand;
import com.varxyz.eka.student.studentcategory.domain.SchoolCategory;

@Repository
public class StudentCategoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentCategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//학교 카테고리 조회
	public List<SchoolCategory> findSchoolCategory() {
		String sql = "SELECT * FROM SchoolCategory";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<SchoolCategory>(SchoolCategory.class));
	}

	//학년 카테고리 조회
	public List<GradeCategoryCommand> findGradeCategory() {
		String sql = "SELECT * FROM GradeCategory";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<GradeCategoryCommand>(GradeCategoryCommand.class));
	}
}
