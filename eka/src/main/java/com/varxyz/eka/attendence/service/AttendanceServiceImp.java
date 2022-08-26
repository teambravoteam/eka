package com.varxyz.eka.attendence.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.attendence.domain.AttendanceStudent;
import com.varxyz.eka.attendence.domain.Attendence;
import com.varxyz.eka.attendence.repository.AttendanceDao;
import com.varxyz.eka.student.domain.Student;

@Service("attendanceService")
public class AttendanceServiceImp implements AttendenceService {
	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public boolean addAttendece(Attendence attendence) {	
		attendanceDao.addAttendece(attendence);
		return true;
	}

	@Override
	public boolean updateAttendence(Attendence atttendence) {
		attendanceDao.updateAttendece(atttendence);
		return true;
	}

	@Override
	public List<Attendence> findAllAcademyAttendences(Academy academy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendence> findAcademyAttendencesByStudentName(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendence> findAcademyAttendencesByLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Attendence> findAcademyAttendanceByLecture(Lecture lc) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyAttendanceByLecture(lc);
	}
	
	public List<Student> findAcademyStudentsByLecture(Lecture lecture){
		return attendanceDao.findAcademyStudentsByLecture(lecture);
	}
	
	public List<AttendanceStudent> findAcademyStudentByLecture(Lecture lecture){
		return attendanceDao.findAcademyStudentsByLectures(lecture);
	}

	@Override
	public List<Attendence> findAcademyAttendencesByDate(Academy academy, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendence findAcademyAttendenceByLectureAndStudentName(Academy academy, Lecture lecture, Student student,
			Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// dad

	public List<Attendence> findAllAcademyStudent(Lecture lc) {
		// TODO Auto-generated method stub
		return attendanceDao.findAllAcademyStudent(lc);
	}

	public List<Attendence> findAcademyStudentByStudentName(Lecture lc, String name) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByStudentName(lc,name);
	}

	public List<Attendence> findAcademyStudentByLectureDate(Lecture lc, String attendanceDate) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByLectureDate(lc,attendanceDate);
	}

	public List<Attendence> findAcademyStudentByLectureAndStudentName(Lecture lc, String studentName) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByLectureAndStudentName(lc,studentName);
	}

	public List<Attendence> findAcademyStudentByLectureAndLectureDate(Lecture lc, String attendanceDate) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByLectureAndLectureDate(lc,attendanceDate);
	}

	public List<Attendence> findAcademyStudentByStudentNameAndLectureDate(Lecture lc, String studentName, String attendanceDate) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByStudentNameAndLectureDate(lc,studentName,attendanceDate);
	}

	public List<Attendence> findAcademyStudentByLectureAndStudentNameAndLectureDate(Lecture lc, String studentName, String attendanceDate) {
		// TODO Auto-generated method stub
		return attendanceDao.findAcademyStudentByLectureAndStudentNameAndLectureDate(lc,studentName,attendanceDate);
	}

	

}