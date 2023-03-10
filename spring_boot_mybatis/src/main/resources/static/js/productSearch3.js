/**
 * 
 */
$(document).ready(function(){
 	$('#prdSearchFrm').on('submit', function(){ //productSearchForm1의id 갖고옴
 		event.preventDefault();
		
		// 폼에 입력한 값들을 쿼리 스트링 방식의 데이터로 변환 : serialize() 사용
		// type=prdName&keyword=노트북 형식으로 만들어서 전송
		var formData = $(this).serialize(); //VO 안쓰고 한꺼번에 보낼 때
		// 이렇게 보내고 컨트롤러에서 HashMap으로 받음
		
		
 		// 서버에 전송하고 결과 받아서 처리
 		$.ajax({
 			type:"post",
 			url:"productSearch3",
 			data: formData, //위에 선언해준 것 (var formData)
 			success:function(result){
 				// 컨트롤러가 ArrayList를 반환한 것을 result로 받음
 				// <div id="searchResultBox">에 테이블 형태로
 				// 받은 개수만큼 반복문으로 출력
 				$('#searchResultBox').empty(); // 이전 내용 지우고
 				// 테이블 제목 출력
 				$('#searchResultBox').append('<table id="resultTable" border="1" width="600">' + 
						'<tr><th>상품번호</th><th>상품명</th><th>가격</th><th>제조사</th>' + 
						'<th>재고</th><th>제조일</th><th>사진</th></tr>');
						
				// 검색 결과 없는 경우
				if(result == ""){
					$('#resultTable').append('<tr align="center"><td colspan="6">찾는 상품이 없습니다</td></tr>');
				}else{ //검색 결과가 있으면
					for(var i=0; i < result.length; i++){
						$('#resultTable').append('<tr><td>' + result[i].prdNo + '</td><td>' +
															  result[i].prdName + '</td><td>' +
															  result[i].prdPrice + '</td><td>' +
															  result[i].prdCompany + '</td><td>' +
															  result[i].prdStock + '</td><td>' +
															  result[i].prdDate + '</td></tr>');
					
					}
				}	
				$('#searchResultBox').append('</table>');	
 			},
 			error:function(){
 				alert("실패");
 			}
 		}); // ajax 종료 	
 	});// submit 종료
});
 