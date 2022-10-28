
public class Ex1 {

	public static void main(String[] args) {
//		삼항 연산자의 중첩사용
//		조건식1 ? 값1 : 조건식2 ? 값2 : 값3;
//		ex)홀수, 짝수, 0의 3가지 경우의 수 판별
		int num = 2;
		String result = (num == 0) 		? "0"	: 
						(num % 2 == 0)	? "짝수"	: "홀수";
		System.out.println(result);
		
		
		
	}

}
