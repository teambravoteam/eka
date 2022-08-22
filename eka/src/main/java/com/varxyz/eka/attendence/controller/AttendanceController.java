package com.varxyz.eka.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;

@Controller
public class AttendanceController {
	
	@Autowired
	private LectureServiceImpl lservice;
	
	@GetMapping("eka_manager/attendance_page")
	public String attendancePage(Model model) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		
		return "eka_manager/attendance";
	}
	
	
	
}
