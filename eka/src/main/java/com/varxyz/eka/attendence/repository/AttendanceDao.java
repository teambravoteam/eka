package com.varxyz.eka.attendence.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.repository.LectureStudentRowMapper;
import com.varxyz.eka.attendence.domain.AttendanceStudent;
import com.varxyz.eka.attendence.domain.Attendence;
import com.varxyz.eka.student.domain.Student;

@Controller
public class AttendanceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AttendanceDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Student> findAcademyStudentsByLecture(Lecture lecture) {
		String sql = "SELECT * FROM LectureStudent a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? ;";
		return jdbcTemplate.query(sql, new LectureStudentRowMapper(), lecture.getLid());
	}
	
	public List<AttendanceStudent> findAcademyStudentsByLectures(Lecture lecture) {
		String sql = "SELECT * FROM LectureStudent a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? ;";
		return jdbcTemplate.query(sql, new AttendanceStudentRowMapper(), lecture.getLid());
	}

	public void addAttendece(Attendence attendence) {
		String sql = "INSERT Attendance(studentId,checking,lectureId, academyId, lectureDate) VALUES (?,?,?,?,?) ;";
		jdbcTemplate.update(sql,attendence.getStudent().getSid(),
				attendence.getChecking(),attendence.getLecture().getLid(),
				attendence.getAcademy().getAid(),attendence.getRegDate());
	}

}
