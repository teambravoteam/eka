-- 학원생
-- 참조 테이블
-- 1.학생 분류 테이블 : eka_student_category
-- 2.학원 테이블 : eka_academy
CREATE TABLE Student(
	sid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT,			
	schoolcate			VARCHAR(20)		NOT NULL,
	gradecate			VARCHAR(20)		NOT NULL,
	name				VARCHAR(20)		NOT NULL,
	gender				VARCHAR(5)		NOT NULL,
	ssn					DATE			NOT NULL,
	phone				VARCHAR(13) 	NOT NULL,
	ekaUserId			VARCHAR(20),
	parentName			VARCHAR(20),
	parentType			VARCHAR(5),
	parentPhone			VARCHAR(13),
	regDate				TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Student_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

SELECT * FROM Student;

SELECT * FROM Student WHERE academyId = "6943" AND ekaUserId = "";
SELECT * FROM Student WHERE academyId = "6943" AND gradecate = "1학년" AND schoolcate = "초등학교";




DROP TABLE Student;  