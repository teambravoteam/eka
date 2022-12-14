package com.varxyz.eka.academy.academy.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;

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

	public List<Academy> findAcademiesByCategory(String field2) {
		String sql = "SELECT * FROM Academy WHERE field2 = ?";
		return jdbcTemplate.query(sql, new AcademyRowMapper(), field2);
	}

	public List<Academy> findAcademiesByAddress(String address) {
		String sql = "SELECT * FROM Academy WHERE address LIKE ? OR address = ?;";
		return jdbcTemplate.query(sql, new AcademyRowMapper(), "%" + address + "%", address);
	}

	public Academy findAcademyByAddressAndName(String address, String name) {
		String sql = "SELECT * FROM Academy WHERE address LIKE ? AND name = ?;";
		return jdbcTemplate.queryForObject(sql, new AcademyRowMapper(), "%" + address + "%", name);
	}

	public void signEkaAcademy(Academy academy) {
		String sql = "UPDATE Academy SET phone = ?, introduction = ?, academyservice = ?, "
				+ "runday = ?, startruntime = ?, endruntime = ?, consultableday = ?, startconsultabletime = ?, endconsultabletime = ?, "
				+ "signedacademy = ? WHERE address = ? AND name = ?;";
		jdbcTemplate.update(sql, academy.getPhone(), academy.getIntroduction(), academy.getAcademyservice(),
				academy.getRunday(), academy.getStartruntime(), academy.getEndruntime(), academy.getConsultableday(),
				academy.getStartconsultabletime(), academy.getEndconsultabletime(), academy.getSignedacademy(),
				academy.getAddress(), academy.getName());
	}

	public Academy findAcademyByAid(long aid) {
		String sql = "SELECT * FROM Academy WHERE aid = ?;";
		return jdbcTemplate.queryForObject(sql, new AcademyRowMapper(), aid);
	}

	public Student findStudentByEkaUserId(String ekaUserId) {
		String sql = "SELECT * FROM Student WHERE ekaUserId = ?;";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), ekaUserId);
	}

	public List<Student> findStudentsByEkaUserId(String ekaUserId) {
		String sql = "SELECT * FROM Student WHERE ekaUserId = ?;";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), ekaUserId);
	}
	
	public List<Academy> findAcademyByName(String name) {
		String sql = "SELECT * FROM Academy WHERE name LIKE ?;";
		return jdbcTemplate.query(sql, new AcademyRowMapper(), "%" + name + "%");
	}
}
