
public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 13. final을 붙일 수 있는 대상과 그 의미
		 * 
		 * 변수 - 상수(한 번 저장된 값을 변경할 수 없다) 
		 * 메서드 - 오버라이딩을 할 수 없다
		 * 클래스 - 상속을 통해 클래스에 새로운 멤버 추가 불가능
		 * 		  (물려받는 것 가능, 물려주는 것 불가능)
		 */
		
		/*
		 * 14. 예외(Exception) try ~ catch ~ finally
		 */
		
		/*
		 * 15. 대소문자 구별하지 않고 알파벳이 같은지 확인하는 메서드 - equalsIgnoreCase
		 */
		
		String s = "abc";
		System.out.println(s.equals("ABC")); 
		System.out.println(s.equalsIgnoreCase("ABC")); 
		
		/*
		 * 16. 개발자가 생성한 인스턴스를 사용하다 더 이상 참조할 필요가 판단되면
		 * JVM에 포함되어 있는 '이것'에 의해 자동으로 메모리에서 제거 됩니다.
		 * 이것 = Garbage Collector
		 */
		
	}

}
