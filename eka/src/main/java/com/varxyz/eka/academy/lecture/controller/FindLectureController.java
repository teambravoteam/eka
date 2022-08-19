package com.varxyz.eka.academy.lecture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.command.LectureCommand;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;

@Controller
public class FindLectureController {
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private TeacherServiceImpl tservice;
	
	@GetMapping("eka_manager/lecture_edit")
	public String lectureEdit(Model model) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);
				
		model.addAttribute("subject", acservice.findAllSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		return "eka_manager/lecture_edit";
	}
	
	// 강좌 전체조회 버튼 클릭
	@GetMapping("eka_manager/lecture_find_all")
	public String lectureFindAll(Model model, HttpSession session) {
		
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		// common
		model.addAttribute("subject", acservice.findAllSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		return "eka_manager/lecture_edit";
	}
	
	// 강좌 세부 검색
	@PostMapping("eka_manager/lecture_find")
	public String lectureFind(LectureCommand lecture,Model model, HttpSession session) {
		//session
		Academy academy = new Academy();
		academy.setAid(1);
		// common
		model.addAttribute("subject", acservice.findAllSubjectCategory());
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		
//		List<Lecture> lecture_list = new ArrayList<Lecture>();
		
		String subject = lecture.getSubject();
		String teacher = lecture.getTeacher();
		String startLectureDate = lecture.getStartLectureDate();
		String finishLectureDate = lecture.getFinishLectureDate();
		String startLectureTime = lecture.getStartLectureTime();
		String finishLectureTime = lecture.getFinishLectureTime();
		String lectureDay = lecture.getLectureDay();
		long lectureCapacity = lecture.getLectureCapacity();
//		String type1 = lecture.getType1();
		long price = lecture.getPrice();
//		String type2 = lecture.getType2();
		String name = lecture.getName();
		
		// 다 all이면 전체검색
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && lectureCapacity == 0
				&& price == 0 && name.equals("")
				) {
			
			System.out.println("전체검색으로 이동");
			model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
			return "eka_manager/lecture_edit";
		}
		
		// 과목으로 검색
		if (!subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && lectureCapacity == 0
				&& price == 0 && name.equals("")
				) {
			
			System.out.println("과목으로만 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesBySubject(academy, subject));
			return "eka_manager/lecture_edit";
		}
		
		// 강사로 검색
		if (subject.equals("all") && !teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && lectureCapacity == 0
				&& price == 0 && name.equals("")) {
			System.out.println("강사로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByTeacher(academy, teacher));
			return "eka_manager/lecture_edit";
		}
		
		// 기간으로 검색 **
		if (subject.equals("all") && teacher.equals("all") 
				&& !startLectureDate.equals("") && !finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& lectureDay.equals("all") && lectureCapacity == 0
				&& price == 0 && name.equals("")) {
			System.out.println("기간으로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByTeacher(academy, teacher));
			return "eka_manager/lecture_edit";
		}
		
		// 요일로 검색 **
		if (subject.equals("all") && teacher.equals("all") 
				&& startLectureDate.equals("") && finishLectureDate.equals("")
				&& startLectureTime.equals("") && finishLectureTime.equals("")
				&& !lectureDay.equals("all") && lectureCapacity == 0
				&& price == 0 && name.equals("")) {
			System.out.println("요일로 검색");
			model.addAttribute("lecture", lservice.findAcademyLecturesByLectureDay(academy, lectureDay));
			return "eka_manager/lecture_edit";
		}
		
		// 정원으로 검색
		
		
		
		
		
		
		return "eka_manager/lecture_edit";
	}
	
	
	
}
