-- 학원리뷰
-- 참고테이블
-- 1. ekauser테이블 : eka_ekauser_ekauser
-- 2. 학원테이블 : eka_academy
CREATE TABLE Review (
	rid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT 			NOT NULL,
	ekaUserId		BIGINT 			NOT NULL,
	reviewScore		INT				NOT NULL DEFAULT 0,
	comment			VARCHAR(300)	NOT NULL,
	CONSTRAINT Review_ekaUserId_FK FOREIGN KEY(ekaUserId) REFERENCES EkaUser(eid)
	CONSTRAINT Review_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);
DROP TABLE Review;