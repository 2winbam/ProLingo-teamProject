package net.softsociety.testboot.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.testboot.domain.DBTestVO;

@Mapper
public interface DBTestDAO {

	int insertTest(DBTestVO vo);

	int insertCodeTest(String code);

}
