package com.varxyz.eka.student.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.FindStudent;
import com.varxyz.eka.student.domain.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 학생추가
	public void addStudent(Student student) {
		String sql = "INSERT INTO Student(academyId,schoolcate,gradecate,name,gender,ssn,phone,ekaUserId,parentName,parentType,parentPhone) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, student.getAcademyId(), student.getSchoolcate(), student.getGradecate(),
				student.getName(), student.getGender(), student.getSsn(), student.getPhone(), student.getEkaUserId(),
				student.getParentName(), student.getParentType(), student.getParentPhone());
	}

	// 하나의 학원에 포함된 학생들의 모든 정보를 불러온다
	public List<Student> findAllAcademyStudentByAcademy(Academy academy) {
		String sql = "SELECT * FROM Student WHERE academyId = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid());
	}

	// 상세정보를 불러온다
	public Student detailedInformation(String name, String phone) {
		String sql = "SELECT * FROM Student WHERE name = ? AND phone = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), name, phone);
	}

	/**
	 * 카테고리별 검색 구간
	 * 
	 * @return
	 * 
	 */

	// 에카 회원일때 아닐때
	public List<Student> findAcademyStudentByEkacheck(Academy academy, String ekacheck) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != ''";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid());
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = ''";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid());
		}
	}

//	// 에카 회원이 아닐때
//	public List<Student> findAcademyStudentByEkacheck2(Academy academy) {
//		String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = ''";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid());
//	}

	// 학교만 입력했을때
	public List<Student> findAcademyStudentBySchool(Academy academy, String school) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND schoolcate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school);

	}

	// 학년만 입력했을때
	public List<Student> findAcademyStudentByGrade(Academy academy, String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), grade);

	}

	// 이름만 입력했을때
	public List<Student> findAcademyStudentByName(Academy academy, String name) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name);

	}

	// 성별을 입력했을때
	public List<Student> findAcademyStudentByGender(Academy academy, String gendercheck) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND gender = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(),
				gendercheck);

	}

	// 회원이고 이름으로 입력
	public List<Student> findAcademyStudentByEkaCheckANDName(Academy academy, String name, String ekacheck) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND name = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name);
		}

	}

	// 회원이고 학교로 입력
	public List<Student> findAcademyStudentByEkaCheckANDSchool(Academy academy, String school, String ekacheck) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school);
		}

	}

	// 회원에 성별
	public List<Student> findAcademyStudentByEkaCheckANDGender(Academy academy, String gender, String ekacheck) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND gender = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND gender = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender);
		}
	}

	// 회원에 학년
	public List<Student> findAcademyStudentByEkaCheckANDGradecate(Academy academy, String gradecate, String ekacheck) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(),
					gradecate);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(),
					gradecate);
		}
	}

	// 이름 성별
	public List<Student> findAcademyStudentByNameANDGender(Academy academy, String name, String genader) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND gender = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				genader);
	}

	// 이름 학교
	public List<Student> findAcademyStudentByNameANDSchool(Academy academy, String name, String school) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND schoolcate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				school);
	}

	// 이름 학년
	public List<Student> findAcademyStudentByNameANDGrade(Academy academy, String name, String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				grade);
	}

	// 학년 학교
	public List<Student> findAcademyStudentByGradeANDSchool(Academy academy, String grade, String school) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND gradecate = ? AND schoolcate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), grade,
				school);
	}

	// 학년 성별
	public List<Student> findAcademyStudentByGradeANDGender(Academy academy, String grade, String gender) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND gradecate = ? AND gender = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), grade,
				gender);
	}

	// 학교 성별
	public List<Student> findAcademyStudentBySchoolANDGender(Academy academy, String school, String gender) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND schoolcate = ? AND gender = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school,
				gender);
	}

	// 회원 이름 성별
	public List<Student> findAcademyStudentByEkaUserANDNameANDGender(Academy academy, String ekacheck, String name,
			String gender) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND gender = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND name = ? AND gender = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender);
		}
	}

	// 회원 이름 학교
	public List<Student> findAcademyStudentByEkaUserANDNameANDSchool(Academy academy, String ekacheck, String name,
			String school) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					school);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND name = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					school);
		}
	}

	// 회원 이름 학년
	public List<Student> findAcademyStudentByEkaUserANDNameANDGrade(Academy academy, String ekacheck, String name,
			String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND name = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					grade);
		}
	}

	// 회원 성별 학교
	public List<Student> findAcademyStudentByEkaUserANDGenderANDSchool(Academy academy, String ekacheck, String gender,
			String school) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND gender = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					school);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND gender = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					school);
		}
	}

	// 회원 성별 학년
	public List<Student> findAcademyStudentByEkaUserANDGenderANDGrade(Academy academy, String ekacheck, String gender,
			String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND gender = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND gender = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					grade);
		}
	}

	// 회원 학교 학년
	public List<Student> findAcademyStudentByEkaUserANDSchoolANDGrade(Academy academy, String ekacheck, String school,
			String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school,
					grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId ='' AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), school,
					grade);
		}
	}

	// 이름 성별 학교
	public List<Student> findAcademyStudentByNameANDGenderANDSchool(Academy academy, String name, String gender,
			String school) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND gender = ? AND schoolcate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				gender, school);
	}

	// 이름 성별 학년
	public List<Student> findAcademyStudentByNameANDGenderANDgrade(Academy academy, String name, String gender,
			String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND gender = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				gender, grade);
	}

	// 이름 학교 학년
	public List<Student> findAcademyStudentByNameANDSchoolANDgrade(Academy academy, String name, String school,
			String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND schoolcate = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				school, grade);
	}

	// 성별 학교 학년
	public List<Student> findAcademyStudentByGenderANDSchoolANDgrade(Academy academy, String gender, String school,
			String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND gender = ? AND schoolcate = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
				school, grade);
	}

	// 회원 이름 성별 학교
	public List<Student> findAcademyStudentByEkaUserANDNameANDGenderANDSchool(Academy academy, String ekacheck,
			String name, String gender, String school) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND gender = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender, school);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND name = ? AND gender = ? AND schoolcate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender, school);
		}
	}

	// 회원 이름 성별 학년
	public List<Student> findAcademyStudentByEkaUserANDNameANDGenderANDGrade(Academy academy, String ekacheck,
			String name, String gender, String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND gender = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender, grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND name = ? AND gender = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
					gender, grade);
		}
	}

	// 회원 성별 학교 학년
	public List<Student> findAcademyStudentByEkaUserANDGenderANDSchoolANDGrade(Academy academy, String ekacheck,
			String gender, String school, String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND gender = ? AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					school, grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND gender = ? AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), gender,
					school, grade);
		}
	}

	// 이름 성별 학교 학년
	public List<Student> findAcademyStudentByNameANDGenderANDSchoolANDgrade(Academy academy, String name, String gender,
			String school, String grade) {
		String sql = "SELECT * FROM Student WHERE academyId = ? AND name = ? AND gender = ? AND schoolcate = ? AND gradecate = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name,
				gender, school, grade);
	}

	// 회원 이름 성별 학교 학년
	public List<Student> findAcademyStudentByEkaUserANDNameANDGenderANDSchoolANDgrade(Academy academy, String ekacheck,String name, String gender,
			String school, String grade) {
		if (ekacheck.equals("가입")) {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId != '' AND name = ? AND gender = ? AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name , gender,
					school, grade);
		} else {
			String sql = "SELECT * FROM Student WHERE academyId = ? AND ekaUserId = '' AND name = ? AND gender = ? AND schoolcate = ? AND gradecate = ?";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), academy.getAid(), name , gender,
					school, grade);
		}
	}

}
