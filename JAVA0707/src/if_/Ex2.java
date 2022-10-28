package if_;

public class Ex2 {

	public static void main(String[] args) {
		int num = 15;
		if(num>=10) {
			System.out.println("두 자리수");
		}else {
			System.out.println("한 자리수");
		}
		System.out.println("=========================================");
		int num1 = -2;
		if(num1>=0) {
			System.out.println(num1 + " : 양수!");
		}else {
			System.out.println(num1 + " : 음수!");
		}
		System.out.println("=========================================");
		int num2 = 10;
		String result = (num2 >= 0) ? " : 양수" : " : 음수!";
		System.out.println(num2+result);
		System.out.println("=========================================");
		char ch = 'z';
		//if ~ else버전
//		if(ch>='A' && ch<='Z') { // 복합연산자는 강제형변환을 할 필요가 없음!!!!!!!!!
//			ch+=32;
//		} else {
//			ch-=32;
//		}
//		System.out.println("ch = "+ ch);
		//삼항연산자 버전
		ch += (ch>='A' && ch<='Z') ? 32 : -32;
		System.out.println(ch);
		// 변수 홀수,짝수,n1 + n2
		int n1 = 4, n2 = 8;
		int n3 = n1+n2;
//		String str = "";
//		if(n1%2==1) {
//			str = "홀수 + ";
//		} else {
//			str = "짝수 + ";
//		} 
//		if(n2%2==1) {
//			str += "홀수 = ";
//		} else {
//			str += "짝수 = ";
//		} 
//		if(n3%2==1) {
//			str += "홀수";
//		} else {
//			str += "짝수";
//		} 
//		System.out.println(str);
		System.out.println("=========================================");
		String str   = (n1%2==1) ? "홀수 + " : "짝수 + ";
		str 		+= (n2%2==1) ? "홀수 = " : "짝수 = ";
		str 		+= (n3%2==1) ? "홀수" 	: "짝수"	  ;
		System.out.println(str);
		
	} 
}
