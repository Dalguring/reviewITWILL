package interface_;

public class Test1 {

	public static void main(String[] args) {
		Flyer f = new SuperMan();
		f.takeOff();
		f.fly();
		f.land();
		System.out.println("==================================");
		Flyer f2 = new Bird();
		f2.takeOff();
		f2.fly();
		f2.land();
		System.out.println("==================================");
		Flyer f3 = new Airplane();
		f3.takeOff();
		f3.fly();
		f3.land();
		System.out.println("==================================");
		Flyer[] fArr = new Flyer[]{f, f2, f3};
		for(Flyer flyer : fArr) {
			flyer.takeOff();
			flyer.fly();
			flyer.land();
		}
		
		
		
	}

}

interface Flyer {
	public void takeOff();
	public void fly();
	public void land();
}

class SuperMan implements Flyer{
	@Override
	public void takeOff() {
		System.out.println("SuperMan 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("SuperMan 비행!");
	}
	@Override
	public void land() {
		System.out.println("SuperMan 착륙!");
	}
}

class Bird implements Flyer{
	@Override
	public void takeOff() {
		System.out.println("Bird 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("Bird 비행!");
	}
	@Override
	public void land() {
		System.out.println("Bird 착륙!");
	}
}

class Airplane implements Flyer{
	@Override
	public void takeOff() {
		System.out.println("Airplane 이륙!");
	}
	@Override
	public void fly() {
		System.out.println("Airplane 비행!");
	}
	@Override
	public void land() {
		System.out.println("Airplane 착륙!");
	}
}


