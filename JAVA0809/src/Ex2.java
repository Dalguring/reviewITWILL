
public class Ex2 {

	public static void main(String[] args) {
		
		System.out.println("----------------------------------------");
		int x = 10;
		int y = x;
		System.out.println("x = " + x + ", y = " + y);
		y = 99;
		System.out.println("x = " + x + ", y = " + y);
		System.out.println("----------------------------------------");
		Num n = new Num();
		n.x = 10;
		n.y = n.x; //인스턴스 내의 기본형 변수도 값의 복사가 일어남!
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		
		n.y = 99;
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		System.out.println("----------------------------------------");
		Num n2 = new Num();
		n2.x = 10;
		n2.y = 10;
		
		Num n3 = n2; //주소를 전달한 것
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n3.y = " + n3.y);
		n3.y = 99;
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n3.y = " + n3.y);
		System.out.println("----------------------------------------");
		System.out.println("========변경 전========");
		MyDate d1 = new MyDate(2022, 8, 9);
		System.out.println(d1);
		MyDate d2 = d1;
		System.out.println(d2);
		System.out.println("========변경 후========");
		d2.year = 1999;
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("----------------------------------------");
		PassValue pv = new PassValue();
		int xNum = 10;
		System.out.println("changeValue() 메서드 호출 전 xNum : " + xNum);
		pv.changeValue(xNum);
		System.out.println("changeValue() 메서드 호출 후 xNum : " + xNum);
		System.out.println("----------------------------------------");
		Num num = new Num();
		num.x = 10;
		System.out.println("changeReferenceValue() 메서드 호출 전 num.x : " + num.x);
		pv.changeReferenceValue(num);
		System.out.println("changeReferenceValue() 메서드 호출 후 num.x : " + num.x);
	}

}
class Num {
	int x;
	int y;
}

class MyDate {
	int year;
	int month;
	int day;
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
}
class PassValue {
	
	public void changeValue(int x) {
		System.out.println("changeValue() 메서드 변경 전 x : " + x);
		x = 999;
		System.out.println("changeValue() 메서드 변경 후 x : " + x);
	}
	
	public void changeReferenceValue(Num num) {
		System.out.println("changeReferenceValue()메서드 변경 전 num.x " + num.x);
		num.x = 999;
		System.out.println("changeReferenceValue()메서드 변경 후 num.x " + num.x);
		
		
	}
	
}




