package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.ContentsVO;
import net.softsociety.testboot.domain.TestLessonVO;

public interface StudyCourseService {
	

	/**
	 * 학습선택 페이지에서 입문편 리스트 전체출력
	 * @return
	 */
	public ArrayList<TestLessonVO> introdutionAll();
	
	/**
	 * 개념 슬라이드 출력
	 * @param lessonid 해당 값과 lesson_id 가 같으면 해당 슬라이드 실행 
	 * @return 해당 슬라이드 리스트
	 */
	public ArrayList<ContentsVO> selectContents(int lessonid);
	
	
}
