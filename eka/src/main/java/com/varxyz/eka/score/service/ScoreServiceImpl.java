package com.varxyz.eka.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.command.LectureStudentCommand;
import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.domain.ScoreCategory;
import com.varxyz.eka.score.repository.ScoreDao;
import com.varxyz.eka.student.domain.Student;

@Service
public class ScoreServiceImpl {
	
	@Autowired
	private ScoreDao dao;
	
	//시험정보 등록
	public boolean addAcademyScoreCategory(ScoreCategory scoreCategory) {
		try {
			dao.addAcademyScoreCategory(scoreCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//시험명 중복체크
	public List<ScoreCategory> findSameTestName(Academy academy, String lectureName, String testName) {
		return dao.findSameTestName(academy, lectureName, testName);
	}
	
	// 과목명으로 시험정보 리스트 조회
	public List<ScoreCategory> findTestName(long aid, String lectureName) {
		return dao.findTestName(aid, lectureName);
	}
	
	
	// 점수 등록
	public boolean addScore(long scid, String name, int sid, double score) {
		try {
			dao.addScore(scid, name, sid, score);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// 시험점수 수정
	public boolean updateScore(long scid, String name, int sid, double score) {
		try {
			dao.updateScore(scid, name, sid, score);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//atcid로 성적테이블에 데이터가 있는지 찾기
	public List<Score> findListByAtcid(long atcid) {
		return dao.findListByAtcid(atcid);
	}
	
	// atcid로 성적조회
	public List<LectureStudentCommand> findStudentScore(long atcid) {
		return dao.findStudentScore(atcid);
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
