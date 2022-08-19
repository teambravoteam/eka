-- 원생 학부모
-- 참조 테이블
-- 1. 학생 테이블: eka_student
CREATE TABLE Parent(
	pid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	gender			VARCHAR(5)		NOT NULL,
	name			VARCHAR(20)		NOT NULL,
	ssn				VARCHAR(14) 	NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	studentId		BIGINT 			NOT NULL,
	CONSTRAINT Parent_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);
DROP TABLE Parent;  