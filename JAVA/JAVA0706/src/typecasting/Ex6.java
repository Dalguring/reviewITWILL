package typecasting;

public class Ex6 {

	public static void main(String[] args) {
		boolean a = false;
		boolean b = true;
		System.out.println("a(false) && a(false) = " + (a && a));
		System.out.println("a(false) && b(true) = " + (a && b));
		System.out.println("b(true) && a(false) = " + (b && a));
		System.out.println("b(true) && b(true) = " + (b && b));
		System.out.println("================================================");
		System.out.println("a(false) || a(false) = " + (a || a));
		System.out.println("a(false) || b(true) = " + (a || b));
		System.out.println("b(true) || a(false) = " + (b || a));
		System.out.println("b(true) || b(true) = " + (b || b));
		System.out.println("================================================");
		System.out.println("!a(false) = " + (!a));
		System.out.println("!b(true) = " + (!b));
		System.out.println("================================================");
		System.out.println("a(false) ^ a(false) = " + (a ^ a));
		System.out.println("a(false) ^ b(true) = " + (a ^ b));
		System.out.println("b(true) ^ a(false) = " + (b ^ a));
		System.out.println("b(true) ^ b(true) = " + (b ^ b));		
		System.out.println("================================================");

		//&&, || : lazy Evaluation에 의해 불필요한 연산은 하지 않는다.
		int i = 10;
		boolean result = i > 5 || i++ > 5; //앞이 True이니 뒤에꺼는 연산하지 않음
		System.out.println(i); 
		// 하지만 |하나일 때는 모두 실행하므로 i 값이 증가하여 11이 됨.
	}

}
