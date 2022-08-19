package com.varxyz.eka.academy.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.repository.LectureDao;
import com.varxyz.eka.academy.teacher.domain.Teacher;

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

	public boolean deleteLecture(Lecture lecture) {
		return false;
	}
	
	// 전체 강좌 조회
	public List<Lecture> findallAcademyLectures(Academy academy) {
		return ldao.findAllLecture(academy);
	}
	
	// 과목으로 검색
	public List<Lecture> findAcademyLecturesBySubject(Academy academy, String subject) {
		return ldao.findAcademyLecturesBySubject(academy, subject);
	}
	
	// 강사로 검색
	public List<Lecture> findAcademyLecturesByTeacher(Academy academy, String teacher) {
		return ldao.findAcademyLecturesByTeacher(academy, teacher);
	}
	
	// 요일로 검색
	public List<Lecture> findAcademyLecturesByLectureDay(Academy academy, String lectureDay) {
		return ldao.findAcademyLecturesByLectureDay(academy, lectureDay);
	}
	
	public List<Lecture> findAcademyLecturesByStartLectureTime(Academy academy, String time) {
		return null;
	}

	public List<Lecture> findAcademyLecturesByFinishLectureTime(Academy academy, String time) {
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

	public Lecture findAcademyLectureByName(Academy academy, String name) {
		return null;
	}

}