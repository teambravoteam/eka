package com.varxyz.eka.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.eka.auth.domain.AcademyManager;
import com.varxyz.eka.auth.domain.EkaUser;
import com.varxyz.eka.auth.repository.AuthDao;


@Component
public class AuthService implements AuthServiceInterface {

	
	@Autowired
	private AuthDao authDao;
	
	
	@Override
	public void addManager(AcademyManager academyManager) { // 원장 회원가입
		authDao.addManager(academyManager);
	}


	@Override
	public void addEkaUser(EkaUser ekaUser) { // 유저 회원가입
		authDao.addEkaUser(ekaUser);
	}

	@Override
	public AcademyManager loginManager(String userId, String userPw) { // 원장 로그인
		return authDao.loginManager(userId, userPw);
	}


	@Override
	public EkaUser loginEkaUsers(String userId, String userPw) { // 유저 로그인
		return authDao.loginEkaUser(userId, userPw);
	}


	@Override
	public boolean managercheckId(String userId) { // 매니저 아이디 중복체크

		if (authDao.managercheckId(userId) != null) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public boolean usercheckId(String userId) { // 유저 아이디 중복체크
		
		if (authDao.usercheckId(userId) != null) {
			return true;
		} else {
			return false;
		}
	}

}
