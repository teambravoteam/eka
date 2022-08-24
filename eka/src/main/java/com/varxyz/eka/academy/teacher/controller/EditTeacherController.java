package com.varxyz.eka.academy.teacher.controller;

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
import com.varxyz.eka.academy.teacher.command.TeacherListCommand;
import com.varxyz.eka.academy.teacher.domain.Teacher;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;

@Controller
public class EditTeacherController {
	
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyCategoryServiceImp acservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/teacher_edit")
	public String teacherFind(Model model) {
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/teacher_edit";
	}
	
	// 강사 전체조회 버튼클릭
	@GetMapping("eka_manager/teacher_find_all")
	public String teacherFindAll(Model model, HttpSession session) {
		//이미지가 없는 강사는 default이미지로 출력하기
		
//		session.getAttribute("academy"); 이걸로 service에 넘기기
//		Academy academy = new Academy();
//		academy.setAid(1);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		
//		System.out.println(tservice.findAllAcademyTeacher(academy));
		model.addAttribute("teacher_list", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/teacher_edit";
	}
	
	// 강사정보 수정
	@PostMapping("eka_manager/teacher_edit")
	public String teacherEdit(TeacherListCommand teacher,Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		System.out.println(teacher);
		teacher.setAcademyId(1);
		boolean result = tservice.updateTeacher(teacher);
		
		if (result == true) {
			String msg = teacher.getName() + "님 정보가 수정되었습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "teacher_edit");
			return "eka_manager/msg_alert";
		} else {
			String msg = "수정이 되지않았습니다. 다시 시도해주세요.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "teacher_edit");
			return "eka_manager/msg_alert";
		}
	}
	
	// 강사 삭제하기
	@GetMapping("eka_manager/teacher_delete")
	public String teacherDelete(String delete) {
		System.out.println(delete);
		return "eka_manager/teacher_edit";
	}
	
	// 강사 검색하기
	@PostMapping("eka_manager/teacher_find")
	public String teacherFindForm(Model model, HttpSession session,
			@RequestParam String subject, @RequestParam String gender,
			@RequestParam String foreigner, @RequestParam String name) {
		
//		System.out.println(subject);
//		System.out.println(gender);
//		System.out.println(foreigner);
//		System.out.println("name : " + name);
//		
//		session.getAttribute("academy"); 이걸로 service에 넘기기
//		Academy academy = new Academy();
//		academy.setAid(1);
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		List<Teacher> teacher_list = new ArrayList<Teacher>();
		
		// all,all,all "" -> 전체검색
		if (subject.equals("all") && gender.equals("all") 
				&& foreigner.equals("all") && name.equals("")) {
			model.addAttribute("teacher_list", tservice.findAllAcademyTeacher(academy));
		}
		
		// 과목으로만 검색
		if (!subject.equals("all") && gender.equals("all") 
				&& foreigner.equals("all") && name.equals("")) {
			System.out.println("과목선택");
			
			teacher_list = tservice.findTeacherBySubject(academy, subject);
			
			// 검색된 결과가 없는 경우 error페이지로 이동
			if (teacher_list.isEmpty()) {
				return "eka_manager/error/teacher_add_error";
			}
			
			model.addAttribute("teacher_list", teacher_list);
			System.out.println(teacher_list);
		}

		// 성별로 검색
		if (subject.equals("all") && !gender.equals("all") 
				&& foreigner.equals("all") && name.equals("")) {
			System.out.println("성별선택");
			
			teacher_list = tservice.findTeacherByGender(academy, gender);
			if (teacher_list.isEmpty()) {
				return "eka_manager/error/teacher_add_error";
			}
			model.addAttribute("teacher_list", teacher_list);
		}
		
		// 외국인여부로 검색
		if (subject.equals("all") && gender.equals("all") 
				&& !foreigner.equals("all") && name.equals("")) {
			System.out.println("외국인여부선택");
			
			teacher_list = tservice.findTeacherByForeigner(academy, foreigner);
			if (teacher_list.isEmpty()) {
				return "eka_manager/error/teacher_add_error";
			}
			model.addAttribute("teacher_list", teacher_list);
		}
		
		// 강사명으로 검색
		if (subject.equals("all") && gender.equals("all") 
				&& foreigner.equals("all") && !name.equals("")) {
			System.out.println("이름검색");
			
			teacher_list = tservice.findTeacherByName(academy, name);
			if (teacher_list.isEmpty()) {
				return "eka_manager/error/teacher_add_error";
			}
			model.addAttribute("teacher_list", teacher_list);
		}
		
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/teacher_edit";
	}
	
	
}
