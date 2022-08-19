package com.varxyz.eka.academy.address.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.address.domain.CityAddress;
import com.varxyz.eka.academy.address.domain.CountyAddress;

@Repository
public class AddressDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AddressDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// ------------- county --------------------

	// county 리스트 불러오기
	public List<CountyAddress> countyList() {
		String sql = "SELECT * FROM CountyAddress";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CountyAddress>(CountyAddress.class));
	}

	// county추가
	public boolean addCounty(CountyAddress countyAddress) {
		try {
			String sql = "INSERT INTO CountyAddress(county) VALUES(?)";
			jdbcTemplate.update(sql, countyAddress.getCounty());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// county수정
	public boolean updateCounty(CountyAddress countyAddress, String newCount) {
		try {
			String sql = "UPDATE CountyAddress SET county=? WHERE county=?";
			jdbcTemplate.update(sql, countyAddress.getCounty(), newCount);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	// -------------- city ------------------

	// city 리스트 불러오기
	public List<CityAddress> cityList(CountyAddress countyAddress) {
		String sql = "SELECT * FROM CountyAddress WHERE county=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CityAddress>(CityAddress.class), countyAddress);
	}

	// city추가
	public boolean addCounty(CountyAddress countyAddress, CityAddress cityAddress) {
		try {
			String sql = "INSERT INTO CountyAddress(county,city) VALUES(?,?)";
			jdbcTemplate.update(sql, countyAddress.getCounty(), cityAddress.getCity());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// city 수정
	public boolean updateCity(CountyAddress countyAddress, CityAddress cityAddress, String newcity) {
		try {
			String sql = "UPDATE CityAddress SET county=?, city=? WHERE city=?";
			jdbcTemplate.update(sql,countyAddress.getCounty(), newcity, cityAddress.getCity());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	// city삭제
	public boolean deleteCity(CountyAddress countyAddress, CityAddress cityAddress) {
		try {
			String sql = "DELETE FROM CityAddress WHERE county=? AND city=?";
			jdbcTemplate.update(sql,countyAddress.getCounty(), cityAddress.getCity());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	

}
