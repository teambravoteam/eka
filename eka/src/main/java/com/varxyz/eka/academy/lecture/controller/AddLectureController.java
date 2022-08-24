package com.varxyz.eka.academy.lecture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;

@Controller
public class AddLectureController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private StudentCategoryServiceImpl scservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	
	// 강좌등록 폼
	@GetMapping("eka_manager/lecture_add")
	public String lectureAdd(Model model, HttpSession session) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("school", scservice.findSchoolCategory());
		model.addAttribute("grade", scservice.findGradeCategory());
		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_add";
	}	
	
	// 강좌등록
	@PostMapping("eka_manager/lecture_add")
	public String lectureAddForm(Model model, Lecture lecture, HttpSession session) {
		
		System.out.println(lecture);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		lecture.setAcademy(academy);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		boolean result = lservice.addLecture(lecture);
		if (result == false) {
			String msg = "강좌등록에 실패했습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "lecture_add");
			return "eka_manager/msg_alert";
		} else {
			String msg = lecture.getName() + "강좌가 등록되었습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "lecture_add");
			return "eka_manager/msg_alert";
		}
		
	}
}
