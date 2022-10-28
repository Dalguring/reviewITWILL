package inheritance;

public class Test1 {

	public static void main(String[] args) {
		ItwillBank itacc = new ItwillBank();
		itacc.accountNo = "111-1111";
		itacc.ownerName = "홍길동";
		itacc.balance = 100000;
		itacc.showAccountInfo();
		System.out.println("==========입금=========");
		itacc.deposit(50000);
		System.out.println("==========출금=========");
		itacc.withdraw(100000);
		System.out.println("==========보험가입=========");
		itacc.contract("자동차");
		System.out.println(itacc.insureName);
	}

}

class Account {
	String accountNo;
	String ownerName;
	int balance;
	int total;
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + this.accountNo);
		System.out.println("예금주명 : " + this.ownerName);
		System.out.println("현재잔고 : " + this.balance);
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금금액 : " + amount + "원");
		System.out.println("입금 후 잔고 : " + balance + "원");
	}
	
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println("출금금액 : " + amount + "원");
			System.out.println("출금 후 잔고 : " + balance + "원");
		} else {
			System.out.println("잔고 부족!");
			amount = 0;
		}
		return amount;
	}
}

class ItwillBank extends Account {
	String insureName;
	public void contract(String insureName) {
		this.insureName = insureName;
		System.out.println("계약하신 보험명 : " + insureName + "보험");
	}
}






