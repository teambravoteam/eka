package com.varxyz.eka.academy.lecture.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LectureEditCommand {
	private long lid;
	private String name;
	private String schoolcate;
	private String gradecate;
	private String subject;
	private String teacher;
	private String startLectureTime;
	private String finishLectureTime;
	private String startLectureDate;
	private String finishLectureDate;
	private String lectureDay;
	private long lectureCapacity;
	private long price;
}
