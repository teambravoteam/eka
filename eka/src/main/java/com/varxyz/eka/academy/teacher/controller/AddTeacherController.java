package com.varxyz.eka.academy.teacher.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.academy.service.AcademyServiceImp;
import com.varxyz.eka.academy.teacher.domain.Teacher;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;

//@Controller
public class AddTeacherController {
	
	@Autowired
	private TeacherServiceImpl tservice;
	@Autowired
	private AcademyServiceImp academyService;
	
	@GetMapping("eka_manager/teacher_add")
	public String TeacherAdd(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/teacher_add";
	}
	
	@PostMapping("eka_manager/teacher_add")
	public String TeacherAddForm(Teacher teacher, Model model, HttpServletRequest request,
			HttpSession session) throws IOException {
		//유효성검증하기, 중복확인
		
		String path="C:\\JAVA\\workspace\\eka\\eka\\src\\main\\webapp\\resources\\teacher_img";
		int sizeLimit = 100 * 1024 * 1024;
		String encode = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encode, new DefaultFileRenamePolicy());
		
		String phone = multi.getParameter("phone1") + "-" 
				+ multi.getParameter("phone2") + "-" + multi.getParameter("phone3");

		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		teacher.setAcademy(academy);
		teacher.setName(multi.getParameter("name"));
		teacher.setSsn(multi.getParameter("ssn"));
		teacher.setGender(multi.getParameter("gender"));
		teacher.setPhone(phone);
		teacher.setSubject(multi.getParameter("subject"));
		teacher.setEducation(multi.getParameter("education"));
		teacher.setCareer(multi.getParameter("career"));
		teacher.setForeigner(multi.getParameter("foreigner"));
		
		//image값이 없다면 'default_profile.png'로 저장하기
		if (multi.getParameter(multi.getFilesystemName("image")) == null) {
			teacher.setImage("default_profile.png");
		} else {
			teacher.setImage(multi.getParameter(multi.getFilesystemName("image")));
		}
		
		//insert결과값으로 유효성검증
		System.out.println(teacher.getPhone());
		
		if (teacher.getName().equals("")) {
			model.addAttribute("msg", "강사명을 입력해주세요.");
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		} else if (teacher.getSsn().equals("")) {
			model.addAttribute("msg", "생년월일을 입력해주세요.");
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		} else if (teacher.getGender() == null) {
			model.addAttribute("msg", "성별을 선택해주세요.");
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		} else if (teacher.getForeigner() == null) {
			model.addAttribute("msg", "원어민 여부를 선택해주세요.");
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		} else if (teacher.getPhone().equals("010--")) {
			model.addAttribute("msg", "전화번호를 입력해주세요.");
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		}
		
		
		boolean result = tservice.addTeacher(teacher);
		if (result == false) {
			String msg = "강사등록에 실패했습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		} else {
			String msg = teacher.getName() + "강사가 등록되었습니다.";
			model.addAttribute("msg", msg);
			model.addAttribute("return_mapping", "teacher_add");
			return "eka_manager/msg_alert";
		}
		
	}
	

}
