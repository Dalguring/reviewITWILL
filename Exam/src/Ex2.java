
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 8. 객체지향 프로그래밍의 특징(APIE)
		 * 1) 슈퍼클래스의 멤버를 서브클래스에서 선언 없이 사용할 수 있도록 물려받는 것 (상속성 - Inheritance)
		 * 2) 객체의 상세한 내용을 외부에 숨기고 단순한 메시지만으로 상호작용 하는 것 (캡슐화 - Encapsulation)
		 * 3) 공통점을 추출하여 상위 개념을 만들고 상세 내역을 없애 나가는 과정 (추상화 - Abstract)
		 * 4) 상속관계에서 슈퍼클래스 타입으로 서브클래스의 인스턴스를 참조할 수 있는 것 (다형성 - Polymolphism)
		 * 
		 */
		
		/*
		 * 9. 접근제한자 접근 범위가 좁은 것부터 넓은것 순으로 나열하시오.
		 * 
		 * private -> default -> protected -> public
		 */
		
		/*
		 * 10. 어떤 인스턴스가 어떤 클래스의 하위 타입인지 판별하는 연산자는?
		 * instanceof
		 */
		
		/*
		 * 11. 1 ~ 100 사이의 난수를 발생시키는 코드를 작성하시오.
		 */
		
		A a = new B();
		E e = new E();
		F f = new F();
		
//		 a = (A)f;		(O)
//		 a = f;			(O)
//		 B b = (B)a		(O)
// 		 C c = f		(O)
		
	}

}

/*
 * 12. 레퍼런스 형변환 문제
 */
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends B {}
class F extends C {}
class G extends C {}




