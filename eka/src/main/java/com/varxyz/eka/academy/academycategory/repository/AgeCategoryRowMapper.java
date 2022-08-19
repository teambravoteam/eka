package com.varxyz.eka.academy.academycategory.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academycategory.domain.AgeCategory;

public class AgeCategoryRowMapper implements RowMapper<AgeCategory> {

	@Override
	public AgeCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		AgeCategory a = new AgeCategory();
		a.setAgeCategoryId(rs.getLong("acid"));
		a.setAgeCate(rs.getString("agecate"));		
		
		return a;
	}

}
