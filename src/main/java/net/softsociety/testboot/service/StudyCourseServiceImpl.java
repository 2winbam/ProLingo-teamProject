package net.softsociety.testboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.StudyCourseDAO;
import net.softsociety.testboot.domain.ContentsVO;


@Slf4j
@Service
public class StudyCourseServiceImpl implements StudyCourseService {
	
	@Autowired
	private StudyCourseDAO dao;
	
	/**
	 * 학습선택 페이지에서 개념편 리스트 전체 출력
	 */
	@Override
	public ArrayList<ContentsVO> introdutionAll(){
				
		ArrayList<ContentsVO> chapterList = dao.introdutionAll();
		
		log.debug("조회 완료 : {}", chapterList);
		 
		return chapterList;
	}
	
	@Override
	public ArrayList<ContentsVO> selectContents(int lessonid){
		
		log.debug("서비스 impl의 lessonid : {}", lessonid);
		
		ArrayList<ContentsVO> contentsList = dao.selectContents(lessonid);
		
		return contentsList;
	}

	@Override
	public ArrayList<ContentsVO> selectContents(int lessonid, int questionindex) {
		
		ArrayList<ContentsVO> contentsList = dao.selectContents2(lessonid, questionindex);
		
		return contentsList;
	} 
}
