package com.varxyz.eka.auth.repository;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;

@Repository
public class AuthDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AuthDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public void addManager(AcademyManager academyManager) { // 원장 가입
		String sql = "INSERT INTO ACADEMYMANAGER(userId, userPw, name, phone,ssn) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, academyManager.getUserId(), academyManager.getUserPw(), academyManager.getName(),
				academyManager.getPhone(), academyManager.getSsn());
	}
	

	public AcademyManager managercheckId(String userId) { // 원장 아이디 중복확인
		try {
			String sql = "SELECT * FROM ACADEMYMANAGER WHERE userId = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AcademyManager>(AcademyManager.class),userId);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public void addEkaUser(EkaUser ekaUser) { // 유저 가입
		String sql = "INSERT INTO EKAUSER(userId, userPw, name, gender, ssn, phone, email) VALUES(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, ekaUser.getUserId(), ekaUser.getUserPw(), ekaUser.getName(), ekaUser.getGender(),
				ekaUser.getSsn(), ekaUser.getPhone(), ekaUser.getEmail());
	}
	

	public AcademyManager usercheckId(String userId) { // 유저 아이디 중복확인
		try {
			String sql = "SELECT * FROM EKAUSER WHERE userId = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AcademyManager>(AcademyManager.class),userId);
		} catch (Exception e) {
			return null;
		}

	}

	

	public AcademyManager loginManager(String userId, String userPw) { // 원장로그인
		
		try {
			String sql = "SELECT * FROM ACADEMYMANAGER WHERE userId = ? AND userPw = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AcademyManager>(AcademyManager.class), userId, userPw);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public EkaUser loginEkaUser(String userId, String userPw) { // 유저로그인
		
		try {
			String sql = "SELECT * FROM EKAUSER WHERE userId = ? AND userPw = ?";
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<EkaUser>(EkaUser.class), userId, userPw);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void updateAcademId(long academyId, AcademyManager manager) { // 아카데미 아이디 업데이트
		String sql = "UPDATE AcademyManager SET academyId = ? WHERE userId = ? AND userPw = ?";
		jdbcTemplate.update(sql, academyId, manager.getUserId(), manager.getUserPw());
	}

}
