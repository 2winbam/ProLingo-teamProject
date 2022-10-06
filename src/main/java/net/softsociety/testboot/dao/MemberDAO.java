package net.softsociety.testboot.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.domain.MemberWeeklyExpVO;

@Mapper
public interface MemberDAO {
	//회원가입
	int insertMember(MemberVO member);
	//로그인 아이디 체크
	int logincheck(HashMap<String, String> map);
	//이메일로 멤버 객체 하나 반환
	MemberVO selectMemberByEmail(String email);
	//로그인 userid로 현재 멤버 객체 하나 반환
	MemberVO selectMemberByUserid(int id);
	//회원정보 수정
	int updateMemberInfo(MemberVO member);
	//회원정보 삭제
	int deleteMemberAccount(int id);
	//요일별 획득경험치 추가
	int insertUserExpDay();
	//경험치 추가
	int updateUserExp(@Param("id") int userid, @Param("exp") int exp);

	//요일별 획득 경험치 업데이트
	int updateUserExpDay(@Param("id")int userid, @Param("exp")int exp, @Param("today")int today);
	//유저 요일별 획득 누적 경험치 조회
	MemberWeeklyExpVO getExp(@Param("id")int userid);

	//전체글 유저닉네임
	int usernickname(MemberVO member);
	
	//유저가 그 문제를 풀었는가
	int isQuestionCompleted(@Param("username")String username, @Param("questionid")int question_id);
	
	//
	int questionComplite(@Param("username")String username, @Param("questionid")int question_id);


}
