package com.varxyz.eka.consulting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.academy.teacher.service.TeacherServiceImpl;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.consulting.category.domain.ConsultCategory;
import com.varxyz.eka.consulting.domain.Consulting;
import com.varxyz.eka.consulting.service.ConsultingServiceImp;

@Controller("consultingController")
public class ConsultingController {

	@Autowired
	private ConsultingServiceImp consultingService;		
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private TeacherServiceImpl tservice;


	@GetMapping("eka_manager/consulting_edit")
	public String ConsultingEdit(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
		model.addAttribute("registConsultingList",registConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_edit";
	}
	

	@GetMapping("eka_manager/consulting_unuser")
	public String consultingUnuser(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		System.out.println(academy.getAid());
		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
		System.out.println(applyConsultingList);
		model.addAttribute("applyConsultingList",applyConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_unuser";
	}
	
	@GetMapping("eka_manager/consulting_eka")
	public String consulting(Model model, HttpSession session) {
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		System.out.println(academy.getAid());
		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
		System.out.println(applyConsultingList);
		model.addAttribute("applyConsultingList",applyConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_eka";
	}
	
	
	@PostMapping("eka_manager/add_apply_consult")
	public String addApplyconsulting(Model model,
			@RequestParam String studentName, @RequestParam String studentPhone,
			@RequestParam String studentConsult, @RequestParam long academyId ,HttpSession session) throws ParseException {		
	
		long checkManager = 0;		
		// ?????? ??????????????? ??????
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		if (am == null) {
			checkManager = 1;
		} else {
			checkManager = 0;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
	
		
		Academy academy = academyService.findAcademyByAid(academyId);
		ConsultCategory csc = new ConsultCategory();
		csc.setCategory("??????");
		
		Consulting applyConsult = new Consulting();
		applyConsult.setAcademy(academy);
		applyConsult.setApplyDate(strToday);
		applyConsult.setConsultCategory(csc);
		applyConsult.setConsultDatail(studentConsult);
		applyConsult.setConsultType("??????");
		applyConsult.setName(studentName);
		applyConsult.setPhone(studentPhone);
		applyConsult.setRegistDate("");
		
		consultingService.addApplyConsulting(applyConsult);
		
		model.addAttribute("academy", academyService.findAcademyByAid(academy.getAid()));
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("teacher", tservice.findAllAcademyTeacher(academy));
		model.addAttribute("subject", tservice.findSubjectCategory());
		model.addAttribute("checkManager", checkManager);
		
		return "eka_main/academy/detail_page";		
	}
	
	@PostMapping("eka_manager/applyconsulting_select")
	public String applyConsultingSelect(Model model, @RequestParam String name,
			@RequestParam String applyDate, @RequestParam String consultType, HttpSession session) throws ParseException {		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date to = fm.parse(applyDate);
		System.out.println(to);
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		Consulting applyConsult = consultingService.findAcademyApplyConsultingByRegDateAndName(academy, to , name);		
		
		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);
		model.addAttribute("applyConsult",applyConsult);
		model.addAttribute("applyConsultingList",applyConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_eka";		
	}
	
	@PostMapping("eka_manager/registconsulting_select")
	public String registConsultingSelect(Model model, @RequestParam String name,
			@RequestParam String applyDate, @RequestParam String consultType,HttpSession session) throws ParseException {		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date to = fm.parse(applyDate);
		System.out.println(to);
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		Consulting registConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);		
		
		
		
		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
		
		
		System.out.println(registConsultingList.get(0).getConsultContent());
		System.out.println(registConsultingList.get(0).getConsultDatail());
		
		model.addAttribute("registConsult",registConsult);		
		model.addAttribute("registConsultingList",registConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_edit";		
	}
	
	
	@PostMapping("eka_manager/update_consulting")
	public String updateConsulting(Model model, @RequestParam String name,
			@RequestParam String applyDate, @RequestParam String registDate,
			@RequestParam String consultContent, HttpSession session) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
		Date to = fm.parse(applyDate);
		Date now = fm.parse(registDate);		
			
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());		
		Consulting updateConsult = consultingService.findAcademyConsultingByRegDateAndName(academy, to , name);
		
		updateConsult.setRegistDate(registDate);
		updateConsult.setConsultContent(consultContent);
		updateConsult.setConsultType("??????");		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		System.out.println(updateConsult);
		
		consultingService.updateConsulting(updateConsult);
		
		
		List<Consulting> applyConsultingList = consultingService.findAllAcademyApplyConsulting(academy);		
		model.addAttribute("applyConsultingList",applyConsultingList);
		return "eka_manager/consulting_eka";
		
	}
	
	@PostMapping("eka_manager/update_regist_consulting")
	public String updateRegistConsulting(Model model, @RequestParam String name,
			@RequestParam String applyDate, @RequestParam String registDate,
			@RequestParam String consultDetail,@RequestParam String consultContent, HttpSession session) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
		Date to = fm.parse(applyDate);
		Date now = fm.parse(registDate);		
			
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		Consulting updateConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);	
		
		updateConsult.setConsultDatail(consultDetail);
		updateConsult.setRegistDate(registDate);
		updateConsult.setConsultContent(consultContent);
		updateConsult.setConsultType("??????");		
		
		
		
	
		System.out.println(consultingService.updateRegistConsulting(updateConsult));
		

		Consulting registConsult = consultingService.findAcademyRegistConsultingByRegDateAndName(academy, to , name);	
		List<Consulting> registConsultingList = consultingService.findAllAcademyRegistConsulting(academy);
		model.addAttribute("registConsult",registConsult);
		model.addAttribute("registConsultingList",registConsultingList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		
		
		return "eka_manager/consulting_edit";		
	}
	
	
	@PostMapping("eka_manager/add_regist_consulting")
	public String addRegistConsulting(Model model, @RequestParam String name,
			@RequestParam String phone1, @RequestParam String phone2, @RequestParam String phone3,
			@RequestParam String applyDate, @RequestParam String registDate,@RequestParam String consultContent,
			@RequestParam String consultCategory,@RequestParam String consultDetail,HttpSession session) throws ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");		
		Date to = fm.parse(applyDate);
		Date now = fm.parse(registDate);
		
		String phone = phone1+"-"+phone2+"-"+phone3;	
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());		
		ConsultCategory csc = new ConsultCategory();
		csc.setCategory(consultCategory);
		
		Consulting addConsult = new Consulting();
		addConsult.setAcademy(academy);
		addConsult.setApplyDate(applyDate);
		addConsult.setConsultCategory(csc);
		addConsult.setConsultContent(consultContent);
		addConsult.setConsultDatail(consultDetail);
		addConsult.setConsultType("??????");
		addConsult.setName(name);
		addConsult.setPhone(phone);
		addConsult.setRegistDate(registDate);
	
		consultingService.addRegistConsulting(addConsult);	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		
		return "eka_manager/consulting_unuser";		
	}
	
	
	@PostMapping("eka_manager/find_select_consulting")
	public String findSelectConsulting(Model model, @RequestParam String name,
			@RequestParam String applyDate, @RequestParam String registDate,
			@RequestParam String consultCategory, HttpSession session) throws ParseException {
		System.out.println(name);
		System.out.println(applyDate);
		System.out.println(registDate);
		System.err.println(consultCategory);
		
		
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		ConsultCategory csc = new ConsultCategory();
		csc.setCategory(consultCategory);
		
		
		List<Consulting> registConsultingList = null;
		
		if(consultCategory == "" && applyDate == "" && registDate == "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsulting(academy);
		}else if(consultCategory != "" && applyDate == "" && registDate == "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategory(academy,consultCategory);
		}else if(consultCategory == "" && applyDate != "" && registDate == "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByApplyDate(academy,applyDate);
		}else if(consultCategory == "" && applyDate == "" && registDate != "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByRegistDate(academy,registDate);
		}else if(consultCategory == "" && applyDate == "" && registDate == "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByName(academy,name);
		}else if(consultCategory != "" && applyDate != "" && registDate == "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDate(academy,consultCategory,applyDate);
		}else if(consultCategory != "" && applyDate == "" && registDate != "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndRegistDate(academy,consultCategory,registDate);
		}else if(consultCategory != "" && applyDate == "" && registDate == "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndName(academy,consultCategory,name);
		}else if(consultCategory == "" && applyDate != "" && registDate != "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByApplyDateAndRegistDate(academy,applyDate,registDate);
		}else if(consultCategory == "" && applyDate != "" && registDate == "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByApplyDateAndName(academy,applyDate,name);
		}else if(consultCategory == "" && applyDate == "" && registDate != "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByRegistDateAndName(academy,registDate,name);
		}else if(consultCategory != "" && applyDate != "" && registDate != "" && name == "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDate(academy,consultCategory,applyDate,registDate);
		}else if(consultCategory != "" && applyDate != "" && registDate == "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndName(academy,consultCategory,applyDate,name);
		}else if(consultCategory != "" && applyDate == "" && registDate != "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndRegistDateAndName(academy,consultCategory,registDate,name);
		}else if(consultCategory == "" && applyDate != "" && registDate != "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByApplyDateAndRegistDateAndName(academy,applyDate,registDate,name);
		}else if(consultCategory != "" && applyDate != "" && registDate != "" && name != "") {
			registConsultingList = consultingService
					.findAllAcademyRegistConsultingByConsultCategoryAndApplyDateAndRegistDateAndName(academy,consultCategory,applyDate,registDate,name);
		}
		
		model.addAttribute("registConsultingList",registConsultingList);	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/consulting_edit";		
	}
	
	
}
