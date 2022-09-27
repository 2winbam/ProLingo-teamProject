package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.TestLessonVO;

public interface StudyCourseService {
	

	/**
	 * 학습선택 페이지에서 입문편 리스트 전체출력
	 * @param intro
	 * @return
	 */
	public ArrayList<TestLessonVO> introdutionAll(String intro);
	
	
}
