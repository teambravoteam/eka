
package com.varxyz.eka.academy.academy.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.repository.AcademyDao;
import com.varxyz.eka.student.domain.Student;

@Service("academyService")
public class AcademyServiceImp implements AcademyService {

	@Autowired
	private AcademyDao academyDao;

	public AcademyServiceImp(DataSource dataSource) {
		academyDao = new AcademyDao(dataSource);
	}
	
	@Override
	public void signEkaAcademy(Academy academy) {
		academyDao.signEkaAcademy(academy);
	}

	@Override
	public List<Academy> findAllAcademies() {
		// TODO Auto-generated method stub
		return academyDao.findAllAcademies();
	}

	@Override
	public List<Academy> findAcademiesByCategory(String field2) {
		// TODO Auto-generated method stub
		return academyDao.findAcademiesByCategory(field2);
	}

	@Override
	public List<Academy> findAcademiesByAddress(String address) {
		// TODO Auto-generated method stub
		return academyDao.findAcademiesByAddress(address);
	}

	@Override
	public Academy findAcademyByAddressAndName(String address, String name) {
		// TODO Auto-generated method stub
		return academyDao.findAcademyByAddressAndName(address, name);
	}

	@Override
	public Academy findAcademyByAid(long aid) {
		return academyDao.findAcademyByAid(aid);
	}

	@Override
	public Student findStudentByEkaUserId(String ekaUserId) {
		return academyDao.findStudentByEkaUserId(ekaUserId);
	}

	@Override
	public List<Student> findStudentsByEkaUserId(String ekaUserId) {
		return academyDao.findStudentsByEkaUserId(ekaUserId);
	}

	@Override
	public List<Academy> findAcademyByName(String name) {
		return academyDao.findAcademyByName(name);
	}

}
