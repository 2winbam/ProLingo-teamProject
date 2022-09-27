package net.softsociety.testboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.testboot.domain.TestLessonVO;

@Mapper
public interface StudyCourseDAO {
	
	/**
	 * 학습선택 페이지에서 입문편 리스트 출력
	 * @param intro 개념편이라는것을 구분하기 위한 파라미터
	 * @return
	 */
	ArrayList<TestLessonVO> introdutionAll(String intro);
	
}
