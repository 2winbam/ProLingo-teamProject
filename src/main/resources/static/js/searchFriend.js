/**
 * 친구 찾기 기능의 script문
 */
 
 $(document).ready(function() {
		
		searchList();
		$('#searchWord').keyup(searchList);

	});
	
	function searchList(){
		
		console.log('키 입력');
		let searchWord = $('#searchWord').val();
			
		$.ajax({
				url:'searchList',
				type:'post',
				data:{ searchWord : searchWord},
				dataType:'json',
				success: output,
				error: function(e){
					console.log(JSON.stringify(e));	
				}
		});	
	}
		
	function output(memberList){
		
		let str;
		$.each(memberList, function(index, item){
			str+='<div class="col-md-8">';
			str+='<div class="people-nearby"><div class="nearby-user"><div class="row"><div class="col-md-2 col-sm-2">';
			//str+='<img src="' + item.photo + '" alt="user" class="profile-photo-lg">';
			str+='</div><div class="col-md-7 col-sm-7">';
			str+='<h5><a href="" class="profile-link">' + item.user_name + '</a></h5>';
			str+='<p>' + item.email + '</p></div>';
			str+='<div class="col-md-3 col-sm-3"> <button class="btn btn-primary pull-right">Add Friend</button></div></div></div></div></div>';
			});
		$('#output').html(str);
	}
