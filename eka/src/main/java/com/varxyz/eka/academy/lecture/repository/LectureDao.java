package com.varxyz.eka.academy.lecture.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.teacher.domain.Teacher;

@Repository
public class LectureDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LectureDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 강좌등록
	public void addLecture(Lecture l) {
		String sql = "INSERT INTO Lecture(academyId, name, schoolcate,"
				+ " gradecate, subject, startLectureTime, finishLectureTime, "
				+ " startLectureDate, finishLectureDate, lectureDay, price, "
				+ " teacherNames, lectureCapacity) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				l.getAcademy().getAid(), l.getName(), l.getSchoolcate(),
				l.getGradecate(), l.getSubject(), l.getStartLectureTime(),l.getFinishLectureTime(),
				l.getStartLectureDate(), l.getFinishLectureDate(),
				l.getLectureDay(), l.getPrice(), l.getTeacher(), l.getLectureCapacity());
	}
	
	// 강좌 전체 조회
	public List<Lecture> findAllLecture(Academy academy) {
		String sql = "SELECT * FROM Lecture WHERE academyId=?";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid());
	}
	
	// 과목으로 검색
	public List<Lecture> findAcademyLecturesBySubject(Academy academy, String subject) {
		String sql = "SELECT * FROM Lecture WHERE academyId=? AND subject=?";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), subject);
	
	}
	
	// 강사로 검색
	public List<Lecture> findAcademyLecturesByTeacher(Academy academy, String teacher) {
		String sql = "SELECT * FROM Lecture WHERE academyId=? AND teacherNames LIKE ?";
		String teacherName = "%"+teacher+"%";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), teacherName);
	}
	
	// 요일로 검색
	public List<Lecture> findAcademyLecturesByLectureDay(Academy academy, String lectureDay) {
		String sql = "SELECT * FROM Lecture WHERE academyId=? AND lectureDay LIKE ?";
		String day = "%"+lectureDay+"%";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), day);
	}
	
	// 강좌 수정
	public void updateLecture(Lecture lecture) {
		String sql = "UPDATE Lecture SET name=?, schoolcate=?,gradecate=?, subject=?, "
				+ " startLectureTime=?, finishLectureTime=?, startLectureDate=?,"
				+ " finishLectureDate=?, lectureDay=?, price=?, teacherNames=?, "
				+ " lectureCapacity=? WHERE lid=?";
		jdbcTemplate.update(sql, lecture.getName(), lecture.getSchoolcate(), lecture.getGradecate(),
				lecture.getSubject(), lecture.getStartLectureTime(), lecture.getFinishLectureTime(),
				lecture.getStartLectureDate(), lecture.getFinishLectureDate(), lecture.getLectureDay(),
				lecture.getPrice(), lecture.getTeacher(), lecture.getLectureCapacity(),
				lecture.getLid()
				);
		
	}
	

}
