/**
 * 
 */
$(document).ready(function() {
	$('paybtn').click(upgradeToPlus);
});
/**
백엔드에서 현재 로그인 중인 유저의 등급을 바꿔줌
딱히 
 */
function upgradeToPlus(){
	//
	//
	$.ajax({
		url: 'upgradeToPlus',
		type: 'get',
		dataType: 'text',
		success: function(res) {
			//alert("성공 : " + res);
			//select문에서 1혹은 0이 돌아올 것이다
			if (res) {
				//$('#loginForm').submit();
			}
			else {
				//상황마다 다르게?
				$('#errorPassword').html('메일 주소 혹은 비밀번호가 틀렸습니다');
			}
		},
		//controller쪽 구현이 안되어 있기 때문에 여기에서 테스트
		error: function(e) {
			alert("로그인 ajax 실패 : " + e.status);
			$('#errorLogin').html('메일 주소 혹은 비밀번호가 틀렸습니다');
		}
	});
}