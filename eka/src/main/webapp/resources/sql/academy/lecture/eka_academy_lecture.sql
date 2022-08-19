-- 학원 강좌
-- 강좌테이블을 위해 참조테이블
-- 1. 학원테이블 : eka_academy 

CREATE TABLE Lecture(
	lid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT		 	NOT NULL,
	name				VARCHAR(30) 	UNIQUE KEY,
	schoolcate			VARCHAR(20)		NOT NULL, -- 초,중,고
	gradecate			VARCHAR(20) 	NOT NULL, -- 학년
	subject				VARCHAR(20) 	NOT NULL, -- 과목
	startLectureTime	TIME 			NOT NULL, -- 00:00
	finishLectureTime	TIME 			NOT NULL, -- 00:00
	startLectureDate	DATE		 	NOT NULL, -- 0000/00/00
	finishLectureDate	DATE		 	NOT NULL, -- 0000/00/00
	lectureDay			VARCHAR(15)		NOT NULL, -- 0,0,0,0,0,0,0
	price				BIGINT			NOT NULL,
	teacherNames		VARCHAR(20),
	lectureCapacity		BIGINT			DEFAULT 0,
	CONSTRAINT Lecture_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);
DROP TABLE Lecture;
SELECT * FROM Lecture;

--test
INSERT INTO Lecture(academyId, name, schoolcate, gradecate, subject, startLectureTime, finishLectureTime, 
startLectureDate, finishLectureDate, lectureDay, price, teacherNames, lectureCapacity)
VALUES(1, "현대미술의 이해2", "초등학생", "1학년", "국어", "11:00", "12:00", 
"2022-01-20", "2022-01-21", "월,화", 20000, "철수", 10);

UPDATE Lecture SET name="현대미술의 이해", schoolcate="고등학교",gradecate="3학년", subject="국어" ,
startLectureTime="11:00:00", finishLectureTime="12:00:00", startLectureDate="2022-12-11",
finishLectureDate="2022-12-12", lectureDay="월,화,수", price="2", teacherNames="짱구", 
lectureCapacity="33" WHERE lid="1";