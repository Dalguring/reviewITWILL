package typecasting;

public class Ex1 {

	public static void main(String[] args) {
		int a1 = 128;
		byte a2 = 127;
		
		System.out.println("변환 전 a1(int) : " + a1 + ", a2(byte) : " + a2);
		a1 = a2;
//		a1 = (int)a2;
		System.out.println("변환 후 a1(int) : " + a1 + ", a2(byte) : " + a2);

		int b1 = 130;
		byte b2 = 127;
		System.out.println("변환 전 b1(int) : " + b1 + ", b2(byte) : " + b2);
		b2=(byte)b1;
		System.out.println("변환 후 b1(int) : " + b1 + ", b2(byte) : " + b2);
		
		int c1 = 10;
		byte c2 = 0 ;
		c2=(byte)c1;
		System.out.println("변환 후 c1(int) : " + c1 + ", c2(byte) : " + c2);

	}

}
