package com.varxyz.eka.attendence.service;

import java.sql.Date;
import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.attendence.domain.Attendence;
import com.varxyz.eka.student.domain.Student;

/*
 * 학원관리자는 학생들의 출석을 관리/수정/첨부/및 확인이 용이 하여야 한다 * 
 * */
public interface AttendenceService {
	
	//학원관리자는 출석을 등재할 수 있어야 한다
	public boolean addAttendece(Attendence attendence);
	
	//학원관리자는 출석을 수정 할 수 있어야 한다
	public boolean updateAttendence(Attendence atttendence);
	
	//학원관리자는 출석 삭제가 필요가 없다
	// 그 이유는 출석은 계속 쌓이는 데이터 이므로 굳이 삭제의 필요성이 없기 때문이다.
	
	/*
	 * 학원관리자는 출석을 다양한 용도에 맞게 찾을 수 있어야 한다
	 * */	
	//학원관리자는 자신 학원의 모든 출석을 찾을 수 있어야 한다
	public List<Attendence> findAllAcademyAttendences(Academy academy);	
	
	//학원관리자는 특정 학생의 출석정보를 찾을 수 있어야한다
	public List<Attendence> findAcademyAttendencesByStudentName(Student student);
	
	//학원관리자는 특정 강의의 출석 정보를 알아야 한다.
	public List<Attendence> findAcademyAttendencesByLecture(Lecture lecture);
	
	//학원관리자는 학원의 특정 날짜 정보를 알아야 한다
	public List<Attendence> findAcademyAttendencesByDate(Academy academy, Date date);
	
	//학원관리자는 학원의 특정 강의에 수강한 학생의 출석 정보를 알아야 한다
	public Attendence findAcademyAttendenceByLectureAndStudentName(Academy academy, Lecture lecture, Student student, Date date);
	
}
