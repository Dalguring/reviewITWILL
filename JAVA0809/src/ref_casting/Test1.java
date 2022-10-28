package ref_casting;

public class Test1 {

	public static void main(String[] args) {
		
		전화기 전화 = new 핸드폰();
		전화.전화();
//		전화.문자();
		전화기 전화2 = new 스마트폰();
		전화2.전화();
//		전화2.문자();
//		전화2.카톡();
		System.out.println("==============================");
		핸드폰 핸드폰 = new 스마트폰();
		핸드폰.전화();
		핸드폰.문자();
//		핸드폰.카톡();
		System.out.println("==============================");
//		핸드폰 핸드폰2 = new 핸드폰(); //런타임 오류 발생. 자바측에서 애초에 변수 차단을 위해 막아버림
		핸드폰 핸드폰2 = new 스마트폰();
		스마트폰 스마트폰;
		스마트폰 = (스마트폰)핸드폰2;
		스마트폰.전화();
		스마트폰.문자();
		스마트폰.카톡();
	}

}

class 전화기 {
	public void 전화() {
		System.out.println("전화 걸기!");
	}
}

class 핸드폰 extends 전화기{
	public void 문자() {
		System.out.println("문자 전송!");
	}
}

class 스마트폰 extends 핸드폰 {
	public void 카톡() {
		System.out.println("카톡 메시지 전송!");
	}
}
//-----------------------------------------------------------
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}
class G extends C {}







