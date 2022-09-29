package net.softsociety.testboot.service;

import java.util.ArrayList;

import net.softsociety.testboot.domain.ProlingoQuestionVO;

public interface QuestionService {

	public ArrayList<ProlingoQuestionVO> selectAllQuestionsByLessonID(int lessonid);

	public ArrayList<String> selectAllKeywordsName(int questionid);

}
