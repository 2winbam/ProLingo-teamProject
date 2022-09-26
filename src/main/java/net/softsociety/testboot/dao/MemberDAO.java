package net.softsociety.testboot.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.testboot.domain.MemberVO;

@Mapper
public interface MemberDAO {

	int insertMember(MemberVO member);

	int logincheck(HashMap<String, String> map);

}
