package thread;

public class Ex1 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <=100; i++) {
					System.out.println("A작업");
				}
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <=100; i++) {
					System.out.println("B작업");
				}
			}
		});
		
		t2.start();
		
		System.out.println("현재 쓰레드명 : " + Thread.currentThread().getName());
		System.out.println("t1의 쓰레드명 : " + t1.getName());
		System.out.println("t2의 쓰레드명 : " + t2.getName());
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <=10; i++) {
					// 현재 수행중인 쓰레드 객체를 가져오는 방법
					// Thread 클래스의 static 메서드 currentThread() 메서드 호출
					Thread t = Thread.currentThread();
					System.out.println("C작업! 현재쓰레드 : " + t.getName());
				}
			}
		});
		t3.setName("t3 쓰레드");
		t3.start();
		System.out.println("t3.getName() : " + t3.getName());
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					Thread t = Thread.currentThread();
					System.out.println("D작업! 현재쓰레드 : " + t.getName());
				}
			}
		}, "t4 쓰레드");
		
		t4.start();
		
		System.out.println("======================================================");
		
		myThread mt = new myThread("<<< 내 쓰레드 >>>", 1000);
		mt.start();
		
		
	}

}

class myThread extends Thread {
	int count;
	
	public myThread(String threadName, int count) {
		super(threadName);
//		setName(threadName); // 외부로부터 쓰레드명을 전달받아 초기화 가능
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(i + " " + getName());
		}
	}
}











