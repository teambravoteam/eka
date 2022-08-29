
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

	/**
	 * 두 지점간의 거리 계산
	 *
	 * @param lat1 지점 1 위도
	 * @param lon1 지점 1 경도
	 * @param lat2 지점 2 위도
	 * @param lon2 지점 2 경도
	 * @param unit 거리 표출단위
	 * @return
	 */
	public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		if (unit == "kilometer") {
			dist = dist * 1.609344;
		} else if (unit == "meter") {
			dist = dist * 1609.344;
		}

		return (dist);
	}

	// This function converts decimal degrees to radians
	public double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	public double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
