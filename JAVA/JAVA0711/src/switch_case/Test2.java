package switch_case;

public class Test2 {

	public static void main(String[] args) {
//		int n1 = 2 , n2 = 5, n3 = 8;
//		if(n1>n2) {
//			if(n1>n3) {
//				System.out.println("최대값 : " + n1);
//			} else {
//				System.out.println("최대값 : " + n3);
//			}
//		} else if(n2>n1) {
//			if(n2>n3) {
//				System.out.println("최대값 : " + n2);
//			}else {
//				System.out.println("최대값 : " + n3);
//			}
//		} else if(n3>n1) {
//			if(n3>n2) {
//				System.out.println("최대값 : " + n3);
//			}else {
//				System.out.println("최대값 : " + n2);
//			}
//		} 
		int n1 = 2 , n2 = 5, n3 = 8;
		
		
		int max = (n1 > n2)  ? n1	: n2;
			max = (max > n3) ? max	: n3;
		System.out.println("최대값 : " + max);
		
		
	}

}
