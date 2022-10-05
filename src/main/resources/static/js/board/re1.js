$(document).ready(function () {
	$('#bt').click(function() {
		$.ajax({
			url:'vote',
			type:'get',
			data: {boardnum: $(this).attr('boardnum')},
			success: function(n) {
				//화면에 추천수 갱신
				$('#cnt').html(n); //html 함수는 지정한 값의 내용을 지우고 들어간다.
			},
			error: function() {
				alert('error');
			}
		});
	});
});