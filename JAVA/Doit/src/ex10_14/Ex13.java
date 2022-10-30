package ex10_14;

public class Ex13 {

	public static void main(String[] args) {
		
		Calc cal = (num1, num2) -> num1+num2;
		System.out.println(cal.add(50, 100));

	}

}

interface Calc {
	public int add(int num1, int num2);
}