package com.varxyz.eka.academy.academycategory.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.repository.AcademyRowMapper;

import com.varxyz.eka.academy.academycategory.domain.AgeCategory;
import com.varxyz.eka.academy.academycategory.domain.MainSubjectCategory;
import com.varxyz.eka.academy.academycategory.domain.SubjectCategory;

@Repository("academyCategoryDao")
public class AcademyCategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	public void addAgeCategory(AgeCategory ageCategory) {
		String sql = "INSERT AgeCategory(agecate) VALUES (?)";
		jdbcTemplate.update(sql, ageCategory.getAgeCate());			
	}


	public void addMainSubjectCategory(MainSubjectCategory mainSubjectCategory) {
		String sql = "INSERT MainSubjectCategory(maincate,agecate) VALUES (?,?)";
		jdbcTemplate.update(sql, mainSubjectCategory.getMainCate(),
				mainSubjectCategory.getAgeCategory().getAgeCate());		
	}

	public void addSubjectCategory(SubjectCategory subjectCategory) {
		String sql = "INSERT SubjectCategory(mainCateId,subjectcate,maincate,agecate) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, subjectCategory.getMainSubjectCategory().getMainCategoryId(),
				subjectCategory.getSubjectCategory(),subjectCategory.getMainSubjectCategory().getMainCate(),
				subjectCategory.getMainSubjectCategory().getAgeCategory().getAgeCate());			
	}

	public List<AgeCategory> findAllAgeCategory() {
		String sql = "SELCTE * FROM AgeCategory";
		return jdbcTemplate.query(sql, new AgeCategoryRowMapper());	
	}

	public List<MainSubjectCategory> findAllMainSubjectCategory() {
		String sql = "SELECT * FROM MainSubjectCategory";
		return jdbcTemplate.query(sql, new MainSubjectCategoryRowMapper());	
	}
	
	// 과목 카테고리 조회
	public List<SubjectCategory> findAllSubjectCategory() {
		String sql = "SELECT * FROM SubjectCategory";
		return jdbcTemplate.query(sql, new SubjectCategoryRowMapper());	
	}

	public void updateAgeCategory(AgeCategory ageCategory) {
		String sql = "UPDATE AgeCategory SET(agecate) VALUES (?)";
		jdbcTemplate.update(sql, ageCategory.getAgeCate());			
		
	}

	public void updateMainSubjectCategory(MainSubjectCategory mainSubjectCategory) {
		// TODO Auto-generated method stub
		
	}

	public void updateSubjectCategory(SubjectCategory subjectCategory) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	

}
