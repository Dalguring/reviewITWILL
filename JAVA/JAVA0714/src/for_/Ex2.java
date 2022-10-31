package for_;

public class Ex2 {

	public static void main(String[] args) {
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		System.out.println("========================================");
//		for(int a = 1; a <=5; a++) {
//			for(int b = 1; b<=5-a ; b++) {
//				System.out.print(" ");
//			}
//			for(int b = 1; b <=a; b++) { System.out.print("*");}
//			System.out.println();
//		}
		System.out.println("========================================");
		int line = 5;
		int star = 1;
		int space = 4;
		
		for(int i = 1; i <= line; i++) {
			
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < star; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			star++;
			space--;
		}
		System.out.println("========================================");
		int a1 = 1;
		int a2 = 5;
		for(int q = 0; q < 5; q++) {
			for(int w = 0; w < (a1-1); w++) {
				System.out.print(" ");
			}
			for(int w = 0; w < a2; w++) {
				System.out.print("*");
			}
			System.out.println();
			a1++; a2--;
		}
		
		
		
		
		
	}

}
