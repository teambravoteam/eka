package com.varxyz.eka.student.service;

import java.util.List;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.studentcategory.domain.StudentCategory;

/*
 * 학원관리자는 학생 정보를 관리 할 수 있어야 한다
 * */
/*
 * 다만 학생 정보 조회시 학생의 부모님의 정보를 확인하기 위해서 각테이블에는 조인이 필수적이라고 생각한다
 * */
public interface StudentService {
	
	//학원관리자는 학생을 등록 할 수 있어야 한다
	public boolean addStudent(Student student);
	
	//학원관리자는 학생정보를 수정 할 수 있어야 한다
	public boolean updateStudent(Student student);
	
	//학원관리자는 학생정보를 삭제 할 수 있어야 한다
	public boolean deleteStudent(Student student);
	
	
	/*
	 * 학원관리자는 다양한 학원정보를 조회 할 수 있어야 한다
	 * */	
	//학원 관리자는 모든 학원학생 정보를 가져올 수 있어야 한다.
	public List<Student> findAllAcademyStudent(Student Student); 
	
	//학원 관리자는 학생 카테고리 별 학생 정보들을 가져올 수 있어야한다
	public List<Student> findAllAcademyStudentParent(Academy academy, StudentCategory studentCategory);
	
	//학원 관리자는 남/여 학생 정보를 가져올 수 있어야 한다
	public List<Student> findAcademyStudentsByGender(Academy academy, String gender);
	
	//학원관리자는 EKA회원 인 학생 정보를 가져올 수 있어야 한다
	public List<Student> findAcademyStudentsByEkaSignUp(Academy academy, boolean ekaSignUp);
	
	//학원관리자는 특정 학생 한명의 정보를 가져 올 수 있어야 한다
	public Student findAcademyStudentByNameAndSsn(Academy academy, String name, String ssn);
	

}
