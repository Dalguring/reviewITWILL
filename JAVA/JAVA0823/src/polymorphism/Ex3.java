package polymorphism;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 다형성(Polymorphism)
		 * - 하나의 클래스 타입 참조변수로 여러 인스턴스를 참조할 수 있는 특성
		 * - 서브클래스 타입 인스턴스들을 슈퍼클래스 타입으로 업캐스팅하여
		 *   공통된 방법으로 여러 인스턴스의 멤버에 접근
		 *   ex) Employee 타입 변수로 Manager과 Engineer 인스턴스를 참조하여
		 *   	 각 개체내의 메서드 (getEmployee())를 공통으로 다루는 것
		 * - 슈퍼클래스 타입 배열에 서브클래스 타입 인스턴스를 저장하거나
		 * 
		 *   
		 * < 주의사항 !>
		 * 업캐스팅 후 슈퍼클래스 타입으로 서브클래스를 다룰 때
		 * 멤버변수는 참조변수 타입에 따라 결정되고,
		 * 메서드는 실제 인스턴스에 따라 결정 됨
		 * => 메서드 오버라이딩 시 업캐스팅 후에도 오버라이딩 된 메서드만 호출되지만
		 * 	  변수에 대한 오버라이딩 시 업캐스팅 후에는 해당 변수에 접근하는
		 *    참조변수 타입에 따라 접근하는 변수가 달라진다.
		 * 
		 */
		
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		//만약, 상속을 통한 메서드 오버라이딩 없이 각 클래스 자율적으로 메서드를 정의할 경우
		//각각 클래스의 메서드가 다르므로 코드의 통일성이 사라짐
		c.circleDraw();
		r.paint();
		
		//그러나, 추상화를 통해 슈퍼클래스인 Shape 클래스를 정의하고
		//상속을 통해 Shape 클래스의 draw() 메서드를 오버라이딩 하게 되면
		//각 인스턴스에서 호출하는 메서드가 동일하므로 코드의 통일성이 형성됨
		
		c.draw();
		r.draw();
		t.draw();
		System.out.println("==================================");
		
		Shape s = c;
		s.draw();
		
		s = r;
		s.draw();
		
		s = t;
		s.draw();
		System.out.println("==================================");
		
		Shape[] sArr = new Shape[3];
		
		sArr[0] = new Circle();
		sArr[1] = new Rectangle();
		sArr[2] = new Triangle();
		
		for(int i = 0; i < sArr.length; i++) {
			sArr[i].draw();
		}
		//향상된 for문
		for(Shape shape : sArr) {
			shape.draw();
		}
		System.out.println("==================================");
		polymorphism(c);
		polymorphism(r);
		polymorphism(t);
	}
	
	public static void polymorphism(Shape s) {
		if(s instanceof Circle) {
			System.out.println("Circle 객체!");
			Circle c = (Circle)s;
			c.draw();		//상속받은 메서드(오버라이딩)
			c.circleDraw(); //서브클래스에서 정의한 메서드
		} else if(s instanceof Rectangle) {
			System.out.println("Rectangle 객체!");
			Rectangle r = (Rectangle)s;
			r.draw();
			r.paint();
		} else if(s instanceof Triangle) {
			System.out.println("Triangle 객체!");
			Triangle t = (Triangle)s;
			t.draw();
		}
		
	}
	
	
	
	
	
	
	
}



class Shape {
	public void draw() {
		System.out.println("도형 그리기!");
	}
}

class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("원 그리기!");
	}
	
	public void circleDraw() {
		System.out.println("원 그리기!");
	}
}

class Rectangle extends Shape{
	@Override
	public void draw() {
		System.out.println("사각형 그리기!");
	}
	
	public void paint() {
		System.out.println("사각형 그리기!");
	}
}

class Triangle extends Shape{
	@Override
	public void draw() {
		System.out.println("삼각형 그리기!");
	}
	
}
