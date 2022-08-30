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
import com.varxyz.eka.student.domain.FindStudent;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.service.StudentServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;

@Controller
public class FindStudentController{

	@Autowired
	private StudentServiceImpl service;
	
	@Autowired
	private AcademyServiceImp academyService;
	
	@Autowired
	private StudentCategoryServiceImpl categoryservice;
	
	// 모든학생조회
	@GetMapping("eka_manager/student_edit")
	public String findAllStudent(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		session.setAttribute("detailedSearch", new FindStudent());
		session.setAttribute("school",categoryservice.findSchoolCategory());
		session.setAttribute("grade",categoryservice.findGradeCategory());
		return "eka_manager/student_edit";
	}
	
	// 모든학생조회
	@PostMapping("eka_manager/student_edit")
	public String findAllStudent(Model model, Student student, HttpSession session) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("allstudent", service.findAllAcademyStudent(academy));
		return "eka_manager/student_edit";
	}
	
	// 학생들의 상세정보
	@GetMapping("eka_manager/student_edit2")
	public String detailedInformation(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("student", new Student());
		session.setAttribute("school",categoryservice.findSchoolCategory());
		session.setAttribute("grade",categoryservice.findGradeCategory());
		return "eka_manager/student_edit";
	}
	
	// 학생들의 상세정보
	@PostMapping("eka_manager/student_edit2")
	public String detailedInformation(Model model,Student student, HttpSession session) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("findstudent",service.detailedInformation(student.getName(), student.getPhone()));
		model.addAttribute("allstudent", service.findAllAcademyStudent(academy));
		return "eka_manager/student_edit";
	}
	
	
	// 카테고리별로 검색
	@GetMapping("eka_manager/detailedSearch")
	public String findStudent(Model model, HttpSession session, FindStudent findStudent) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("findstudt", new FindStudent());
		session.setAttribute("school",categoryservice.findSchoolCategory());
		session.setAttribute("grade",categoryservice.findGradeCategory());
		return "eka_manager/student_edit";
	}
	
	// 카테고리별로 검색
	@PostMapping("eka_manager/detailedSearch")
	public String findStudent(Model model, FindStudent findStudent, Student student, HttpSession session) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("ekaUserStudent",service.findAcademyStudentsByEkaSignUp(academy, findStudent));
		return "eka_manager/student_edit";
	}
	
	
	
	// 상세정보 수정
	@GetMapping("eka_manager/updateStudent")
	public String updateStudent(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("update",new Student());
		return "eka_manager/student_edit";
	}
	
	// 상세정보 수정
	@PostMapping("eka_manager/updateStudent")
	public String updateStudent(Model model, Student student, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		student.setAcademyId(academy.getAid());
		
		service.updateStudent(student);
		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
//		model.addAttribute("newStudent",find);
		return "eka_manager/student_edit";
	}
	
	
	
	
}
