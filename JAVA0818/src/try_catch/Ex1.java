package try_catch;

public class Ex1 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		int num1 = 10, num2 = 0;
		
//		System.out.println(num1 + "/" + num2 + " = " + (num1 / num2));
		
		/*Exception in thread "main" java.lang.ArithmeticException: 
		 * =>예외 발생 상황 정보 및 예외 발생을 탐지한 예외 클래스명
		 *   (예외 발생을 탐지하는 리스너 객체 : java.lang.ArithmeticException)
		 * by zero
		 * =>예외 발생 원인 메시지 (0에 의한 나눗셈으로 인해 예외 발생했다는 의미)
		  at try_catch.Ex1.main(Ex1.java:11)
		   =>예외 발생 위치
		 */
		
		//예외가 발생하지 않도록 if문을 통해 피연산자 값 검사하는경우 예외처리가 아님!
		if(num2 != 0) {
			System.out.println(num1 + "/" + num2 + " = " + (num1 / num2));
		}
		
		String str = null; //참조 변수에 저장된 주소값이 없음
		//null 값을 참조하는 객체에 접근하여 작읍 수행하려 할 경우
		//접근이 불가능하므로 NullPointerException 예외가 발생!
//		System.out.println(str.length());
		
		int[] arr = new int[2];
		//배열 인덱스 사용 시 존재하지 않는 인덱스를 사용할 경우
		//ArrayIndexOutOfBoundsException 예외가 발생!
//		arr[2] = 10;
		
		
		System.out.println("프로그램 종료");
	
	}

}
