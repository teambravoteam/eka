package com.varxyz.eka.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;

import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.service.StudentServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;


@Controller
public class AddSudentController {

	
	@Autowired
	private StudentCategoryServiceImpl categoryservice;
	
	@Autowired
	private StudentServiceImpl service;
	
	@Autowired
	private AcademyServiceImp academyService;
	
	
	//학원관리자는 학생을 등록 할 수 있어야 한다
	@GetMapping("eka_manager/student_add")
	public String StudentAdd(Model model,HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");	
		session.setAttribute("school",categoryservice.findSchoolCategory());
		session.setAttribute("grade",categoryservice.findGradeCategory());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("student", new Student());
		return "eka_manager/student_add";
	}
	
	//학원관리자는 학생을 등록 할 수 있어야 한다
	@PostMapping("eka_manager/student_add")
	public String StudentAdd(Model model , Student student, HttpSession session) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
	
		student.setPhone(student.getPhone1() + "-" + student.getPhone2() + "-" + student.getPhone3());
		student.setParentPhone(student.getParentPhone1() + "-" + student.getParentPhone2() + "-" + student.getParentPhone3());
		
		student.setAcademyId(academy.getAid());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		if (service.addStudent(student) == true) {
			return "eka_manager/student_add";
		} else {
			return "eka_manager/student_add";
		}
		
	}
	
	
	
}
