/**
 * 
 */
$(document).ready(function() {
	//alert("hi");
	
	$('#errorEmail').html('');
	$('#errorPassword').html('');
	$('#errorLogin').html('');

	$('#email').keyup(emailCheck);
	$('#password').keyup(passwordCheck);
	$('#loginbtn').click(loginCheck);
	//$('#logoutbtn').click(onSignout);
	
	//for google login
	google.accounts.id.disableAutoSelect();
	google.accounts.id.initialize({
		client_id: "969064842874-ido7rmd0p911v3mq4gi7jk2dggfesv8n.apps.googleusercontent.com",
		callback: handleCredentialResponse
	});
	google.accounts.id.renderButton(
		document.getElementById("buttonDiv"),
		{ theme: "outline", size: "large", width: 400}  // customization attributes
	);
	//google.accounts.id.prompt(); // also display the One Tap dialog
});

//이메일 입력시 체크해서 메세지 띄우는 함수
function emailCheck(key) {
	//console.log($('#floatingInput').val());
	if (!IsEmail($('#email').val())) {
		$('#errorEmail').html('올바른 이메일 형식이 아닙니다');
	}
	else {
		$('#errorEmail').html('');
	}
	
	if (key.keyCode == 13) {
		//alert("엔터키를 눌렀습니다.");
		$('#password').select();
	}
}

//https://www.tutorialspoint.com/How-to-validate-email-using-jQuery
//에서 가져옴, 이메일 형식이 맞는지 체크해 주는 함수
function IsEmail(email) {
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!regex.test(email)) {
		return false;
	} else {
		return true;
	}
}

//비밀번호 입력시 체크해서 메세지 띄우는 함수
function passwordCheck(key) {
	if ($('#password').val().length < 8) {
		$('#errorPassword').html('비밀번호는 8자리 이상 입니다');
	}
	else {
		$('#errorPassword').html('');
	}
	
	if (key.keyCode == 13) {
		//alert("엔터키를 눌렀습니다.");
		$('#loginbtn').click();
	}
}

//로그인 버튼 클릭시 ajax로 이메일과 비밀번호로 select
//값이 없다면 에러 메세지, 값이 있다면 summit();
//DB 구현 이후에 테스트 가능
function loginCheck() {
	//alert('안냥');
	let email = $('#email').val();
	let password = $('#password').val();

	$.ajax({
		url: 'logincheck',
		type: 'post',
		data: { email: email, user_pw: password },
		//생략해서 숫자로 받아옴
		//dataType: 'text',
		success: function(res) {
			//alert("성공 : " + res);
			//select문에서 아이디 혹은 0이 돌아옴
			if (res != 0) {
				//alert(res);
				//hidden인 id에 id값을 넣어서 섭밋
				$('#userid').val(res);
				$('#loginForm').submit();
			}
			else if (res == 0)  {
				//상황마다 다르게?
				//alert("0");
				$('#errorLogin').html('메일 주소 혹은 비밀번호가 틀렸습니다');
			}
		},
		error: function(e) {
			alert("로그인 ajax 실패 : " + e.status);
			//$('#errorLogin').html('메일 주소 혹은 비밀번호가 틀렸습니다');
		}
	});
}

//여유 되면 자동 로그인도 구현할 것

//로그아웃 위해?
let currentId;
//구글 로그인 긁어온것
function handleCredentialResponse(response) {
	console.log("Encoded JWT ID token: " + response.credential);
	console.log("select_by: " + response.select_by);
	
	//console.log(parseJwt(response.credential));
	// decodeJwtResponse() is a custom function defined by you
    // to decode the credential response. 
    const responsePayload = decodeJwtResponse(response.credential);

    console.log("ID: " + responsePayload.sub);
    console.log('Full Name: ' + responsePayload.name);
    console.log('Given Name: ' + responsePayload.given_name);
    console.log('Family Name: ' + responsePayload.family_name);
    console.log("Image URL: " + responsePayload.picture);
    console.log("Email: " + responsePayload.email);
    
    loginAjaxTest(response.credential);
}

//현재 로그인 되어 있는 아이디(responsePayload.sub)을 받아올 수 있어야함
//새로고침이 되어야함
function onSignout() {
	//alert(currentId);
    google.accounts.id.disableAutoSelect();
//    google.accounts.id.revoke(currentId, done => {
//    	console.log(done.error);
//    });
}

const parseJwt = (token) => {
  try {
    return JSON.parse(atob(token.split('.')[1]));
  } catch (e) {
    return null;
  }
};

//token decode하는 함수
//https://stackoverflow.com/questions/38552003/how-to-decode-jwt-token-in-javascript-without-using-a-library
function decodeJwtResponse(token){
	var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}

//구글 로그인시 ajax
function loginAjaxTest(token){
	console.log("ajax 들어옴");
	$.ajax({
		url: 'getTokenTest',
		type: 'post',
		data: { token: token },
		dataType: 'text',
		success: function(res) {
			//alert("성공 : " + res);
			console.log(res);
		},
		error: function(e) {
			alert("ajax 실패 : " + e.status);
		}
	});
}

//구글 로그인 테스트