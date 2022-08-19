package com.varxyz.eka.consulting.category.service;

import java.util.List;


import com.varxyz.eka.consulting.category.domain.ConsultCategory;

public interface ConsultingCategoryService {
		//학원관리자는 상담카테고리정보를 등록합니다
		public boolean addCategory(ConsultCategory category);
		
		//학원관리자는 상담카테고리정보를 수정합니다.
		public boolean updateCategory(ConsultCategory category);
		
		//학원관리자는 상담카테고리정보를 삭제합니다
		public boolean deleteCategory(ConsultCategory category);
		
		/*
		 * 학원 관리자는 다양한 점수카테고리정보를 조회할수 있습니다.
		 * */				
		//학원관리자는 학원의 모든   상담카테고리정보를 알 수 있다.
		public List<ConsultCategory> findAllConsultCategory();
	
}
