package com.varxyz.eka.score.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.service.ScoreServiceImpl;

@Controller
public class AddAcademyScoreController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private ScoreServiceImpl sservice;
	
	@GetMapping("eka_manager/score_add_academy")
	public String scoreAddAcademyForm(Model model, HttpSession session) {
		
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		return "eka_manager/score_add_academy";
	}
	
	//시험명 등록
	@PostMapping("eka_manager/score_add_academy")
	public String scoreAddAcademy(Score score, Model model) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);

		score.setAcademyId(1); 
		
		boolean addResult = sservice.addAcademyScoreCategory(score);
//		System.out.println(score.getLecturename());
//		System.out.println(score.getTestname());
//		System.out.println(score.getTestdate());
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		
		if (addResult == false) {
			model.addAttribute("msg", "시험정보 등록에 실패하셨습니다.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		} else {
			model.addAttribute("msg", "시험정보가 등록되었습니다.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		}
		
	}
	
	// 강좌명으로 시험 조회
	@PostMapping("eka_manager/score_find_academy")
	public String scoreFindAcademy(@RequestParam String lecturename, Model model) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		long aid = academy.getAid();
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("testList", sservice.findTestName(aid, lecturename));
		
		System.out.println(lservice.findallAcademyLectures(academy));
//		System.out.println(sservice.findTestName(aid, lecturename));
		return "eka_manager/score_add_academy";
		
	}
	
	// 성적입력하기
	@PostMapping("eka_manager/add_score_insert")
	public String addScoreInsert(@RequestParam String lecturename, Score score, Model model, HttpSession session) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		
		Lecture lecture = lservice.findAcademyLectureByName(academy, lecturename); 
		long lid = lecture.getLid();
		System.out.println(lid + " ?????");
//		System.out.println("lid : " + lid);
		// aid, 학원이름으로 lid찾기
		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		return "eka_manager/score_add_academy";
	}
	
	
	
	
}
