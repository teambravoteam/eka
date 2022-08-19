-- 학원 강사
-- 참조테이블
-- 1. 학원테이블: eka_academy
CREATE TABLE Teacher(
	tid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT		 	NOT NULL,
	name			VARCHAR(20)		NOT NULL,	
	gender			VARCHAR(5)		NOT NULL,
	ssn				DATE			NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	subject			VARCHAR(20) 	NOT NULL,
	education		VARCHAR(50), 	-- 최종학력
	career			VARCHAR(100), 	-- 경력사항 
	image			VARCHAR(20),
	foreigner		VARCHAR(5)		NOT NULL DEFAULT false,
	CONSTRAINT Teacher_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

DROP TABLE Teacher;
SELECT * FROM Teacher;

--test
INSERT INTO Teacher(academyId, name, gender, ssn, phone, subject, education, career, image, foreigner)
VALUES(1, '짱구', '남', '2022-11-11', '010-1111-1111', '수학', '코리아It아카데미', '코리아It아카데미강사', 'ㄴㅇㄹ', 1);
SELECT * FROM Teacher WHERE academyId=1;

SELECT * FROM Teacher WHERE academyId=1 AND subject='수학';
SELECT * FROM Teacher WHERE academyId=1 AND name LIKE '%짱구%';