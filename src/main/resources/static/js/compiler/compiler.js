/**
 * 
 */
// 코드미러 실행
//이거 함수명 넣은 이유?
$(document).ready(function codemirror() {

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

	// 학습 리스트를 보여주는 모달을 불러옴
	$('#pageList').click(function() {
		$('#learningModal').fadeIn();
	});


	//모달창 클릭시 닫기
	$('.contentClose').click(function() {
		$('.modal-lesson').fadeOut();
	});

	//슬라이드 돌아가기 버튼
	$('.callModal').click(function() {
		$('.modal-lesson').fadeIn();
	});

	//submit 버튼을 누른후 나오는 결과 모달창을 불러옴
	//함수 따로 빼겠습니다
//	$('#resultSubmit').click(function() {
//		
//		$('#resultModal').fadeIn();
//	});
	$('#resultSubmit').click(submitClick);

	//모달창을 닫는 버튼( 모든 모달창에서 사용됨 )
	$('.resultClose').click(function() {
		$('#resultModal').fadeOut();
		$('#answerModal').fadeOut();
		$('#learningModal').fadeOut();
	});


	//모달창 바로 띄우기
	$('.modal-lesson').fadeIn();


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

});

function submitClick(){
	//alert('submit clicked');
	
	//만들어둔게 있으니까 넣겠습니다.
	//컴파일용 ajax
	let language = 'java';
	let code = $('#codeAnswer').val();
	$.ajax({
		url: 'compile',
		type: 'post',
		data: {language: language, code: code},
		dataType:'text',
		success: function(res){
			console.log("compile ajax 성공")
			$('#resultText').html(res);
		},
		error: function(e){
			alert("compile ajax 실패 : " + e);
		}
	});
	
	$('#resultModal').fadeIn();
}