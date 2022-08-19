package com.varxyz.eka.academy.academycategory.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academycategory.domain.AgeCategory;
import com.varxyz.eka.academy.academycategory.domain.MainSubjectCategory;

public class MainSubjectCategoryRowMapper implements RowMapper<MainSubjectCategory
> {

	@Override
	public MainSubjectCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AgeCategory a = new AgeCategory();
		MainSubjectCategory mc = new MainSubjectCategory();
		
		a.setAgeCate(rs.getString("agecate"));
		
		mc.setAgeCategory(a);
		mc.setMainCate(rs.getString("maincate"));
		mc.setMainCategoryId(rs.getLong("mcid"));
		
		return mc;
	}

}
