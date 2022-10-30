package switch_case;

public class Ex1 {

	public static void main(String[] args) {
		int num = 2;
		
		switch (num) {
		case 1:
			System.out.println("num = 1");
			break;
		case 2:
			System.out.println("num = 2");
//			break;
		case 3:
			System.out.println("num = 3");
			break;
		default:
			System.out.println("나머지");
			break;
		}
		System.out.println("===================================");
		String init = "K";
		switch (init) {
		case "U":
			System.out.println("USA");
			break;
		case "K":
			System.out.println("KOREA");
			break;
		case "C":
			System.out.println("CANADA");
			break;
		}
		
		
		
		
		
	}

}
