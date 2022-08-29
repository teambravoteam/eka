package com.varxyz.eka.review.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Review {
	private Long rid;
	private Long academyId;
	private Long ekaUserId;
	private int reviewScore;
	private String comment;
	
	public Review() {
		
	}
}
