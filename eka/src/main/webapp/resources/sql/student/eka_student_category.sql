--  
-- 학생 분류 테이블
CREATE TABLE SchoolCategory(
	smid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL UNIQUE
);

SELECT * FROM SchoolCategory;
DROP TABLE SchoolCategory;

CREATE TABLE GradeCategory(
	ssid			BIGINT 		PRIMARY KEY AUTO_INCREMENT,
	schoolcate		VARCHAR(20)	NOT NULL,
	gradecate		VARCHAR(20) NOT NULL,
	CONSTRAINT GradeCategory_schoolcate_FK FOREIGN KEY(schoolcate) REFERENCES SchoolCategory(schoolcate)
);

SELECT * FROM GradeCategory;

DROP TABLE GradeCategory;

--test query
INSERT INTO SchoolCategory(schoolcate) VALUES("초등학교");
INSERT INTO SchoolCategory(schoolcate) VALUES("중학교");
INSERT INTO SchoolCategory(schoolcate) VALUES("고등학교");

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