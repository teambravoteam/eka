package com.varxyz.eka.payment.domain;

import java.sql.Date;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.student.domain.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Payment {
	private Academy academy;
	private String paymentDesc;
	private double price;
	private boolean accessType;
	private Date regDate;
	private Student student;
	
	public Payment() {
		
	}
	

}
