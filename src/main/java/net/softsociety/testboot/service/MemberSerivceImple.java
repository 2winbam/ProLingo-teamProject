package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.testboot.dao.MemberDAO;

@Service
public class MemberSerivceImple implements MemberService {

	@Autowired
	MemberDAO dao;
}
