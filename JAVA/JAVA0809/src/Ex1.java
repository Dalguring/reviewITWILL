
public class Ex1 {

	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1==str2);
		String str3 = new String("abc");
		String str4 = new String("abc");
		str1 = str1 + "def"; //연산자를 만나면 상수풀이 아닌 Heap공간의 주소값을 가리킴
		String str5 = "abcdef";
		
		System.out.println(str1==str2);
		System.out.println(str2==str3);
		System.out.println(str3==str4);
		System.out.println(str1==str5); // 주소비교\
		System.out.println(str1.equals(str5));
	}

}
