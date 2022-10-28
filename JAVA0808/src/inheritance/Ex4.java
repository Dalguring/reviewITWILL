package inheritance;

public class Ex4 {

	public static void main(String[] args) {
		new G();
		System.out.println("--------------------");
		new P(); //이 때 찍히는 G생성됨은 상속 받은것이 아니라 부모 클래스의 생성자를 호출한 것임
		System.out.println("--------------------");
		new C();
	}

}

class G {
	public G() {
		System.out.println("G 생성됨");
	}
}

class P extends G {
	public P() {
		System.out.println("P 생성됨");
	}
}

class C extends P {
	public C() {
		System.out.println("C 생성됨");
	}
}


