package com.varxyz.eka.academy.academycategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.varxyz.eka.academy.academycategory.domain.AgeCategory;
import com.varxyz.eka.academy.academycategory.domain.MainSubjectCategory;
import com.varxyz.eka.academy.academycategory.domain.SubjectCategory;
import com.varxyz.eka.academy.academycategory.repository.AcademyCategoryDao;

@Service("academyCategoryService")
public class AcademyCategoryServiceImp implements AcademyCategoryService {

	@Autowired
	private AcademyCategoryDao academyCategoryDao;

	@Override
	public boolean addAgeCategory(AgeCategory ageCategory) {
		List<AgeCategory> ageCategoryList =  academyCategoryDao.findAllAgeCategory();
		for(AgeCategory a : ageCategoryList) {
			if(a.getAgeCategoryId() == ageCategory.getAgeCategoryId()) {
				return false;
			}
		}
		academyCategoryDao.addAgeCategory(ageCategory);
		return true;
	}

	@Override
	public boolean addMainSubjectCategory(MainSubjectCategory mainSubjectCategory) {
		List<MainSubjectCategory> mainSubjectCategoryList =
				academyCategoryDao.findAllMainSubjectCategory();
		for(MainSubjectCategory a : mainSubjectCategoryList) {
			if(a.getMainCategoryId() == mainSubjectCategory.getMainCategoryId()) {
				return false;
			}
		}
		academyCategoryDao.addMainSubjectCategory(mainSubjectCategory);
		return true;
	}
	
	@Override
	public boolean addSubjectCategory(SubjectCategory subjectCategory) {
		List<SubjectCategory> subjectCategoryList =  academyCategoryDao.findAllSubjectCategory();
		for(SubjectCategory a : subjectCategoryList) {
			if(a.getSubjectCategoryId() == subjectCategory.getSubjectCategoryId()) {
				return false;
			}
		}
		academyCategoryDao.addSubjectCategory(subjectCategory);
		return true;
	}

	@Override
	public boolean updateAgeCategory(AgeCategory ageCategory) {
		List<AgeCategory> ageCategoryList =  academyCategoryDao.findAllAgeCategory();
		for(AgeCategory a : ageCategoryList) {
			if(a.getAgeCategoryId() == ageCategory.getAgeCategoryId()) {
				academyCategoryDao.updateAgeCategory(ageCategory);
				return true;
			}
		}		
		return false;
	}

	@Override
	public boolean updateMainSubjectCategory(MainSubjectCategory mainSubjectCategory) {
		List<MainSubjectCategory> mainSubjectCategoryList =
				academyCategoryDao.findAllMainSubjectCategory();
		for(MainSubjectCategory a : mainSubjectCategoryList) {
			if(a.getMainCategoryId() == mainSubjectCategory.getMainCategoryId()) {
				academyCategoryDao.updateMainSubjectCategory(mainSubjectCategory);
				return true;
			}
		}		
		return false;
	}

	@Override
	public boolean updateSubjectCategory(SubjectCategory subjectCategory) {
		List<SubjectCategory> subjectCategoryList =  academyCategoryDao.findAllSubjectCategory();
		for(SubjectCategory a : subjectCategoryList) {
			if(a.getSubjectCategoryId() == subjectCategory.getSubjectCategoryId()) {
				academyCategoryDao.updateSubjectCategory(subjectCategory);
				return true;
			}
		}		
		return false;
	}

	@Override
	public boolean deleteAgeCategory(AgeCategory ageCategory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMainSubjectCategory(MainSubjectCategory mainSubjectCategorty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSubJectCategory(SubjectCategory subjectCategorty) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// 과목 카테고리 조회
	@Override
	public List<SubjectCategory> findAllSubjectCategory() {		
		return academyCategoryDao.findAllSubjectCategory();
	}

	@Override
	public List<AgeCategory> findAllAgeCategory() {		
		return academyCategoryDao.findAllAgeCategory();
	}

	@Override
	public List<MainSubjectCategory> findAllMainSubjectCategory() {		
		return academyCategoryDao.findAllMainSubjectCategory();
	}

	@Override
	public SubjectCategory findAcademyCategoryByName(SubjectCategory subjectCategory) {
		
		return null;
	}

	@Override
	public List<SubjectCategory> findSubjectCategoryByMainCategory(String ageCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectCategory> findSubjectCategoryByAgeCategory(String mainCategory) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
