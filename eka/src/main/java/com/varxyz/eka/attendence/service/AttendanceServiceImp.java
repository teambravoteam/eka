package com.varxyz.eka.attendence.service;

import java.sql.Date;
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
		// TODO Auto-generated method stub
		return false;
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

}
