package com.varxyz.eka.academy.lecture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
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
	
	
	// 강좌등록 폼
	@GetMapping("eka_manager/lecture_add")
	public String lectureAdd(Model model, HttpSession session) {
		
//		session.getAttribute("academy");
		Academy academy = new Academy();
		academy.setAid(1);
		
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("school", scservice.findSchoolCategory());
		model.addAttribute("grade", scservice.findGradeCategory());
		System.out.println("과목 : " + tservice.findSubjectCategory());
		return "eka_manager/lecture_add";
	}	
	
	// 강좌등록
	@PostMapping("eka_manager/lecture_add")
	public String lectureAddForm(Model model, Lecture lecture, HttpSession session) {
		
		System.out.println(lecture);
//		session.getAttribute("academy");
		Academy academy = new Academy();
		academy.setAid(1);
		lecture.setAcademy(academy);
		
		System.out.println(lecture.getAcademy().getAid());
		System.out.println(lecture.getName());
		System.out.println(lecture.getSchoolcate());
		System.out.println(lecture.getGradecate());
		System.out.println(lecture.getSubject());
		System.out.println(lecture.getStartLectureTime());
		System.out.println(lecture.getFinishLectureTime());
		System.out.println(lecture.getStartLectureDate());
		System.out.println(lecture.getFinishLectureDate());
		System.out.println(lecture.getLectureDay());
		System.out.println(lecture.getPrice());
		System.out.println(lecture.getTeacher());
		System.out.println(lecture.getLectureCapacity());
		
		// true, false확인하기
//		lservice.addLecture(lecture);
		System.out.println(lservice.addLecture(lecture));
		
		model.addAttribute("name", lecture.getName());
		return "eka_manager/success/lecture_add_success";
	}
}
