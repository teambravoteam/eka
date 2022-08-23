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
	
	@Override //학원관리자는 학생을 등록 할 수 있어야 한다
	public boolean addStudent(Student student) {
		try {
			dao.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//학원관리자는 학생정보를 수정 할 수 있어야 한다
	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//학원관리자는 학생정보를 삭제 할 수 있어야 한다
	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/// 갓 수현 첨삭중
	public List<Student> findAllAcademyStudentByAcademy(Academy academy) {
		return dao.findAllAcademyStudentByAcademy(academy);
	}
	
	
	//학원 관리자는 모든 학원학생 정보를 가져올 수 있어야 한다.
	@Override
	public List<Student> findAllAcademyStudent(Student Student) {
		return dao.findAllAcademyStudent(Student);
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
