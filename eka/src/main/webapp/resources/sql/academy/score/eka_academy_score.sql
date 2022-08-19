

-- 학원 시험 점수 테이블
-- 참조 테이블
-- 1.학원 테이블 : eka_academy
-- 2.학원 시험 카테고리 테이블: eka_academy_score_category
-- 3.학생 테이블 : eka_student
CREATE TABLE AcademyScore (
	asid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT			NOT NULL,
	testTypeId			BIGINT			NOT NULL,
	studentId			BIGINT 			NOT NULL,	
	testScore			DOUBLE			NOT NULL,	
	CONSTRAINT AcademyScore_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT AcademyScore_academyId_FK FOREIGN KEY(testTypeId) REFERENCES AcademyTestCategory(atcid),
	CONSTRAINT AcademyScore_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);
DROP TABLE AcademyScore;