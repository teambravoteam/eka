package com.varxyz.eka.student.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.domain.FindStudent;
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
		session.setAttribute("school",categoryservice.findSchoolCategory());
		session.setAttribute("grade",categoryservice.findGradeCategory());
		model.addAttribute("student", new Student());
		return "eka_manager/student_add";
	}
	
	//학원관리자는 학생을 등록 할 수 있어야 한다
	@PostMapping("eka_manager/student_add") 
	public String StudentAdd(Model model , Student student) {
		
		student.setPhone(student.getPhone1() + "-" + student.getPhone2() + "-" + student.getPhone3());
		student.setParentPhone(student.getParentPhone1() + "-" + student.getParentPhone2() + "-" + student.getParentPhone3());
		
		// 임시로 넣어놓은 아카데미id 나중에 사용할때 삭제나 주석처리바람
		student.setAcademyId(1);
		
		if (service.addStudent(student) == true) {
			return "eka_manager/student_add";
		} else {
			return "eka_manager/student_add";
		}
		
	}
	
	
	// 모든학생조회
	@GetMapping("eka_manager/student_edit")
	public String findAllStudent(Model model) {
		model.addAttribute("student", new FindStudent());
		return "eka_manager/student_edit";
	}
	
	// 모든학생조회
	@PostMapping("eka_manager/student_edit")
	public String findAllStudent(Model model, Student student, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
//		Academy academy = academyService.findAcademyByAid(am.getAcademyId()); 
		
		model.addAttribute("allstudent", service.findAllAcademyStudent(student));
		return "eka_manager/student_edit";
	}
	
	
	
	
	
	
}
