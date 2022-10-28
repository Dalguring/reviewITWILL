package typecasting;

public class Ex7 {

	public static void main(String[] args) {
		int a = 10;
		String result = a%2 == 0 ? "짝수" : "홀수";
		System.out.println(result);
		a = 11;
		result = a%2 == 0 ? "짝수" : "홀수";
		System.out.println(result);
		
		a = 30;
		int b = 40;
		int max = a - b >= 0  ? a : b;
		int min = a - b <= 0  ? a : b;
		String strMax = a > b ? "a" : "b";
		String strMin = a < b ? "a" : "b";
		System.out.println(max);
		System.out.println(min);
		System.out.println(strMax);
		System.out.println(strMin);
		System.out.println("======================================");
//		double d = 97.5;
//		int i = d - (int)d >= 0.5 ? (int)d+1 : (int)d; (내가 한 것)
//		System.out.println(i);
		System.out.println("=====================================");
		double d = 97.5;
//		double d2 = (int)(d*10%10) >= 5 ? d+1 : d;
//		int r = (int)d2;
		System.out.println((int)(d*10%10) >= 5 ? d+1 : d);
		
		
		
		double k = 97.56;
		
	}

}
