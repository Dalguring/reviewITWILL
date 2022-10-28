package ex01_04;

public class Ex_Q4 {

	public static void main(String[] args) {
		for(int i = 1; i <= 4; i++) {
			for(int j = 4-i; j > 0; j--) 	System.out.print(" ");
			for(int j = 1; j <= i*2-1; j++) System.out.print("*");
			for(int j = 4-i; j > 0; j--) 	System.out.print(" ");
			System.out.println();
		}
	}

}
