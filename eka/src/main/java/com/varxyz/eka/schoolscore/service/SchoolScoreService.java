package com.varxyz.eka.schoolscore.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.schoolscore.category.domain.TestSubjectCategory;
import com.varxyz.eka.schoolscore.domain.SchoolScore;
import com.varxyz.eka.student.domain.Student;


/*
 * 학원관리자는 학교 점수를 관리합니다
 * */
public interface SchoolScoreService {

		//학원관리자는 점수정보를 등록합니다
		public boolean addScore(SchoolScore schoolscore);
		
		//학원관리자는  점수정보를 수정합니다.
		public boolean updateScore(SchoolScore schoolscore);
		
		//학원관리자는 점수정보를 삭제합니다
		public boolean deleteScore(SchoolScore schoolscore);
		
		/*
		 * 학원 관리자는 다양한 점수정보를 조회할수 있습니다.
		 * */		
		//학원관리자는 학원의 모든 학교점수정보를 알 수 있다.
		public List<SchoolScore> findAllSchoolScore(Academy academy);
		
		//학원관리자는 학원생의 모든 학교점수정보를 알 수 있다
		public List<SchoolScore> findSchoolScoreByStudent(Academy academy, Student student);
		
		//학원관리자는 일정 날짜의 모든 점수정보를 알 수 있다
		public List<SchoolScore> findSchoolScoreByTestDate(Academy academy, String testDate);
		
		//학원관리자는 일정 학생의 일정 날짜의 모든 점수정보를 알 수 있다
		public SchoolScore findSchoolScoreByTestDateAndStudent(Academy academy, String testDate, Student student);
			
		//학원관리자는 학교에서 등록된 카테고리에 점수 정보를 알 수 있다
		public List<SchoolScore> findSchoolScoresByCategory(Academy academy, TestSubjectCategory category);

		// 학원관리자는 일정 점수 이상의 점수 정보를 알 수 있다
		public List<SchoolScore> findSchoolScoresByUpScore(Academy academy, double testScore);

		// 학원관리자는 일정 점수 이하의 점수 정보를 알 수 있다
		public List<SchoolScore> findSchoolScoresByDownScore(Academy academy, double testScore);

		// 학원관리자는 일정 학생의 일정 점수 이상의 점수 정보를 알 수 있다
		public List<SchoolScore> findSchoolScoresByUpScoreAndStudent(Academy academy, Student student, double testScore);

		// 학원관리자는 일정 학생의 일정 점수 이하의 점수 정보를 알 수 있다
		public List<SchoolScore> findSchoolScoresByDownScoreAndStudent(Academy academy, Student student, double testScore);
}
