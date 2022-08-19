package com.varxyz.eka.consulting.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.consulting.category.domain.ConsultCategory;
import com.varxyz.eka.consulting.domain.Consulting;
import com.varxyz.eka.consulting.repository.ConsultingDao;

@Service("consultinService")
public class ConsultingServiceImp implements ConsultingService {
	@Autowired
	private ConsultingDao consultingDao;

	@Override
	public boolean addConsulting(Consulting consulting) {
		List<Consulting> consultingList =  consultingDao.findAllAcademyConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				return false;
			}
		}
		consultingDao.addConsulting(consulting);
		return true;
	}
	
	@Override
	public boolean addApplyConsulting(Consulting consulting) {
		List<Consulting> consultingList =  consultingDao.findAllAcademyConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				return false;
			}
		}
		consultingDao.addApplyConsulting(consulting);
		return true;
	}

	@Override
	public boolean addRegistConsulting(Consulting consulting) {
		List<Consulting> consultingList =  consultingDao.findAllAcademyConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				return false;
			}
		}
		consultingDao.addRegistConsulting(consulting);
		return true;
	}


	@Override
	public boolean updateConsulting(Consulting consulting) {
		
		List<Consulting> consultingList =  consultingDao.findAllAcademyApplyConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			System.out.println(a.getApplyDate() + "와" + consulting.getApplyDate() + "를 비교");
			System.out.println(a.getName() + "와" + consulting.getName() + "를 비교");
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				consultingDao.updateConsulting(consulting);
				return true;
			}
		}		
		return false;
	}
	
	
	public boolean updateRegistConsulting(Consulting consulting) {		
		List<Consulting> consultingList =  consultingDao.findAllAcademyRegistConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			System.out.println(a.getApplyDate() + "와" + consulting.getApplyDate() + "를 비교");
			System.out.println(a.getName() + "와" + consulting.getName() + "를 비교");
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				consultingDao.updateConsulting(consulting);
				return true;
			}
		}		
		return false;
	}

	@Override
	public boolean deleteConsulting(Consulting consulting) {
		List<Consulting> consultingList =  consultingDao.findAllAcademyConsulting(consulting.getAcademy());
		for(Consulting a : consultingList) {
			if(a.getApplyDate().equals(consulting.getApplyDate()) &&
					a.getName().equals(consulting.getName())) {
				consultingDao.deleteConsulting(consulting);
				return true;
			}
		}		
		return false;
	}

	@Override
	public List<Consulting> findAllAcademyConsulting(Academy academy) {		
		return consultingDao.findAllAcademyConsulting(academy);
	}
	

	@Override
	public List<Consulting> findAllAcademyApplyConsulting(Academy academy) {
		return consultingDao.findAllAcademyApplyConsulting(academy);
	}

	@Override
	public List<Consulting> findAllAcademyRegistConsulting(Academy academy) {
		return consultingDao.findAllAcademyRegistConsulting(academy);
	}

	@Override
	public List<Consulting> findAcademyConsultingsByName(Academy academy, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulting> findAcademyConsultingsByConsultCategory(Academy academy, ConsultCategory consultCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulting> findAcademyConsultingsByRegDat(Academy academy, Date regDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulting findAcademyConsultingByRegDateAndName(Academy academy, Date to, String name) {		
		return consultingDao.findAcademyApplyConsultingByRegDateAndName(academy,to,name);
	}

	@Override
	public Consulting findAcademyApplyConsultingByRegDateAndName(Academy academy, Date regDate, String name) {		
		return consultingDao.findAcademyApplyConsultingByRegDateAndName(academy,regDate,name);
	}

	@Override
	public Consulting findAcademyRegistConsultingByRegDateAndName(Academy academy, Date regDate, String name) {		
		return consultingDao.findAcademyRegistConsultingByRegDateAndName(academy,regDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategory(Academy academy, String consultCategory) {
		
		return consultingDao.findAllAcademyRegistConsultingByConsultCategory(academy,consultCategory);
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDate(Academy academy, String applyDate) {

		return consultingDao.findAllAcademyRegistConsultingByApplyDate(academy,applyDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByRegistDate(Academy academy, String registDate) {

		return consultingDao.findAllAcademyRegistConsultingByRegistDate(academy,registDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByName(Academy academy, String name) {

		return consultingDao.findAllAcademyRegistConsultingByName(academy,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDate(Academy academy,
			String consultCategory, String applyDate) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndApplyDate(academy,consultCategory,applyDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndRegistDate(Academy academy,
			String consultCategory, String registDate) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndRegistDate(academy,consultCategory,registDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndName(Academy academy,
			String consultCategory, String name) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndName(academy,consultCategory,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndRegistDate(Academy academy, String applyDate,
			String registDate) {

		return consultingDao.findAllAcademyRegistConsultingByApplyDateAndRegistDate(academy,applyDate,registDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndName(Academy academy, String applyDate,
			String name) {

		return consultingDao.findAllAcademyRegistConsultingByApplyDateAndName(academy,applyDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByRegistDateAndName(Academy academy, String registDate,
			String name) {

		return consultingDao.findAllAcademyRegistConsultingByRegistDateAndName(academy,registDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDate(Academy academy,
			String consultCategory, String applyDate, String registDate) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDate(academy,consultCategory,applyDate,registDate);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndName(Academy academy,
			String consultCategory, String applyDate, String name) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndName(academy,consultCategory,applyDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndRegistDateAndName(Academy academy,
			String consultCategory, String registDate, String name) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndRegistDateAndName(academy,consultCategory,registDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByApplyDateAndRegistDateAndName(Academy academy,
			String applyDate, String registDate, String name) {

		return consultingDao.findAllAcademyRegistConsultingByApplyDateAndRegistDateAndName(academy,applyDate,registDate,name);
	}

	public List<Consulting> findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDateAndName(
			Academy academy, String consultCategory, String applyDate, String registDate, String name) {

		return consultingDao.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDateAndName(academy,consultCategory,applyDate,registDate,name);
	}



}
