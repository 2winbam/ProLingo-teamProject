package net.softsociety.testboot.service;

import net.softsociety.testboot.domain.MemberVO;

public interface MemberService {
	//회원 등록
	public int insertMember(MemberVO member); 
	//AJAX 로그인 체크
	public int logincheck(String email, String user_pw);

	public MemberVO getMemerInfo(String userid);
	//회원정보 수정
	public int updateMemberInfo(MemberVO member);
	//회원탈퇴
	public int deleteAccont(String userid, String user_pw);

}
