package com.varxyz.eka.score.scorecategory.service;

import java.util.List;

import com.varxyz.eka.score.scorecategory.domain.ScoreCategory;

/*
 * EKA 관리자는 점수카테고리를 관리한다
 * */
public interface ScoreCategoryService {

	//EKA 관리자는 점수카테고리를 등록할 수 있다
	public boolean addScoreCategory(ScoreCategory scoreCategory);
	
	//EKA 관리자는 점수카테고리를 수정할 수 있어야 한다
	public boolean updateScoreCategory(ScoreCategory scoreCategory);
	
	//EKA 관리자는 점수카테고리를 삭제할 수 있어야 한다
	public boolean deleteScoreCategory(ScoreCategory scoreCategory);
	
	/*
	 * EKA관리자는 점수카테고리 조회가 가능
	 * */
	//EKA 관리자는 모든 카테고리 확인 가능하다
	public List<ScoreCategory> findAllScoreCategory();
	
	//EKA 관리자는 AREA(장소별) 카테고리 확인이 가능하다
	public List<ScoreCategory> findAreaScoreCategory();
	
	//EKA 관리자는 TESTTYPE(시험점수별) 카테고리 확인이 가능하다
	public List<ScoreCategory> findTestTypeScoreCategory();
	
	//EKA 관리자는 SUBJECT(과목별) 카테고리 확인이 가능하다
	public List<ScoreCategory> findSubjectScoreCategory();
	
	//EKA 관리자는 특정 카테고리를 찾아와야 한다
	public ScoreCategory findScoreCategoryByAreaTestTypeAndSubjectCategory
	(String areaCategory, String TestTypeCategory, String SubjectCategory);
}
