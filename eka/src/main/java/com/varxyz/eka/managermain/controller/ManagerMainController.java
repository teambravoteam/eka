package com.varxyz.eka.managermain.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;

@Controller
public class ManagerMainController {
	
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/main")
	public String managerMain(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		System.out.println("am : " + am);
		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/main";
	}
}
