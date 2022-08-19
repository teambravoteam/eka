package com.varxyz.eka.academy.lecture.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.teacher.domain.Teacher;

//lecture 는 학원의 관리자가 관리하는 영역으로 분류된다
// 즉 EKA의 관리자가 아닌 학원을 운영하는 자가 사용하는 기능이다
public interface LecutureService {

	//학원관리자는 강좌를 등록해야한다
	public boolean addLecture(Lecture lecture);
	
	//학원 관리자는 강좌의 정보를 수정이 가능해야한다
	public boolean updateLecture(Lecture lecture);
	
	//학원 관리자는 강좌를 삭제 할 수 있어야 한다
	public boolean deleteLecture(Lecture lecture);
	
	/*
	 * 학원 관리자는 여러 강좌의 정보를 가져올 수 있어야한다
	 * 이는 곧, 강좌를 데이터 화 함으로써 추후 학원 측에 이익이 되기 때문이다.
	 * */
	
	//학원 관리자는 자신 학원의 모든 강좌정보를 가져올 수 있어야 한다
	public List<Lecture> findallAcademyLectures(Academy academy);
	
	//학원 관리자는 자신 학원중 특정 과목의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesBySubject(Academy academy, String subject);
	
	//학원 관리자는 자신 학원 중 특정 시작 시간의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByStartLectureTime(Academy academy, String time);
	
	//학원 관리자는 자신 학원 중 특정 종료 시간의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByFinishLectureTime(Academy academy, String time);
	
	//학원 관리자는 자신 학원 중 특정 시작 기간의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByStartLectureDate(Academy academy, String date);
	
	//학원 관리자는 자신 학원 중 특정 종료 기간의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByFinishLectureDate(Academy academy, String date);
		
	//학원 관리자는 자신 학원 중 특정 날짜의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByLectureDay(Academy academy, String day);
	
	//학원 관리자는 자신 학원 중 특정 강사가 포함된 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByTeacher(Academy academy, Teacher teacher);		
		
	//학원 관리자는 자신 학원 중 특정 금액 이상의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByUpPrice(Academy academy, double price);
	
	//학원 관리자는 자신 학원 중 특정 금액 이하의 강좌정보를 가져올 수 있어야한다
	public List<Lecture> findAcademyLecturesByDownPrice(Academy academy, double price);
	
	//학원 관리자는 자신 학원 중 특정 수강생 이상의 강좌정보를 가져올 수 있어야 한다
	public List<Lecture> findAcademyLecturesByUpLectureCapacity(Academy academy, long lecturCapacity);
		
	//학원 관리자는 자신 학원 중 특정 수강생 이하의 강좌정보를 가져올 수 있어야 한다
	public List<Lecture> findAcademyLecturesByDownLectureCapacity(Academy academy, long lecturCapacity);
		
	//학원 관리자는 자신 학원 중 강좌의 이름으로 특정 강좌정보를 가져올 수 있어야한다
	public Lecture findAcademyLectureByName(Academy academy, String name);
	
}
