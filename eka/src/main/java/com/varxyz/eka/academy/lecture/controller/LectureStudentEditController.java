package com.varxyz.eka.academy.lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.eka.academy.academycategory.service.AcademyCategoryServiceImp;
import com.varxyz.eka.academy.lecture.command.LectureEditCommand;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.student.studentcategory.service.StudentCategoryServiceImpl;

@Controller
public class LectureStudentEditController {
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private StudentCategoryServiceImpl scservice;
	
	// 수강생등록/수정 버튼 클릭
	@PostMapping("eka_manager/lecture_student_edit")
	public String lectureStudentEdit(LectureEditCommand lecture, Model model) {
		// 강좌별 학생리스트 찾아서 뿌리기
		System.out.println(lecture);
		
		model.addAttribute("lecture", lecture);
		return "eka_manager/lecture_student_edit";
	}
	
	// 학생이름으로 학생 리스트 찾기
	@PostMapping("eka_manager/lecture_student_find")
	public String lectureStudentFind(@RequestParam String name, Model model) {
		System.out.println(name);
		
		return "eka_manager/lecture_student_edit";
		
	}
	
	// 학생 등록
	
	// 학생 삭제
}
