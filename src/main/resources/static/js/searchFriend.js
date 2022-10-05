/**
 * 친구 찾기 기능의 script문
 */
 
 $(document).ready(function() {
		
		$('#searchWord').keyup(friendList);
		$('#searchWord').keyup(notFriendList);
		
		notFriendList();
		friendList();
		
	});
		
	
	function friendList(){
		
		console.log('키 입력');
		let searchWord = $('#searchWord').val();
			
		$.ajax({
				url:'friendList',
				type:'get',
				data:{ searchWord : searchWord},
				dataType:'json',
				async: false,
				success: friend,
				error: function(e){
					console.log('ajax실패');
					console.log(JSON.stringify(e));	
				}
		});	
	}
	
	function notFriendList(){
		
		console.log('키 입력');
		let searchWord = $('#searchWord').val();
			
		$.ajax({
				url:'notFriendList',
				type:'get',
				data:{ searchWord : searchWord},
				dataType:'json',
				async: false,
				success: notFriend,
				error: function(e){
					console.log('ajax실패');
					console.log(JSON.stringify(e));	
				}
		});	
	}
	
	function friend(friendList){
		
		console.log('friend 함수 내의 memberList' + friendList);
		
		let str;
		$.each(friendList, function(index, item){
			str+='<div class="profile card radius-15 col-3 bt-50">';
			str+='<div class="card-body text-center">';
			str+='<div class="searchForm p-3 border radius-15">';
			str+='<img th:src="@{/img/avatars/avatar.jpg}" th:alt="@{/img/avatars/basicprofilePhoto.png}" width="110" height="110" class="rounded-circle shadow">';
			str+='<a href="" class="profileLink">&nbsp;' + item.user_name + '</a>';
			str+='<p>'+ item.email +'</p>';
			str+='<div class="d-grid"> <button class="btn btn-primary radius-15" id="unFollow"><i class="bi bi-person-dash"></i> 친구취소</button>';
			str+='</div></div></div></div>';
			});

		$('#output1').html(str);
	}
	
	
	function notFriend(notFriendList){
		
		console.log('friend 함수 내의 memberList' + notFriendList);
		
		let str;
		$.each(notFriendList, function(index, item){
			str+='<div class="profile card radius-15 col-3 bt-50">';
			str+='<div class="card-body text-center">';
			str+='<div class="searchForm p-3 border radius-15">';
			str+='<img th:src="@{/img/avatars/avatar.jpg}" th:alt="@{/img/avatars/basicprofilePhoto.png}" width="110" height="110" class="rounded-circle shadow">';
			str+='<a th:href="@{/profile(user_id=${ + ' + item.user_id + '})}" class="profileLink">&nbsp;' + item.user_name + '</a>';
			str+='<p>'+ item.email +'</p>';
			str+='<div class="d-grid"> <button class="btn btn-outline-primary radius-15" id="follow"><i class="bi bi-person-plus"></i> 친구추가</button>';
			str+='</div></div></div></div>';
			});

		$('#output2').html(str);
	}