package inheritance;

public class Test3 {

	public static void main(String[] args) {
		ItwillBank2 ib2 = new ItwillBank2();
		ib2.accountNo = "222-2222";
		ib2.balance = 100000;
		ib2.grade = 0;
		ib2.ownerName = "이순신";
		ib2.showAccountInfo();
		System.out.println("===========입금============");
		ib2.deposit(50000);
		System.out.println("===========출금============");
		int a=ib2.withdraw(200000);
		System.out.println(a);
	}

}

class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
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
			return amount;
		} else {
			System.out.println("잔고 부족!");
			amount = 0;
			return amount;
		}
	}
}

class ItwillBank2 extends Account2{
	int grade;
	@Override
	public int withdraw(int amount) {
		if(grade==1) {
			balance -= amount;
			System.out.println("출금금액 : " + amount + "원");
			System.out.println("출금 후 잔고 : " + balance + "원");
		} else if(grade==0){
			return super.withdraw(amount);
		}
		return amount;
		
	}
}


