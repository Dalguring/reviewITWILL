package try_catch;

public class Ex2 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작!");
		
		try {
			System.out.println("try블록 시작!");
			int num1 = 3;
			int num2 = 0;
			
			System.out.println(num1 / num2); //예외(ArithmeticException)가 발생하는 코드
			//현재 예외가 발생한 코드의 아래쪽 나머지 코드들(try블록 내의 코드들)은 
			//실행되지 못하고, catch 블록으로 가서 예외 객체에 해당하는 클래스를 찾아
			//해당 catch 블록 내의 코드들을 실행하게 된다!
			System.out.println("try블록 끝!");
		} catch(ArithmeticException e) {
			//ArithmeticException예외가 try 블록 내에서 발생하면
			//JVM에 이해 ArithmeticException 예외 객체가 생성되고 던져짐
			//따라서 catch블록의 소괄호 안에 해당 예외 클래스와 일치하는 참조변수를 선언하여
			//던져지는 예외 객체를 전달 받아야한다 (catch)
			//=> catch 블록 중괄호 내에서 예외 발생시 수행할 작업들을 명시
			System.out.println("ArithmeticException 예외발생! - 0으로 나눌 수 없습니다!");
		}
		System.out.println("프로그램 종료!");
		
		System.out.println("====================================");
		System.out.println("프로그램 시작!");
		
		try {
			System.out.println("try블록 시작!");
			int[] arr = {1,2,3};
			System.out.println(arr[3]);
			System.out.println("try블록 끝!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException예외 발생!");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료!");
		
		System.out.println("====================================");
		System.out.println("프로그램 시작!");
		
		try {
			System.out.println("try블록 시작!");
			String str = null;
			System.out.println(str.length());
			System.out.println("try블록 끝!");
		} catch (NullPointerException e) {
			System.out.println("NullPointerException예외 발생!");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료!");
		
		
	}

}
