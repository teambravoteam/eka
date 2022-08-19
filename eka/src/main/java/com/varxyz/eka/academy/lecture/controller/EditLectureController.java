package com.varxyz.eka.academy.lecture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.command.LectureEditCommand;
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;

@Controller
public class EditLectureController {
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private StudentCategoryServiceImpl scservice;
	@Autowired
	private LectureServiceImpl lservice;
	
	// 강좌 정보 수정 폼
	@PostMapping("eka_manager/lecture_edit_form")
	public String lectureEditForm(Model model, LectureEditCommand lecture, HttpSession session) {
//		session.getAttribute("academy");
		Academy academy = new Academy();
		academy.setAid(1);
		// common
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", acservice.findAllSubjectCategory());
		model.addAttribute("school", scservice.findSchoolCategory());
		model.addAttribute("grade", scservice.findGradeCategory());

//		System.out.println(lecture);
		// tid추가해야함
		model.addAttribute("lecture", lecture);
		return "eka_manager/lecture_edit_form";
	}
	
	// 강좌 수정하기 버튼클릭
	@PostMapping("eka_manager/lecture_edit_update")
	public String lectureEditUpdate(Lecture lecture, Model model) {
		System.out.println(lecture);
		System.out.println("lid:" + lecture.getLid());
		boolean result = lservice.updateLecture(lecture);
		
		if (result == false) {
			//수정실패
			String msg = "수정실패";
			String mapping = "lecture_edit";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", mapping);
			return "eka_manager/msg_alert";
		} else {
			String msg = "수정성공";
			String mapping = "lecture_edit";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", mapping);
			return "eka_manager/msg_alert";
		}
	}
	
}
