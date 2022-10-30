package typecasting;

public class Ex5 {

	public static void main(String[] args) {
		int a = 10, b = 5;
		System.out.println("a > b 인가?" + (a > b));
		System.out.println("a < b 인가?" + (a < b));
		System.out.println("a >= b 인가?" + (a >= b));
		System.out.println("a <= b 인가?" + (a <= b));
		System.out.println("a == b 인가?" + (a == b));
		System.out.println("a != b 인가?" + (a != b));

		boolean bool = (a == b);
		System.out.println(bool);
		System.out.println("========================================");
		//char 타입을 비교연산자에 사용 시 정수(유니코드)값을 비교
		System.out.println('A' > 'B');
//		System.out.println("A" > "B"); 문자열은 비교가 불가능함
		System.out.println('A' == 65);
		System.out.println(3 == 3.0); //이 식도 연산이므로 3 이 double의 3.0으로 변해서 같음
		System.out.println(0.1 == 0.1f);//근사치 표현에 의해서 서로 다른값으로 취급됨 !float에서 f를 붙이면 float으로 고정되므로 더 많은 소숫점이하 자리를 표현하는 double과 다름
		
		System.out.println((float)0.1 == 0.1f);
		
	}

}
