-- 결제
-- 참고 테이블
-- 1. 학원테이블: eka_academy
-- 2. 학생 테이블: eka_student
CREATE TABLE Payment (
	pid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT 			NOT NULL,
	studentId		BIGINT			NOT NULL,
	paymentDesc		VARCHAR(30)		NOT NULL,
	price			INT				NOT NULL,
	accessType		BOOLEAN			NOT NULL DEFAULT false,
	regDate			TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Payment_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT Payment_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);
DROP TABLE Payment;  