package method;

public class Ex1 {

	public static void main(String[] args) {
		
//		Person p = new Person("서성민", 28);
//		p.name = "~~~~~~~";
//		System.out.println(p.name);
//		p.age = 20; //private때문에 외부(main)에서 접근이 불가능함.
		
		Student s = new Student();
		s.setName("홍길동");
		System.out.println("이름 : " + s.getName());
		s.setAge(20);
		s.setScore(90);
		System.out.println("나이 : " + s.getAge());
		System.out.println("점수 : " + s.getScore());
		
		s.setScore(1000000);
		System.out.println(s.getScore());
//		s.score = 1000000;
//		System.out.println(s.score);
	}

}

class Student{
	private String name;
	private int age;
	private int score;
//	int score;
	
	public void setName(String name) {
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}


	
	
//	public String getname(String name) { set 하는 순간 name에 저장되기에 서로 다른 값들을 넣어 이를 조작할 수 없음. 
//		this.name = name;
//		return this.name;
//	}
	
	
