package static_;

public class Ex4 {

	public static void main(String[] args) {
		StaticMethod sm = new StaticMethod();
		sm.normalMethod();
		sm.staticMethod();
		StaticMethod.setStaticVar(99);
//		staticMethod();
	}

}

class StaticMethod{
	private int normalVar = 10;
	private static int staticVar = 20;
	
	public void normalMethod() {
		System.out.println("일반 메서드!");
		System.out.println("일반 메서드에서 인스턴스 변수 접근 : " + normalVar);
		System.out.println("일반 메서드에서 static 변수 접근 : " + staticVar);
	}
	
	public static void staticMethod() {
		System.out.println("static 메서드!");
//		System.out.println("static 메서드에서 인스턴스 변수 접근 : " + normalVar);
		//오류! static 멤버가 메모리에 로딩되는 시점에는 인스턴스 멤버는 로딩되지 않은 상태!
		System.out.println("static 메서드에서 static 변수 접근 : " + staticVar);
	}
	
	public void setNormalVar(int normalVar) {
		this.normalVar = normalVar;
	}
	
	public static void setStaticVar(int staticVar) {
//		this.staticVar = staticVar; //오류! static메서드 내에서 this 사용 불가!
		StaticMethod.staticVar = staticVar;
		
		staticMethod(); //static메서드 호출 가능! 같은 타이밍에 로딩되어 있기 때문
//		normalMethod(); // 호출 불가! 인스턴스 생성 전이므로 로딩 불가
	}
	
	
	
}


