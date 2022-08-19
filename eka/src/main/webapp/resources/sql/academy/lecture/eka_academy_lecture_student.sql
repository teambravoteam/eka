--강좌별 수강생 관리
CREATE TABLE LectureStudent(
	lsid 		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	academyId	BIGINT		NOT NULL,
	lectureId	BIGINT		NOT NULL,
	studentId	BIGINT,
	CONSTRAINT LectureStudent_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT LectureStudent_lectureId_FK FOREIGN KEY(lectureId) REFERENCES Lecture(lid),
	CONSTRAINT LectureStudent_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);