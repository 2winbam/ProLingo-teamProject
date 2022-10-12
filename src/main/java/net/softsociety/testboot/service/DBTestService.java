package net.softsociety.testboot.service;

import net.softsociety.testboot.domain.DBTestVO;

public interface DBTestService {

	int insertTest(DBTestVO vo);

	int insertCodeTest(String code);

}
