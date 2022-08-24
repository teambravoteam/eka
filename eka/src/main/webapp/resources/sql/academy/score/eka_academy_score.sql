--

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
SELECT * FROM AcademyTestCategory;

CREATE TABLE AcademyTestCategory(
	atcid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId 		BIGINT  		NOT NULL,
	lectureName		VARCHAR(20)		NOT NULL,
	testName		VARCHAR(20)		NOT NULL,
	testDate		DATE			NOT NULL,
	CONSTRAINT AcademyTestCategory_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
); 

CREATE TABLE AcademyScore (
	asid 			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	testCategoryId	BIGINT			NOT NULL,
	studentName		VARCHAR(20)		NOT NULL,
	studentId	    BIGINT,
	testScore       DOUBLE
);


DROP TABLE AcademyTestCategory;

SELECT * FROM AcademyScore WHERE academyId = 1 AND lecturename="현대미술의 이해2";
SELECT lid FROM Lecture WHERE academyId = 1 AND name = "현대미술의 이해2";