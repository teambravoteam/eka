package com.varxyz.eka.academy.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.address.domain.CountyAddress;
import com.varxyz.eka.academy.address.service.AddressService;

@Controller("eka_academy.addressController")
@SuppressWarnings("resource") // 컴파일 경고를 없애줌
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping("/eka_academy/main")
	public String main(Model model) {
		model.addAttribute("main", new CountyAddress());
		return "eka_academy/main";
	}
	
	@PostMapping("/eka_academy/main")
	public String main (CountyAddress countyAddress, Model model) {
		if (service.addCounty(countyAddress) == true) {
			model.addAttribute("countyMg","추가완료");
		} else {
			model.addAttribute("countyMg","추가실패");
		}
		return "eka_academy/main";
	}
	
	
	@GetMapping("/eka_academy/countylist")
	public String countyList(Model model) {
		model.addAttribute("main", new CountyAddress());
		return "eka_academy/main";
	}
	
	
	@PostMapping("/eka_academy/countylist")
	public String countyList2(Model model) {
		model.addAttribute("countylist", service.countyList());
		return "eka_academy/main";
	}
	
	
	
	
	
	
	
}
