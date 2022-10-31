package try_catch;

public class Ex4 {

	public static void main(String[] args) {
		
		/*
		 * Exception 객체의 정보 활용
		 * - 예외 발생 시 해당 예외를 처리할 수 있는 예외 객체를 생성하여 전달되어짐
		 *  => 이때, catch 블록에서 해당 예외 객체를 전달받을 수 있다!
		 * - 전달받은 객체의 여러 메서드를 통해 객체 정보를 활용 가능
		 * 
		 * 1. void printStackTrace()
		 * 2. String getMessage()
		 * 3. String getlocalizedMessage()
		 * 
		 * */
		
		 try {
			 int num1 =3, num2 = 0;
			 System.out.println(num1 / num2);
		 } catch(Exception e) {
//			 e.printStackTrace();
			 System.out.println(e.getLocalizedMessage());
		 }
		
		
		
		
		
		
	}

}
