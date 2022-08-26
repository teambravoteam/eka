package com.varxyz.eka.managermain.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import com.varxyz.eka.academy.teacher.domain.Teacher;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;

@Controller
public class ManagerMainController {
	
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;
	
	@GetMapping("eka_manager/main")
	public String managerMain(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		
		if(am == null) {
			model.addAttribute("msg", "로그인 후 접근 가능합니다.");
			model.addAttribute("return_mapping", "../eka_main/main");
			return "eka_manager/msg_alert";
		}
		if (am.getAcademyId() == 0) {
			model.addAttribute("msg", "등록된 학원이 없습니다.");
			model.addAttribute("return_mapping", "../eka_main/main");
			return "eka_manager/msg_alert";
		}
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/main";
	}
	
	@PostMapping("eka_manager/quick_find")
	public String quickFind(Model model, @RequestParam String findType,
			@RequestParam String search, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		if (search == null) {
			model.addAttribute("msg", "검색어 입력은 필수입니다.");
			model.addAttribute("return_mapping", "main");
			return "eka_manager/msg_alert";
		}
		
		if (findType == "student") {
			
		}
		if (findType == "teacher") {
			List<Teacher> teacher_list = new ArrayList<Teacher>();
			teacher_list = tservice.findTeacherByName(academy, search);
			
			if (teacher_list.isEmpty()) {
				model.addAttribute("msg", "일치하는 항목이 없습니다.");
				model.addAttribute("return_mapping", "main");
				return "eka_manager/msg_alert";
			} else {
				model.addAttribute("teacher_list", teacher_list);
				
				model.addAttribute("subject", tservice.findSubjectCategory());
				model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
				return "eka_manager/teacher_edit";
			}
		}
		
		if (findType == "lecture") {
			List<Lecture> lecture_list = new ArrayList<Lecture>();
			lecture_list = lservice.findAcademyLectureByName(academy, search);
			
			if (lecture_list.isEmpty()) {
				model.addAttribute("msg", "일치하는 항목이 없습니다.");
				model.addAttribute("return_mapping", "main");
				return "eka_manager/msg_alert";
			} else {
				model.addAttribute("lecture", lservice.findAcademyLectureByName(academy, search));
				model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
				return "eka_manager/lecture_edit";
			}
		}
		
		return null;
	}
	
	//로그아웃
	@GetMapping("eka_main/manager_logout")
	public String managerLogout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		
		response.setHeader("Pragma", "no-cache"); 
		response.setHeader("Cache-Control", "no-cache"); 
		response.setHeader("Cache-Control", "no-store"); 
		response.setDateHeader("Expires", 0L);
		
		return "eka_main/main";
	}
	

}
