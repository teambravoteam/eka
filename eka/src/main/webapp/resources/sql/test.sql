CREATE TABLE AcademyManager (
	aid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(20) 	NOT NULL,
	userPw			VARCHAR(20) 	NOT NULL,
	name			VARCHAR(20) 	NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	ssn				VARCHAR(14) 	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM AcademyManager;
INSERT INTO AcademyManager(userId, userPw, name, phone, ssn)
VALUES("am1111", "pw1111", "김원장", "010-1111-1111", "1980-11-11");

CREATE TABLE Academy (
	aid						BIGINT 			PRIMARY KEY AUTO_INCREMENT,		
	name					VARCHAR(50) 	NOT NULL,
	openingday				DATE			NOT NULL, -- 개업일
	address					VARCHAR(100)	NOT NULL, -- 주소
	detailaddress			VARCHAR(100) 	NOT NULL, -- 상세주소
	lat						VARCHAR(20) 	NOT NULL,
	lon						VARCHAR(20) 	NOT NULL,
	personnel				BIGINT			NOT NULL, 
	field1					VARCHAR(100) 	NOT NULL,
	field2					VARCHAR(100) 	NOT NULL,
	field3					VARCHAR(100) 	NOT NULL,
	field4					VARCHAR(100) 	NOT NULL,
	priceList				VARCHAR(1000)	NOT NULL,
	phone					VARCHAR(20),			  -- 전화번호
	introduction			VARCHAR(300), 			  -- 소개글
	academyservice			VARCHAR(150), 			  -- 학원제공서비스
	runday					VARCHAR(50), 			  -- 운영요일 (이슈 하나 여러개 복수 가능)
	startruntime			TIME, 					  -- 시작운영시간 (00:00)
	endruntime				TIME,					  -- 종료운영시간 (00:00)
	consultableday			VARCHAR(50), 			  -- 상담가능요일 (이슈 둘 여러개 복수 가능)
	startconsultabletime	TIME, 					  -- 시작상담가능시간 (00:00)
	endconsultabletime		TIME, 					  -- 종료상담가능시간 (00:00)
	signedacademy			VARCHAR(50)				  -- '리스트는 다 나오는데' or '신청된 학원만 디테일한 정보가 뜨게 이걸로 구분'
);

INSERT INTO Academy(name, openingday, address, detailaddress, lat, lon, personnel,
field1, field2, field3, field4, priceList)
VALUES("에카학원", "2020-01-03", "대구광역시 중구", "코리아IT아카데미", "2222", "3333", 3000,
"분야1", "분야2", "분야3", "분야4", "수강료리스트");

-- 학생분류
CREATE TABLE SchoolCategory(
	smid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL UNIQUE
);
INSERT INTO SchoolCategory(schoolcate) VALUES("초등학교");
INSERT INTO SchoolCategory(schoolcate) VALUES("중학교");
INSERT INTO SchoolCategory(schoolcate) VALUES("고등학교");

CREATE TABLE GradeCategory(
	ssid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL,
	gradecate		VARCHAR(20) NOT NULL,
	CONSTRAINT GradeCategory_schoolcate_FK FOREIGN KEY(schoolcate) REFERENCES SchoolCategory(schoolcate)
);

INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "1학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "2학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "3학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "4학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "5학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("초등학교", "6학년");

INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("중학교", "1학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("중학교", "2학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("중학교", "3학년");

INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("고등학교", "1학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("고등학교", "2학년");
INSERT INTO GradeCategory(schoolcate, gradecate) VALUES("고등학교", "3학년");

-- 학생
CREATE TABLE Student(
	sid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT			NOT NULL,
	schoolcate			VARCHAR(20)		NOT NULL,
	gradecate			VARCHAR(20)		NOT NULL,
	name				VARCHAR(20)		NOT NULL,
	gender				VARCHAR(5)		NOT NULL,
	ssn					DATE			NOT NULL,
	phone				VARCHAR(13) 	NOT NULL,
	ekaUserId			VARCHAR(20),
	parentName			VARCHAR(20),
	parentType			VARCHAR(5),
	parentPhone			VARCHAR(13),
	regDate				TIMESTAMP		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Student_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

SELECT * FROM Student;
-- 학원 강좌
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

INSERT INTO Lecture(academyId, name, schoolcate, gradecate, subject, startLectureTime, finishLectureTime, 
startLectureDate, finishLectureDate, lectureDay, price, teacherNames, lectureCapacity)
VALUES(1, "현대미술의 이해2", "초등학생", "1학년", "국어", "11:00", "12:00", 
"2022-01-20", "2022-01-21", "월,화", 20000, "철수", 10);

-- 수강생관리
CREATE TABLE LectureStudent(
	lsid 		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	academyId	BIGINT		NOT NULL,
	lectureId	BIGINT		NOT NULL,
	studentId	BIGINT,
	CONSTRAINT LectureStudent_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT LectureStudent_lectureId_FK FOREIGN KEY(lectureId) REFERENCES Lecture(lid),
	CONSTRAINT LectureStudent_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);

CREATE TABLE Teacher(
	tid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT		 	NOT NULL,
	name			VARCHAR(20)		NOT NULL,	
	gender			VARCHAR(5)		NOT NULL,
	ssn				DATE			NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	subject			VARCHAR(20) 	NOT NULL,
	education		VARCHAR(50), 	-- 최종학력
	career			VARCHAR(100), 	-- 경력사항 
	image			VARCHAR(20),
	foreigner		VARCHAR(5)		NOT NULL DEFAULT false,
	CONSTRAINT Teacher_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

INSERT INTO Teacher(academyId, name, gender, ssn, phone, subject, education, career, image, foreigner)
VALUES(1, '짱구', '남', '2022-11-11', '010-1111-1111', '수학', '코리아It아카데미', '코리아It아카데미강사', 'ㄴㅇㄹ', 1);
SELECT * FROM Teacher WHERE academyId=1;

--과목
CREATE TABLE SubjectCategory(
	scid 			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	subjectcate		VARCHAR(10) 	NOT NULL
);

SELECT * FROM SubjectCategory;

INSERT INTO SubjectCategory(subjectcate) VALUES("국어");
INSERT INTO SubjectCategory(subjectcate) VALUES("수학");
INSERT INTO SubjectCategory(subjectcate) VALUES("사회");
INSERT INTO SubjectCategory(subjectcate) VALUES("과학");
INSERT INTO SubjectCategory(subjectcate) VALUES("영어");