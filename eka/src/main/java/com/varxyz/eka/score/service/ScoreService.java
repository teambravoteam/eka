package com.varxyz.eka.score.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.domain.ScoreCategory;
import com.varxyz.eka.student.domain.Student;

/*
 * 학원관리자는 점수를 관리합니다
 * */
public interface ScoreService {

	//학원관리자는 점수정보를 등록합니다
	public boolean addScore(Score score);
	
	//학원관리자는 점수정보를 수정합니다.
	public boolean updateScore(Score score);
	
	//학원관리자는 점수정보를 삭제합니다
	public boolean deleteScore(Score score);
	
	/*
	 * 학원 관리자는 다양한 점수정보를 조회할수 있습니다.
	 * */
	
	
	//학원관리자는 학원의 모든 점수정보를 알 수 있다.
	public List<Score> findAllAcademyScore(Academy academy);
	
	//학원관리자는 학원생의 모든 점수정보를 알 수 있다
	public List<Score> findAcademyScoreByStudent(Academy academy, Student student);
	
	//학원관리자는 일정 날짜의 모든 점수정보를 알 수 있다
	public List<Score> findAcademyScoreByTestDate(Academy academy, String testDate);
	
	//학원관리자는 일정 학생의 일정 날짜의 모든 점수정보를 알 수 있다
	public Score findAcademyScoreByTestDateAndStudent(Academy academy, String testDate, Student student);
		
	//학원관리자는 학원에서 등록된 카테고리에 점수 정보를 알 수 있다
	public List<Score> findAcademyScoresByCategory(Academy academy, ScoreCategory scoreCategory);

	// 학원관리자는 일정 점수 이상의 점수 정보를 알 수 있다
	public List<Score> findAcademyScoresByUpScore(Academy academy, double testScore);

	// 학원관리자는 일정 점수 이하의 점수 정보를 알 수 있다
	public List<Score> findAcademyScoresByDownScore(Academy academy, double testScore);

	// 학원관리자는 일정 학생의 일정 점수 이상의 점수 정보를 알 수 있다
	public List<Score> findAcademyScoresByUpScoreAndStudent(Academy academy, Student student, double testScore);

	// 학원관리자는 일정 학생의 일정 점수 이하의 점수 정보를 알 수 있다
	public List<Score> findAcademyScoresByDownScoreAndStudent(Academy academy, Student student, double testScore);
}
