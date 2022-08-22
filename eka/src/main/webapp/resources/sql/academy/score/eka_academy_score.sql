

-- 학원 시험 점수 테이블
-- 참조 테이블
-- 1.학원 테이블 : eka_academy
-- 2.학원 시험 카테고리 테이블: eka_academy_score_category
-- 3.학생 테이블 : eka_student
--CREATE TABLE AcademyScore (
--	asid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
--	academyId			BIGINT			NOT NULL,
--	testTypeId			BIGINT			NOT NULL,
--	studentId			BIGINT 			NOT NULL,	
--	testScore			DOUBLE			NOT NULL,	
--	CONSTRAINT AcademyScore_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
--	CONSTRAINT AcademyScore_testTypeId_FK FOREIGN KEY(testTypeId) REFERENCES AcademyTestCategory(atcid),
--	CONSTRAINT AcademyScore_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);
DROP TABLE AcademyScore;
DROP TABLE AcademyTestCategory;

SELECT * FROM AcademyScore;

CREATE TABLE AcademyScore (
	asid 			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	academyId 		BIGINT  		NOT NULL,
	lecturename 	VARCHAR(20)		NOT NULL,
	testname		VARCHAR(20)		NOT NULL,
	testdate		DATE			NOT NULL,
	studentId	    BIGINT,
	testScore       DOUBLE,
	CONSTRAINT AcademyScore_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);


--CREATE TABLE AcademyTestCategory(
--	atcid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
--	lecturename		VARCHAR(20)		NOT NULL,
--	testname		VARCHAR(20)		NOT NULL,
--	testdate		DATE			NOT NULL,
--	CONSTRAINT AcademyTest_CategoryacademyId_FK 
--	FOREIGN KEY(lecturename) REFERENCES Lecture(name)
--); 

SELECT * FROM AcademyScore WHERE academyId = 1 AND lecturename="현대미술의 이해2";
SELECT lid FROM Lecture WHERE academyId = 1 AND name = "현대미술의 이해2";