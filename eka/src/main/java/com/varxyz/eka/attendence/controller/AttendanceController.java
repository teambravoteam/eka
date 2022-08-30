package com.varxyz.eka.attendence.controller;

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
import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.academy.lecture.service.LectureServiceImpl;
import com.varxyz.eka.attendence.domain.AttendanceStudent;
import com.varxyz.eka.attendence.domain.Attendence;
import com.varxyz.eka.attendence.service.AttendanceServiceImp;
import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.student.domain.Student;

@Controller
public class AttendanceController {
	
	
	@Autowired
	private LectureServiceImpl lservice;
	@Autowired
	private AcademyServiceImp academyService;
	@Autowired
	private AttendanceServiceImp attendanceService;
	
	@GetMapping("eka_manager/attendance_page")
	public String attendancePage(Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());		
		
		session.setAttribute("lecture", lservice.findallAcademyLectures(academy));		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/attendance";
	}
	
	@GetMapping("eka_manager/attendance_edit")
	public String attendanceEdit(Model model, HttpSession session) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");

		Academy academy = academyService.findAcademyByAid(am.getAcademyId());	
		
		session.setAttribute("lecture", lservice.findallAcademyLectures(academy));	
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/attendance_edit";
	}
	
	@PostMapping("eka_manager/find_lecture_student")
	public String findLectureStudent(Model model, HttpSession session, @RequestParam String lectureName) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		Lecture lc = lservice.findLectureIdByLectureName(academy, lectureName);
		List<AttendanceStudent> lectureStudentList = attendanceService.findAcademyStudentByLecture(lc);
			
		
		session.setAttribute("slecture", lc);
		session.setAttribute("lectureStudentList", lectureStudentList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		
		return "eka_manager/attendance";
	}
	
	@PostMapping("eka_manager/find_lecture_attendance")
	public String findAttendanceStudent(Model model, HttpSession session, @RequestParam String lectureName,
			@RequestParam String studentName, @RequestParam String attendanceDate) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		Lecture lc = lservice.findLectureIdByLectureName(academy, lectureName);
		
		List<Attendence> attendanceList = attendanceService.findAcademyAttendanceByLecture(lc);
		

		if(lectureName == "" && studentName == "" && attendanceDate == "") {
			attendanceList = attendanceService.findAllAcademyStudent(lc);
		}else if(lectureName != "" && studentName == "" && attendanceDate ==  "" ) {
			attendanceList = attendanceService.findAcademyAttendanceByLecture(lc);
		}else if(lectureName == "" && studentName != "" && attendanceDate ==  "" ) {
			attendanceList = attendanceService.findAcademyStudentByStudentName(lc, studentName);
		}else if(lectureName == "" && studentName == "" && attendanceDate !=  "" ) {
			attendanceList = attendanceService.findAcademyStudentByLectureDate(lc,attendanceDate);
		}else if(lectureName != "" && studentName != "" && attendanceDate ==  "" ) {
			attendanceList = attendanceService.findAcademyStudentByLectureAndStudentName(lc,studentName);
		}else if(lectureName != "" && studentName == "" && attendanceDate !=  "" ) {
			attendanceList = attendanceService.findAcademyStudentByLectureAndLectureDate(lc,attendanceDate);
		}else if(lectureName == "" && studentName != "" && attendanceDate !=  "" ) {
			attendanceList = attendanceService.findAcademyStudentByStudentNameAndLectureDate(lc,studentName,attendanceDate);
		}else if(lectureName != "" && studentName != "" && attendanceDate !=  "" ) {
			attendanceList = attendanceService.findAcademyStudentByLectureAndStudentNameAndLectureDate(lc,studentName,attendanceDate);
		}		
		
		session.setAttribute("slecture", lc);		
		session.setAttribute("attendanceList", attendanceList);		
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		return "eka_manager/attendance_edit";
	}
	
	@PostMapping("eka_manager/attendance_finish")
	public String attendanceFinish(Model model, HttpSession session) throws ParseException {
		// session

		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = fm.format(c1.getTime());
		Date now = fm.parse(strToday);

		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		List<AttendanceStudent> lectureStudentList = (List<AttendanceStudent>) session
				.getAttribute("lectureStudentList");
		Lecture lecture = (Lecture) session.getAttribute("slecture");
		
		List<Attendence> lista = attendanceService.findAcademyAttendanceByLecture(lecture);
		
		for (AttendanceStudent a : lectureStudentList) {
			Attendence att = new Attendence();
			att.setStudent(a.getStudent());
			att.setLecture(lecture);
			att.setAcademy(academy);
			att.setChecking(a.getAttendanceType());
			att.setRegDate(now);
			
			for(Attendence b :lista) {
				if(b.getStudent().getName().equals(att.getStudent().getName()) 
						&& b.getRegDate() == att.getRegDate()) {
					attendanceService.updateAttendence(att);
				}
			}
			attendanceService.addAttendece(att);
		}
		session.setAttribute("lectureStudentList", null);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		
		return "eka_manager/attendance";
		
		
	}
	
	
	@PostMapping("eka_manager/attendance_check")
	public String attendanceCheck(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<AttendanceStudent> lectureStudentList = (List<AttendanceStudent>) session.getAttribute("lectureStudentList");
		for(AttendanceStudent a : lectureStudentList) {
			if(a.getStudent().getSid() == studentId) {
				a.setAttendanceType("출석");
			}
		}
		session.setAttribute("lectureStudentList", lectureStudentList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());

		
		return "eka_manager/attendance";
	}
	
	
	
	@PostMapping("eka_manager/absence_check")
	public String absenceCheck(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<AttendanceStudent> lectureStudentList = (List<AttendanceStudent>) session.getAttribute("lectureStudentList");
		for(AttendanceStudent a : lectureStudentList) {
			if(a.getStudent().getSid() == studentId) {
				a.setAttendanceType("결석");
			}
		}
		session.setAttribute("lectureStudentList", lectureStudentList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());

		
		return "eka_manager/attendance";
	}
	
	@PostMapping("eka_manager/late_check")
	public String lateCheck(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<AttendanceStudent> lectureStudentList = (List<AttendanceStudent>) session.getAttribute("lectureStudentList");
		for(AttendanceStudent a : lectureStudentList) {
			if(a.getStudent().getSid() == studentId) {
				a.setAttendanceType("지각");
			}
		}
		session.setAttribute("lectureStudentList", lectureStudentList);
//		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());
		
		return "eka_manager/attendance";
	}
	
	
	
	
	//// dadwd
	
	@PostMapping("eka_manager/attendance_update")
	public String attendanceUpdate(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<Attendence> attendanceList = (List<Attendence>) session.getAttribute("attendanceList");
		for(Attendence a : attendanceList) {
			if(a.getStudent().getSid() == studentId) {
				a.setChecking("출석");
				attendanceService.updateAttendence(a);
			}
		}
		session.setAttribute("attendanceList", attendanceList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());

		
		return "eka_manager/attendance_edit";
	}
	
	@PostMapping("eka_manager/absence_update")
	public String absenceUpdate(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<Attendence> attendanceList = (List<Attendence>) session.getAttribute("attendanceList");
		for(Attendence a : attendanceList) {
			if(a.getStudent().getSid() == studentId) {
				a.setChecking("결석");
				attendanceService.updateAttendence(a);
			}
		}
		session.setAttribute("attendanceList", attendanceList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());

		
		return "eka_manager/attendance_edit";
	}
	
	@PostMapping("eka_manager/late_update")
	public String lateUpdate(Model model, HttpSession session, @RequestParam long studentId) {
		//session
		AcademyManager am = (AcademyManager) session.getAttribute("manager");
		Academy academy = academyService.findAcademyByAid(am.getAcademyId());
		
		model.addAttribute("lecture", lservice.findallAcademyLectures(academy));
		List<Attendence> attendanceList = (List<Attendence>) session.getAttribute("attendanceList");
		for(Attendence a : attendanceList) {
			if(a.getStudent().getSid() == studentId) {
				a.setChecking("지각");
				attendanceService.updateAttendence(a);
			}
		}
		session.setAttribute("attendanceList", attendanceList);
		model.addAttribute("academyName", academyService.findAcademyByAid(am.getAcademyId()).getName());

		
		return "eka_manager/attendance_edit";
	}
	
	
	
	
	
}