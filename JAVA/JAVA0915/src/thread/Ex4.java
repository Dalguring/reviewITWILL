package thread;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 멀티쓰레딩 환경에서의 문제점
		 * - 복수개의 쓰레드에서 동일한 객체의 데이터에 접근할 경우
		 * 	 각 쓰레드에서 사용되는 데이터의 일관성이 깨질 수 있다
		 * 	 => A라는 쓰레드에서 접근해서 사용하는 데이터를
		 * 	 	B라는 쓰레드에서 동시에 접근해서 변경할 경우
		 * 		올바른 데이터가 아니게 될 수 있음 (=데이터 일관성이 깨짐!)
		 * 
		 */
		
		Account account = new Account(100000);
		
		//출금 쓰레드를 수행할 객체를 2개 생성
		withdrawThread iBanking = new withdrawThread("인터넷뱅킹", account, 2000);
		withdrawThread mBanking = new withdrawThread("모바일뱅킹", account, 2000);
		
		iBanking.start();
		mBanking.start();
		
		
	}

}

class Account {
	int balance;

	public Account(int balance) {
		this.balance = balance;
	}
	
	// 입금 메서드
	public int deposit(int amount) {
		balance += amount;
		return balance; 
	}
	
	// 출금 메서드
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
		} else {
			System.out.println("잔액이 부족합니다!");
			amount = 0;
		}
		System.out.println("출금된 금액 : " + amount + " 출금후 잔고 : " + balance);
		return amount;
	}
	
}

// 출금 기능을 전담할 쓰레드 정의
class withdrawThread extends Thread {
	
	Account account;
	int amount;
	
	public withdrawThread(String threadName, Account account, int amount) {
		super(threadName);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		for(int i = 1; i < 6; i++) {
			// 현재쓰레드를 0.5초 일시정지
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int money = account.withdraw(amount);
		}
		
	}
	
}




