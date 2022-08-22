


-- 학원 출석
-- 참조테이블
-- 1. 학원테이블: eka_academy
-- 2. 강좌테이블: eka_academy_lecture
-- 3. 학생테이블: eka_student
CREATE TABLE Attendance (
	aid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	studentId	BIGINT		 	NOT NULL,
	checking	CHAR(5)			NOT NULL, -- 출석A, 결석B, 조퇴C, 지각D
	lectureId	BIGINT		 	NOT NULL,
	academyId	BIGINT		 	NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Attendance_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid),
	CONSTRAINT Attendance_lectureId_FK FOREIGN KEY(lectureId) REFERENCES Lecture(lid),
	CONSTRAINT Attendance_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);  
DROP TABLE Attendance;