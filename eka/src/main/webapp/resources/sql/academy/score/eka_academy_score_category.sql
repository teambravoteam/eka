

-- 학원 시험 분류 테이블 
-- 참조 테이블
-- 1. 강좌테이블 : eka_academy_lecture 
-- CREATE TABLE AcademyTestCategory(
--	atcid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
--	lecturename		VARCHAR(20)		NOT NULL,
--	testname		VARCHAR(20)		NOT NULL,
--	testdate		DATE			NOT NULL,
--	CONSTRAINT AcademyTest_CategoryacademyId_FK 
--	FOREIGN KEY(lecturename) REFERENCES Lecture(name)
--);  

DROP TABLE AcademyTestCategory;

SELECT * FROM AcademyTestCategory;