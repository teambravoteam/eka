
--학교 시험 분류 테이블

-- 아직 구현 안했으니 테이블 만들지 마삼
--(ex. 모의고사/기말고사/중간고사)
CREATE TABLE SchoolTestTypeCategory(
	sttcid		BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	testtype	VARCHAR(20)	UNIQUE KEY,
);

--(ex. 국/수/사/과/영)
CREATE TABLE SchoolTestSubjectCategory(
	stscid		BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	testtpye	VARCHAR(20)	NOT NULL,
	testsubject	VARCHAR(20)	NOT NULL,
	CONSTRAINT SchoolTestSubjectCategory_testtpye_FK 
	FOREIGN KEY(testtpye) REFERENCES SchoolTestTypeCategory(testtpye)	
);