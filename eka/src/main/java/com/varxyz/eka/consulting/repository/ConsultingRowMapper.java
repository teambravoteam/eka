package com.varxyz.eka.consulting.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.consulting.category.domain.ConsultCategory;
import com.varxyz.eka.consulting.domain.Consulting;

public class ConsultingRowMapper implements RowMapper<Consulting> {

	@Override
	public Consulting mapRow(ResultSet rs, int rowNum) throws SQLException {
		Academy a = new Academy();
		ConsultCategory c = new ConsultCategory();
		Consulting cs = new Consulting();
		
		a.setAid(rs.getLong("academyId"));
		
		c.setCategory(rs.getString("consultCategory"));
		
		cs.setAcademy(a);
		cs.setConsultCategory(c);
		cs.setName(rs.getString("name"));
		cs.setPhone(rs.getString("phone"));
		
		String phone = cs.getPhone();
		String[] phoneList = phone.split("-");
		cs.setPhone1(phoneList[0]);
		cs.setPhone2(phoneList[1]);
		cs.setPhone3(phoneList[2]);		
		
		cs.setConsultDatail(rs.getString("consultDetail"));
		cs.setConsultContent(rs.getString("consultContent"));
		cs.setApplyDate(rs.getString("applyDate"));
		cs.setRegistDate(rs.getString("registDate"));
		cs.setConsultType(rs.getString("consultType"));
		
		return cs;
	}

}
