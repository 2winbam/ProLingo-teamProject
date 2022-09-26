package net.softsociety.testboot.service;

import java.util.HashMap;

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
		String encodePasswrod = passwordEncoder.encode(user_pw);
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("email", email);
		map.put("user_pw", encodePasswrod);
		log.debug("email:{}, user_pw:{}", map.get("email"), encodePasswrod);
		int check = dao.logincheck(map);
		return check;
	}
}
