package com.varxyz.eka.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.service.StudentServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;


@Controller
public class AddSudentController {

	
	@Autowired
	private StudentCategoryServiceImpl categoryservice;
	
	@Autowired
	private StudentServiceImpl service;
	
	@GetMapping("eka_manager/student_add_2")
	public String StudentAdd(Model model) {
		model.addAttribute("school",categoryservice.findSchoolCategory());
		model.addAttribute("grade",categoryservice.findGradeCategory());
		model.addAttribute("student", new Student());
		return "eka_manager/student_add";
	}
	
	//학생추가
	@PostMapping("eka_manager/student_add_2") 
	public String StudentAdd(Model model , Student student) {
		model.addAttribute("student", service.addStudent(student));
		return "eka_manager/student_add";
	}
	
	
	
	
	
	
	
	
	
	
}
