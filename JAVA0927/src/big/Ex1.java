package big;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * BigInteger, BigDecimal 클래스
		 * - java.math 패키지
		 * - 수치데이터를 처리하는 부가적인 클래스
		 * - 아주 큰 정수 또는 실수를 저장하거나, 실수의 문제점을 해결하는 용도로 사용
		 * 
		 * 1. BigInteger 클래스 (금융권)
		 * - 정수의 최대 크기(long 타입이라고 가정)는 약 922경인데
		 * 	 이보다 크거나 작은 정수는 취급이 불가능한 문제점이 발생하여
		 * 	 이를 해결할 용도로 별도로 추가된 클래스(정수 기본형 데이터타입을 확장한 클래스)
		 * - 객체 생성 시 파라미터로 전달할 정수는 "문자열" 형태로 전달함
		 * - 정수 데이터를 내부적으로 int[] 타입으로 관리함
		 * - toString() 메서드 오버라이딩 되어있음
		 * - 일반적인 산술연산자를 사용한 연산은 불가능하며 반드시 메서드를 통해 연산 수행
		 * 	 => add(), subtract(), multiply(), divide() 등 산술연산 메서드 제공
		 * 
		 * 2. BigDecimal 클래스 (공장, 생산)
		 * - 실수 기본형 데이터타입을 확장한 클래스
		 * - 실수 표현 방식으로 인한 정확도의 문제를 해결하기 위해 만들어진 클래스
		 * - 실수 데이터를 내부적으로 char[] 타입으로 관리함
		 * - 주의사항! 객체 생성 시 기본 데이터타입 (float 또는 double)을 사용할 경우
		 * 	 값의 정확도가 떨어질 수 있으므로 문자열 형태로 생성하는 것을 추천함!
		 * 	 ex) new BigDecimal(1.1);	// 부정확한 실수가 저장됨
		 * 		 new BigDecimal("1.1");	// 정확한 실수가 저장됨
		 * - 기본적인 사용법(메서드)은 BigInteger 클래스와 거의 동일함
		 */
		
		Integer i = 10; // Wrapper 클래스 타입은 오토박싱/오토언박싱에 의해 자동 변환됨
//		BigInteger bi = 10; // BigInteger 클래스타입은 자동변환 지원 안됨
		// => 반드시 생성자를 통해 "문자열" 형태로 정수를 전달해야한다!
		
		BigInteger bi = new BigInteger("9999999999999999999999999999");
		// long 타입보다 큰 정수도 문자열 형태로 전달이 가능하며 접미사 불필요
		
		// toString() 메서드가 오버라이딩 되어 있으므로 출력이 간편함
		System.out.println(bi);
		
		// BigInteger -> 기본데이터타입으로 변환 : xxxValue() 메서드 사용
		int num = bi.intValue(); // BigInteger -> int로 변환(오버플로우 발생 가능성 있음)
//		System.out.println(num);

		// 두 정수의 연산
		BigInteger bi2 = new BigInteger("55555555555555555555");
		System.out.println("+ : " + bi.add(bi2));
		
		System.out.println("- : " + bi.subtract(bi2));
		
		System.out.println("* : " + bi.multiply(bi2));
		
		System.out.println("/ : " + bi.divide(bi2));
		
		System.out.println("%(remainder) : " + bi.remainder(bi2));
		// => 나머지 연산에서 두번째 피연산자가 음수일 경우 ArithmaticException 발생(예외)
		System.out.println("%(mod) : " + bi.mod(bi2));
		
		System.out.println("===============================================================");
		
		double d1 = 2.0;
		double d2 = 1.1;
		System.out.println(d1 - d2); // 2.0 - 1.1 = 0.8999999999999999 (= 정확하지 않음)
		
		// 기본 데이터타입으로 객체를 생성할 경우 => 값이 부정확할 수 있다!
//		BigDecimal bc1 = new BigDecimal(2.0);
//		BigDecimal bc2 = new BigDecimal(1.1);
		
		BigDecimal bc1 = new BigDecimal("2.0");
		BigDecimal bc2 = new BigDecimal("1.1");
		System.out.println(bc1);
		System.out.println(bc2);
		System.out.println(bc1 + " - " + bc2 + " = " + bc1.subtract(bc2));
		
		// 참고, 기본데이터타입 실수형 변수 데이터를 BigDecimal 객체로 변환하는 경우
		double d3 = 1.1;
//		BigDecimal bc3 = new BigDecimal(d3); // 기본데이터타입을 그대로 전달하면
//		System.out.println(bc3); // 문제 발생할 수 있음
		
		// double -> 문자열로 변환하여 BigDecimal 객체 생성하는 방법
//		BigDecimal bc3 = new BigDecimal(d3 + ""); // 널스트링과 결합
//		BigDecimal bc3 = new BigDecimal(Double.toString(d3)); // Double.toString() 사용
		BigDecimal bc3 = new BigDecimal(String.valueOf(d3)); // String.valueOf() 사용
		
		System.out.println(bc3);
		
	}

}