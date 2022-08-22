package com.varxyz.eka.academy.academy.controller;

import java.sql.Time;
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
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.service.AuthService;

@Controller
public class AcademyController {
	@Autowired
	private AcademyServiceImp acdemyService;
	@Autowired
	private AuthService authService;
	
	@GetMapping("eka_main/add_academy")
	public String addacademy() {
		return "eka_main/add_academy";
	}
	
	@PostMapping("eka_main/select_academies_by_address")
	public String selectAcademiesByAddress(Model model, @RequestParam String address) { 
		List<Academy> academyList = acdemyService.findAcademiesByAddress(address);
		
		
		
		model.addAttribute("academyList",academyList);
		model.addAttribute("address",address);
		return "eka_main/add_academy";
	}
	
	@PostMapping("eka_main/signed_eka_academy")
	public String signedEkaAcademy(HttpSession session ,Model model, @RequestParam String address,
			@RequestParam String name, @RequestParam String phone1,
			@RequestParam String phone2, @RequestParam String phone3,
			@RequestParam String service, @RequestParam String runday,
			@RequestParam String startruntime, @RequestParam String endruntime,
			@RequestParam String introduction) { 
		String[] namelist = name.split(",");
		name = namelist[0];		
		
		String[] phone1list = phone1.split(",");
		phone1 = phone1list[0];		
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		String[] srt = startruntime.split(",");
		String shour = srt[0].split("시")[0];
		
		String smin = srt[1].split("분")[0];		
		startruntime = shour + ":" + smin;
		
		
		String[] ert = endruntime.split(",");
		String ehour = ert[0].split("시")[0];
		String emin = ert[1].split("분")[0];		
		endruntime = ehour + ":" + emin;		
		
		Academy academy= acdemyService.findAcademyByAddressAndName(address,name);
		
		academy.setPhone(phone);
		academy.setAcademyservice(service);
		academy.setRunday(runday);
		academy.setIntroduction(introduction);
		academy.setStartruntime(startruntime);
		academy.setEndruntime(endruntime);
		academy.setSignedacademy("가입");		
		
		acdemyService.signEkaAcademy(academy);
		
		AcademyManager a = (AcademyManager) session.getAttribute("manager");
		a.setAcademyId(academy.getAid());
		
		authService.updateAcademId(a.getAid(), a);
		
		
		return "eka_main/main";
	}

	@GetMapping("eka_main/academy/main")
	public String academyMain() {
		return "eka_main/academy/main";
	}

	@GetMapping("eka_main/academy/register")
	public String academyRegister() {
		return "eka_main/academy/register";
	}

	@GetMapping("eka_main/academy/write")
	public String academyWrite() {
		return "eka_main/academy/write";
	}

	@GetMapping("eka_main/academy/search")
	public String academySearch() {
		return "eka_main/academy/search";
	}

	@PostMapping("eka_main/academy/search")
	public String Search() {
		return "eka_main/academy/search";
	}

	@GetMapping("eka_main/academy/xml")
	public String academyXml() {
		return "eka_main/academy/xml";
	}

}
