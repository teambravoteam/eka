package com.varxyz.eka.consulting.repository;

import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.consulting.domain.Consulting;

@Repository("consultingDao")
public class ConsultingDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ConsultingDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addConsulting(Consulting consulting) {
		String sql = "INSERT Consulting(academyId, name, phone, consultCategory "
				+ " consultContent, regDate) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, consulting.getAcademy().getAid(),consulting.getName(),
				consulting.getPhone(),consulting.getConsultCategory(),
				consulting.getConsultContent(),consulting.getApplyDate());		
	}
	
	public void addApplyConsulting(Consulting consulting) {
		String sql = "INSERT Consulting(academyId, name, phone, consultCategory, "
				+ "consultDetail, consultContent, applyDate, registDate, consultType)"
				+ " VALUES (?,?,?,?,?,?,?,?,'신청')";
		jdbcTemplate.update(sql, consulting.getAcademy().getAid(),consulting.getName(),
				consulting.getPhone(),consulting.getConsultCategory(),
				consulting.getConsultDatail(),consulting.getConsultContent()
				,consulting.getApplyDate(),consulting.getRegistDate());
		
	}

	public void addRegistConsulting(Consulting consulting) {
		String sql = "INSERT Consulting(academyId, name, phone, consultCategory, "
				+ "consultDetail, consultContent, applyDate, registDate, consultType)"
				+ " VALUES (?,?,?,?,?,?,?,?,'완료')";
		jdbcTemplate.update(sql, consulting.getAcademy().getAid(),consulting.getName(),
				consulting.getPhone(),consulting.getConsultCategory().getCategory(),
				consulting.getConsultDatail(),consulting.getConsultContent()
				,consulting.getApplyDate(),consulting.getRegistDate());
		
	}


	public void updateConsulting(Consulting consulting) {
		String sql = "UPDATE Consulting SET consultContent=?, registDate=?, consultType='완료' "
				+ "WHERE academyId = ? AND applyDate = ? AND name = ?;";
		jdbcTemplate.update(sql,consulting.getConsultContent(),consulting.getRegistDate(),consulting.getAcademy().getAid(),
				consulting.getApplyDate(),consulting.getName());	
		
	}

	public void deleteConsulting(Consulting consulting) {
		String sql = "DELETE *  FROM Consulting WHERE cid = ?";
		jdbcTemplate.update(sql,consulting.getCid());	
		
	}

	public List<Consulting> findAllAcademyConsulting(Academy academy) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND ConsultType ='신청';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid());	
	}

	public List<Consulting> findAllAcademyApplyConsulting(Academy academy) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND ConsultType ='신청';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid());	
	}

	public List<Consulting> findAllAcademyRegistConsulting(Academy academy) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid());	
	}

	public Consulting findAcademyApplyConsultingByRegDateAndName(Academy academy, Date to, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ? AND name = ? AND ConsultType ='신청';";	
		return jdbcTemplate.queryForObject(sql,new ConsultingRowMapper(),academy.getAid(),to,name);	
	}

	public Consulting findAcademyConsultingByRegDateAndName(Academy academy, Date to, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Consulting findAcademyRegistConsultingByRegDateAndName(Academy academy, Date regDate, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ? AND name = ? AND ConsultType ='완료';";	
		return jdbcTemplate.queryForObject(sql,new ConsultingRowMapper(),academy.getAid(),regDate,name);	
	}

	/// 카테고리 별 찾기
	public List<Consulting> findAllAcademyRegistConsultingByConsultCategory(Academy academy, String consultCategory) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ?  AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDate(Academy academy, String applyDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ?  AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),applyDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByRegistDate(Academy academy, String registDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND registDate = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),registDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByName(Academy academy, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDate(Academy academy,
			String consultCategory, String applyDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND applyDate = ?  AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,applyDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndRegistDate(Academy academy,
			String consultCategory, String registDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND registDate = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,registDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndName(Academy academy,
			String consultCategory, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndRegistDate(Academy academy, String applyDate,
			String registDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ? AND registDate = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),applyDate,registDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndName(Academy academy, String applyDate,
			String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),applyDate,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByRegistDateAndName(Academy academy, String registDate,
			String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND registDate = ? AND name = ?  AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),registDate,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDate(Academy academy,
			String consultCategory, String applyDate, String registDate) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND applyDate = ? AND registDate = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,applyDate,registDate);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndName(Academy academy,
			String consultCategory, String applyDate, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND applyDate = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,applyDate,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndRegistDateAndName(Academy academy,
			String consultCategory, String registDate, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND registDate = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,registDate,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndRegistDateAndName(Academy academy,
			String applyDate, String registDate, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND applyDate = ? AND registDate = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),applyDate,registDate,name);	
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDateAndName(
			Academy academy, String consultCategory, String applyDate, String registDate, String name) {
		String sql = "SELECT * FROM Consulting WHERE academyId = ? AND consultCategory = ? AND applyDate = ? AND registDate = ? AND name = ? AND ConsultType ='완료';";		
		return jdbcTemplate.query(sql,new ConsultingRowMapper(),academy.getAid(),consultCategory,applyDate,registDate,name);	
	}


}
