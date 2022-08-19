package com.varxyz.eka.academy.lecture.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LectureCommand {
	private String subject;
	private String teacher;
	private String startLectureDate;
	private String finishLectureDate;
	private String startLectureTime;
	private String finishLectureTime;
	private String lectureDay;
	private long lectureCapacity;
//	private String type1;
	private long price;
//	private String type2;
	private String name;

}
