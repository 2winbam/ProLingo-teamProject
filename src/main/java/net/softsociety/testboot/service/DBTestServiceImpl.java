package net.softsociety.testboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.DBTestDAO;
import net.softsociety.testboot.domain.DBTestVO;

@Service
@Slf4j
public class DBTestServiceImpl implements DBTestService {

	@Autowired
	DBTestDAO dao;

	@Override
	public int insertTest(DBTestVO vo) {
		
		log.debug("넘어온 값 : {}", vo);
		
		int result = dao.insertTest(vo);
		
		return result;
	}
	
	
}
