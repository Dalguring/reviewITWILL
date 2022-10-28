package oop;

public class Ex1 {

	public static void main(String[] args) {
		Bubble b1 = new Bubble();
		b1.x = 100;
		b1.y = 50;
		
		Bubble b2 = new Bubble();
		b2.x = 40;
		b2.y = 60;
		
		Bubble b3;
		b3 = b1;
		
		b3.x=1000;
		System.out.println("b1.x : " + b1.x + ", b1.y : " + b1.y);
		System.out.println("b2.x : " + b2.x + ", b2.y : " + b2.y);
		System.out.println("b3.x : " + b3.x + ", b3.y : " + b3.y);
	}
}
class Bubble {
	int x;
	int y;
}

