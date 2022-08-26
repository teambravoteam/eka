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
	public String teacherFind(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/teacher_edit";
	}
	
	// 강사 전체조회 버튼클릭
	@GetMapping("eka_manager/teacher_find_all")
	public String teacherFindAll(Model model, HttpSession session) {
		//이미지가 없는 강사는 default이미지로 출력하기
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		model.addAttribute("teacher_list", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/teacher_edit";
	}
	
	// 강사정보 수정
	@PostMapping("eka_manager/teacher_edit")
	public String teacherEdit(TeacherListCommand teacher,Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
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
	@PostMapping("eka_manager/teacher_delete")
	public String teacherDelete(String delete, Model model, HttpSession session, @RequestParam long tid) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		boolean result = tservice.deleteTeacher(tid);
		if (result == false) {
			model.addAttribute("msg", "삭제가 실패했습니다.");
			model.addAttribute("return_mapping", "teacher_edit");
			return "eka_manager/msg_alert";
		} else {
			model.addAttribute("msg", "삭제가 완료되었습니다.");
			model.addAttribute("return_mapping", "teacher_edit");
			return "eka_manager/msg_alert";
		}
	}
	
	// 강사 검색하기
	@PostMapping("eka_manager/teacher_find")
	public String teacherFindForm(Model model, HttpSession session,
			@RequestParam String subject, @RequestParam String gender,
			@RequestParam String foreigner, @RequestParam String name) {
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		List<Teacher> teacher_list = new ArrayList<Teacher>();
		
		// all,all,all "" -> 전체검색
		if (subject.equals("all") && gender.equals("all") 
				&& foreigner.equals("all") && name.equals("")) {
			model.addAttribute("teacher_list", tservice.findAllAcademyTeacher(academy));
		}
		if (!subject.equals("all") && !gender.equals("all") && !foreigner.equals("all") && !name.equals("")) {
			teacher_list = tservice.findTeacherByAll(academy, subject, gender, foreigner, name);
			model.addAttribute("teacher_list", teacher_list);
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
		
		// 과목, 성별
		if (!subject.equals("all") && !gender.equals("all") && foreigner.equals("all") && name.equals("")) {
			teacher_list = tservice.findTeacherBySubjectGender(academy, subject, gender);
			model.addAttribute("teacher_list", teacher_list);
		}
		// 과목, 외국인
		if (!subject.equals("all") && gender.equals("all") && !foreigner.equals("all") && name.equals("")) {
			teacher_list = tservice.findTeacherBySubjectForeign(academy, subject,foreigner);
			model.addAttribute("teacher_list", teacher_list);
		}
		// 과목, 이름
		if (!subject.equals("all") && gender.equals("all") && foreigner.equals("all") && !name.equals("")) {
			teacher_list = tservice.findTeacherBySubjectName(academy, subject, name);
			model.addAttribute("teacher_list", teacher_list);
		}
		// 성별, 외국인
		if (subject.equals("all") && !gender.equals("all") && !foreigner.equals("all") && name.equals("")) {
			teacher_list = tservice.findTeacherByGenderForeign(academy, gender, foreigner);
			model.addAttribute("teacher_list", teacher_list);
		}
		// 성별, 이름
		if (subject.equals("all") && !gender.equals("all") && foreigner.equals("all") && !name.equals("")) {
			teacher_list = tservice.findTeacherByGenderName(academy,gender,name);
			model.addAttribute("teacher_list", teacher_list);
		}
		// 외국인, 이름
		if (subject.equals("all") && gender.equals("all") && !foreigner.equals("all") && !name.equals("")) {
			teacher_list = tservice.findTeacherByForeignName(academy,foreigner, name);
			model.addAttribute("teacher_list", teacher_list);
		}
		
		model.addAttribute("subject", tservice.findSubjectCategory());
		return "eka_manager/teacher_edit";
	}
	
	
}
