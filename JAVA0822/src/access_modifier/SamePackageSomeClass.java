package access_modifier;

public class SamePackageSomeClass {
	//패키지가 동일한 다른 클래스에서의 접근 범위
	public void useMember() {
		ParentClass p = new ParentClass();
		p.pulicVar = 10;
		p.protectedVar = 20;
		p.defaultVar = 30;
//		p.privateVar = 40; 다른 클래스에서 접근 불가
	}
	
}
