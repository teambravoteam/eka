package com.varxyz.eka.academy.academy.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;

@Repository("academyListDao")
public class AcademyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AcademyDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Academy> findAllAcademies() {
		String sql = "SELECT * FROM Academy";
		return jdbcTemplate.query(sql, new AcademyRowMapper());
	}
	
	public List<Academy> findAcademiesByAddress(String address) {
		String sql = "SELECT * FROM Academy WHERE address";
		return jdbcTemplate.query(sql, new AcademyRowMapper(), address);
	}
}
