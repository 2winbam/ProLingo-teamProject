package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.dao.BoardDAO;
import net.softsociety.testboot.domain.BoardVO;
import net.softsociety.testboot.domain.BoardWithName;
import net.softsociety.testboot.domain.PageNavigator;
import net.softsociety.testboot.service.BoardService;
import net.softsociety.testboot.service.MemberService;


@Slf4j
@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	MemberService memberservice;
	
	@Autowired
	BoardDAO dao;
	
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
	@GetMapping("list")
	public String getBoardList(@RequestParam(value = "page", defaultValue = "1")int page,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "searchWord", required = false) String searchWord,
			@RequestParam(value = "mode", required = false) String mode, 
			Model model) {
		log.debug("getBoardList() called");
		log.debug("페이지당 글수:{}, 페이지이동 링크수{}, page : {}, type : {}, searchWord : {}, mode : {}"
				,countPerPage, pagePerGroup, page, type, searchWord, mode);
		
		
		PageNavigator navi = service.getgetPageNavigator(pagePerGroup, countPerPage, page, type, searchWord);
		
		//DB의 게시판 테이블의 모든 글을 읽기
		//ArrayList<BoardVO> boardList = service.boardListAll(navi,type,searchWord);
		ArrayList<BoardWithName> boardList = service.boardListAll(navi,type,searchWord);
		
		
		//ArrayList<Board> 타입으로 모델에 저장
		model.addAttribute("navi", navi);
		model.addAttribute("type", type);
		model.addAttribute("boardlist", boardList);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("mode", mode);
		
		return "boardView/boardList";
	}
	
	/**
	 * 글쓰기
	 * @return
	 */
	@GetMapping("writeForm")
	public String writeForm() {
		log.debug("writeForm() called");
		return "boardView/writeForm";
	}

	/**
	 * 글저장
	 */
	@PostMapping("writeForm")
	public String writeForm(
			BoardVO board
			, @AuthenticationPrincipal UserDetails user // 로그인한 사용자 정보 전달
			) {
		String id = user.getUsername(); // id 읽어서
		int boardID = Integer.parseInt(id);
		//board.setBoard_id(boardID);
		board.setUser_id(boardID); // userid입니다
		
		
		
		log.debug("저장할 글 정보: {}", board);
		
		service.writeBoard(board);
		
		//return "boardView/boardList";
		return "redirect:list";
		
	}
	
	/**
	 * 글 읽기
	 */
	@GetMapping("read")
	public String read(@RequestParam(name="board_id", defaultValue="0") int board_id, Model model) {
		log.debug("read() called");
		
		BoardWithName board = service.boardNum(board_id);
		
		log.debug("가져온 값 : {}", board);
		
		if(board == null) {				
			return "redirect:list";
		}
		
		//조회수 증가
		service.updateHits(board_id);
		
		//현재 글의 리플 목록 읽기

		
		//결과를 모델에 담아서 html에 출력
		model.addAttribute("writingRead", board);
		//model.addAttribute("replylist", replylist);
			
		return "boardView/read";
	}
	
}
