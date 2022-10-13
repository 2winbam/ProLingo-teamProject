package net.softsociety.testboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentsVO {

	int content_id; // 개념 식별 아이디 (seq로 nextval값을 넣을 예정, 슬라이드 정렬을 하는 기준)
	int lesson_id; // 학습 아이디(학습페이지 식별을 위해서 사용, 슬라이드를 조회시 기준이 되기도 함)
	String lesson_title; // 해당 학습의 제목(ex. '시작하기')
	int lesson_slide; // 슬라이드의 번호
	String lesson_subtitle; // 해당 슬라이드의 소제목(ex. 시작하기 - '코드 작성을 배워봅시다.')
	String lesson_contents; // 해당 슬라이드의 내용
	String lesson_picture; // 사진 경로
}
