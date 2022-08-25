package com.varxyz.eka.report.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ReportAttendanceCommand {
	private String lectureDate;
	private String checking;
	private String lectureName; //name
	
	public ReportAttendanceCommand() {
		
	}
}
