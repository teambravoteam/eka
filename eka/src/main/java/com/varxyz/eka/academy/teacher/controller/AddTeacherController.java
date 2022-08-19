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
import com.varxyz.eka.academy.teacher.domain.Teacher;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;

@Controller
public class AddTeacherController {
	
	@Autowired
	private TeacherServiceImpl tservice;
	
	@GetMapping("eka_manager/teacher_add")
	public String TeacherAdd(Model model) {
		
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

//		session.getAttribute("academy");
		Academy academy = new Academy(); // academy정보는 session에 저장해서 계속 이용
		academy.setAid(1);
		
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
		System.out.println(tservice.addTeacher(teacher));
		
//		System.out.println(teacher);
		
		model.addAttribute("name", teacher.getName());
		return "eka_manager/success/teacher_add_success";
	}
	

}
