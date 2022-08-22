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
//		String priceListstr = rs.getString("priceList");		
//		ac.setPriceList(priceListstr.split("/"));
		
		ac.setPriceList(rs.getString("priceList"));
		
		ac.setPhone(rs.getString("phone"));
		ac.setIntroduction(rs.getString("introduction"));
		
//		String academyServiceListstr = rs.getString("academyService");		
//		if(academyServiceListstr != null) {
//			ac.setAcademyservice(academyServiceListstr.split(","));	
//		}
		ac.setAcademyservice(rs.getString("academyService"));
		
		// 리스트
//		String rundayListstr = rs.getString("runday");
//		if(rundayListstr != null) {
//			ac.setRunday(rundayListstr.split(","));	
//		}
		ac.setRunday(rs.getString("runday"));
		
		ac.setStartruntime(rs.getString("startruntime"));
		ac.setEndruntime(rs.getString("endruntime"));
		
		//리스트
		String consultableListstr = rs.getString("consultableday");
		if(consultableListstr != null) {
			ac.setConsultableday(consultableListstr.split(","));	
		}
		
		ac.setStartconsultabletime(rs.getString("startconsultabletime"));
		ac.setEndconsultabletime(rs.getString("endconsultabletime"));
		
		ac.setSignedacademy(rs.getString("signedacademy"));
		
		return ac;
	}

}
