package com.varxyz.eka.academy.lecture.controller;

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
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.command.LectureEditCommand;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;

@Controller
public class LectureStudentEditController {
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private StudentCategoryServiceImpl scservice;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	// 수강생등록/수정 버튼 클릭
	@PostMapping("eka_manager/lecture_student_edit")
	public String lectureStudentEdit(LectureEditCommand lecture, Model model, HttpSession session) {
		// 강좌별 학생리스트 찾아서 뿌리기
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		//common
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("lecture", lecture);
		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lecture.getLid()));
		return "eka_manager/lecture_student_edit";
	}
	
	// 학생이름으로 학생 리스트 찾기
	@PostMapping("eka_manager/lecture_student_find")
	public String lectureStudentFind(@RequestParam String name, 
			@RequestParam long lid ,Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		List<Student> studentList = lservice.findStudentByName(academy, name);
		
		model.addAttribute("student", studentList);
		// common
		model.addAttribute("lecture", lservice.findLectureBylid(lid));
		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_student_edit";
		
	}
	
	// 수강목록에 학생 등록
	@PostMapping("eka_manager/lecture_student_add")
	public String lectureStudentAdd(@RequestParam long sid,
			@RequestParam long lid, @RequestParam long aid, Model model, HttpSession session) {
		System.out.println("aid : " + aid);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		
		
		//이미등록된 학생 거르는거
		List<Student> student = lservice.checkLectureStudent(aid, lid, sid);
		if (student.isEmpty()) {
			// 이 sid로 등록된 정보가 없으면 수강생으로 등록
			boolean addResult = lservice.addLectureStudent(aid, lid, sid);
			
		} else {
			model.addAttribute("msg", "이미 등록된 수강생입니다.");
			model.addAttribute("return_mapping", "lecture_student");
			return "eka_manager/msg_alert";
		}
		
		// common
		model.addAttribute("lecture", lservice.findLectureBylid(lid));
		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_student_edit";
		
	}
	
	// 수강생등록 실패 시 
//	@GetMapping("eka_manager/lecture_student_edit")
//	public String lectureStudentAddError(Model model, HttpSession session) {
//		AcademyManager am = (AcademyManager) session.getAttribute("manager");
//		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
//		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
//		
//		return "eka_manager/lecture_student_edit";
//	}
	
	// 수강생 삭제
	@PostMapping("eka_manager/lecture_student_delete")
	public String lectureStudentDelete(
			@RequestParam long sid, @RequestParam long lid,Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		// 성공실패 구분
		boolean result = lservice.deleteLectureStudent(lid, sid);
		System.out.println(result);
//		if (result == false) {
//			
//		} else {
//			
//		}
		// common
		model.addAttribute("lecture", lservice.findLectureBylid(lid));
		model.addAttribute("lectureStudentList", lservice.findLectureStudentList(lid));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/lecture_student_edit";
	}
}
