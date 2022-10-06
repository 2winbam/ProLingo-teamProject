/**
 * 친구 찾기 기능의 script문
 */
 
 $(document).ready(function() {
		
		$('#searchWord').keyup(notFriendList);
		notFriendList();
		
		
	});
	
	function followFriend(user_id){
		console.log('버튼 실행');
		console.log(user_id);
		location.href='followFriend?user_id='+user_id;
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
	
	function notFriend(notFriendList){
		
		console.log('friend 함수 내의 memberList' + notFriendList);
		
		let str = '';
		$.each(notFriendList, function(index, item){
			console.log(item);
			str+='<div class="profile card radius-15 col-2 bt-50">';
			str+='<div class="card-body text-center">';
			str+='<div class=" p-3 border radius-15">';
			str+='<img src="prolingo/img/avatars/' + item.photo +'" alt="/img/avatars/basicprofilePhoto.png" width="110" height="110" class="rounded-circle shadow">';
			str+='<a href="friendProfile?user_id=' + item.user_id + '" class="profileLink">&nbsp;' + item.user_name + '</a>';
			str+='<p>'+ item.email +'</p>';
			str+='<div class="d-grid"> <button class="btn btn-outline-primary radius-15" id="follow" ';
			str+='user_id="'+ item.user_id +'" onclick="javascript:followFriend(' + item.user_id + ')"><i class="bi bi-person-plus"></i> 친구추가</button>';
			str+='</div></div></div></div>';
			});
			
		$('#output2').html(str);
	}