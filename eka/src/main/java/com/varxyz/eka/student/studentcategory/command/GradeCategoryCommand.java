package com.varxyz.eka.student.studentcategory.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GradeCategoryCommand {
	private long ssid;
	private String schoolcate;
	private String gradecate;
	
	public GradeCategoryCommand() {
		
	}
}
