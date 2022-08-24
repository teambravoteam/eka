package com.varxyz.eka.attendence.domain;

import com.varxyz.eka.academy.lecture.domain.Lecture;
import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AttendanceStudent {
	private Student student;	
	private String attendanceType;
	

	public AttendanceStudent() {
		
	}
}
