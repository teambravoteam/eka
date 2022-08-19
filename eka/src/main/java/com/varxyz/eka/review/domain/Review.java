package com.varxyz.eka.review.domain;

import com.varxyz.eka.academy.academy.domain.Academy;
import com.varxyz.eka.auth.domain.EkaUser;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Review {
	private Academy academy;
	private EkaUser eakUser;
	private float reviewScore;
	private String comment;
	
	public Review() {
		
	}
}
