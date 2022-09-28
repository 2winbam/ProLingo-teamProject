package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.BoardVO;
import net.softsociety.testboot.domain.PageNavigator;
import net.softsociety.testboot.service.BoardService;


@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//게시판 페이지 당 출력할 글수
	@Value("${user.board.page}")
	int countPerPage;
		
	//게시판 목록의 페이지 이동 링크 수
	@Value("${user.board.group}")
	int pagePerGroup;
	
	
	/**
	 * 글 전체 불러오기
	 * @return
	 */
	@GetMapping("/list")
	public String getBoardList(@RequestParam(value = "page", defaultValue = "1")int page,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "searchWord", required = false) String searchWord,
			@RequestParam(value = "mode", required = false) String mode, Model model) {
		log.debug("getBoardList() called");
		log.debug("페이지당 글수:{}, 페이지이동 링크수{}, page : {}, type : {}, searchWord : {}, mode : {}"
				,countPerPage, pagePerGroup, page, type, searchWord, mode);
		
		//PageNavigator navi = service.getgetPageNavigator(page, type, searchWord);
		
		//ArrayList<BoardVO> boardList = service.boardListAll(navi,type,searchWord);
		
		//model.addAttribute("navi", navi);
		model.addAttribute("type", type);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("mode", mode);
		
		return "boardView/boardList";
	}
	
	/**
	 * 글쓰기
	 * @return
	 */
	@GetMapping("/writeForm")
	public String writeForm() {
		log.debug("writeForm() called");
		return "boardView/writeForm";
	}
	
	
	
	
}
