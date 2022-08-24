package com.varxyz.eka.academy.lecture.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.command.LectureCommand;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;

@Controller
public class FindLectureController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/lecture_edit")
	public String lectureEdit(Model model, HttpSession session) {
		//session
//		Academy academy = new Academy();
//		academy.setAid(1);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
				
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_edit";
	}
	
	// 강좌 전체조회 버튼 클릭
	@GetMapping("eka_manager/lecture_find_all")
	public String lectureFindAll(Model model, HttpSession session) {
		
		//session
//		Academy academy = new Academy();
//		academy.setAid(1);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		// common
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_edit";
	}
	
	// 강좌 세부 검색
	@PostMapping("eka_manager/lecture_find")
	public String lectureFind(LectureCommand lecture,Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		// common
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		List<Lecture> lecture_list = new ArrayList<Lecture>();
		
		String subject = lecture.getSubject();
		String teacher = lecture.getTeacher();
		String startLectureDate = lecture.getStartLectureDate();
		String finishLectureDate = lecture.getFinishLectureDate();
		String startLectureTime = lecture.getStartLectureTime();
		String finishLectureTime = lecture.getFinishLectureTime();
		String lectureDay = lecture.getLectureDay();
		String name = lecture.getName();
		
		// 다 all이면 전체검색
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && name.equals("")
				) {
			
			System.out.println("전체검색으로 이동");
			model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
			return "eka_manager/lecture_edit";
		}
		
		// 과목으로 검색
		if (!subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") &&  name.equals("")
				) {
			
			System.out.println("과목으로만 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesBySubject(academy, subject));
			return "eka_manager/lecture_edit";
		}
		
		// 강사로 검색
		if (subject.equals("all") && !teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && name.equals("")) {
			System.out.println("강사로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByTeacher(academy, teacher));
			return "eka_manager/lecture_edit";
		}
		
		// 기간으로 검색 
		if (subject.equals("all") && teacher.equals("all") 
				&& !startLectureDate.equals("") && !finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") &&  name.equals("")) {
			System.out.println("기간으로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByDate(academy, startLectureDate, finishLectureDate));
			return "eka_manager/lecture_edit";
		}
		
		// 시간으로 검색
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& !startLectureTime.equals("") && !finishLectureTime.equals("")
				&& lectureDay.equals("all") &&  name.equals("")) {
			System.out.println("시간으로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByTime(academy, startLectureTime, finishLectureTime));
			return "eka_manager/lecture_edit";
		}
		
		
		// 요일로 검색 **
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& !lectureDay.equals("all") && name.equals("")) {
			System.out.println("요일로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByLectureDay(academy, lectureDay));
			return "eka_manager/lecture_edit";
		}
		
		// 강좌명으로 검색
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && !name.equals("")) {
			System.out.println("강좌명로 검색");
			lecture_list = lservice.findAcademyLectureByName(academy, name);
			System.out.println("lecutre리스 : " + lecture_list);
			model.addAttribute("lecture", lservice.findAcademyLectureByName(academy, name));
			return "eka_manager/lecture_edit";
		}
		
		
		return "eka_manager/lecture_edit";
	}
	
	
	
}
