package net.softsociety.testboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private int m_id;
	private String m_default_email;
	private String m_name;
	private String m_nickname;
	private String m_pw;
	private int m_age;
	private int m_longintype;
	private String photo;
	private String joindate;
	private int goal;
	private int m_exp;
	private int notice;
	private int autosave;
	private int m_continue;
	private int money;
	private int is_prime;	
}

/*
 *m_id 	NUMBER	NOT NULL, --'회원 식별 아이디',
    m_default_email	VARCHAR2(30)	NULL, --'최초 가입 이메일',
	m_mail 	VARCHAR2(30)	NULL, --'로그인 아이디로 쓸 이메일',
	m_name 	VARCHAR2(20)	NULL, --'이름',
	m_nickname	VARCHAR2(20)	NULL, --'닉네임',
    m_pw   	VARCHAR2(30)	NULL, --'비밀번호',
	m_age	    NUMBER	NULL, --'나이',
	m_longintype	VARCHAR2(30)	NULL, --'본 사이트 가입인지, 외부 가입인지',
	photo	VARCHAR2(300)	NULL, --'프로필 사진',
	joindate	DATE DEFAULT SYSDATE, --'가입 날짜',
	goal    	NUMBER	DEFAULT 50, --'일일 목표',
	m_exp NUMBER	DEFAULT 0, --'누적 경험치',
	notice	NUMBER	DEFAULT 1, --'알림 기능',
	autosave	NUMBER	DEFAULT 0, --'문제 풀이 자동 저장',
	m_continue   NUMBER DEFAULT 0, --'연속 학습 일수',
	money   	NUMBER	DEFAULT 0, --'재화',
	is_prime    NUMBER	NULL --'결제 유무'
 * 
 * 
 */
