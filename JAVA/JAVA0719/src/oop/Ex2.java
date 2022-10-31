package oop;

class Animal {
	String name;
	int age;
	void cry() {
	System.out.println("동물 울음 소리!");
	}
}
public class Ex2 {

	public static void main(String[] args) {
		Animal ani = new Animal();
		ani.name = "멍멍이";
		ani.age = 3;
		System.out.println("이름 : " + ani.name +  "\t나이 : " + ani.age);
		ani.cry();
		
		Animal ani2 = new Animal();
		ani2.name = "야옹";
		ani2.age = 2;
		System.out.println("이름 : " + ani2.name +  "\t나이 : " + ani2.age);
		System.out.println("========================================");
		
		Student st = new Student();
		System.out.println(st.name + "\t" + st.id);
		Student s2 = new Student();
		System.out.println(s2.name + "\t" + s2.id);
		System.out.println("========================================");
		st.name = "서성민";
		st.id = "a123456";
		st.age = 28;
		st.eng = 96;
		st.kor = 78;
		st.nat = 100;
//		System.out.println("이름 : " + st.name);
//		System.out.println("학번 : " + st.id);
//		System.out.println("나이 : " + st.age);
//		System.out.println("영어 : " + st.eng);
//		System.out.println("국어 : " + st.kor);
//		System.out.println("수학 : " + st.nat);
		st.showStudentInfo();
		System.out.println("========================================");
		s2.showStudentInfo();
		System.out.println("========================================");
		System.out.println("합계 : " + st.getTotal());
		System.out.println("합계 : " + s2.getTotal());
		System.out.println("========================================");
		System.out.println("평균 : " + st.getAverage());
	}

}

class Student {
	//멤버변수(인스턴스변수)는 초기값을 지정해도 되고 생략도 가능
	String name = "홍길동";
	String id = "a0000";
	int age;
	int kor;
	int eng;
	int nat;
	
	void showStudentInfo() {
		System.out.println("이름 : " + name);
		System.out.println("학번 : " + id);
		System.out.println("나이 : " + age);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + nat);
		
	}
	int getTotal() {
//		int sum = kor + eng + nat;
//		return sum;
		return kor + eng + nat;
	}
	double getAverage() {
//		double avg = (kor + eng + nat) / 3.0;
//		return avg;
		
//		return (kor + eng + nat) / 3.0;
		return getTotal() / 3.0;
	}
	
	
	
}



