/**
 * 
 */
// 코드미러 실행
$(document).ready(function() {

	//컴파일러 호출을 위한 현재 학습중인 언어 설정
	//setDefaultCode($('#language').attr(rang));
	//console.log($('#defaultcode').attr('dcode'));
	//var defaultcode1 = $('#defaultcode').attr('dcode');
	//var defaultcode2 = 'class Main{\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}';
	//$('#codemirror').val($('#defaultcode').attr('dcode'));
	//console.log(defaultcode1.length);
	//console.log(defaultcode1.replaceAll('\\n', '\n').replaceAll('\\t', '\t').replaceAll('\\"', '\"').length);
	//console.log(defaultcode2.length);

	var defaultcode = codechange($('#info').attr('dcode'));
	//$('#codemirror').val(defaultcode1.replaceAll('\\n', '\n').replaceAll('\\t', '\t').replaceAll('\\"', '\"'));
	$('#codemirror').val(defaultcode);
	$('#codeAnswer').html(codechange($('#info').attr('acode')));
	$('#contentsText').html(codechange($('#info').attr('question')));

	//alert('연결?');
	const codemirrorEditor = CodeMirror.fromTextArea(
		document.getElementById("codemirror"), {
		//코드미러 세부설정

		//라인 번호
		lineNumbers: true,
		//테마
		theme: 'monokai',
		//자바 모드
		mode: "text/x-java",
		readOnly: false,
		lineWrapping: true,
		matchBrackets: true,
		styleActiveLine: true,
		autoCloseBrackets: true,
		autoRefresh: true,
		autoCloseTags: true,
	});

	console.log(codemirrorEditor.getValue());
	// 학습 리스트를 보여주는 모달을 불러옴
	$('#pageList').click(function() {
		$('#learningModal').fadeIn();
	});

	//모달창 바로 띄우기
	$('.modal-lesson').fadeIn();

	//모달창 클릭시 닫기
	$('.contentClose').click(function() {
		$('.modal-lesson').fadeOut();
	});

	//슬라이드 돌아가기 버튼
	$('.callModal').click(function() {
		$('.modal-``').fadeIn();
	});

	//submit 버튼을 누른후 나오는 결과 모달창을 불러옴
	$('#resultSubmit').click(function() {
		let language = $('#info').attr('lang');
		let code = codemirrorEditor.getValue();
		//let code = $('#codeAnswer').html();
		//console.log(code);

		//컴파일용 ajax
		$.ajax({
			url: '/prolingo/compile',
			type: 'post',
			data: { language: language, code: code },
			dataType: 'text',
			success: function(res) {
				console.log("compile ajax 성공");
				$('#resultText').html(res);

				if (isCorrect(res)) {
					$('#resultModal').fadeIn();
				}
				else {
					$('#falseModal').fadeIn();
				}
			},
			error: function(e) {
				alert("compile ajax 실패 : " + e);
			}
		});

	});
	//$('#resultSubmit').click(submitClick);

	//리셋 버튼 클릭
	$('#reset').click(function() {
		codemirrorEditor.setValue(defaultcode);
	});
	//넥스트 버튼 클릭
	$('#nextButton').click(nextpage);

	//모달창을 닫는 버튼( 모든 모달창에서 사용됨 )
	$('.resultClose').click(function() {
		$('#resultModal').fadeOut();
		$('#answerModal').fadeOut();
		$('#learningModal').fadeOut();
		$('#falseModal').fadeOut();
	});

	//정답 모달창 띄우기('#answerButton', '#seeAnswer')
	//같은 기능이라 같은 아이디로 실행하려고 하였으나 한쪽만 실행되는 문제가 발생해서 분리시킴
	$('#answerButton').click(function() {
		$('#resultModal').fadeOut();
		$('#answerModal').fadeIn();

	});

	$('#seeAnswer').click(function() {
		$('#resultModal').fadeOut();
		$('#answerModal').fadeIn();

	});

	//슬라이더
	$('.modal-lesson-wrapper').slick(
		{
			slidesToShow: 1,
			slidesToScroll: 1,
			speed: 100,
			autoplay: false,
			prevArrow: "<button type='button' class='slick-prev'><i class='bi bi-arrow-left-circle-fill'></i></button>", // 이전 화살표 모양 설정
			nextArrow: "<button type='button' class='slick-next'><i class='bi bi-arrow-right-circle-fill'></i></button>"
		});

	//	function submitClick() {
	//		
	//	}
});

//function setDefaultCode(lang) {
//	//alert(lang);
//	switch (lang) {
//		case "java":
//			//console.log("it is java");
//			$('#codemirror').val(
//				"class Main{\n"
//				+ "\tpublic static void main(String[] args) {\n"
//				+ "\t\tSystem.out.println(\"Hello World!\");\n"
//				+ "\t}\n"
//				+ "}");
//			break;
//		case "c":
//			//console.log("it is c");
//			$('#codemirror').val(
//				"#include <stdio.h>\n\n"
//				+ "int main() {\n"
//				+ "\tprintf(\"Hello World!\\n\");\n"
//				+ "\treturn 0;\n"
//				+ "}");
//			break;
//		default:
//			console.log("lang error");
//			break;
//	}
//}

//데이터 베이스에서 받아온 \를 출력하려고 자동으로 \가 하나씩 더 들어가는걸 다시 되돌려주는 용도
//다른 특수문자가 추가된다면 더 추가해야함, \\를 \로 바꿔주는건 \가 동작해버려서 못함
function codechange(code) {
	return code.replaceAll('\\n', '\n',).replaceAll('\\t', '\t').replaceAll('\\"', '\"');
}

//정답 체크 임시
function isCorrect(answer) {
	let result = codechange($('#info').attr('result'));
	//	console.log("결과 : " + answer + "정답 : " + result);
	//	console.log("결과 : " + typeof answer + "\n정답 : " + typeof result);
	//	console.log("결과 : " + answer.length + "\n정답 : " + result.length);

	if (result == answer) {
		//alert("정답!");
		return true;
	}
	else {
		//alert("오답!");
		return false;
	}

}

//다음 페이지로 가는데 index가 초과되면 과정 선택 페이지로
function nextpage() {
	//alert('gd');
	let currlesson = $('#info').attr('lid');
	let currindex = $('#info').attr('index');
	let indexmax = $('#info').attr('listlength');

	let currurl = $('#info').attr('currurl');

	currindex = Number(currindex);
	currindex++;

	if (currindex < indexmax) {
		location.href = currurl + "?lessonid=" + currlesson + "&questionindex=" + currindex;
	}
	else {
		location.href = "./";
	}
}

