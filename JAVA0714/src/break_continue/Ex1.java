package break_continue;

public class Ex1 {

	public static void main(String[] args) {
		int i = 1;
//		for(;;) {//for문의 무한루프
		while(true) {
			System.out.println(i);
			
			if(i ==5) {
				break;
			}
			
			i++;
		}
		System.out.println(i);
		System.out.println("=================================================");
		for(i = 1; i < 11; i++) {
			
			if(i %2 == 1) {
				continue;
			}
			System.out.println(i);
		}
		System.out.println("========================================");
		i = 0;
		while(i <= 10) {
			i++;
			if(i %2 == 1) {
				continue;
			}
			System.out.println(i);
			
			
		}
		
		
		
	}

}
