package com.varxyz.eka.report.controller;

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
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.report.service.ReportService;
import com.varxyz.eka.student.domain.Student;

@Controller
public class ReportController {
	
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private ReportService rservice;
	
	@GetMapping("eka_manager/student_report")
	public String studentReport(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		return "eka_manager/student_report";
	}
	
	// 학생검색
	@PostMapping("eka_manager/student_report_find")
	public String studentReportFind(Model model, HttpSession session, 
			@RequestParam String name) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		List<Student> studentList = lservice.findStudentByName(academy, name);
		model.addAttribute("student", studentList);
		
		return "eka_manager/student_report";
	}
	
	//학생 개별페이지로 이동
	@PostMapping("eka_manager/student_report_detail")
	public String studentReportDetail(Model model, HttpSession session,
			@RequestParam String name, @RequestParam long sid) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		model.addAttribute("name", name);
		model.addAttribute("sid", sid);
		
		//수강중인 강의리스트
		model.addAttribute("lecture", lservice.findLectureBySid(academy, sid));
		
		return "eka_manager/student_report_detail";
	}
	
	@PostMapping("eka_manager/student_report_lecture")
	public String studentReportLecture(Model model, HttpSession session,
			@RequestParam long lid, @RequestParam long sid,
			@RequestParam String name) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		//수강중인 강의리스트
		model.addAttribute("lecture", lservice.findLectureBySid(academy, sid));
		model.addAttribute("name", name);
		model.addAttribute("sid", sid);
		
		//출석현황리스트
		model.addAttribute("attendance", rservice.findAttendanceListBySid(academy, sid, lid));
		System.out.println(rservice.findAttendanceListBySid(academy, sid, lid));
		//성적리스트
		model.addAttribute("score", rservice.findScoreListBySid(academy, sid, lid));
			
		return "eka_manager/student_report_detail";
	}
	
}
