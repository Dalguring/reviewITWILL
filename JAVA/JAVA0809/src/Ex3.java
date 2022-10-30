
public class Ex3 {

	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("우리집 TV : " + c.tv);
		c.watchTv();
		c.watchMyParentTv();
		System.out.println("========================================");
//		c.scope();
		SonofChild sc = new SonofChild();
		sc.scope();
		System.out.println("========================================");
		N n = new N();
		n.method();
		
		
	}

}

class Parent {
	String tv = "부모님이 구입한 TV";
	
	public void watchTv() {
		System.out.println("부모님 댁에서 " + tv + "를 보자!");
	}
	
	//-------------------------------------------------------
	
	String name ="Parent의 멤버변수 name"; 
}
class Child extends Parent{
	String tv = "내가 구입한 TV";

	@Override
	public void watchTv() {
		System.out.println("우리집에서 " + tv + " 를 보자!");
	}
	
	public void watchMyParentTv() {
		super.watchTv();
	}
	
	//---------------------------------------------------------------------
	
	String name = "Child의 멤버변수 name";
	public void scope() {
		
		String name = "Child 클래스 메서드 내의 로컬변수 name";
		
		System.out.println("name : " + name);
		System.out.println("this.name : " + this.name);
		System.out.println("super.name : " + super.name);
	}
	
}

class SonofChild extends Child {
	
	String name = "SonofChild의 멤버변수 name";
	
	@Override
	public void scope() {
		System.out.println("name : " + name);
		System.out.println("this.name : " + this.name);
		System.out.println("super.name : " + super.name);
//		System.out.println("super.super.name : " + super.super.name); // 사용불가
	}
	
}

class G {
	String name = "할아버지";
}

class P extends G{
	String name = "아버지";
	
	public String parentName() {
		return super.name;
	}
}

class N extends P{
	String name = "나";
	public void method() {
		String name = "로컬";
		System.out.println("name = " + name);
		System.out.println("this.name = " + this.name);
		System.out.println("super.name = " + super.name);
		System.out.println(super.parentName());
	}
}


