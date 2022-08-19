package com.varxyz.eka.academy.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcademyController {
	
	@GetMapping("eka_main/add_academy")
	public String addacademy() {
		return "eka_main/add_academy";
	}
	
	@PostMapping("eka_main/select_academies_by_address")
	public String selectAcademiesByAddress(Model model) {
		return "eka_main/add_academy";
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
