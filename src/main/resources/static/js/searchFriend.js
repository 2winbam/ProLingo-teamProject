/**
 * 친구 찾기 기능의 script문
 */
 
 $(document).ready(function() {
		
		friendList();
		$('#searchWord').keyup(friendList);

	});
	
	function friendList(){
		
		console.log('키 입력');
		let searchWord = $('#searchWord').val();
			
		$.ajax({
				url:'friendList',
				type:'get',
				data:{ searchWord : searchWord},
				dataType:'json',
				success: friend,
				error: function(e){
					console.log(JSON.stringify(e));	
				}
		});	
	}
		
	function friend(memberList){
		
		let str;
		$.each(memberList, function(index, item){
			str+='<div class="profile card radius-15 col-2 bt-50">';
			str+='<div class="card-body text-center">';
			str+='<div class="p-3 border radius-15">';
			str+='<img th:src="@{'+ item.photo +'}" th:alt="@{/img/avatars/basicprofilePhoto.png}" width="110" height="110" class="rounded-circle shadow">';
			str+='<a href="" class="profileLink">' + item.user_name + '</a>';
			str+='<a href=""  class="">'+ item.email +'</a>';
			str+='<div class="d-grid"> <button class="btn btn-outline-primary radius-15"><i class="bi bi-person-plus"></i> 친구추가</button>';
			str+='</div></div></div></div>'
			});
			
		$('#output').html(str);
	}
