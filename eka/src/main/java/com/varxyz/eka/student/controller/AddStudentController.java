package com.varxyz.eka.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.service.StudentServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;


@Controller
public class AddStudentController {

	
	@Autowired
	private StudentCategoryServiceImpl categoryservice;
	
	@Autowired
	private StudentServiceImpl service;
	
	@GetMapping("eka_manager/student_add")
	public String StudentAdd(Model model) {
		model.addAttribute("school",categoryservice.findSchoolCategory());
		model.addAttribute("grade",categoryservice.findGradeCategory());
		model.addAttribute("student", new Student());
		return "eka_manager/student_add";
	}
	
	//학생추가
	@PostMapping("eka_manager/student_add") 
	public String StudentAdd(Model model , Student student, HttpSession session) {
		
//		AcademyManager am = (AcademyManager) session.getAttribute("manager");
//		student.setAcademyId(am.getAcademyId());
		student.setAcademyId(1);
		student.setPhone(student.getPhone1()+"-"+student.getPhone2()+"-"+student.getPhone3());
		
		model.addAttribute("student", service.addStudent(student));
		model.addAttribute("school",categoryservice.findSchoolCategory());
		model.addAttribute("grade",categoryservice.findGradeCategory());
		
		return "eka_manager/student_add";
	}
	
	@GetMapping("eka_manager/student_edit")
	public String studentAdd2(Model model) {
		return "eka_manager/student_edit";
	}
	
	
	
	
	
	
	
	
}
