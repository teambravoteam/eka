--

-- 학원 시험 점수 테이블
-- 참조 테이블
-- 1.학원 테이블 : eka_academy
-- 2.학원 시험 카테고리 테이블: eka_academy_score_category
-- 3.학생 테이블 : eka_student

DROP TABLE AcademyScore;

SELECT * FROM AcademyScore;


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


SELECT * FROM AcademyTestCategory a JOIN AcademyScore b ON a.atcid = b.testCategoryId
WHERE studentId=1 AND lectureName="국어내신";









