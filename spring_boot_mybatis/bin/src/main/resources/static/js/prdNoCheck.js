/**
 * 
 */
$(document).ready(function(){
 	$('#prdNoCheckBtn').on('click', function(){ 	
 		event.preventDefault();

 		// 서버에 전송하고 결과 받아서 처리
 		$.ajax({
 			type:"post",
 			url:"prdNoCheck",
 			data: {"prdNo":$('#prdNo').val()}, //여기 붙여도 됨.
 			dataType:'text',
 			success:function(result){
 				if(result == "no_use"){ //문자열비교니까 text (컨트롤러에서 확인 가능)
 					alert("사용할 수 없는 번호입니다.");
 				}else{
 					alert("사용 가능한 번호입니다.");
 				}
 			},
 			error:function(){
 				alert("실패");
 			},
 			complete:function(){
 				//alert("작업 완료");  //귀찮아서 주석처리
 			}
 		}); // ajax 종료 	
 	});// submit 종료
});
 