

-- 학원 시험 분류 테이블 
-- 참조 테이블
-- 1. 강좌테이블 : eka_academy_lecture 
CREATE TABLE AcademyTestCategory(
	atcid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId 		BIGINT  		NOT NULL,
	lectureName		VARCHAR(20)		NOT NULL,
	testName		VARCHAR(20)		NOT NULL,
	testDate		DATE			NOT NULL,
	CONSTRAINT AcademyTestCategory_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);  

DROP TABLE AcademyTestCategory;

SELECT * FROM AcademyTestCategory;