package ex01_04;

public class Ex4_Q5 {

	public static void main(String[] args) {
		int line = 7;
		int star = 1;
		int space = 3;
		
		for(int i = 0; i < line; i++) {
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < star; j++) {
				System.out.print("*");
			}
			
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			System.out.println();
			if(i < line/2) {
				star += 2;
				space--;
			} else {
				star -= 2;
				space++;
			}
			
			
			
		}
	}

}
