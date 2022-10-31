package typecasting;

public class Ex2 {

	public static void main(String[] args) {
		System.out.println(10+2);
		System.out.println(10-2);
		System.out.println(10*2);
		System.out.println(10/3);
		System.out.println(10%3);
		System.out.println("=============================");
		byte b1 = 10, b2 = 20, b3;
		System.out.println(b1 + b2);
//		b3 = b1 + b2; 오류! byte + byte = int가 되어 byte 타입인 b3에 저장 불가
		b3 = (byte)(b1 + b2);
		System.out.println(b3);
		
		int c1 = 10, c2 = 20, c3;
		c3 = c1+c2;
		System.out.println(c3);
	}

}
