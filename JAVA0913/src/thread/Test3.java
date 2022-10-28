package thread;

public class Test3 {

	public static void main(String[] args) {
		
		new Thread(new GugudanRunnable(2)).start();
		new Thread(new GugudanRunnable(4)).start();
		new Thread(new GugudanRunnable(8)).start();
		
	}

}


class GugudanRunnable implements Runnable {

	int dan;

	public GugudanRunnable(int dan) {
		this.dan = dan;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
	}
	
}

