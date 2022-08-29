
-- 1. 학원 테이블 --
CREATE TABLE Academy (
	aid						BIGINT 			PRIMARY KEY AUTO_INCREMENT,		
	name					VARCHAR(50) 	NOT NULL,
	openingday				DATE			NOT NULL, -- 개업일
	address					VARCHAR(100)	NOT NULL, -- 주소
	detailaddress			VARCHAR(100) 	NOT NULL, -- 상세주소
	lat						VARCHAR(20) 	NOT NULL, -- 위도
	lon						VARCHAR(20) 	NOT NULL, -- 경도
	personnel				BIGINT			NOT NULL, -- 인원
	field1					VARCHAR(100) 	NOT NULL, -- 필드1
	field2					VARCHAR(100) 	NOT NULL, -- 필드2
	field3					VARCHAR(100) 	NOT NULL, -- 필드3
	field4					VARCHAR(100) 	NOT NULL, -- 필드4
	priceList				VARCHAR(1000)	NOT NULL, -- 가격표
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

-- 2. 학생 생성을 위한 학생 카테고리
CREATE TABLE SchoolCategory(
	smid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL UNIQUE
);


CREATE TABLE GradeCategory(
	ssid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL,
	gradecate		VARCHAR(20) NOT NULL,
	CONSTRAINT GradeCategory_schoolcate_FK FOREIGN KEY(schoolcate) REFERENCES SchoolCategory(schoolcate)
);

-- 3. 학생 테이블

CREATE TABLE Student(
	sid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT,
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

-- 4. EkaUser 중, 학원원장
CREATE TABLE AcademyManager (
	aid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT			NOT	NULL DEFAULT 0,
	userId			VARCHAR(20) 	NOT NULL,
	userPw			VARCHAR(20) 	NOT NULL,
	name			VARCHAR(20) 	NOT NULL,
	phone			VARCHAR(13) 	NOT NULL,
	ssn				VARCHAR(14) 	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

-- 5. EkaUser 중, 학생
CREATE TABLE EkaUser(
	eid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	userId			VARCHAR(20) 	NOT NULL,
	userPw			VARCHAR(20) 	NOT NULL,
	name			VARCHAR(20) 	NOT NULL,
	gender			VARCHAR(20) 	NOT NULL,
	ssn				VARCHAR(20) 	NOT NULL,
	phone			VARCHAR(20) 	NOT NULL,
	email			VARCHAR(20) 	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
);

--- 6. 리뷰 테이블
CREATE TABLE Review (
	rid				BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId		BIGINT 			NOT NULL,
	ekaUserId		BIGINT 			NOT NULL,
	reviewScore		INT				NOT NULL DEFAULT 0,
	comment			VARCHAR(300)	NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Review_ekaUserId_FK FOREIGN KEY(ekaUserId) REFERENCES EkaUser(eid)
	CONSTRAINT Review_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

-- 7. 강좌 데이블
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

-- 8. 강좌 과목 카테고리
CREATE TABLE SubjectCategory(
	scid 			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	subjectcate		VARCHAR(10) 	NOT NULL
);

-- 9. 강좌를 수강중인 학생 테이블
CREATE TABLE LectureStudent(
	lsid 		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	academyId	BIGINT		NOT NULL,
	lectureId	BIGINT		NOT NULL,
	studentId	BIGINT,
	CONSTRAINT LectureStudent_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid),
	CONSTRAINT LectureStudent_lectureId_FK FOREIGN KEY(lectureId) REFERENCES Lecture(lid),
	CONSTRAINT LectureStudent_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid)
);

-- 10. 강사 테이블
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


-- 11. 상담 카테고리 테이블
CREATE TABLE ConsultingCategory(
	cid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	category	VARCHAR(20)		NOT NULL
);

-- 12. 상담 테이블
CREATE TABLE Consulting(
	cid					BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId			BIGINT		 	NOT NULL,
	name				VARCHAR(20)		NOT NULL,
	phone				VARCHAR(13) 	NOT NULL,
	consultCategory		VARCHAR(20)		NOT NULL,
	consultDetail		VARCHAR(100)	NOT NULL,
	consultContent		VARCHAR(300),
	applyDate			DATE 			NOT NULL,
	registDate			DATE,
	consultType			VARCHAR(2)		NOT NULL,
	CONSTRAINT Consulting_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);

-- 13. 출석 테이블
CREATE TABLE Attendance (
	aid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	studentId	BIGINT		 	NOT NULL,
	checking	CHAR(5)			NOT NULL, -- 출석A, 결석B, 조퇴C, 지각D
	lectureId	BIGINT		 	NOT NULL,
	academyId	BIGINT		 	NOT NULL,
	lectureDate	DATE,
	CONSTRAINT Attendance_studentId_FK FOREIGN KEY(studentId) REFERENCES Student(sid),
	CONSTRAINT Attendance_lectureId_FK FOREIGN KEY(lectureId) REFERENCES Lecture(lid),
	CONSTRAINT Attendance_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);  

-- 14. 학원 시험 카테고리 테이블
CREATE TABLE AcademyTestCategory(
	atcid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	academyId 		BIGINT  		NOT NULL,
	lectureName		VARCHAR(20)		NOT NULL,
	testName		VARCHAR(20)		NOT NULL,
	testDate		DATE			NOT NULL,
	CONSTRAINT AcademyTestCategory_academyId_FK FOREIGN KEY(academyId) REFERENCES Academy(aid)
);  

-- 15. 성적 테이블
CREATE TABLE AcademyScore (
	asid 			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	testCategoryId	BIGINT			NOT NULL,
	studentName		VARCHAR(20)		NOT NULL,
	studentId	    BIGINT,
	testScore       DOUBLE
);