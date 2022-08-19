package com.varxyz.eka.academyscore.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academyscore.category.domain.AcademyTestCategory;
import com.varxyz.eka.academyscore.domain.AcademyScore;
import com.varxyz.eka.student.domain.Student;

/*
 * 학원관리자는 학원 점수를 관리합니다
 * */
public interface AcademyScoreService {
			//학원관리자는 점수정보를 등록합니다
			public boolean addScore(AcademyScore academyscore);
			
			//학원관리자는 점수정보를 수정합니다.
			public boolean updateScore(AcademyScore academyscore);
			
			//학원관리자는 점수정보를 삭제합니다
			public boolean deleteScore(AcademyScore academyscore);
			
			/*
			 * 학원 관리자는 다 양한 점수정보를 조회할수 있습니다.
			 * */		
			//학원관리자는 학원의 모든 학교점수정보를 알 수 있다.
			public List<AcademyScore> findAllAcademyScore(Academy academy);
			
			//학원관리자는 학원생의 모든 학교점수정보를 알 수 있다
			public List<AcademyScore> findAcademyScoreByStudent(Academy academy, Student student);
			
			//학원관리자는 일정 날짜의 모든 점수정보를 알 수 있다
			public List<AcademyScore> findAcademyScoreByTestDate(Academy academy, String testDate);
			
			//학원관리자는 일정 학생의 일정 날짜의 모든 점수정보를 알 수 있다
			public AcademyScore findAcademyScoreByTestDateAndStudent(Academy academy, String testDate, Student student);
				
			//학원관리자는 학원에서 등록된 카테고리에 점수 정보를 알 수 있다
			public List<AcademyScore> findAcademyScoresByCategory(Academy academy, AcademyTestCategory category);

			// 학원관리자는 일정 점수 이상의 점수 정보를 알 수 있다
			public List<AcademyScore> findAcademyScoresByUpScore(Academy academy, double testScore);

			// 학원관리자는 일정 점수 이하의 점수 정보를 알 수 있다
			public List<AcademyScore> findAcademyScoresByDownScore(Academy academy, double testScore);

			// 학원관리자는 일정 학생의 일정 점수 이상의 점수 정보를 알 수 있다
			public List<AcademyScore> findAcademyScoresByUpScoreAndStudent(Academy academy, Student student, double testScore);

			// 학원관리자는 일정 학생의 일정 점수 이하의 점수 정보를 알 수 있다
			public List<AcademyScore> findAcademyScoresByDownScoreAndStudent(Academy academy, Student student, double testScore);
}
