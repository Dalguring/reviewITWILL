package method;

class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		System.out.println("입금할 금액 : " + amount + "원");
		this.balance += amount;
		System.out.println("입금 후 현재잔고 : " + balance + "원");
	}
	
	
}

public class Test1 {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.setAccountNo("111-1111");
		acc.setOwnerName("서성민");
		acc.deposit(10000);
		acc.deposit(5000);
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance());
		
		
	}

}
