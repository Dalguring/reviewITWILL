package abstract_method;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		
		Bird b = new Bird();
		b.fly();
		SuperMan s = new SuperMan();
		s.fly();
		Airplane a = new Airplane();
		a.fly();
		System.out.println("--------------------------------------------------");
		Flyer f = b;
		f.fly();
		f = s;
		f.fly();
		f = a;
		f.fly();
		System.out.println("--------------------------------------------------");
//		Flyer[] fArr = new Flyer[3]; // 이 때 new Flyer[3]은 Flyer타입의 변수가 들어갈 수 있는 배열을 만드는 new임 new Flyer()은 객체를 만드는 new 이므로 서로 다름
//		fArr[0] = b;
//		fArr[1] = s;
//		fArr[2] = a;
		Flyer[] fArr = new Flyer[] {b, s ,a};
		for(Flyer flyer : fArr) {
			flyer.fly();
		}
		
		System.out.println("=========================================");
		ArrayList<Flyer> arrList = new ArrayList<Flyer>();
		arrList.add(new Bird());
		arrList.add(new SuperMan());
		arrList.add(new Airplane());
		
		for(Flyer flyer : arrList) {
			flyer.fly();
		}
		
		
		
	}

}

abstract class Flyer {
	public abstract void fly();
}

class Bird extends Flyer {
	@Override
	public void fly() {
		System.out.println("Bird 비행!");
	}
}

class SuperMan extends Flyer {
	@Override
	public void fly() {
		System.out.println("SuperMan 비행!");
	}
}

class Airplane extends Flyer {
	@Override
	public void fly() {
		System.out.println("Airplane 비행!");
	}
}



