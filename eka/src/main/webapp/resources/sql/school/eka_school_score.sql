-- 학교 시험 점수 테이블
-- 참조 테이블 
-- 1.학원테이블: eka_academy
-- 2.학생테이블: eka_student
-- 3.학교시험분류테이블: eka_school_score_category
CREATE TABLE SchoolScore(
	ssid		  BIGINT		PRIMARY KEY AUTO_INCREMENT,
	academyId	  BIGINT		NOT NULL,
	testtypeId	  BIGINT		NOT NULL,
	studentId	  BIGINT		NOT NULL,
	testScore	  DOUBLE		NOT NULL,
	CONSTRAINT SchoolScore_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT SchoolScore_testtypeId_FK FOREIGN KEY(testTypeId) REFERENCES SchoolTestSubjectCategory(stscid),
	CONSTRAINT SchoolScore_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);