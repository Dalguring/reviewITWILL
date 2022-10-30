package thread;

public class Test2 {

	public static void main(String[] args) {
		SendMessageThread smt = new SendMessageThread("Hi", 10000);
		FileTransferThread ftt = new FileTransferThread("사진.jpg", 10000);
		ReceiveMessageThread rmt = new ReceiveMessageThread("밥먹자", 10000);
		
		smt.start();
		ftt.start();
		rmt.start();
		
		
	}

}

class SendMessageThread extends Thread {
	String str;
	int count;
	
	public SendMessageThread(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str + " 메시지 전송");
		}
	}
}

class FileTransferThread extends Thread {
	String str;
	int count;
	
	public FileTransferThread(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str + " 파일전송");
		}
	}
}

class ReceiveMessageThread extends Thread {
	String str;
	int count;
	
	public ReceiveMessageThread(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str + " 메시지 수신");
		}
	}
}




