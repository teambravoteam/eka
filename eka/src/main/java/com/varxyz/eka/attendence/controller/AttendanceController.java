package com.varxyz.eka.attendence.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.attendence.service.AttendanceServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.domain.Student;

@Controller
public class AttendanceController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private AttendanceServiceImp attendanceService;
	
	@GetMapping("eka_manager/attendance_page")
	public String attendancePage(Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());		
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));		
		return "eka_manager/attendance";
	}
	
	@GetMapping("eka_manager/attendance_edit")
	public String attendanceEdit(Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		System.out.println(am);
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		System.out.println(academy);
		System.out.println(lservice.findallAcademyLectures(academy));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));		
		return "eka_manager/attendance_edit";
	}
	
	@PostMapping("eka_manager/find_lecture_student")
	public String findLectureStudent(Model model, HttpSession session, @RequestParam String lectureName) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		Lecture lc = lservice.findAcademyLectureByName(academy, lectureName);
		List<Student> lectureStudentList = attendanceService.findAcademyStudentsByLecture(lc);
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		System.out.println(lectureStudentList);
		model.addAttribute("lectureStudentList",lectureStudentList);
		
		return "eka_manager/attendance";
	}
	
	
	
}
