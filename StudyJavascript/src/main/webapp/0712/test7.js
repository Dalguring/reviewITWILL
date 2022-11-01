/**
 *외부자바스크립트 파일 
 */
 var correctNum = 10; //정답
 var count = 0;
 function checkNumGame() {
	//자바스크립트의 var은 변수 선언 전에 미리 변수 사용도 가능함(undefined값 저장됨)
	while(i != correctNum) {
		var i = prompt("숫자를 입력하세요");
		if(i < correctNum) {
			alert("입력받은 숫자보다 큽니다!");
		} else if(i > correctNum) {
			alert("입력받은 숫자보다 작습니다!");
		} else if(i == correctNum) {
			alert("정답입니다!");
		}
		
		count++;
	}	
}