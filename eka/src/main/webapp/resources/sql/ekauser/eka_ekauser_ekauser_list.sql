-- 학생유저 별 학원리스트
-- 참조 테이블
-- 1. ekauser 테이블 : eka_ekauser_ekauser
-- 2. 학원 테이블:  eka_academy


CREATE TABLE EkaUserAcademy(
	euaid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	ekaUserId		BIGINT			NOT NULL,
	academyId		BIGINT			NOT NULL,
	CONSTRAINT EkaUserAcademy_ekaUserId_FK FOREIGN KEY(ekaUserId) REFERENCES EkaUser(eid),
	CONSTRAINT EkaUserAcademy_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);
DROP TABLE EKAUSERACADEMY;

-- 학생용 학원 찜 목록
CREATE TABLE WishAcademy(
	wid				BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	ekaUserId		BIGINT			NOT NULL,
	academyId		BIGINT			NOT NULL,
	CONSTRAINT WishAcademy_ekaUserId_FK FOREIGN KEY(ekaUserId) REFERENCES EkaUser(eid),
	CONSTRAINT WishAcademy_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)	
);
DROP TABLE WISHACADEMY;  