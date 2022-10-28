package constructor;

class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + this.accountNo);
		System.out.println("예금주명 : " + this.ownerName);
		System.out.println("현재잔고 : " + this.balance);
	}
	
	public Account2() {
		this.accountNo = "111-1111-111";
		this.ownerName = "홍길동";
		this.balance = 0;
	}

	public Account2(String accountNo) {
		this.accountNo = accountNo;
		this.ownerName = "홍길동";
		this.balance = 0;
	}

	public Account2(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = 0;
	}

	public Account2(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
}


public class Test2 {

	public static void main(String[] args) {
		Account2 acc1 = new Account2();
		acc1.showAccountInfo();
		System.out.println("===============================");
		Account2 acc2 = new Account2("111-1111-111");
		acc2.showAccountInfo();
		System.out.println("===============================");
		Account2 acc3 = new Account2("111-1111-111", "홍길동");
		acc2.showAccountInfo();
		System.out.println("===============================");
		Account2 acc4 = new Account2("111-1111-111", "홍길동", 0);
		acc2.showAccountInfo();
		
	}

}
