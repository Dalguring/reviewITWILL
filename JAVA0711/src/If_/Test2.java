package If_;

public class Test2 {

	public static void main(String[] args) {
		int n1 =3, n2 = 8; String str = "";
		if (n1 %2 == 0) {
			str = "짝수 + ";
			str += n2 %2 == 0	 ? " 짝수 = " : " 홀수 = ";
			str += (n1+n2)%2 == 0? "짝수" : "홀수";
			System.out.println(str);
		} else {
			str = "홀수 + ";
			str += n2 %2 == 0? " 짝수 = " : " 홀수 = ";
			str += (n1+n2)%2 == 0? "짝수" : "홀수";
			System.out.println(str);
				
		}
		
		
		
		
		
		
	}

}
