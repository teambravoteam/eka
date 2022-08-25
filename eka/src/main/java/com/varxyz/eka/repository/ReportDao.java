package com.varxyz.eka.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.report.command.ReportAttendanceCommand;
import com.varxyz.eka.report.command.ReportScoreCommand;

@Repository
public class ReportDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ReportDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 출석정보 가져오기
	public List<ReportAttendanceCommand> findAttendanceListBySid(Academy academy, long sid, long lid) {
		String sql = "SELECT * FROM Attendance a JOIN Lecture b ON a.academyId = b.academyId "
				+ " WHERE a.academyId =? AND a.studentId =? AND a.lectureId=?";
		return jdbcTemplate.query(sql, new ReportAttendanceRowMapper(), academy.getAid(), sid, lid);
	}
	
	// 성적정보 가져오기
	public List<ReportScoreCommand> findScoreListBySid(Academy academy, long sid, String lectureName) {
		String sql = "SELECT * FROM AcademyTestCategory a JOIN AcademyScore b ON a.atcid = b.testCategoryId "
				+ " WHERE studentId= ? AND lectureName=? ";
		return jdbcTemplate.query(sql, new ReportScoreRowMapper(), sid, lectureName);
	
	}
}
