package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.MemberDAO;
import net.softsociety.testboot.domain.MemberVO;

@Slf4j
@Service
public class MemberSerivceImple implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 회원가입
	@Override
	public int insertMember(MemberVO member) {
		
		String encodePasswrod = passwordEncoder.encode(member.getUser_pw());
		member.setUser_pw(encodePasswrod);
		
		int result = dao.insertMember(member);
		return result;
	}
	
	// AJAX 로그인 체크
	//수정해야함
	@Override
	public int logincheck(String email, String user_pw) {
		
		//우선 가입된 이메일이 있는지 확인
		MemberVO member = dao.selectMemberByEmail(email);
		
		//이메일이 일치하는 멤버가 없으면 0 리턴
		if(member != null) {
			if(passwordEncoder.matches(user_pw, member.getUser_pw())) {
				log.debug("이메일과 비밀번호가 일치함, id : {}", member.getUser_id());
				return member.getUser_id();
			}
			else {
				log.debug("이메일은 있으나 비밀번호가 일치하지 않음");
				return 0;
			}
		}
		log.debug("이메일과 일치하는 유저 없음");
		return 0;
		
//		HashMap<String, String> map = new HashMap<>();
//		
//		map.put("email", email);
//		map.put("user_pw", encodePasswrod);
//		log.debug("email:{}, user_pw:{}", map.get("email"), encodePasswrod);
//		int check = dao.logincheck(map);
//		return check;
	}
	
	//현재 로그인한 멤버 정보 찾기
	@Override
	public MemberVO getMemerInfo(String userid) {
		
		int id = Integer.parseInt(userid);
		MemberVO member =  dao.selectMemberByUserid(id);
		return member;
	}

	@Override
	public int updateMemberInfo(MemberVO member) {
		// 만약 비밀번호 수정도 추가할시 들어가야함.
//		if (!(member.getUser_pw() == null || member.getUser_pw() == "")) {
//			String encodePassword = passwordEncoder.encode(member.getUser_pw());
//			member.setUser_pw(encodePassword);
//		}
		
		int result = dao.updateMemberInfo(member);
		return result;
	}

	@Override
	public int deleteAccont(String userid, String user_pw) {
		
		if(!(user_pw == null || user_pw == "")) {
			//DB에서 넘어온 비번
			int id = Integer.parseInt(userid);
			MemberVO DBmember = dao.selectMemberByUserid(id);
			log.debug("넘어온 정보 : {} ", DBmember.getUser_pw());
			// 웹에서 받은 암호화된 비번과 DB에서 넘어온 비번 비교
			if(passwordEncoder.matches(user_pw, DBmember.getUser_pw())) {
				log.debug("비밀번호 서로 일치");
				return dao.deleteMemberAccount(id);
			} else {
				log.debug("비밀번호 불일치");
				return 0;
			}
			
		}
		return 0;
	}

	@Override
	public int updateUserExp(String userid, int exp) {
		
		int result = dao.updateUserExp(Integer.parseInt(userid), exp);
		
		return result;
	}
}
