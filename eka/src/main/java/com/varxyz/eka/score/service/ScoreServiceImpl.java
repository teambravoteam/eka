package com.varxyz.eka.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.repository.ScoreDao;
import com.varxyz.eka.student.domain.Student;

@Service
public class ScoreServiceImpl {
	
	@Autowired
	private ScoreDao dao;
	
	//시험정보 등록
	public boolean addAcademyScoreCategory(Score score) {
		try {
			dao.addAcademyScoreCategory(score);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 과목명으로 시험정보 리스트 조회
	public List<Score> findTestName(long aid, String lecturename) {
		return dao.findTestName(aid, lecturename);
	}
		 
	public boolean addScore(Score score) {
//		 TODO Auto-generated method stub
		return false;
	}

	public boolean updateScore(Score score) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteScore(Score score) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Score> findAllAcademyScore(Academy academy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoreByStudent(Academy academy, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoreByTestDate(Academy academy, String testDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public Score findAcademyScoreByTestDateAndStudent(Academy academy, String testDate, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoresByCategory(Academy academy, Score score) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoresByUpScore(Academy academy, double testScore) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoresByDownScore(Academy academy, double testScore) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoresByUpScoreAndStudent(Academy academy, Student student, double testScore) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Score> findAcademyScoresByDownScoreAndStudent(Academy academy, Student student, double testScore) {
		// TODO Auto-generated method stub
		return null;
	}

}
