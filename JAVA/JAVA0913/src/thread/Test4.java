package thread;

public class Test4 {

	public static void main(String[] args) {
		String str1 = "메시지 송신";
		String str2 = "파일 전송";
		String str3 = "메시지 수신";
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " : " + str1);
				}
			}
		}).start();; 
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " : " + str2);
				}
			}
		}).start();; 
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(i + " : " + str3);
				}
			}
		}).start();; 
		
	}

}







