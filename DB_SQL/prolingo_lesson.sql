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
KEYWORDS	VARCHAR2(1000)		,   --채점 할 때 들어가 있어야 하는 문구(객관식에선 문제로 만드는용도)
DEFAULT_CODE VARCHAR2(2000) 	,	--최초 코드
CONSOLE_RESULT VARCHAR2(1000)   );  --콘솔 결과값

					
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

--실제 DB에 넣을 데이터																									
																									
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	0	, 	'C'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	1	, 	'C++'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	2	, 	'C#'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	3	, 	'JAVA'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	4	, 	'HTML'||'&'||'CSS'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	5	, 	'JAVASCRIPT'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	6	, 	'PHP'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	7	, 	'PYTHON'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	8	, 	'RUBY'	);													
INSERT INTO	PROLINGO_SUBJECT	(	SUBJECT_ID	,	SUBJECT_NAME	)	VALUES	(	9	, 	'GO'	);													
																									
																									
INSERT INTO	PROLINGO_LESSON	(	LESSON_ID	,	SUBJECT_ID	,	GRADE	,	LESSON_CONTENTS	)															
	VALUES	(	0	,	3	, 	'INTRODUTION'	, 	'NULL'	) ;															
INSERT INTO	PROLINGO_LESSON	(	LESSON_ID	,	SUBJECT_ID	,	GRADE	,	LESSON_CONTENTS	)															
	VALUES	(	3	,	3	, 	'INTRODUTION'	, 	'quiz'	) ;															
INSERT INTO	PROLINGO_LESSON	(	LESSON_ID	,	SUBJECT_ID	,	GRADE	,	LESSON_CONTENTS	)															
	VALUES	(	8	,	3	, 	'INTRODUTION'	, 	'quiz'	) ;															
																									
																									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	0	,	0	,	'"Hello Java"를 출력하세요.'	,	class Main {\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"Hello Java\");\n\t}\n}'	,	class Main {\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"Hello Java\");\n\t}\n}'	,	'Hello Java\n'	,	'0'	);									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	1	,	0	,	'"4번 줄의 This line should be a comment를 주석으로 만드세요.\n\nSystem.out.println()를 사용하여 "Hello Java"를 출력하세요.'	,	'class Main {\n\tpublic static void main(String[] args) {\n\n\t\tThis line should be a comment\n\n\t}\n}'	,	'class Main {\n\tpublic static void main(String[] args) {\n\n\t\t//This line should be a comment\n\n\t\tSystem.out.println(\"Hello Java\");\n\t}\n}'	,	'Hello Java\n'	,	'1'	);									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	2	,	0	,	'17을 정수형으로 출력하세요.\n\n+ 연산자를 사용해 5와 3을 더한 값을 출력하세요.\n\n5 + 3을 문자형으로 출력하세요.'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Print 17 as an integer\n\t\t\n\t\t// Print the sum of 5 and 3\n\t\t\n\t\t// Print \"5 + 3\" as a string\n\t\t\n\t}\n}'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Print 17 as an integer\n\t\tSystem.out.println(17);\n\n\t\t// Print the sum of 5 and 3\n\t\tSystem.out.println(5 + 3);\n\n\t\t// Print \"5 + 3\" as a string\n\t\tSystem.out.println(\"5 + 3\");\n\t}\n}'	,	'17\n8\n5 + 3\n'	,	'2'	);									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	3	,	0	,	'/ 연산자를 사용해 12를 3으로 나눈 값을 출력하세요.\n\n* 연산자를 사용해 3과 6을 곱한 값을 출력하세요.\n\n%연산자를 사용해 8을 3으로 나눈 나머지 값을 출력하세요.'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Print the result of 12 divided by 3\n\t\t\n\t\t// Print the result of 3 times 6\n\t\t\n\t\t// Print the remainder of 8 divided by 3\n\t\t\n\t}\n}'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Print the result of 12 divided by 3\n\t\tSystem.out.println(12 / 3);\n\n\t\t// Print the result of 3 times 6\n\t\tSystem.out.println(3 * 6);\n\n\t\t// Print the remainder of 8 divided by 3\n\t\tSystem.out.println(8 % 3);\n\n\t}\n}'	,	'4\n18\n2\n'	,	'4,5,6'	);									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	4	,	0	,	'Hello와 World를 연결하여 출력하세요.\n\n문자열 38과19를 연결하여 출력하세요.\n\n정수 38과 19를 더해서 출력하세요.'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Concatenate \"Hello\" and \"World\", and print it\n\t\t\n\t\t// Concatenate \"38\" and \"19\", and print it\n\t\t\n\t\t// Add 38 and 19, and print it\n\t\t\n\t}\n}'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Concatenate \"Hello\" and \"World\", and print it\n\t\tSystem.out.println(\"Hello\" + \"World\");\n\n\t\t// Concatenate \"38\" and \"19\", and print it\n\t\tSystem.out.println(\"38\" + \"19\");\n\n\t\t// Add 38 and 19, and print it\n\t\tSystem.out.println(38 + 19);\n\t}\n}'	,	'HelloWorld\n3819\n57\n'	,	'2'	);									
																									
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	0	,	'System.out.println'	,	'IO'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	1	,	'//'	,	'comment'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	2	,	'+'	,	'operator'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	3	,	'-'	,	'operator'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	4	,	'*'	,	'operator'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	5	,	'/'	,	'operator'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	6	,	'%'	,	'operator'	);																	
																									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	5	,	3	,	'We''ll be creating a program that prints your name, age, height, weight and BMI. \n\nDeclare the following variables, and assign any values you like:\n・name of type String\n・age of type int\n・height of type double\n・weight of type double\n・bmi of type double\n\nTips:\n・You can assign any values you like, but make sure they have the correct type.\n・Your BMI can be calculated using the following formula: weight / height / height\n\nPrint the following text using the variables you defined:\n\nMy name is ____\nI am ____ years old\nMy height is ____ meters\nMy weight is ____ kilograms\nMy BMI is ____'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Assign a string to the name variable\n\t\t\n\t\t\n\t\t// Assign an integer to the age variable\n\t\t\n\t\t\n\t\t// Assign a double to the height variable (i.e. 1.6)\n\t\t\n\t\t\n\t\t// Assign a double to the weight variable (i.e. 50.0)\n\t\n\t\t\n\t\t// Calculate the BMI and assign it into the bmi variable\n\t\t\n\t\t\n\t\t// Print name, age, height, weight, and BMI\n\t\t\n\t\t\t}\n}'	,	'class Main {\n\tpublic static void main(String[] args) {\n\t\t// Assign a string to the name variable\n\t\tString name = \"Kate Jones\";\n\t\t\n\t\t// Assign an integer to the age variable\n\t\tint age = 27;\n\t\t\n\t\t// Assign a double to the height variable (i.e. 1.6)\n\t\tdouble height = 1.6;\n\t\t\n\t\t// Assign a double to the weight variable (i.e. 50.0)\n\t\tdouble weight = 50.0;\n\t\t\n\t\t// Calculate the BMI and assign it into the bmi variable\n\t\tdouble bmi = weight / height / height;\n\t\t\n\t\t// Print name, age, height, weight, and BMI\n\t\tSystem.out.println(\"My name is \" + name);\n\t\tSystem.out.println(\"I am \" + age + \" years old\");\n\t\tSystem.out.println(\"My height is \" + height + \" meters\");\n\t\tSystem.out.println(\"My weight is \" + weight + \" kilograms\");\n\t\tSystem.out.println(\"My BMI is \" + bmi);\n\t\t\n\t}\n}'	,	'weight/height/height'	,	'7,8,11'	);									
							'우리는 당신의 이름, 나이, 키, 몸무게, BMI를 출력하는 프로그램을 만들 것입니다. \n\n다음 변수를 선언하고 원하는 값을 지정하십시오:\n・String타입 name\n・int형 age\n・double형 height\n・double형 weight\n・double형 bmi\n\nTips:\n・당신의 BMI는 다음 공식을 사용하여 계산될 수 있습니다: weight / height / height\n\n정의한 변수를 사용하여 다음의 텍스트를 인쇄:\n\nMy name is ____\nI am ____ years old\nMy height is ____ meters\nMy weight is ____ kilograms\nMy BMI is ____'																		
																									
																									
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	7	,	'String'	,	'string'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	8	,	'int'	,	'integer'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	9	,	'long'	,	'integer'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	10	,	'float'	,	'real_number'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	11	,	'double'	,	'real_number'	);																	
																									
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	12	,	'for'	,	'loop'	);																	
INSERT INTO	PROLINGO_KEYWORD	(	KEYWORD_ID	,	KEYWORD_NAME	,	KEYWORD_TYPE	)																	
	VALUES	(	13	,	'while'	,	'loop'	);																	
																									
INSERT INTO	PROLINGO_LESSON	(	LESSON_ID	,	SUBJECT_ID	,	GRADE	,	LESSON_CONTENTS	)															
	VALUES	(	10	,	0	, 	'INTRODUTION'	, 	'quiz'	) ;															
																									
INSERT INTO	PROLINGO_QUESTION	(	QUESTION_ID	,	LESSON_ID	,	QUESTION_CONTENTS	,	DEFAULT_CODE	,	ANSWER	,	CONSOLE_RESULT	,	KEYWORDS	)									
	VALUES	(	6	,	10	,	'첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., 5번째 줄에는 별 9개를 출력하세요.\n\n별은 가운데를 기준으로 대칭이어야 합니다.\n\n예시)\n    *\n   ***\n  *****\n *******\n*********'	,	'#include <stdio.h>\n\nvoid main() {\n\tint n = 5;\n\n}'	,	'#include <stdio.h>\n\nvoid main() {\n\tint n = 5;\n\t\n\tfor (int i = 0; i < n; i++){\n\t\tfor(int k = n - i - 1; k > 0; k--){\n\t\t\tprintf(\" \");\n\t\t}\n\t\tfor(int j = 0; j <i * 2 + 1; j++ ){\n\t\t\tprintf(\"*\");\n\t\t}\n\t\tprintf(\"\\\n\");\n\t}\n}'	,	'    *\n   ***\n  *****\n *******\n*********'	,	'12,13'	);									
																									
																									
--1																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '시작하기', 0, 'Java에 오신 것을 환영합니다.', '이 과에서는 Java의 기본 사항에 대해 알아보겠습니다.																								
여러분은 처음에는 어려워 보일 수 있는 많은 새로운 용어들을 보게 될 것이지만, 걱정하지 마세요!																									
한 개씩 같이 배워보도록 하겠습니다.', '/prolingo/img/contents/0-0.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '시작하기', 0, '렛츠 런 자바', '첫 번째 자바 코드를 작성합시다. Main.java라는 파일에서 이 작업을 하게 됩니다. 첫 번째 단계는 문자를 인쇄하는 것입니다.																								
System.out.println()의 () 안에 문자를 기록하여 콘솔에서 인쇄할 수 있습니다.', '/prolingo/img/contents/0-1.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '시작하기', 0, '자바란 무엇인가?', '자바는 전 세계적으로 사용되는 인기 있는 언어입니다. 대규모 시스템, 웹 애플리케이션, 모바일 애플리케이션 등 자바를 이용해 모든 것을 개발할 수 있습니다.																								
※ 자바는 자바스크립트와 같지 않으니 헷갈리지 마세요.', '/prolingo/img/contents/0-2.png'																									
);																									
																									
-- 2																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열', 1, '문자열', '지난 수업에서는 콘솔에 문자를 출력했습니다. 프로그래밍에서, "Hello Java"와 같은 일련의 문자는 문자열로 알려져 있습니다.																								
문자열을 큰따옴표 "로 묶어야 합니다. 그렇지 않으면 오류가 발생합니다.', '/prolingo/img/contents/1-0.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열', 1, 'System.out.println', 'System.out.println()은 () 안에 있는 것을 인쇄하기 위한 명령입니다.																								
프로그래밍에서는 컴퓨터에 이와 같은 다양한 명령을 내릴 수 있습니다. System.out.println()을 숙지하십시오. 이 과정에서는 System.out.println()을 반복해서 사용합니다.																									
※ "println"의 l은 L의 소문자입니다.', '/prolingo/img/contents/1-1.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열', 1, '자바의 구조?', '모든 Java 파일에는 class가 있습니다. clsss 안에는 methods이 있다.																								
아래 예제에는 Main 클래스와 Main method가 있습니다. 현재로서는, 당신이 기억해야 할 유일한 것은 당신이 메인 메서드 안에 당신의 코드를 쓸 것이라는 것입니다.',																									
/prolingo/img/contents/1-2.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열', 1, '세미콜론', 'Java에는 모든 문의 끝에 세미콜론이 필요합니다.																								
그렇지 않으면 오류가 발생할 수 있으니 조심하세요!', '/prolingo/img/contents/1-3.png'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열', 1, '주석', '우리는 또한 //를 사용하여 코드로 주석을 작성할 수 있습니다.																								
코드를 실행할 때 주석은 무시되므로 주석을 사용하여 메모를 남길 수 있습니다.', '/prolingo/img/contents/1-4.png'																									
);																									
																									
--3																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '정수', 2, '정수', '프로그래밍에서 정수 같은 숫자를 사용할 수 있습니다. 문자열과 달리 따옴표로 묶을 필요가 없습니다.																								
왼쪽 그림에서 보듯이 수학에서처럼 정수를 더하고 뺄 수 있습니다. 정수 앞과 뒤에 공백을 넣을 필요는 없지만 코드를 읽기 쉽게 만듭니다.', '/prolingo/img/contents/2-0.jpg'																									
);																									
																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '정수', 2, '문자열과 정수의 차이', '프로그래밍에서 문자열과 정수는 다르게 해석됩니다.																								
5 + 2는 7을 출력합니다. 이는 덧셈의 결과입니다. 그러나 "5 + 2"와 같이 큰 따옴표 "를 추가하여 문자열로 만들면 출력은 리터럴 문자열: 5 + 2가 됩니다.',																									
/prolingo/img/contents/2-1.jpg'																									
);																									
																									
																									
--4																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '계산', 3, '다양한 계산들', '자바에서는 곱셈과 나눗셈과 같은 다른 계산을 할 수 있지만 수학에서 사용하는 것과 다른 기호로 계산할 수 있습니다.																								
* 연산자는 곱셈용이고 / 연산자는 나눗셈용입니다. % 연산자를 사용하여 분할 후 나머지를 계산할 수도 있습니다.', '/prolingo/img/contents/3-0.jpg'																									
);																									
																									
																									
--5																									
INSERT INTO	PROLINGO_CONTENTS(CONTENT_ID, LESSON_ID,	LESSON_TITLE, LESSON_SLIDE, LESSON_SUBTITLE, LESSON_CONTENTS, LESSON_PICTURE)																							
VALUES	(																								
PROLINGO_CONTENTS_SEQ.nextval,	0, '문자열 연결', 4, '문자열 연결', '계산에 사용한 +를 사용하면 문자열을 결합할 수 있습니다.																								
문자열을 결합하는 것을 문자열 연결이라고 합니다. 아래 그림과 같이 "5" + "3"은 두 문자열을 숫자로 추가하는 대신 "53"이 되도록 연결합니다. 항상 정수와 문자열의 차이를 인식하도록 하십시오.', '/prolingo/img/contents/4-0.jpg'																									
);																									
commit;																																							
																									
commit;																									