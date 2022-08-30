package com.varxyz.eka.attendence.repository;

import java.util.Date;
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
	
	public void updateAttendece(Attendence atttendence) {
		String sql = "UPDATE Attendance SET checking = ?  WHERE aid = ? ;";
		jdbcTemplate.update(sql,atttendence.getChecking(),atttendence.getAid());
	}
	
	public void updateAttendance(Attendence atttendence) {
		String sql = "UPDATE Attendance SET checking = ?  WHERE studentId = ? AND lectureDate = ? AND lectureId = ? ;";
		jdbcTemplate.update(sql,atttendence.getChecking(),atttendence.getStudent().getSid(), atttendence.getRegDate(), atttendence.getLecture().getLid());
	}

	public List<Attendence> findAcademyAttendanceByLecture(Lecture lc) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? ;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getLid());
	}

	// dada
	public List<Attendence> findAllAcademyStudent(Lecture lc) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE b.academyId = ? ;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getAcademy().getAid());
	}

	public List<Attendence> findAcademyStudentByStudentName(Lecture lc, String name) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE b.academyId = ? AND b.name = ? ;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getAcademy().getAid(), name);
	}

	public List<Attendence> findAcademyStudentByLectureDate(Lecture lc, String attendanceDate) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE b.academyId = ? AND a.lectureDate = ?;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getAcademy().getAid(), attendanceDate);
	}

	public List<Attendence> findAcademyStudentByLectureAndStudentName(Lecture lc, String studentName) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? AND b.name ;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getLid(),studentName);
	}

	public List<Attendence> findAcademyStudentByLectureAndLectureDate(Lecture lc, String attendanceDate) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? AND lectureDate = ? ;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getLid(),attendanceDate);
	}

	public List<Attendence> findAcademyStudentByStudentNameAndLectureDate(Lecture lc, String studentName,
			String attendanceDate) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE b.academyId = ? AND b.name = ? AND lectureDate = ?;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getAcademy().getAid(),studentName,attendanceDate);
	}

	public List<Attendence> findAcademyStudentByLectureAndStudentNameAndLectureDate(Lecture lc, String studentName,
			String attendanceDate) {
		String sql = "SELECT * FROM Attendance a JOIN Student b ON a.studentId = b.sid WHERE lectureId = ? AND b.name = ? AND lectureDate = ?;";
		return jdbcTemplate.query(sql, new AttendanceRowMapper(), lc.getLid(),studentName,attendanceDate);
	}

	

}
