package net.softsociety.testboot.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.testboot.domain.MemberVO;

@Mapper
public interface MemberDAO {

	int insertMember(MemberVO member);


}
