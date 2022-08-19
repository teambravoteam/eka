package com.varxyz.eka.academy.academycategory.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academycategory.domain.AgeCategory;
import com.varxyz.eka.academy.academycategory.domain.MainSubjectCategory;
import com.varxyz.eka.academy.academycategory.domain.SubjectCategory;

public class SubjectCategoryRowMapper implements RowMapper<SubjectCategory> {

	@Override
	public SubjectCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AgeCategory ac = new AgeCategory();
		MainSubjectCategory mc = new MainSubjectCategory();
		SubjectCategory sc = new SubjectCategory();
		
		ac.setAgeCate(rs.getString("agecate"));
		
		mc.setAgeCategory(ac);
		mc.setMainCate(rs.getString("maincate"));
		
		sc.setMainSubjectCategory(mc);
		sc.setSubjectCategory(rs.getString("subjectcate"));
		sc.setSubjectCategoryId(rs.getLong("scid"));
		
		return sc;
	}

}
