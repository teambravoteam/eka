package com.varxyz.eka.academy.academy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;

@Controller
public class DetailPageController {

	@Autowired
	private AcademyServiceImp asservice;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;

	@GetMapping("eka_main/detail_page")
	public String detailPage(Model model, HttpSession session, @RequestParam String academyAid) {
		long aid = Integer.parseInt(academyAid);
		Academy academy = asservice.findAcademyByAid(aid);
		long checkManager = 0;
		long checkStudent = 0;
		
		// 원장 로그인여부 체크
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		if (am == null) {
			checkManager = 1;
		} else {
			checkManager = 0;
		}
		
		// 학생 로그인여부 체크
//		EkaUser as = (EkaUser) session.getAttribute("user");
//		if (as == null) {
//			checkStudent = 1;
//		} else {
//			checkStudent = 0;
//		}

		System.out.println(asservice.findAcademyByAid(academy.getAid()));
		System.out.println(tservice.findAllAcademyTeacher(academy));

		model.addAttribute("academy", asservice.findAcademyByAid(academy.getAid()));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("checkManager", checkManager);
//		model.addAttribute("checkStudent", checkStudent);
		return "eka_main/academy/detail_page";
	}
}
