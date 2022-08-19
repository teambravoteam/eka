package com.varxyz.eka.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.repository.StudentDao;
import com.varxyz.eka.student.studentcategory.domain.StudentCategory;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao dao;
	
	@Override
	public String addStudent(Student student) {
		if (dao.addStudent(student) == true) {
			return "등록완료";
		} else {
			return "등록실패";
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> findAllAcademyStudent(Academy academy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAcademyStudentsByGender(Academy academy, String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAcademyStudentsByEkaSignUp(Academy academy, boolean ekaSignUp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findAcademyStudentByNameAndSsn(Academy academy, String name, String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAllAcademyStudentParent(Academy academy, StudentCategory studentCategory) {
		// TODO Auto-generated method stub
		return null;
	}

}
