package constructor;

class Person {
	String name;
	int age;
	
//	public void setName(String name) {
//		//파라미터로 전달받은 데이터가 로컬변수 name에 저장되며
//		//name=name 코드에 의해 로컬변수 name값이 다시 자신에 저장됨
////		name = name; 경고 발생 : 아무런 효과가 없는 코드
//	}
	
//	//1번 방법 : 멤버변수와 로컬변수의 이름을 다르게 선언
//	public void setName(String newName) {
//		name = newName;
//}
	//2번 방법 : 레퍼런스 this를 사용하여 멤버변수를 지정
	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * this 키워드
		 * 1. 레퍼런스(Reference) this
		 * 		- 자신의 인스턴스 주소가 저장되는 레퍼런스
		 * 		- 개발자가 임의로 생성할 수 없으며, 인스턴스 생성 시 자동으로 주소가 저장됨
		 * 		=> 각 인스턴스 마다 this에 저장되는 주소가 달라짐
		 * 		- 일반적인 참조변수와 동일한 방법으로 사용가능
		 * 		- 주로 생성자나 메서드 내에서 멤버변수와 로컬변수의 이름이 동일할 경우
		 * 		  멤버변수를 구별할 목적으로 사용
		 * 		- 또한, 자신의 인스턴스 내의 다른 메서드를 호출하는데도 사용 가능
		 * 			(일반적으로 메서드 이름은 로컬변수처럼 중복되지 않으므로 this 생략)
		 * 
		 * < 기본문법 >
		 * this.멤버변수명
		 * this.메서드명()
		 * */
		
		
		
		
		
	}

}
