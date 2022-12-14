package com.varxyz.eka.auth.service;

import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;

public interface AuthServiceInterface {
	
	public void addManager(AcademyManager academyManager); //원장가입
	public void addEkaUser(EkaUser ekaUser); // 사이트유저 가입
	public boolean managercheckId(String userId); //매니져 아이디 중복체크
	public boolean usercheckId(String userId); // 유저 아이디 중복체크
	public AcademyManager loginManager(String userId, String userPw); // 원장로그인
	public EkaUser loginEkaUsers(String userId, String userPw); // 유저로그인
	public boolean updateAcademId(long academyId, AcademyManager manager); // 아카데미 아이디 업데이트
	public void updateAcademyManager(String userPw, String userName, String userSsn, String userPhone, String userAid); // 원장 정보 수정
	public void updateEkaUser(String userPw, String userName, String userSsn, String userPhone, String userEmail, String userEid); // EkaUser 정보 수정
	public EkaUser findEkaUserByekaUserId(Long eid); // eid로 유저 조회
}
