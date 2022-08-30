package com.varxyz.eka.student.service;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.FindStudent;
import com.varxyz.eka.student.domain.Student;
import com.varxyz.eka.student.repository.StudentDao;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override // 학원관리자는 학교을 등록 할 수 있어야 한다
	public boolean addStudent(Student student) {
		try {
			dao.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 학원관리자는 학생의 정보를 수정
	@Override
	public boolean updateStudent(Student student) {
		return dao.updateStudent(student);
	}

	// 학원관리자는 학생의 정보를 삭제
	@Override
	public boolean deleteStudent(Student student) {
		return dao.deleteStudent(student);
	}

	

	/*
	 * 학생전체 리스트 학교 리스트
	 * */	
	
	
	// 그 학원의 등록된 학생의 리스트를 불러온다
	@Override
	public List<Student> findAllAcademyStudent(Academy academy) {
		return dao.findAllAcademyStudentByAcademy(academy);
	}

	// 학교의 상세정보를 불러온다
	@Override
	public Student detailedInformation(String name, String ssn) {
		return dao.detailedInformation(name, ssn);
	}

	/**
	 * 카테고리별 검색 구간
	 * 
	 */

	// 학생의 정보를 카테고리별로 불러온다
	@Override
	public List<Student> findAcademyStudentsByEkaSignUp(Academy academy, FindStudent findStudent) {
		List<Student> stuList = null;
		
		
		if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0 
				&&findStudent.getGendercheck() == null &&findStudent.getSchool().equals("선택") 
				&& findStudent.getGrade().equals("선택")) {
			//1. 아무것도 선택 x 
			stuList = dao.findAllAcademyStudentByAcademy(academy);
			
		}else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&&findStudent.getGendercheck() == null && findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//2. 에카회원일때 아닐때
			stuList = dao.findAcademyStudentByEkacheck(academy, findStudent.getEkacheck());
			
		}else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&&findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//3. 학교만 입력할때,
			stuList = dao.findAcademyStudentBySchool(academy,findStudent.getSchool());
			
		}else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&&findStudent.getGendercheck() == null &&findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//4. 학년만 입력 했을 때,
			stuList = dao.findAcademyStudentByGrade(academy,findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&&findStudent.getGendercheck() == null &&findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//5.이름만 입력 했을 떄,
			stuList = dao.findAcademyStudentByName(academy,findStudent.getName());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&&findStudent.getGendercheck() != null &&findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//6. 성별을 했을 때
			stuList = dao.findAcademyStudentByGender(academy ,findStudent.getGendercheck());
			
		}  else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&&findStudent.getGendercheck() == null &&findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//7. 회원 + 이름
			stuList = dao.findAcademyStudentByEkaCheckANDName(academy,findStudent.getName(), findStudent.getEkacheck());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&&findStudent.getGendercheck() == null &&!findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//8. 회원 + 학교 
			stuList = dao.findAcademyStudentByEkaCheckANDSchool(academy,findStudent.getSchool(), findStudent.getEkacheck());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null &&findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//9 회원 + 성별 
			stuList = dao.findAcademyStudentByEkaCheckANDGender(academy, findStudent.getGendercheck(), findStudent.getEkacheck());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() == null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//10 회원 + 학년
			stuList = dao.findAcademyStudentByEkaCheckANDGradecate(academy ,findStudent.getGrade(),findStudent.getEkacheck());
			
		}  else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//11 이름 + 성별
			stuList = dao.findAcademyStudentByNameANDGender(academy ,findStudent.getName(),findStudent.getGendercheck());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//12 이름 + 학교
			stuList = dao.findAcademyStudentByNameANDSchool(academy ,findStudent.getName(),findStudent.getSchool());
			
		}  else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() == null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//13 이름 + 학년
			stuList = dao.findAcademyStudentByNameANDGrade(academy ,findStudent.getName(),findStudent.getGrade());
			
		}  else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//14 학년 + 학교
			stuList = dao.findAcademyStudentByNameANDGrade(academy ,findStudent.getGrade(),findStudent.getSchool());
			
		}  else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//15 학년 + 성별
			stuList = dao.findAcademyStudentByGradeANDGender(academy ,findStudent.getGrade(),findStudent.getGendercheck());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//16 학교 + 성별
			stuList = dao.findAcademyStudentBySchoolANDGender(academy ,findStudent.getSchool(),findStudent.getGendercheck());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//17 회원 + 이름 + 성별
			stuList = dao.findAcademyStudentByEkaUserANDNameANDGender(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getGendercheck());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//18 회원 + 이름 + 학교
			stuList = dao.findAcademyStudentByEkaUserANDNameANDSchool(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getSchool());
			
		}  else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() == null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//19 회원 + 이름 + 학년
			stuList = dao.findAcademyStudentByEkaUserANDNameANDGrade(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//20 회원 + 성별 + 학교
			stuList = dao.findAcademyStudentByEkaUserANDGenderANDSchool(academy ,findStudent.getEkacheck(),findStudent.getGendercheck(),findStudent.getSchool());
			
		}  else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//21 회원 + 성별 + 학년
			stuList = dao.findAcademyStudentByEkaUserANDGenderANDGrade(academy ,findStudent.getEkacheck(),findStudent.getGendercheck(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//22 회원 + 학교 + 학년
			stuList = dao.findAcademyStudentByEkaUserANDSchoolANDGrade(academy ,findStudent.getEkacheck(),findStudent.getSchool(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//23 이름 + 성별 + 학교
			stuList = dao.findAcademyStudentByNameANDGenderANDSchool(academy ,findStudent.getName(),findStudent.getGendercheck(),findStudent.getSchool());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//24 이름 + 성별 + 학년
			stuList = dao.findAcademyStudentByNameANDGenderANDgrade(academy ,findStudent.getName(),findStudent.getGendercheck(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() == null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//25 이름 + 학교 + 학년
			stuList = dao.findAcademyStudentByNameANDSchoolANDgrade(academy ,findStudent.getName(),findStudent.getSchool(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//26 성별 + 학교 + 학년
			stuList = dao.findAcademyStudentByGenderANDSchoolANDgrade(academy ,findStudent.getGendercheck(),findStudent.getSchool(),findStudent.getGrade());
			
		}else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& findStudent.getGrade().equals("선택")) {
			//27 회원 / 이름 / 성별 / 학교
			stuList = dao.findAcademyStudentByEkaUserANDNameANDGenderANDSchool(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getGendercheck(),findStudent.getSchool());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//28 회원 / 이름 / 성별 / 학년
			stuList = dao.findAcademyStudentByEkaUserANDNameANDGenderANDGrade(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getGendercheck(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() == 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//29 회원 / 성별 / 학교/ 학년
			stuList = dao.findAcademyStudentByEkaUserANDGenderANDSchoolANDGrade(academy ,findStudent.getEkacheck(),findStudent.getGendercheck(),findStudent.getSchool(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() == null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//30 이름 / 성별 / 학교 / 학년
			stuList = dao.findAcademyStudentByNameANDGenderANDSchoolANDgrade(academy ,findStudent.getName(),findStudent.getGendercheck(),findStudent.getSchool(),findStudent.getGrade());
			
		} else if(findStudent.getEkacheck() != null && findStudent.getName().length() != 0
				&& findStudent.getGendercheck() != null && !findStudent.getSchool().equals("선택")
				&& !findStudent.getGrade().equals("선택")) {
			//31 회원 / 이름 / 성별 / 학교 / 학년
			stuList = dao.findAcademyStudentByEkaUserANDNameANDGenderANDSchoolANDgrade(academy ,findStudent.getEkacheck(),findStudent.getName(),findStudent.getGendercheck(),findStudent.getSchool(),findStudent.getGrade());
			
		} 
		
		return stuList;
	}


}
