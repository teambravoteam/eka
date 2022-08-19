package com.varxyz.eka.consulting.category.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ConsultCategory {
	private long cid;
	private String category;
	
	public ConsultCategory() {
		
	}

}
  