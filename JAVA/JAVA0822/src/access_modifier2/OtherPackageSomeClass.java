package access_modifier2;

import access_modifier.ParentClass;

public class OtherPackageSomeClass {
	public void useMember() {
		ParentClass p = new ParentClass();
		p.pulicVar = 10; //누구나 접근 가능
//		p.protectedVar = 20; 다른 패키지이고 상속 관계가 아니므로 접근 불가
//		p.defaultVar = 30; 다른 패키지이므로 접근 불가
//		p.privateVar = 40; 다른 클래스에서 접근 불가
	}
	
	
	
	
}
