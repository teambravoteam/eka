package com.varxyz.eka.academy.lecture.domain;

import java.util.*;

import com.varxyz.eka.academy.academy.domain.Academy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Lecture {
	private long lid;
	private String name;
	private String schoolcate;
	private String gradecate;	
	private String subject;
	private String startLectureTime;
	private String finishLectureTime;
	private String startLectureDate;
	private String finishLectureDate;
	private String lectureDay;
	private long price;
	private String teacher;
	private long lectureCapacity;
	private Academy academy;
	
	public Lecture() {
		
	}
}
