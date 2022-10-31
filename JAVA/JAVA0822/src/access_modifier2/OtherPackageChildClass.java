package access_modifier2;

import access_modifier.ParentClass;

public class OtherPackageChildClass extends ParentClass{

	public void useMember() {
		//주의! 상속 관계에서 슈퍼클래스의 멤버에 접근할 때
		//슈퍼클래스의 인스턴스를 생성하여 접근할 경우 상속 관계로서의 접근이 아니게 된다!
		ParentClass p = new ParentClass();
		p.pulicVar = 10; // 누구나 접근 가능
//		p.protectedVar = 20; 다른 패키지이고 상속 관계가 아니므로 접근이 불가능(상속 관계로서 테스트하는 것이 아님 / 생성한 객체로서 접근 중)
		//애초에 p.으로 접근하면 ParentClass의 protectedVar은 같은 패키지만 접근가능하므로 접근이 불가능함.
//		p.defaultVar = 30; 다른 패키지이므로 접근 불가
//		p.privateVar = 40; 다른 클래스에서 접근 불가
		
		this.pulicVar = 10; //누구나 접근가능
		this.protectedVar = 20; //다른 패키지이지만 상속관계이므로 접근가능
//		this.defaultVar = 30; 다른 패키지이므로 접근 불가
//		this.privateVar = 40; 다른 클래스에서 접근 불가
	}
	
}
