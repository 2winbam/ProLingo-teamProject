package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.domain.ProlingoKeywordVO;
import net.softsociety.testboot.domain.ProlingoQuestionVO;
import net.softsociety.testboot.service.MemberService;
import net.softsociety.testboot.service.QuestionService;

@Controller
@Slf4j
@ResponseBody
public class QuestionController {

	@Autowired
	QuestionService qs;
	
	@Autowired
	MemberService ms;
	
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
		
		ArrayList<ProlingoQuestionVO> questionList = qs.selectAllQuestionsByLessonID(lessonid);
		
		return questionList;
	}
	
	/**
	 * 
	 * @param lessonid 지금은 question 아이디만 알면 필요 없지만 나중에 lessonid, index 복합키로 바꾼다면 필요
	 * @param questid
	 * @return
	 */
	@PostMapping("lessoncomplite")
	public String lessoncomplite(int lesson_id, int question_id, @AuthenticationPrincipal UserDetails user) {
		log.debug("레슨 : {} 퀘스쳔 : {}", lesson_id, question_id);
		
		//로그인 한 유저가 있으면
		if(user != null) {
			//lesson의 question을 이미 완료했는지 확인하는 코드 필요
			
			//완료하지 않은 문제였다면
			//그 유저의 경험치를 10만큼 추가
			int result = ms.updateUserExp(user.getUsername(), 10);
			int result2 = ms.updateUserExpDay(user.getUsername(), 10);
			//log.debug("user값 : {}",user.getUsername());
			//성공시
			if(result != 0) {
				//경험치를 확인하기 위해
				MemberVO member = ms.getMemerInfo(user.getUsername());
				
				return "user " + member.getUser_name() + "의 경험치 : " + member.getUser_exp();
			}
			else {
				return "lessoncomplite fail";
			}
			
			//완료한 문제였다면
			//return "이미 경험치 획득한 문제";
		}
		
		return "로그인 한 유저 없음";
	}
	
	@PostMapping("getkeywords")
	ArrayList<ProlingoKeywordVO> getkeywords(String kewords){
		log.debug("문제 키워드들 : {}", kewords);
		
		ArrayList<ProlingoKeywordVO> keywordnames = qs.selectAllKeywordsName(kewords);
		
		return keywordnames;
	}
}
