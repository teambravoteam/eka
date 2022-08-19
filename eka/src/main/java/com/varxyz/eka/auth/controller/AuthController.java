package com.varxyz.eka.auth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;
import com.varxyz.eka.auth.domain.ErrorMsgs;
import com.varxyz.eka.auth.service.AuthService;

@Controller("eka_main.authController")
@SuppressWarnings("resource") // 컴파일 경고를 없애줌
public class AuthController {

	@Autowired
	private AuthService service;

	@GetMapping("/eka_main/main") // 확인용 메인페이지
	public String main(Model model) {
		model.addAttribute("main", new AcademyManager());
		return "eka_main/main";
	}

	@GetMapping("/eka_main/register_main")
	public String registerMain(Model model) {
		model.addAttribute("acadmyManager", new AcademyManager());
		return "eka_main/auth/register_main";
	}

	@GetMapping("/eka_main/addmanager")
	public String addManager(Model model) {
		model.addAttribute("register_academy", new AcademyManager());
		return "eka_main/auth/register_academy";
	}

	@GetMapping("/eka_main/adduser")
	public String addUser(Model model) {
		model.addAttribute("acadmyManager", new AcademyManager());
		return "eka_main/auth/register_student";

	}

	@PostMapping("/eka_main/addmanager") // 원장가입
	public String addManager(AcademyManager academyManager, Model model, HttpServletRequest request,
			ErrorMsgs errorMsgs) {

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userPw2 = request.getParameter("userPw2");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String ssn = request.getParameter("ssn");

		errorMsgs.setUserId(null);
		errorMsgs.setUserPw(null);
		errorMsgs.setUserPw2(null);
		errorMsgs.setName(null);
		errorMsgs.setPhone(null);
		errorMsgs.setSsn(null);

		List<String> count = new ArrayList<>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.setUserId("아이디는 필수입력 정보입니다");
			count.add("1");
		}
		if (userPw == null || userPw.length() == 0) {
			errorMsgs.setUserPw("비밀번호는 필수입력 정보입니다");
			count.add("1");
		}
		if (userPw2 == null || userPw2.length() == 0) {
			errorMsgs.setUserPw2("비밀번호 확인을 하지 않았습니다");
			count.add("123");
		}
		if (name == null || name.length() == 0) {
			errorMsgs.setName("이름은 필수입력 정보입니다");
			count.add("1");
		}
		if (phone == null || phone.length() == 0) {
			errorMsgs.setPhone("폰번호는 필수입력 정보입니다");
			count.add("1");
		}
		if (ssn == null || ssn.length() == 0) {
			errorMsgs.setSsn("주민번호는 필수입력 정보입니다");
			count.add("1");
		}

		// 리스트에 사이즈가 0이상이면 안한곳이 있으니 메서지를 보낸다
		if (count.size() > 0) {
			model.addAttribute("errorMsgs", errorMsgs);
			return "eka_main/auth/register_academy";
		}
		
		// 비밀번호와 확인이 같지 않으면 가입 안됨
		if (academyManager.getUserPw().equals(academyManager.getUserPw2()) == false) {
			model.addAttribute("passwd","비밀번호가 일치하지 않습니다");
			return "eka_main/auth/register_academy";
		}

		try {
			
			service.addManager(academyManager);
			return "eka_main/success_addmanager";
		} catch (Exception e) {
			e.printStackTrace();
			return "eka_main/error_addmanager";
		}

	}
	

	// 매니저 아이디체크
	@PostMapping("/eka_main/idtest1") 
	public String idtest1(EkaUser ekaUser, Model model, HttpServletRequest request) {

		if (service.usercheckId(ekaUser.getUserId()) == true) {
			model.addAttribute("message_red", "존재하는 아이디입니다");
			return "eka_main/auth/register_academy";
		} else {
			model.addAttribute("message_green", "사용가능한 아이디입니다");
			model.addAttribute("userId", ekaUser.getUserId());
			return "eka_main/auth/register_academy";
		}

	}

	// 유저 아이디체크
	@PostMapping("/eka_main/idtest2")
	public String idtest2(EkaUser ekaUser, Model model, HttpServletRequest request) {

		if (service.usercheckId(ekaUser.getUserId()) == true) {
			model.addAttribute("message_red", "존재하는 아이디입니다");
			return "eka_main/auth/register_student";
		} else {
			model.addAttribute("message_green", "사용가능한 아이디입니다");
			model.addAttribute("userId", ekaUser.getUserId());
			return "eka_main/auth/register_student";
		}

	}

	@PostMapping("/eka_main/adduser") // 유저가입
	public String addUser(EkaUser ekaUser, Model model, HttpServletRequest request, ErrorMsgs errorMsgs) { // 유저가입

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userPw2 = request.getParameter("userPw2");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		errorMsgs.setUserId(null);
		errorMsgs.setUserPw(null);
		errorMsgs.setUserPw2(null);
		errorMsgs.setName(null);
		errorMsgs.setGender(null);
		errorMsgs.setSsn(null);
		errorMsgs.setPhone(null);
		errorMsgs.setEmail(null);

		List<String> count = new ArrayList<>();
		if (userId == null || userId.length() == 0) {
			errorMsgs.setUserId("아이디는 필수입력 정보입니다");
			count.add("123");
		}
		if (userPw == null || userPw.length() == 0) {
			errorMsgs.setUserPw("비밀번호 필수");
			count.add("123");
		}
		if (userPw2 == null || userPw2.length() == 0) {
			errorMsgs.setUserPw2("비밀번호 확인을 하지 않았습니다");
			count.add("123");
		}
		if (name == null || name.length() == 0) {
			errorMsgs.setName("이름은 필수입력 정보입니다");
			count.add("123");
		}
		if (phone == null || phone.length() == 0) {
			errorMsgs.setPhone("폰번호는 필수입력 정보입니다");
			count.add("123");
		}
		if (ssn == null || ssn.length() == 0) {
			errorMsgs.setSsn("주민번호는 필수입력 정보입니다");
			count.add("123");
		}
		if (email == null || email.length() == 0) {
			errorMsgs.setEmail("이메일은 필수입력 정보입니다");
			count.add("123");
		}
		if (gender == null || gender.length() == 0) {
			errorMsgs.setGender("성별은 필수 선택사항입니다");
			count.add("123");
		}

		// 리스트에 사이즈가 0이상이면 안한곳이 있으니 메서지를 보낸다
		if (count.size() > 0) {
			model.addAttribute("errorMsgs", errorMsgs);
			return "eka_main/auth/register_student";
		}
		
		// 비밀번호와 확인이 같지 않으면 가입 안됨
		if (ekaUser.getUserPw().equals(ekaUser.getUserPw2()) == false) {
			model.addAttribute("passwd","비밀번호가 일치하지 않습니다");
			return "eka_main/auth/register_student";
		}

		try {
			service.addEkaUser(ekaUser);
			return "eka_main/auth/success_adduser";
		} catch (Exception e) {
			e.printStackTrace();
			return "eka_main/auth/register_student";
		}

	}

	
	
	
	@GetMapping("/eka_main/managerlogin") // 매니저 로그인
	public String login(Model model) {
		model.addAttribute("academymanager", new AcademyManager());
		return "eka_main/auth/login_academy";
	}

	@PostMapping("/eka_main/managerlogin") // 매니저 로그인
	public String managerLogin(Model model, AcademyManager academyManager) {

		if (service.loginManager(academyManager.getUserId(), academyManager.getUserPw()) != null) {

			model.addAttribute("manager", service.loginManager(academyManager.getUserId(), academyManager.getUserPw()));
			return "eka_main/main";
		}
		return "eka_main/login_error";
	}

	@GetMapping("/eka_main/ekauserlogin")
	public String ekaUserLogin(Model model) {
		model.addAttribute("ekauser", new EkaUser());
		return "eka_main/auth/login_student";
	}

	@PostMapping("/eka_main/ekauserlogin") // eka홈페이지 유저 로그인
	public String ekaUserLogin(Model model, EkaUser ekaUser) {

		if (service.loginEkaUsers(ekaUser.getUserId(), ekaUser.getUserPw()) != null) {
			model.addAttribute("ekauser", service.loginEkaUsers(ekaUser.getUserId(), ekaUser.getUserPw()));
			return "eka_main/main";
		}
		return "eka_main/error_ekauserlogin";

	}

}
