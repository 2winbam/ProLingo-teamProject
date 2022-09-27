/**
 * 
 */
 
  $(document).ready(function() {
		
		contents();
	});
	
	function contents(){
		
		console.log('개념 출력');
			
		$.ajax({
			url:'contentsList',
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
		/*
		$.each(ob, function(index ,item){
			s += '<div class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">';
			s += '<img th:src=' + item.A_icon + 'alt="twbs" width="50" height="50" class="rounded-circle flex-shrink-0">';
			s += '<div class="d-flex gap-2 w-100 justify-content-between">';
			s += '<div><h6 class="mb-0">' + item.A_name + '</h6>';
			s += '<p class="mb-0 opacity-75">' + item.A_text + '</p></div>';
			s += '<small class="opacity-50 text-nowrap">' + item.A_date + '</small></div></div>';
		});
		$('#output').html(s); 
		
		$.each(ob, function(index ,item){
			s += '<div class="modal-lesson-content">';
			s += '<div class="modal-lesson-header d-flex justify-content-end">';
			s += '<a class="contentClose">';
			s += '<span aria-hidden="true"><i class="bi bi-x-circle-fill"></i></span>';
			s += '</a></div><div class="modal-lesson-body">';
			s += '<h2>'+ item.LESSON_SUBJECT +'</h2>';	
			s += '<div class="modal-lesson-body-content">';
			s += '<p class="slide-top__description"><span><font style="vertical-align: inherit;">';
			s += '<font style="vertical-align: inherit;">' + item.LESSON_CONTENTS + '</font></font></span><br>' 
							<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">처음 듣는 단어도 많이 어렵다고 느낄 수도 있을지도 모릅니다만, </font></font></span><br> <span><font
								style="vertical-align: inherit;"><font
									style="vertical-align: inherit;">하나하나 순서를 쫓아 배워 가므로, 끝까지
										노력해 갑시다.</font></font></span><br> <span></span>
						</p>
					
					</div>
						<div class="slide__SlideBottom-z90lcr-1 wNtlP">
							<div
								class="slide_bottom_items__SlideBottomItems-sc-1g258za-0 cVxUeS">
								<div
									class="slide_bottom_items__SlideBottomItemsInnerWrapper-sc-1g258za-1 eIFOJW">
									<div 
										class="slide_bottom_items__SlideBottomItem-sc-1g258za-2 kDyeWH">
										<div class="u-inline">
											<div class="u-relative">
												<img data-id="1377"
													class="slide_image1"
													src="https://d2aj9sy12tbpym.cloudfront.net/progate/shared/images/slide/java/study/1/1464330632364.png">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
		*/
		
	}
		