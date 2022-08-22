package com.varxyz.eka.score.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.score.domain.ScoreCategory;

@Controller
public class AddAcademyScoreController {
	
	@Autowired
	private LectureServiceImpl lservice;
	
	@GetMapping("eka_manager/score_add_academy")
	public String ScoreAddAcademyForm(Model model, HttpSession session) {
		
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		return "eka_manager/score_add_academy";
	}
	
	//시험명 등록
	@PostMapping("eka_manager/score_add_academy")
	public String ScoreAddAcademy(ScoreCategory scoreCategory, Model model) {
		
		System.out.println(scoreCategory);
		return "eka_manager/score_add_academy";
	}
}
