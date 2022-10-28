package method;

class Calculator {
	public void calc(char opr, int num1, int num2) {
		if(opr == '+') {
			System.out.println(num1+num2);
		} else if(opr == '-') {
			System.out.println(num1-num2);
		} else if(opr == '*') {
			System.out.println(num1*num2);
		} else if(opr == '/') {
			System.out.println(num1/num2);
		}
	}
	
	public void calc(char opr, int num1, int num2, int num3) {
		if(opr == '+') {
			System.out.println(num1+num2+num3);
		} else if(opr == '-') {
			System.out.println(num1-num2-num3);
		} else if(opr == '*') {
			System.out.println(num1*num2*num3);
		} else if(opr == '/') {
			System.out.println(num1/num2/num3);
		}
	}
	
	public void calc(char opr, int num1, int num2, int num3, int num4) {
		if(opr == '+') {
			System.out.println(num1+num2+num3+num4);
		} else if(opr == '-') {
			System.out.println(num1-num2-num3-num4);
		} else if(opr == '*') {
			System.out.println(num1*num2*num3*num4);
		} else if(opr == '/') {
			System.out.println(num1/num2/num3/num4);
		}
	}
	
}

public class Ex3 {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		cal.calc('+', 10, 20);
		cal.calc('+', 10, 20, 30);
		cal.calc('+', 10, 20, 30, 40);
		System.out.println("-----------------------------------");
		cal.calc('-', 100, 10);
		cal.calc('-', 100, 10, 20);
		cal.calc('-', 100, 10, 20, 30);
		System.out.println("-----------------------------------");
		cal.calc('*', 1, 2);
		cal.calc('*', 1, 2, 3);
		cal.calc('*', 1, 2, 3, 4);
	}

}
