package com.varxyz.eka.academy.academy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;

@Controller
public class DetailPageController {
	
	@Autowired
	private AcademyServiceImp asservice;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	
	
	@GetMapping("eka_main/detail_page")
	public String detailPage(Model model, HttpSession session, 
			@RequestParam String academyAid) {
		long aid = Integer.parseInt(academyAid);
		Academy academy = asservice.findAcademyByAid(aid);
				
		System.out.println(asservice.findAcademyByAid(academy.getAid()));
		System.out.println(tservice.findAllAcademyTeacher(academy));
		
		model.addAttribute("academy", asservice.findAcademyByAid(academy.getAid()));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", acservice.findAllSubjectCategory());

		return "eka_main/academy/detail_page";
	}
	
//	@GetMapping("eka_main/detail_page")
//	public ModelAndView detailPage(HttpServletRequest request, HttpServletResponse response) {
//
//		ModelAndView mav = new ModelAndView();
//
//		String academyId = request.getParameter("academyId");
//		String ekauserId = request.getParameter("ekauserId");
//		String academyName = null;
//
//		if (academyId != null && academyId != "") {
//			Long academyIdL = Long.parseLong(academyId);
//			academyName = academyService.findAcademyByAid(academyIdL).getName();
//
//			mav.addObject("academyName", academyName);
//			mav.setViewName("eka_main/myPage");
//		} else if (ekauserId != null && ekauserId != "") {
//			Long academyIdL = academyService.findStudentByEkauserId(ekauserId).getAcademyId();
//			academyName = academyService.findAcademyByAid(academyIdL).getName();
//
//			mav.addObject("academyName", academyName);
//			mav.setViewName("eka_main/myPage_ekaUser");
//		}
//
//		return mav;
//	}
	
}
