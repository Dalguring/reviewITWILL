package try_catch;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		for(int i = 0; i < 10; i++) {
			int num = r.nextInt(10);
			try {
				System.out.println("10 / " + num + " = " + (10 / num));
			} catch(ArithmeticException e) {
				System.out.println("피연산자가 0이므로 연산에서 제외됩니다!");
			}
		}
		
		
		
	}

}
