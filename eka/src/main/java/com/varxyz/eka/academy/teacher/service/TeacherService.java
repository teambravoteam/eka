package com.varxyz.eka.academy.teacher.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.academy.teacher.domain.Teacher;

/*
 *lecture 는 학원의 관리자가 관리하는 영역으로 분류된다
 *즉, EKA의 관리자가 아닌 학원을 운영하는 자가 사용하는 기능이다
 * */
public interface TeacherService {

	//학원관리자는 강사를 추가할 수 있어야 한다
	public boolean addTeacher(Teacher teacher);
	
	//학원관리자는 강사정보를 수정 할 수 있어야 한다
	public boolean updateTeacher(Teacher teacher);
	
	//학원관리자는 강사정보를 삭제 할 수 있어야 한다
	public boolean deleteTeacher(Teacher teacher);
		
	/*
	 * 학원관리자는 다양한 강사의 정보를 확인 할 수 있어야 한다
	 * */
	
	//학원관리자는 학원의 모든 강사를 찾을 수 있어야 한다
	public List<Teacher> findAllAcademyTeacher(Academy academy);
	
	// 학원관리자는 학원의 남/여 강사진들을 찾을 수 있어야 한다
	public List<Teacher> findAcademyTeachersByGender(Academy academy, String gender);

	// 학원관리자는 학원의 과목별  강사진들을 찾을 수 있어야 한다
	public List<Teacher> findAcademyTeachersBySubject(Academy academy, String subject);

	// 학원관리자는 학원의 외국인 강사진들을 찾을 수 있어야 한다
	public List<Teacher> findAcademyTeachersByForeigner(Academy academy, boolean foreigner);
	
	// 학원관리자는 특정 강사진을 찾을 수 있어야 한다.
	public Teacher findAcademyTeacherByNameAndPhone(Academy academy, String phone, String name);
	

}
