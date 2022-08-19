package com.varxyz.eka.academy.academy.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academy.domain.Academy;


public class AcademyRowMapper implements RowMapper<Academy> {

	@Override
	public Academy mapRow(ResultSet rs, int rowNum) throws SQLException {		
		Academy ac = new Academy();
		ac.setAid(rs.getLong("aid"));
		ac.setName(rs.getString("name"));
		ac.setOpeningday(rs.getDate("openingday"));
		ac.setAddress(rs.getString("address"));
		ac.setDetailaddress(rs.getString("detailaddress"));
		ac.setLat(rs.getString("lat"));
		ac.setLon(rs.getString("lon"));
		ac.setPersonnel(rs.getLong("personnel"));
		ac.setField1(rs.getString("field1"));
		ac.setField2(rs.getString("field2"));
		ac.setField3(rs.getString("field3"));
		ac.setField4(rs.getString("field4"));
		// 리스트
		String priceListstr = rs.getString("priceList");
		
		ac.setPriceList(priceListstr.split("/"));
		
		ac.setPhone(rs.getString("phone"));
		ac.setIntroduction(rs.getString("introduction"));
		String academyServiceListstr = rs.getString("academyService");
		ac.setAcademyservice(academyServiceListstr.split(","));
		
		// 리스트
		String rundayListstr = rs.getString("runday");
		ac.setRunday(rundayListstr.split(","));
		ac.setStartruntime(rs.getTime("startruntime"));
		ac.setEndruntime(rs.getTime("endruntime"));
		
		//리스트
		String consultableListstr = rs.getString("consultableday");
		ac.setConsultableday(consultableListstr.split(","));
		ac.setStartconsultabletime(rs.getTime("startconsultabletime"));
		ac.setEndconsultabletime(rs.getTime("endconsultabletime"));
		
		ac.setSignedacademy(rs.getString("signedacademy"));
		
		return ac;
	}

}
