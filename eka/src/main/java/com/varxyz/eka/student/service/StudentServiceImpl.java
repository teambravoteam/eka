package com.varxyz.eka.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.FindStudent;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.repository.StudentDao;
import com.varxyz.eka.student.studentcategory.domain.StudentCategory;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override // 학원관리자는 학생을 등록 할 수 있어야 한다
	public boolean addStudent(Student student) {
		try {
			dao.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 학원관리자는 학생정보를 수정 할 수 있어야 한다
	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	// 학원관리자는 학생정보를 삭제 할 수 있어야 한다
	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}


	// 하나의 학원에 포함된 학생들의 모든 정보를 불러온다
	@Override
	public List<Student> findAllAcademyStudent(Academy academy) {
		return dao.findAllAcademyStudentByAcademy(academy);
	}

	// 학생의 상세정보를 불러온다
	@Override
	public Student detailedInformation(String name, String ssn) {
		return dao.detailedInformation(name, ssn);
	}

	
	/**
	 * 카테고리별 검색 구간
	 * 
	 */

	
	// 학원관리자는 EKA회원 인 학생 정보를 가져올 수 있어야 한다
	@Override
	public List<Student> findAcademyStudentsByEkaSignUp(Academy academy, FindStudent findStudent) {
		List<Student> a = dao.findAllAcademyStudentByAcademy(academy);
		List<Student> b = null;
		for (Student student : a) {
			if (findStudent.getEkacheck().equals("가입")) {
				
			}
		}
		
		
		
		return b;
	}
	
	
	
	
	
	
	
	
	
	

	// 학원 관리자는 학생 카테고리 별 학생 정보들을 가져올 수 있어야한다
	@Override
	public List<Student> findAllAcademyStudentParent(Student student, FindStudent findStudent) {
		return null;
	}

	
	//학원 관리자는 남/여 학생 정보를 가져올 수 있어야 한다
	@Override
	public List<Student> findAcademyStudentsByGender(Student student, FindStudent findStudent) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
