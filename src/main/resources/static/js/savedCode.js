/**
 * 
 */
 
 // 코드미러 실행
$(document).ready(function() {
	/*
	var defaultcode = codechange($('#info').attr('dcode'));
	$('#codemirror').val(defaultcode);
	$('#codeAnswer').html(codechange($('#info').attr('acode')));
	$('#contentsText').html(codechange($('#info').attr('question')));
	*/
	//alert('연결');
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
})