package ex01_04;

public class Ex4_Q3 {

	public static void main(String[] args) {
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println("< " + dan + "단 >");
			for(int i = 1; i <= 9; i++) {
				if(i > dan) {
				break;
				}
				System.out.println(dan + " x " + i + " = " + dan*i);
			}
		}
		
		
		
	}

}
