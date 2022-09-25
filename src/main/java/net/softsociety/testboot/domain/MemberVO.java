package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private int user_id; 
	private int user_pw;
	private String default_email;
	private String email;
	private String user_name;
	private String nickname;
	private String photo;
	private int age;
	private String user_role;
	private String longintype;
	private int joindate;
	private int exp;
	private int continueday;
	private int money;
	private int goal;
	private int notice;
	private int autosave;
}	

/*--PROLINGO_USER                  
DROP TABLE   PROLINGO_USER   ;            
CREATE TABLE   PROLINGO_USER            (   
USER_ID   NUMBER   PRIMARY KEY         ,   --멤버 아이디, 시퀀스로 사용
USER_PW   NUMBER   NOT NULL         ,   --비밀번호
DEFAULAT_EMAIL   VARCHAR2(50)   NOT NULL   UNIQUE      ,   --최초 가입 이메일
EMAIL   VARCHAR2(50)   NOT NULL   UNIQUE      ,   --로그인에 사용할 이메일
USER_NAME   VARCHAR2(30)   NOT NULL         ,   --이름
NICKNAME   VARCHAR2(30)   NOT NULL         ,   --닉네임
PHOTO   VARCHAR2(100)            ,   --프로필 사진
AGE   NUMBER            ,   --나이
USER_ROLE   VARCHAR2(10)   DEFAULT 'NORMAL'   NOT NULL   CHECK(USER_ROLE IN('NORMAL', 'PLUS', 'ADMIN'))   ,   --회원 등급
LOGINTYPE   VARCHAR2(10)   DEFAULT 'NORMAL'    NOT NULL   CHECK(LOGINTYPE IN('NORMAL', 'GOOGLE', 'KAKAO', 'NAVER', 'FACEBOOK'))   ,   --로그인 타입
JOINDATE   DATE   DEFAULT SYSDATE   NOT NULL      ,   --가입일
EXP   NUMBER   DEFAULT 0   NOT NULL      ,   --누적 경험치
CONTINUEDAY   NUMBER   DEFAULT 0   NOT NULL      ,   --연속 학습일
MONEY   NUMBER   DEFAULT 0   NOT NULL      ,   --재화
GOAL   NUMBER   DEFAULT 60   NOT NULL   CHECK(GOAL IN(20, 40, 60, 80, 100))   ,   --일일 학습 목표
NOTICE   NUMBER   DEFAULT 0   NOT NULL   CHECK(NOTICE IN(0, 1))   ,   --알림 설정
AUTOSAVE   NUMBER   DEFAULT 0   NOT NULL   CHECK(AUTOSAVE IN(0, 1))   );   --해답 자동 저장
*/