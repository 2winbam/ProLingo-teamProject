--PROLINGO_SUBJECT					
DROP TABLE	PROLINGO_SUBJECT	;			
CREATE TABLE	PROLINGO_SUBJECT	(			
SUBJECT_ID	NUMBER	PRIMARY KEY		,	--과목 아이디(직접 넣기)
SUBJECT_NAME	VARCHAR2(20)	NOT NULL		);	--과목 이름
					
--USER_SUBJECT					
DROP TABLE	USER_SUBJECT	;			
CREATE TABLE	USER_SUBJECT	(			--유저의 관심 과목
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디
SUBJECT_ID	NUMBER	REFERENCES PROLINGO_SUBJECT(SUBJECT_ID)	ON DELETE CASCADE	,	--과목 아이디
PRIMARY KEY(USER_ID, SUBJECT_ID)				);	--복합키
					
--PROLINGO_LESSON					
DROP TABLE	PROLINGO_LESSON	;			
CREATE TABLE	PROLINGO_LESSON	(			
LESSON_ID	NUMBER	PRIMARY KEY		,	--학습 아이디(직접?)
SUBJECT_ID	NUMBER	REFERENCES PROLINGO_SUBJECT(SUBJECT_ID)	ON DELETE CASCADE	,	--과목 아이디
GRADE	VARCHAR2(20)	CHECK(GRADE IN('INTRODUTION', 'BEGINNER'))	NOT NULL	,	--과정 등급
LESSON_CONTENTS	VARCHAR2(2000)		NOT NULL	);	-- 레슨의 이름


-- PROLINGO_CONTENTS 개념 슬라이드 파트를 위한 테이블
DROP TABLE PROLINGO_CONTENTS; 
CREATE TABLE PROLINGO_CONTENTS(
    CONTENT_ID NUMBER PRIMARY KEY,                              -- 개념 식별 아이디 (seq로 nextval값을 넣을 예정, 슬라이드 정렬을 하는 기준)
    LESSON_ID	NUMBER	REFERENCES PROLINGO_LESSON(LESSON_ID),	-- 학습 아이디(학습페이지 식별을 위해서 사용, 슬라이드를 조회시 기준이 되기도 함)
    LESSON_TITLE VARCHAR2(100),                                 -- 해당 학습의 제목(ex. '시작하기')
    LESSON_SLIDE NUMBER,                                        -- 슬라이드의 번호
    LESSON_SUBTITLE VARCHAR2(200),                              -- 해당 슬라이드의 소제목(ex. 시작하기 - '코드 작성을 배워봅시다.')
    LESSON_CONTENTS	VARCHAR2(2000),                             -- 해당 슬라이드의 내용
    LESSON_PICTURE VARCHAR2(500)                                -- 사진 경로
);
-- CONTENT_ID의 생성을 위한 시퀀스
DROP SEQUENCE	PROLINGO_CONTENTS_SEQ;	
CREATE SEQUENCE	PROLINGO_CONTENTS_SEQ;	


--PROLINGO_QUESTION					
DROP TABLE	PROLINGO_QUESTION	;			
CREATE TABLE	PROLINGO_QUESTION	(			
QUESTION_ID	NUMBER	PRIMARY KEY		,	--문제 아이디
LESSON_ID	NUMBER	REFERENCES PROLINGO_LESSON(LESSON_ID)	ON DELETE CASCADE	,	--학습 아이디
QUESTION_CONTENTS	VARCHAR2(2000)		NOT NULL	,	--문제 내용
ANSWER	VARCHAR2(2000)			,	--정답(콘솔 출력 내용 객관식에서는 직접 만들기?)
KEYWORDS	VARCHAR2(1000)			);	--채점 할 때 들어가 있어야 하는 문구(객관식에선 문제로 만드는용도)

ALTER TABLE PROLINGO_QUESTION ADD DEFAULT_CODE VARCHAR2(2000);
ALTER TABLE PROLINGO_QUESTION ADD CONSOLE_RESULT VARCHAR2(1000);
					
--PROLINGO_KEYWORD					
DROP TABLE	PROLINGO_KEYWORD	;			
CREATE TABLE	PROLINGO_KEYWORD	(			--키워드의 정보만 가지고 있고 다른 테이블이랑 관계 없는듯
KEYWORD_ID	NUMBER	PRIMARY KEY		,	--키워드 아이디
KEYWORD_NAME	VARCHAR2(20)		NOT NULL	,	--키워드 이름(FOR, WHILE 등)
KEYWORD_TYPE	VARCHAR2(20)		NOT NULL	);	--키워드 타입(반복문, 제어문 등)
					
--PROLINGO_HISTORY					
DROP TABLE	PROLINGO_HISTORY	;			
CREATE TABLE	PROLINGO_HISTORY	(			
HISTORY_ID	NUMBER	PRIMARY KEY		,	--풀이 내역 아이디
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디
QUESTION_ID	NUMBER	REFERENCES PROLINGO_QUESTION(QUESTION_ID)	ON DELETE CASCADE	,	--문제 아이디
HISTORY_CONTENT	VARCHAR2(2000)		NOT NULL	);	--풀이 내용
				
--PROLINGO_HISTORY_SEQ					
DROP SEQUENCE	PROLINGO_HISTORY_SEQ	;			
CREATE SEQUENCE	PROLINGO_HISTORY_SEQ	;		

COMMIT;

--개념데이터
--1
INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
여러분은 처음에는 어려워 보일 수 있는 많은 새로운 용어들을 보게 될 것이지만, 걱정하지 마세요!
한 개씩 같이 배워보도록 하겠습니다.', '/prolingo/img/contents/0-0.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
System.out.println()의 () 안에 문자를 기록하여 콘솔에서 인쇄할 수 있습니다.', '/prolingo/img/contents/0-1.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
※ 자바는 자바스크립트와 같지 않으니 헷갈리지 마세요.', '/prolingo/img/contents/0-2.png'
);

-- 2
INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
문자열을 큰따옴표 "로 묶어야 합니다. 그렇지 않으면 오류가 발생합니다.', '/prolingo/img/contents/1-0.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
프로그래밍에서는 컴퓨터에 이와 같은 다양한 명령을 내릴 수 있습니다. System.out.println()을 숙지하십시오. 이 과정에서는 System.out.println()을 반복해서 사용합니다.
※ "println"의 l은 L의 소문자입니다.', '/prolingo/img/contents/1-1.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
아래 예제에는 Main 클래스와 Main method가 있습니다. 현재로서는, 당신이 기억해야 할 유일한 것은 당신이 메인 메서드 안에 당신의 코드를 쓸 것이라는 것입니다.',
/prolingo/img/contents/1-2.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
그렇지 않으면 오류가 발생할 수 있으니 조심하세요!', '/prolingo/img/contents/1-3.png'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
코드를 실행할 때 주석은 무시되므로 주석을 사용하여 메모를 남길 수 있습니다.', '/prolingo/img/contents/1-4.png'
);

--3

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
왼쪽 그림에서 보듯이 수학에서처럼 정수를 더하고 뺄 수 있습니다. 정수 앞과 뒤에 공백을 넣을 필요는 없지만 코드를 읽기 쉽게 만듭니다.', '/prolingo/img/contents/2-0.jpg'
);

INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
5 + 2는 7을 출력합니다. 이는 덧셈의 결과입니다. 그러나 "5 + 2"와 같이 큰 따옴표 "를 추가하여 문자열로 만들면 출력은 리터럴 문자열: 5 + 2가 됩니다.',
/prolingo/img/contents/2-1.jpg'
);


--4
INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
* 연산자는 곱셈용이고 / 연산자는 나눗셈용입니다. % 연산자를 사용하여 분할 후 나머지를 계산할 수도 있습니다.', '/prolingo/img/contents/3-0.jpg'
);


--5
INSERT INTO
VALUES
PROLINGO_CONTENTS_SEQ.nextval,
문자열을 결합하는 것을 문자열 연결이라고 합니다. 아래 그림과 같이 "5" + "3"은 두 문자열을 숫자로 추가하는 대신 "53"이 되도록 연결합니다. 항상 정수와 문자열의 차이를 인식하도록 하십시오.', '/prolingo/img/contents/4-0.jpg'
);
commit;