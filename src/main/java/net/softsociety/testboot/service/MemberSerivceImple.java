package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.testboot.dao.MemberDAO;
import net.softsociety.testboot.domain.MemberVO;

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
}
