--PROLINGO_BOARD								
DROP TABLE	PROLINGO_BOARD	;						
CREATE TABLE	PROLINGO_BOARD	(						
BOARD_ID	NUMBER	PRIMARY KEY		,	--게시글 번호		
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--멤버 아이디			
TITLE	VARCHAR2(100)		NOT NULL	,	--글 제목			
BOARD_CONTENT	VARCHAR2(2000)		NOT NULL	,	--글 내용			
WRITINGDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--작성 날짜			
EDITDATE	DATE	DEFAULT SYSDATE	NOT NULL	,	--수정 날짜			
HITS	NUMBER	DEFAULT '0'	NOT NULL	,	--조회수			
LIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--추천			
DISLIKES	NUMBER	DEFAULT '0'	NOT NULL	,	--비추천			
ORIGINALFILE	VARCHAR2(200)			,	--원본 파일 이름			
SAVEDFILE	VARCHAR2(200)			);	--서버에 저장된 파일 이름
							
--PROLINGO_BOARD_SEQ								
DROP SEQUENCE	PROLINGO_BOARD_SEQ	;						
CREATE SEQUENCE	PROLINGO_BOARD_SEQ	;						
								
--PROLINGO_REPLY								
DROP TABLE	PROLINGO_REPLY	;						
CREATE TABLE	PROLINGO_REPLY	(						
REPLY_ID 	NUMBER	PRIMARY KEY		,	--댓글 아이디			
REPLY_CONTENT	VARCHAR2(600)		NOT NULL	,	--댓글 내용			
BOARD_ID	NUMBER	REFERENCES PROLINGO_BOARD(BOARD_ID)	ON DELETE CASCADE	,	--댓글이 작성된 게시글 아이디			
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--댓글을 작성한 유저 아이디			
TARGET_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--대댓 대상			
WRITINGDATE	DATE	DEFAULT SYSDATE	NOT NULL	);	--댓글 작성 날짜			
								
--PROLINGO_REPLY_SEQ								
DROP SEQUENCE	PROLINGO_REPLY_SEQ	;						
CREATE SEQUENCE	PROLINGO_REPLY_SEQ	;

--PROLINGO_게시판 더미 데이터
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (1, 5 'JAVA 질문이 있습니다.', 'Java란 무엇인가요?');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (1, '자바는 썬 마이크로시스템즈의 제임스 고슬링과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어입니다. :)', 1, 22);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (2, 23, 'JAVA로 소문자 대문자는 어떻게 변경하나요?', '방법이 어떻게 되나요?');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (2, 'toUpperCase(): 소문자 -> 대문자, toLowerCase(): 대문자 -> 소문자', 2, 24);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (3, 23, 'JAVA 아스키코드 질문이요', 'A랑 a 10진수가 어떻게 되나요?');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (3, 'A는 65고 a는 97입니다.', 3, 24);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (4, 25, 'JAVA 별로 삼각형 찍기 하려는데요',									
'for(int i=1;i<5;i++){									
for(int j=0;j<i;j++){									
System.out.print(*);									
}									
System.out.println("");									
}여기서 제가 무엇을 빼먹은거죠?');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (4, 'System.out.print(*); 이부분 *쪽에 "*"이렇게 해주서야 됩니다. :)', 4, 26);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (5, 26, 'JAVA 코딩 폰트 추천 부탁드립니다.', '깔끔한거 추천 부탁드려요');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (5, 'D2 Coding 폰트 추천합니다!', 5, 27);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (6, 23, 'JAVA for문 어떻게 작성하나요?', '제곧내');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (6, 'for(초기값; 조건; 초기값변경)이렇게 됩니다. 예시: for(int i=0; i < 10 ; i ++)', 6, 5);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (7, 23, 'JAVA if문 어떻게 작성하나요?', '제곧내');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (7, '제가 게시한 글을 참조 하세요', 7, 5);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (8, 5, 'if문 작성방법',									
'if(조건식){									
실행문;									
실행문;									
...									
} 조건식이 true값을 가질 때 중괄호({ }) 안의 실행문을 작동시킨다. 반대로 조건식이 false이면 중괄호({ })의 실행문은 동작하지 않고 if문을 빠져나간다.');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (8, '고맙습니다!', 8, 23);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (9, 29, 'JAVA는 몇년도에 나온 언어인가요?', '제곧내');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (9, '1991년 그린 프로젝트라는 이름으로 시작해 1995년에 발표되었습니다. :)', 9, 27);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (10, 23, 'static이란 뭔가요?', '제곧내');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (10, '제가 게시한글 보셔요~', 10, 28);									
									
INSERT INTO PROLINGO_BOARD(BOARD_ID, USER_ID, TITLE, BOARD_CONTENT)									
VALUES (11, 28, 'static 개념', 'Static은 고정된이라는 의미를 가지고 있으며, Static 키워드를 통해 정적 변수와 정적 메소드를 만들 수 있다. 이렇게 만들어진 정적 변수나 정적 메소드는 프로그램이 종료되기 전까지 사용할 수 있고, GC에 의해 수집되지 않는다. 참고로, 정적 객체는 GC에 의해 수집될 수 있다.									
동적은 객체를 런타임 도중에 힙 영역에 할당하는 행위를 말한다. 반대로, 정적은 프로그램이 시작되는 시점에 클래스 로더가 클래스를 해석하여 메소드 영역 혹은 힙 영역에 클래스 메타 데이터 및 정적 변수를 적재한다.');									
									
INSERT INTO PROLINGO_REPLY(REPLY_ID, REPLY_CONTENT, BOARD_ID, USER_ID)									
VALUES (11, '고맙습니당!', 11, 28);												
					
--PROLINGO_ACHIEVEMENT					
DROP TABLE	PROLINGO_ACHIEVEMENT	;			
CREATE TABLE	PROLINGO_ACHIEVEMENT	(		--시퀀스 필요하면 만드는걸로	
ACHIEVEMENT_ID	    NUMBER	PRIMARY KEY	,	--업적 아이디	
ACHIEVEMENT_NAME	VARCHAR2(100)	NOT NULL	,	--업적 이름	
ACHIEVEMENT_TEXT	VARCHAR2(1000)	NOT NULL	,	--업적 내용
ACHIEVEMENT_DATE    DATE DEFAULT SYSDATE
);

DROP SEQUENCE	PROLINGO_ACHIEVEMENT_SEQ;	
CREATE SEQUENCE	PROLINGO_ACHIEVEMENT_SEQ;
					
--USER_ACHIEVE					
DROP TABLE	USER_ACHIEVE	;			
CREATE TABLE	USER_ACHIEVE	(			
USER_ID	NUMBER	REFERENCES PROLINGO_USER(USER_ID)	ON DELETE CASCADE	,	--유저 아이디
ACHIEVEMENT_ID	NUMBER	REFERENCES PROLINGO_ACHIEVEMENT(ACHIEVEMENT_ID)	ON DELETE CASCADE	,	--달성한 업적 아이디
PRIMARY KEY(USER_ID, ACHIEVEMENT_ID)				);	--복합키

COMMIT;