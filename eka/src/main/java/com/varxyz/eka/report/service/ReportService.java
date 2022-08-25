package com.varxyz.eka.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.report.command.ReportAttendanceCommand;
import com.varxyz.eka.report.command.ReportScoreCommand;
import com.varxyz.eka.repository.ReportDao;

@Service
public class ReportService {
	
	@Autowired
	private ReportDao dao;
	
	@Autowired
	private LectureServiceImpl lservice;
	
	// sid로 출석정보 가져오기
	public List<ReportAttendanceCommand> findAttendanceListBySid(Academy academy, long sid, long lid) {
		return dao.findAttendanceListBySid(academy, sid, lid);
	}
	
	// 성적정보 가져오기
	public List<ReportScoreCommand> findScoreListBySid(Academy academy, long sid, long lid) {
		Lecture lecture = lservice.findLectureBylid(lid);
		return dao.findScoreListBySid(academy, sid, lecture.getName());
	}
	
	
	
	
}
