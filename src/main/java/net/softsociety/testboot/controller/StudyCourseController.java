package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.ContentsVO;
import net.softsociety.testboot.domain.ProlingoQuestionVO;
import net.softsociety.testboot.service.QuestionService;
import net.softsociety.testboot.service.QuestionServiceImpl;
import net.softsociety.testboot.service.StudyCourseService;

@Slf4j
@Controller
@RequestMapping("study")
public class StudyCourseController {
	
	@Autowired
	StudyCourseService service;
	
	@GetMapping("javaCourse")
	public String JavaCourse() {
		return"studyCourse/javaCourse";
	}
	
	/**
	 * 
	 * @return 코스 선택 페이지
	 */
	@GetMapping("")
	public String selectCourse() {
		return "studyCourse/selectCourse";
	}
	
	/**
	 * 학습선택 페이지에서 입문편 리스트를 전부 출력
	 * @return 자바 입문
	 */
	@GetMapping("javaCourse/introduction")
	public String JavaIntroduction(Model model) {
		
		ArrayList<ContentsVO> chapterList = service.introdutionAll();
		
		log.debug("조회한 리스트 전체 : {}", chapterList);
		
		model.addAttribute("chapterList", chapterList);
		
		return "studyCourse/java_introduction";
	}
	
	/**
	 * 
	 * @return 자바 초급
	 */
	@GetMapping("javaCourse/beginner")
	public String JavaBeginner() {
		return "studyCourse/java_beginner";
	}
	
	@Autowired
	QuestionService qs;
	
	/**
	 * get방식으로 lessonid를 받아서 모델에 넣어줌
	 * kim : 걍 여기서 문제 받아와서 넣어버리겠음
	 * @param lessonid
	 * @param questionindex
	 * @param model
	 * @return 컴파일 문제 풀이 페이지
	 */
	@GetMapping("javaCourse/compilerForm")
	public String compilerForm(
			@RequestParam(name="lessonid", defaultValue="0")int lessonid, 
			@RequestParam(name="questionindex", defaultValue="0")int questionindex, 
			Model model) {
		
		log.debug("lessonid : {}", lessonid);
		
		ArrayList<ContentsVO> chapterList = service.introdutionAll();
		String title = service.searchTitle(questionindex);
		
		model.addAttribute("title", title);
		model.addAttribute("chapterList", chapterList);
			
		ArrayList<ContentsVO> contentsList = service.selectContents(lessonid, questionindex);
		
		model.addAttribute("contentsList", contentsList);

		ArrayList<ProlingoQuestionVO> questionlist = qs.selectAllQuestionsByLessonID(lessonid);		
		
		model.addAttribute("lessonid", lessonid);
		model.addAttribute("questionindex", questionindex);
		model.addAttribute("questionlist", questionlist);
		
		String language = service.getLanguage(lessonid);
		
		log.debug("이 레슨의 언어 : {}", language);
		model.addAttribute("language", language);
		
		return "studyCourse/compilerForm";
	}
	
	@GetMapping("javaCourse/compilerForm2")
	public String compilerForm2(
			@RequestParam(name="lessonid", defaultValue="0")int lessonid, 
			@RequestParam(name="questionindex", defaultValue="0")int questionindex, 
			Model model) {
		log.debug("lessonid : {}", lessonid);
		
		ArrayList<ProlingoQuestionVO> questionlist = qs.selectAllQuestionsByLessonID(lessonid);		
		
		model.addAttribute("lessonid", lessonid);
		model.addAttribute("questionindex", questionindex);
		model.addAttribute("questionlist", questionlist);
		
		return "studyCourse/compilerForm2";
	}
	
	@GetMapping("javaCourse/compilerForm3")
	public String compilerForm3(
			@RequestParam(name="lessonid", defaultValue="0")int lessonid, 
			@RequestParam(name="questionindex", defaultValue="0")int questionindex, 
			Model model) {
		
		log.debug("lessonid : {}", lessonid);
		
		ArrayList<ContentsVO> contentsList = service.selectContents(lessonid);
		
		log.debug("받아온 contentsList 값 : {}", contentsList);
		
		model.addAttribute("contentsList", contentsList);

		ArrayList<ProlingoQuestionVO> questionList = qs.selectAllQuestionsByLessonID(lessonid);		
		
		model.addAttribute("lessonid", lessonid);
		model.addAttribute("questionindex", questionindex);
		model.addAttribute("questionList", questionList);
		
		return "studyCourse/compilerForm3";
	}
}