package net.softsociety.testboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.StudyCourseDAO;
import net.softsociety.testboot.domain.TestLessonVO;

@Slf4j
@Service
public class StudyCourseServiceImpl implements StudyCourseService {
	
	@Autowired
	private StudyCourseDAO dao;
	
	/**
	 * 학습선택 페이지에서 개념편 리스트 전체 출력
	 */
	@Override
	public ArrayList<TestLessonVO> introdutionAll(){
				
		ArrayList<TestLessonVO> chapterList = dao.introdutionAll();
		
		log.debug("조회 완료 : {}", chapterList);
		 
		return chapterList;
	}
}
