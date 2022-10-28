package oop;

class Account2 {
	String accountNo;
	String onwerName;
	int balance;
	
	void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo + "\n예금주명 : " + onwerName + "\n현재잔고 : " +balance + "원");
	}
	
	void deposit(int account) {
		balance += account;
		System.out.println("입금 금액 : " + account + "원" + "\n현재잔고 : " + balance + "원");
	}
	
	int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("출금할 금액 : " + amount + "원" + "\n잔액이 부족하여 출금 불가 (현재잔고 : " + balance + "원)");
			return 0;
		} else {
			balance-=amount;
			System.out.println("출금할 금액 : " + amount + "원" + "\n현재잔고 : " + (balance) + "원");
			return amount;
		}
		
	}
}


public class Test2 {

	public static void main(String[] args) {
		
		Account2 my = new Account2();
		my.accountNo = "123-456";
		my.onwerName = "서성민";
		my.balance = 8768;
		
		my.showAccountInfo();
		System.out.println("================================");
		my.deposit(232);
		System.out.println("================================");
		my.withdraw(50000);
	}

}
