package string;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringBuilder & StringBuffer
		 * 
		 * - StringBuffer	: 문자열이 안전하게 변경되도록 보장(O) / 멀티스레드에서 사용
		 * - StringBuilder 	: 문자열이 안전하게 변경되도록 보장(X) / 싱글스레드에서 사용
		 * 	 (멀티스레드 프로그램이 아니라면 StringBuilder 속도가 좀 더 빠르다)
		 * 	 주소가 변경되지 않고 동일한 객체에 추가되므로 메모리를 효율적으로 사용할 수 있음.
		 */
		
		String javaStr = new String("Java");
		// System.identityHashCode() :  인스턴스가 처음 생성되었을 때 메모리 주소
		System.out.println("javaStr 문자열 주소 : " + System.identityHashCode(javaStr));
		
		javaStr += "Programming";
		System.out.println("javaStr 문자열 주소 : " + System.identityHashCode(javaStr));
		
		StringBuilder builder = new StringBuilder("Java");
		System.out.println("연산 전 builder 메모리 주소 : " + System.identityHashCode(builder));
		builder.append(" and");
		builder.append(" android");
		builder.append(" programming is fun!!");
		System.out.println("연산 후 builder 메모리 주소 : " + System.identityHashCode(builder));
		
		System.out.println("-----------------------------------------------------");
		
		String str1 = "abc";		//abc
		String str2 = str1 + "de";	//abcde
		String str3 = "abc";		//abc
		String str4 = "a" + "bc";	//abc
		String str5 = "a";			
		String str6 = str5 + "bc";	//abc
		str5 += "bc";				//abc
		
		System.out.println("Str1 : " + System.identityHashCode(str1));
		System.out.println("Str2 : " + System.identityHashCode(str2));
		System.out.println("Str3 : " + System.identityHashCode(str3));
		System.out.println("Str4 : " + System.identityHashCode(str4));
		System.out.println("Str5 : " + System.identityHashCode(str5));
		System.out.println("Str6 : " + System.identityHashCode(str6));
		
		
		
		
	}

}
