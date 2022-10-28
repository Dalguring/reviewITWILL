package if_;

public class Test1 {

	public static void main(String[] args) {
		int num = 5;
		if(num<0) {
			num=-num;
		}
		System.out.println("변수 num = " + num);
		char ch = 'a';
		if(ch>='A' && ch<='Z') {
			ch = (char)(ch+32);
		} System.out.println(ch);
		System.out.println("=====================================");
		char ch2 = 'a';
		ch2 += ('A' <= ch2 && ch2 <= 'Z') ? 32 : 0;
		System.out.println(ch2);
	
	}

}
