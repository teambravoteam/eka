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
		
		return "eka_manager/score_add_academy";
	}
	
	// 성적입력하기
	@PostMapping("eka_manager/add_score_insert")
	public String addScoreInsert(@RequestParam String lectureName, ScoreCategory score, Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		Lecture lecture = lservice.findLectureIdByLectureName(academy, lectureName); 
		long lid = lecture.getLid();
		
		// aid, 학원이름으로 lid찾기
//		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
//		model.addAttribute("lecturename", lectureName);
//		model.addAttribute("testinfo", score);
		
		
		// 해당 시험에대한 데이터가 테이블에 있는 경우 -> 테이블 값 가져오기
				// 없는 경우 수강생 정보 담아오기
		//atcid로 성적입력리스트 뒤지기
		List<Score> score2 = sservice.findListByAtcid(score.getAtcid());
//		if (score2.isEmpty()) {
			model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
			model.addAttribute("lecturename", lectureName);
			model.addAttribute("testinfo", score);
//		} else {
//			
//		}
		System.out.println(score.getAcademyId());
		return "eka_manager/score_add_academy";
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
		
		System.out.println("atcid : " + atcid);
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
		
		
		boolean result = false;
		for (int i=0; i <nameList.length;i++) {
			result = sservice.addScore(atcid, nameList[i], sidArrayList.get(i), testScoreArrayList.get(i));
		}
//		Long.parseLong(atcid)
		
		if (result == false) {
			model.addAttribute("msg", "성적입력에 실패했습니다.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		} else {
			model.addAttribute("msg", "성적입력을 완료했습니다.");
			model.addAttribute("return_mapping", "score_add_academy");
			return "eka_manager/msg_alert";
		}
		
	}
	
	
}
