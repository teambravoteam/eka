package com.varxyz.eka.score.controller;

import java.util.ArrayList;
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
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.score.domain.Score;
import com.varxyz.eka.score.domain.ScoreCategory;
import com.varxyz.eka.score.service.ScoreServiceImpl;

@Controller
public class AddAcademyScoreController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private ScoreServiceImpl sservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/score_add_academy")
	public String scoreAddAcademyForm(Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		return "eka_manager/score_add_academy";
	}
	
	//시험명 등록
	@PostMapping("eka_manager/score_add_academy")
	public String scoreAddAcademy(@RequestParam String lectureName, 
			@RequestParam String testDate, @RequestParam String testName,
			Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		//시험명 중복체크
		List<ScoreCategory> check = sservice.findSameTestName(academy, lectureName, testName);
		if (!check.isEmpty()) {
			model.addAttribute("msg", "중복된 시험명이 있습니다.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		}
		
		// 유효성 검증
		if (testDate.equals("")) {
			model.addAttribute("msg", "시험일자를 입력해주세요.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		} else if (testName.equals("")) {
			model.addAttribute("msg", "시험명을 입력해주세요.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		}
		
		ScoreCategory scoreCategory = new ScoreCategory();
		scoreCategory.setAcademyId(academy.getAid()); 
		scoreCategory.setLectureName(lectureName);
		scoreCategory.setTestDate(testDate);
		scoreCategory.setTestName(testName);
		
		boolean addResult = sservice.addAcademyScoreCategory(scoreCategory);
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
	public String scoreFindAcademy(@RequestParam String lectureName, Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("testList", sservice.findTestName(academy.getAid(), lectureName));
		List<ScoreCategory> scoreca = sservice.findTestName(academy.getAid(), lectureName);
		return "eka_manager/score_add_academy";
	}
	
	// 성적입력하기
	@PostMapping("eka_manager/add_score_insert")
	public String addScoreInsert(@RequestParam String lectureName, ScoreCategory score, Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("testList", sservice.findTestName(academy.getAid(), lectureName));
		
		Lecture lecture = lservice.findLectureIdByLectureName(academy, lectureName); 
		long lid = lecture.getLid();
		
//		atcid 로 testCategoryId일치하는거 찾는거
		//해당시험에 대한 데이터가 비어있는지 확인하기
		List<Score> check = sservice.findListByAtcid(score.getAtcid());
		
		if (check.isEmpty()) {
			//비어있다면 
			model.addAttribute("lectureStudentList", lservice.findLectureStudentList2(lid));
			model.addAttribute("lecturename", lectureName);
			model.addAttribute("testinfo", score);
			return "eka_manager/score_add_academy";
		} else {
			//비어있지 않다면 데이터 가져오기
			model.addAttribute("lectureStudentList", sservice.findStudentScore(score.getAtcid()));
			model.addAttribute("lecturename", lectureName);
			model.addAttribute("testinfo", score);
			return "eka_manager/score_add_academy";
		}
		
		
	}
	
	// 성적입력 저장
	@PostMapping("eka_manager/add_test_score")
	public String addTestScore(HttpSession session,Model model,
			@RequestParam long atcid,
			@RequestParam String lectureName,
			@RequestParam String sid, @RequestParam String name, @RequestParam String testScore) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		
		// 학생이름
		String[] nameList = name.split(",");
		// 학생id
		String[] sidList = sid.split(",");
		List<Integer> sidArrayList = new ArrayList<>();
		for (int i = 0; i < nameList.length;i++) {
			int j = Integer.parseInt(sidList[i]);
			sidArrayList.add(j);
		}
		
		// 시험점수
		String[] testScoreList = testScore.split(",");
		List<Double> testScoreArrayList = new ArrayList<>();
		for(int i = 0; i < testScoreList.length; i++) {
			double j = Double.parseDouble(testScoreList[i]);
			testScoreArrayList.add(j);
		}
		
		//저장하기 눌렀을때 겹치는 데이터 있으면 update하기
		
		if (sservice.findListByAtcid(atcid).isEmpty()) {
			
			boolean result = false;
			for (int i=0; i <nameList.length;i++) {
				result = sservice.addScore(atcid, nameList[i], sidArrayList.get(i), testScoreArrayList.get(i));
			}
			
			if (result == false) {
				model.addAttribute("msg", "성적입력에 실패했습니다.");
				model.addAttribute("return_mapping", "score_add_academy");
				return "eka_manager/msg_alert";
			} else {
				model.addAttribute("msg", "성적입력을 완료했습니다.");
				model.addAttribute("return_mapping", "score_add_academy");
				return "eka_manager/msg_alert";
			}
			
		} else {
			
			//update하기
			boolean result = false;
			for (int i=0; i <nameList.length;i++) {
				result = sservice.updateScore(atcid, nameList[i], sidArrayList.get(i), testScoreArrayList.get(i));
			}
			
			if (result == false) {
				model.addAttribute("msg", "성적수정 실패했습니다.");
				model.addAttribute("return_mapping", "score_add_academy");
				return "eka_manager/msg_alert";
			} else {
				model.addAttribute("msg", "성적수정을 완료했습니다.");
				model.addAttribute("return_mapping", "score_add_academy");
				return "eka_manager/msg_alert";
			}
		}
		
		
	}
	
	
}
