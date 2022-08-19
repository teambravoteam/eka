-- 학원 분류 카테고리(ex. 초/중/고 )
CREATE TABLE AgeCategory(
	acid		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	agecate		VARCHAR(10) 	UNIQUE KEY
);

DROP TABLE AgeCategory;
SELECT * FROM AgeCategory;

--ex)교과 / 예능 / 외국어 / 기타
CREATE TABLE MainSubjectCategory(
	mcid		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	maincate	VARCHAR(10) 	NOT NULL UNIQUE,
	agecate 	VARCHAR(10) 	NOT NULL,
	CONSTRAINT MainSubjectCategory_agecate_FK FOREIGN KEY(agecate) REFERENCES AgeCategory(agecate)
); 

DROP TABLE MAINSUBJECTCATEGORY;
SELECT * FROM MainSubjectCategory;

--ex)국어 / 수학 / 영어 / 종합
CREATE TABLE SubjectCategory(
	scid		BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	maincate	VARCHAR(10)		NOT NULL,
	subjectcate	VARCHAR(10) 	NOT NULL,	
	agecate 	VARCHAR(10) 	NOT NULL,
	CONSTRAINT SubjectCategory_mainCateId_FK FOREIGN KEY(maincate) REFERENCES MainSubjectCategory(maincate)
);

DROP TABLE SubjectCategory;
SELECT * FROM SubjectCategory;


--송)test query
INSERT INTO AgeCategory(agecate) VALUES('초등학생');
INSERT INTO MainSubjectCategory(maincate, agecate) VALUES('교과', '초등학생');
INSERT INTO SubjectCategory(maincate, subjectcate, agecate) VALUES('교과', '종합', '초등학생');
INSERT INTO SubjectCategory(maincate, subjectcate, agecate) VALUES('교과', '국어', '초등학생');
INSERT INTO SubjectCategory(maincate, subjectcate, agecate) VALUES('교과', '수학', '초등학생');