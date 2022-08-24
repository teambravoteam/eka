package com.varxyz.eka.academy.lecture.controller;

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
import com.varxyz.eka.auth.domain.AcademyManager;

@Controller
public class LectureStudentFindController {
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/lecture_student")
	public String lectureStudentMain(Model model)  {
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/lecture_student";
	}
	
	// 강좌 전체조회
	@GetMapping("eka_manager/lecture_student_find_all")
	public String lectureFindAll(Model model, HttpSession session) {
		
		//session
//		Academy academy = new Academy();
//		academy.setAid(1);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		// common
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		return "eka_manager/lecture_student";
	}
	
	// 강좌 세부조회
	
	
	
}
