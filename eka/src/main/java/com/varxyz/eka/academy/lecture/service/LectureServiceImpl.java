package com.varxyz.eka.academy.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.repository.LectureDao;
import com.varxyz.eka.student.domain.Student;

@Service
public class LectureServiceImpl {
	
	@Autowired
	private LectureDao ldao;

	// 강좌 등록
	public boolean addLecture(Lecture lecture) {
		try {
			ldao.addLecture(lecture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 강좌 수정
	public boolean updateLecture(Lecture lecture) {
		try {
			ldao.updateLecture(lecture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// 강좌 삭제
	public boolean deleteLecture(Lecture lecture) {
		return false;
	}
	
	
	// 전체 강좌 조회
	public List<Lecture> findallAcademyLectures(Academy academy) {
		return ldao.findAllLecture(academy);
	}
	
	//임시) 학생이름으로 학생 찾기
	public List<Student> findStudentByName(Academy academy, String name) {
		return ldao.findStudentByName(academy, name);
	}
	
	// 강의id로 강의정보 찾기
	public Lecture findLectureBylid(long lid) {
		return ldao.findLectureBylid(lid);
	}
	
	// 강좌별 수강생 등록
	public boolean addLectureStudent(long aid, long lid, long sid) {
		try {
			ldao.addLectureStudent(aid, lid, sid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 강좌별 수강생 조회
	public List<Student> findLectureStudentList(long lid) {
		return ldao.findLectureStudentList(lid);
	}
	
	// 강좌 수강생 삭제
	public boolean deleteLectureStudent(long lid, long sid) {
		try {
			ldao.deleteLectureStudent(lid, sid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// aid, name으로 lid조회
	public long findLidByAidAndName(long aid, String name) {
		return ldao.findLidByAidAndName(aid, name);
	}
	
	// 과목으로 검색
	public List<Lecture> findAcademyLecturesBySubject(Academy academy, String subject) {
		return ldao.findAcademyLecturesBySubject(academy, subject);
	}
	
	// 강사로 검색
	public List<Lecture> findAcademyLecturesByTeacher(Academy academy, String lectureDay) {
		return ldao.findAcademyLecturesByTeacher(academy, lectureDay);
	}
	
	// 요일로 검색
	public List<Lecture> findAcademyLecturesByLectureDay(Academy academy, String lectureDay) {
		return ldao.findAcademyLecturesByLectureDay(academy, lectureDay);
	}
	
	// 강좌명으로 검색 List
	public List<Lecture> findAcademyLectureByName(Academy academy, String name) {
		return ldao.findAcademyLectureByName(academy,name);
	}
	//강좌명으로 강의찾기
	public Lecture findLectureIdByLectureName(Academy academy, String name) {
		return ldao.findLectureIdByLectureName(academy,name);
	}
	
	// 강의 기간으로조회
	public List<Lecture> findAcademyLecturesByDate(Academy academy, String startLectureDate, String finishLectureDate) {
		return ldao.findAcademyLecturesByDate(academy, startLectureDate, finishLectureDate);
	}
	
	public List<Lecture> findAcademyLecturesByTime(Academy academy, String startLectureTime, String finishLectureTime) {
		return ldao.findAcademyLecturesByTime(academy,startLectureTime,finishLectureTime);
	}
	
	public List<Lecture> findAcademyLecturesByStartLectureTime(Academy academy, String time) {
		return null;
	}


	public List<Lecture> findAcademyLecturesByStartLectureDate(Academy academy, String date) {
		return null;
	}

	public List<Lecture> findAcademyLecturesByFinishLectureDate(Academy academy, String date) {
		return null;
	}



	public List<Lecture> findAcademyLecturesByUpPrice(Academy academy, double price) {
		return null;
	}

	public List<Lecture> findAcademyLecturesByDownPrice(Academy academy, double price) {
		return null;
	}

	public List<Lecture> findAcademyLecturesByUpLectureCapacity(Academy academy, long lecturCapacity) {
		return null;
	}

	public List<Lecture> findAcademyLecturesByDownLectureCapacity(Academy academy, long lecturCapacity) {
		return null;
	}

	

}
