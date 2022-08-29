package com.varxyz.eka.academy.lecture.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.command.LectureStudentCommand;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.student.domain.Student;

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
		String sql = "SELECT * FROM Lecture WHERE academyId=? AND lectureDay = ?";
//		String day = "%"+lectureDay+"%";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), lectureDay);
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
	
	//임시)학생이름으로 학생 찾기
	public List<Student> findStudentByName(Academy academy, String name) {
		String sql = "SELECT * FROM Student WHERE academyId=? AND name LIKE ?";
		String likeName = "%"+name+"%";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), likeName);
	}
	
	// lid로 강의정보 찾기
	public Lecture findLectureBylid(long lid) {
		String sql = "SELECT * FROM Lecture WHERE lid=?";
		return jdbcTemplate.queryForObject(sql, new LectureListRowMapper(), lid);
	}
	
	// 강좌별 수강생 등록
	public void addLectureStudent(long aid, long lid, long sid) {
		String sql = "INSERT INTO LectureStudent(academyId, lectureId, studentId)"
				+ " VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, aid, lid, sid);
	}
	
	// 강좌별 수강생 있는지 확인
	public List<Student> checkLectureStudent(long aid, long lid, long sid) {
		String sql = "SELECT * FROM LectureStudent a JOIN Student b "
				+ " ON a.studentId = b.sid "
				+ " WHERE a.lectureId = ? AND b.sid =?";
		return jdbcTemplate.query(sql, new LectureStudentRowMapper(), lid, sid);
	}
		
	// 강좌별 수강생 조회
	public List<Student> findLectureStudentList(long lid) {
		String sql = "SELECT * FROM LectureStudent a JOIN Student b "
				+ " ON a.studentId = b.sid "
				+ " WHERE a.lectureId = ?";
		return jdbcTemplate.query(sql, new LectureStudentRowMapper(), lid);
	}
	
	//score=0
	public List<LectureStudentCommand> findLectureStudentList2(long lid) {
		String sql = "SELECT * FROM LectureStudent a JOIN Student b "
				+ " ON a.studentId = b.sid "
				+ " WHERE a.lectureId = ?";
		return jdbcTemplate.query(sql, new LectureStudentRowMapper2(), lid);
	}
	
	
	// 강좌별 수강생 삭제
	public void deleteLectureStudent(long lid, long sid) {
		String sql = "DELETE FROM LectureStudent WHERE lectureId = ? AND studentId =?";
		jdbcTemplate.update(sql, lid, sid);
	}
	
	// 강좌id 조회
	public long findLidByAidAndName(long aid, String name) {
		String sql = "SELECT lid FROM Lecture WHERE academyId = ? AND name = ?";
		return jdbcTemplate.queryForObject(sql, Long.class, aid, name);
	}
	
	// 강좌명으로 검색
	public List<Lecture> findAcademyLectureByName(Academy academy, String name) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND name LIKE ?";
		String likeName = "%"+name+"%";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), likeName);
	}
	
	// 기간으로 강좌 조회
	public List<Lecture> findAcademyLecturesByDate(Academy academy, String startLectureDate, String finishLectureDate) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND startLectureDate =? AND finishLectureDate=? ";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), startLectureDate, finishLectureDate);
	}

	// 시간으로 강좌 조회
	public List<Lecture> findAcademyLecturesByTime(Academy academy, String startLectureTime, String finishLectureTime) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND startLectureTime =? AND finishLectureTime=? ";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), startLectureTime, finishLectureTime);
	}
	// 강좌이름으로 강좌id찾기
	public Lecture findLectureIdByLectureName(Academy academy, String name) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND name =?";
		return jdbcTemplate.queryForObject(sql, new LectureListRowMapper(), academy.getAid(), name);
	}
	
	//학생이 수강중인 강의찾기
	public List<Lecture> findLectureBySid(Academy academy, long sid) {
		String sql = "SELECT * FROM Lecture a JOIN LectureStudent b ON a.lid = b.lectureId"
				+ " WHERE b.studentId = ?";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), sid);
	}

	public List<Lecture> findAcademyLectureByAll(Academy academy, String subject, String teacher,
			String startLectureDate, String finishLectureDate, String startLectureTime, String finishLectureTime,
			String lectureDay, String name) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND subject=? AND teacher =? AND "
				+ " startLectureTime =? AND finishLectureTime=? AND startLectureTime=? AND finishLectureTime=? "
				+ " AND lectureDay=? AND name=?";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), startLectureTime, finishLectureTime);
	}

	public List<Lecture> findAcademyLectureBySubjectTeacher(Academy academy, String subject, String teacher) {
		String sql = "SELECT * FROM Lecture WHERE academyId = ? AND subject =? AND teacher=? ";
		return jdbcTemplate.query(sql, new LectureListRowMapper(), academy.getAid(), subject, teacher);
	
	}
	
	
	
	
	

}
