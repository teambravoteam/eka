package com.varxyz.eka.academy.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.teacher.command.TeacherListCommand;
import com.varxyz.eka.academy.teacher.domain.SubjectCategory;
import com.varxyz.eka.academy.teacher.domain.Teacher;
import com.varxyz.eka.academy.teacher.repository.TeacherDao;

@Service
public class TeacherServiceImpl {

	@Autowired
	private TeacherDao dao;
	
	
	// 과목 조회
	public List<SubjectCategory> findSubjectCategory() {
		return dao.findSubjectCategory();
	}
	
	// 강사등록
	public boolean addTeacher(Teacher teacher) {
		try {
			dao.addTeacher(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 강사 정보 수정 업데이트
	public boolean updateTeacher(TeacherListCommand teacher) {
		try {
			dao.updateTeacher(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 강사 삭제하기
//	public boolean deleteTeacher(Teacher teacher) {
//		try {
//			dao.updateTeacher(TeacherListCommand);
//			return true;
//		} catch (Exception e) {			
//			return false;
//		}
//	}
	
	// 강사 전체 조회
	public List<Teacher> findAllAcademyTeacher(Academy academy) {
		return dao.findAllAcademyTeacher(academy);
	}

	// 성별로 강사 조회
	public List<Teacher> findTeacherByGender(Academy academy, String gender) {
		return dao.findTeacherByGender(academy, gender);
	}
	
	// 과목으로강사 조회
	public List<Teacher> findTeacherBySubject(Academy academy, String subject) {
		return dao.findTeacherBySubject(academy, subject);
	}
	
	// 외국인 여부로 강사 조회
	public List<Teacher> findTeacherByForeigner(Academy academy, String foreigner) {
		return dao.findTeacherByForeigner(academy, foreigner);
	}
	
	// 강사명으로 강사 조회
	public List<Teacher> findTeacherByName(Academy academy, String name) {
		return dao.findTeacherByName(academy, name);
	}
	
	// 강사id로 강사 상세정보 조회
	public List<Teacher> findTeacherByTid(Academy academy, long teacherId) {
		return dao.findTeacherByTid(academy, teacherId);
	}

}
