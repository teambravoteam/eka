package com.varxyz.eka.academy.academy.service;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.repository.AcademyDao;

@Service("academyListService")
public class AcademyListServiceImp implements AcademyListService {

	@Autowired
	private AcademyDao academyDao;

	public AcademyListServiceImp(DataSource dataSource) {
		academyDao = new AcademyDao(dataSource);
	}

	@Override
	public List<Academy> findAllAcademies() {
		// TODO Auto-generated method stub
		return academyDao.findAllAcademies();
	}

	@Override
	public List<Academy> findAcademiesByAddress(String address) {
		// TODO Auto-generated method stub
		return academyDao.findAcademiesByAddress(address);
	}
}
