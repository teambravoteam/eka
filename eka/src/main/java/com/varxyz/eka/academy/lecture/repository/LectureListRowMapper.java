package com.varxyz.eka.academy.lecture.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;

public class LectureListRowMapper implements RowMapper<Lecture> {

	@Override
	public Lecture mapRow(ResultSet rs, int rowNum) throws SQLException {
		Lecture lecture = new Lecture();
		Academy academy = new Academy();
		
		academy.setAid(rs.getLong("academyId"));
		lecture.setLid(rs.getLong("lid"));
		lecture.setAcademy(academy);
		lecture.setName(rs.getString("name"));
		lecture.setSchoolcate(rs.getString("schoolcate"));
		lecture.setGradecate(rs.getString("gradecate"));
		lecture.setSubject(rs.getString("subject"));
		lecture.setStartLectureTime(rs.getString("startLectureTime"));
		lecture.setFinishLectureTime(rs.getString("finishLectureTime"));
		lecture.setStartLectureDate(rs.getString("startLectureDate"));
		lecture.setFinishLectureDate(rs.getString("finishLectureDate"));
		lecture.setLectureDay(rs.getString("lectureDay"));
		lecture.setPrice(rs.getLong("price"));
		lecture.setTeacher(rs.getString("teacherNames"));
		lecture.setLectureCapacity(rs.getInt("lectureCapacity"));
		
		return lecture;
	}
}
