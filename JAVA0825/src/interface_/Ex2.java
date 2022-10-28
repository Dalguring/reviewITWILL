package interface_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 인터페이스 필요성 (장점)
		 * 3. 상속관계가 없는 객체끼리의 관계를 부여하여 다형성 활용 가능
		 * 
		 */
		
//		------------------상속 관계가 아닐 경우 불편한 예------------------
		/*
		 * HandPhone 클래스와 DigitalCamera는 특정 클래스와 상속 관계가 아니므로
		 * 두 클래스의 유일한 공통클래스는 Object 클래스 뿐임.
		 * 
		 * 따라서 업캐스팅을 통해 다형성을 적용하려면 Object 타입으로 업캐스팅하여야 하며
		 * 업캐스팅 후에는 두 객체의 고유멤버 접근이 불가능하므로
		 * 다시 다운캐스팅을 통해 각 개체의 고유 멤버를 호출해야함.
		 */
		Object obj1 = new HandPhone();
		Object obj2 = new DigitalCamera();
		
		Object[] objs = {obj1, obj2};
		
		for(int i = 0; i < objs.length; i++) {
			Object obj = objs[i];
			if(obj instanceof HandPhone) {
				HandPhone hp = (HandPhone)obj;
				hp.charge();
			} else if(obj instanceof DigitalCamera) {
				DigitalCamera dc = (DigitalCamera)obj;
				dc.charge();
			}
		}
		System.out.println("------------------------------");
		for(Object obj : objs) {
			if(obj instanceof HandPhone) {
				HandPhone hp = (HandPhone)obj;
				hp.charge();
			} else if(obj instanceof DigitalCamera) {
				DigitalCamera dc = (DigitalCamera)obj;
				dc.charge();
			}
		}
		System.out.println("------------------------------");
		
		// --------인터페이스를 통해 상속관계가 아닌 클래스끼리 상속 관계 부여---------
		
		Chargeable[] objs2 = {new HandPhone2(), new DigitalCamera2()};
		for(Chargeable ch : objs2) {
			ch.charge();
		}
		
		
		
		
		
		
	}

}

// ------------------상속 관계가 아닐 경우 불편한 예------------------
// 서로 상속관계가 없는 HandPhone2와 DigitalCamera2 클래스에
class Phone {}
class HandPhone extends Phone {
	public void charge() {
		System.out.println("HandPhone 충전!");
	}
}

class Camera {}
class DigitalCamera extends Camera {
	public void charge() {
		System.out.println("DigitalCamera 충전!");
	}
}

// --------인터페이스를 통해 상속관계가 아닌 클래스끼리 상속 관계 부여---------
interface Chargeable {
	public void charge();
}

class Phone2 {}
class HandPhone2 extends Phone2 implements Chargeable {
	@Override
	public void charge() {
		System.out.println("HandPhone 충전!");
	}
}

class Camera2 {}
class DigitalCamera2 extends Camera2 implements Chargeable {
	@Override
	public void charge() {
		System.out.println("DigitalCamera 충전!");
	}
}






