package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.ProlingoQuestionVO;
import net.softsociety.testboot.service.QuestionService;

@Controller
@Slf4j
@ResponseBody
public class QuestionController {

	@Autowired
	QuestionService service;
	
	/**
	 * 레슨 아이디의 모든 문제를 받아와서 넘겨줄거임
	 * 잠만 그냥 컨트롤러에 넣으면 되나?
	 * 일단 당장은 안쓰임
	 * 
	 * @param lessonid
	 * @return questionList
	 */
	@GetMapping("getQuestion")
	public ArrayList<ProlingoQuestionVO> getQuestion(int lessonid) {
		log.debug("문제 id : {}", lessonid);
		
		ArrayList<ProlingoQuestionVO> questionList = service.selectAllQuestionsByLessonID(lessonid);
		
		return questionList;
	}
}
