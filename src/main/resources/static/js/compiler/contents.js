/**
 * 개념 슬라이드를 불러오는 스크립트문
 */
 
 $(document).ready(function() {

		contents();
	});
	
	function contents(){
		
		$.ajax({
			url:'../contentsList',
			type:'get',
			dataType:'json',
			success: output,
			error: function(e){
				console.log(JSON.stringify(e));
			}
		});
	}
	
	function output(ob){
		
		console.log(ob);
		
		let s = '';

		$.each(ob, function(index ,item){
			s += '<div class="modal-lesson-content">';
			s += '<div class="modal-lesson-header d-flex justify-content-end">';
			s += '<a class="contentClose"><span aria-hidden="true"><i class="bi bi-x-circle-fill"></i></span></a></div>';
			s += '<div class="modal-lesson-body">';
			s += '<div class="d-flex flex-row justify-content-center">';
			s += '<div class="contents modal-lesson-body-title"><h3>' + item.lesson_subtitle + '</h3></div>';
			s += '<div class="contents modal-lesson-body-content">';
			s += '<p class="slide-top__description"><span>' + item.lesson_contents + '</span></p></div></div>';
			s += '<div class="slide__SlideBottom-z90lcr-1 wNtlP">';
			s += '<div class="slide_bottom_items__SlideBottomItems-sc-1g258za-0 cVxUeS">';
			s += '<div class="slide_bottom_items__SlideBottomItemsInnerWrapper-sc-1g258za-1 eIFOJW">';
			s += '<div class="slide_bottom_items__SlideBottomItem-sc-1g258za-2 kDyeWH">';
			s += '<div class="u-inline"><div class="u-relative"><img class="slide_image1" th:src="' + item.lesson_picture +'"></div></div></div></div></div></div></div></div>';
		});
		$('#slider').html(s);
	}
		