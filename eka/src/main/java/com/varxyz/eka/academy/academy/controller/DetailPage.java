package com.varxyz.eka.academy.academy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;

@Controller
public class DetailPage {
	
	@Autowired
	private AcademyServiceImp asservice;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	
	
	@GetMapping("eka_main/academy/detail_page")
	public String detailPage(Model model, HttpSession session) {
		
		// @requestParam long aid ,, Academy academy = asservice.findAcademyByAid(aid);
		Academy academy = new Academy();
		academy.setAid(9);
		
		
		System.out.println(asservice.findAcademyByAid(academy.getAid()));
		
		model.addAttribute("academy", asservice.findAcademyByAid(academy.getAid()
				));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", acservice.findAllSubjectCategory());
		
		return "eka_main/academy/detail_page";
	}
}
