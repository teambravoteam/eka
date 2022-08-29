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

	@Override
	public boolean updateAcademId(long academyId, AcademyManager manager) { // 아카데미 아이디 업데이트
		try {
			authDao.updateAcademId(academyId, manager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 원장 정보 수정
	@Override
	public void updateAcademyManager(String userPw, String userName, String userSsn, String userPhone, String userAid) {
		authDao.updateAcademyManager(userPw, userName, userSsn, userPhone, userAid);
	}

	// ekaUser 정보 수정
	@Override
	public void updateEkaUser(String userPw, String userName, String userSsn, String userPhone, String userEmail,
			String userEid) {
		authDao.updateEkaUser(userPw, userName, userSsn, userPhone, userEmail, userEid);
	}
}
