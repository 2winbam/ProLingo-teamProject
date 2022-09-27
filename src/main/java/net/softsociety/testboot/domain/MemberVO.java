package net.softsociety.testboot.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//시큐리티 로그인을 위한 인터페이스
public class MemberVO implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3714727137138636200L;
	private int user_id; 
	private String user_pw; //ALTER TABLE PROLINGO_USER MODIFY USER_PW VARCHAR2(100);
	private String default_email;
	private String email;
	private String user_name;
	private String nickname;
	private String photo;
	private int age;
	private String user_role;
	private String longintype;
	private String joindate; //int로 되어있던걸 String으로 수정
	private int exp;
	private int continueday;
	private int money;
	private int goal;
	private int notice;
	private int autosave;
	//로그인에 필수라는듯
	//db에도 ALTER TABLE PROLINGO_USER ADD ENABLED NUMBER DEFAULT 1 NOT NULL CHECK(ENABLED IN (0, 1)); 해줘야함
	private boolean enabled;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	//패스워드 리턴
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user_pw;
	}
	@Override
	//아이디를 String으로 리턴
	public String getUsername() {
		// TODO Auto-generated method stub
		return Integer.toString(this.user_id);
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}	

/*--PROLINGO_USER								
DROP TABLE	PROLINGO_USER	;						
CREATE TABLE	PROLINGO_USER				(			
USER_ID	NUMBER	PRIMARY KEY			,	--멤버 아이디		
USER_PW	VARCHAR2(100)	NOT NULL			,	--비밀번호		
DEFAULAT_EMAIL	VARCHAR2(50)	NOT NULL	UNIQUE		,	--최초 가입 이메일		
EMAIL	VARCHAR2(50)	NOT NULL	UNIQUE		,	--로그인에 사용할 이메일		
USER_NAME	VARCHAR2(30)	NOT NULL			,	--이름		
NICKNAME	VARCHAR2(30)	NOT NULL			,	--닉네임		
PHOTO	VARCHAR2(100)				,	--프로필 사진		
AGE	NUMBER				,	--나이		
USER_ROLE	VARCHAR2(10)	DEFAULT 'NORMAL'	NOT NULL	CHECK(USER_ROLE IN('NORMAL', 'PLUS', 'ADMIN'))	,	--회원 등급		
LOGINTYPE	VARCHAR2(10)	DEFAULT 'NORMAL' 	NOT NULL	CHECK(LOGINTYPE IN('NORMAL', 'GOOGLE', 'KAKAO', 'NAVER', 'FACEBOOK'))	,	--로그인 타입		
JOINDATE	DATE	DEFAULT SYSDATE	NOT NULL		,	--가입일		
EXP	NUMBER	DEFAULT 0	NOT NULL		,	--누적 경험치		
CONTINUEDAY	NUMBER	DEFAULT 0	NOT NULL		,	--연속 학습일		
MONEY	NUMBER	DEFAULT 0	NOT NULL		,	--재화		
GOAL	NUMBER	DEFAULT 60	NOT NULL	CHECK(GOAL IN(20, 40, 60, 80, 100))	,	--일일 학습 목표		
NOTICE	NUMBER	DEFAULT 0	NOT NULL	CHECK(NOTICE IN(0, 1))	,	--알림 설정		
AUTOSAVE	NUMBER	DEFAULT 0	NOT NULL	CHECK(AUTOSAVE IN(0, 1))	);	--해답 자동 저장		
								
--PROLINGO_USER_SEQUENCE								
DROP SEQUENCE	PROLINGO_USER_SEQ	;				-- FOR USER_ID		
CREATE SEQUENCE	PROLINGO_USER_SEQ	;						
*/