
public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 1.
		 * 절차(구조적) 프로그래밍 언어 : C, Pascal
		 * 객체지향 프로그래밍 언어 : C++, JAVA, C# 
		 */
		
		/*
		 * 2. 키워드(예약어)
		 * - 이미 자바에 등록되어 있어 의미가 약속되어 있는 단어
		 * - 속성의 변수명, 메서드명으로 사용할 수 없음
		 * (abstract, default, goto, package, boolean
		 *  do, if, for, this, break, protected, else, import, case, public)
		 *  
		 * 예약어 인지 아닌지 판별하는 문제가 나옴
		 */
		
		/*
		 * 3. 변수 선언 및 초기화 문제
		 * 1) 문자열로된 자신의 이름을 저장하는 변수 선언 및 초기화
		 * 2) 문자 A를 저장하는 변수 ch를 선언 및 초기화
		 * 3) 정수 25억을 저장하는 num 변수를 선언 및 초기화
		 * 
		 */
		String name = "서성민";
		char ch = 'A';
		long num = 2500000000L;
		
		/*
		 * 4. 논리연산자 종류
		 * &&, ||, !, ^(XOR)
		 * && : 모두 true일 경우 true, 하나라도 false일 경우 false
		 * || : 하나라도 true일 경우 true
		 * ^  : 좌우가 다를 경우 true, 좌우가 같으면 false
		 * 
		 */
		
		/*
		 * 5. 형변환(원인 및 해결책)
		 * int i = 10 + 1.0;
		 * 
		 * char ch = 'A';
		 * ch = ch + 2;
		 */
		
		/*
		 * 6. 배열 선언 및 초기화
		 * int[] arr;
		 * 
		 * arr = {1, 2, 3}; // 선언과 초기화를 동시에 하려면 한줄에 해야함. (X)
		 * new int[3]{1, 2, 3}; // 크기를 쓴 경우 초기화 할 수 없음. (X)
		 * new int[]{1, 2, 3} (O)
		 * 
		 */
		
		Student s = new Student("서성민", 100);
		s.print();
		
		
		
		
	}

}

/*
 * 7. 클래스 작성 문제
 * 
 * 클래스 이름 : Student
 * 멤버변수 : 이름(문자열, name), 성적(점수, score)
 * 메서드 : 이름(name)과 성적(score)을 출력하는 print() 메서드 정의 (파라미터 X, 리턴 X)
 * 
 * main() 메서드에서 객체 생성 및 초기화 후 print() 메서드 호출 
 */

class Student {
	String name;
	int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public void print() {
		System.out.println("이름 : " + name + " \n점수 : " + score);
	}
}










