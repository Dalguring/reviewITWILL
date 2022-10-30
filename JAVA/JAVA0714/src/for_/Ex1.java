package for_;

public class Ex1 {

	public static void main(String[] args) {
		for(int min = 0; min <60; min++) {
			
			for(int sec=0; sec < 60; sec++) {
				System.out.println(min + "분" + sec + "초");
			}
		}
		
		for(int h = 0; h <24; h++) {
			for(int n = 0; n < 60; n++) {
				for(int s = 0; s < 60; s++) {
					System.out.println(h + "시" + n + "분" + s + "초");
				}
			}
		}
		
		
		
	}

}
