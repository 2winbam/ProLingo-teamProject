package net.softsociety.testboot.service;

import net.softsociety.testboot.domain.MemberVO;

public interface MemberService {

	public int insertMember(MemberVO member); //회원 등록
	
	//AJAX 로그인 체크
	public int logincheck(String email, String user_pw);

	public MemberVO getMemerInfo(String userid);

	public int updateMemberInfo(MemberVO member);

}
