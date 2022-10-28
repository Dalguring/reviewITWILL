package constructor;

class Account {
	String accountNo;
	String ownerName;
	int balance;
	public Account() {
		this.accountNo="333-333-33";
		this.ownerName="소지섭";
		this.balance=1000000;
		
	}
	public Account(String accountNo, String ownerName, int balance) {
		System.out.println(this);
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
}

public class Test1 {

	public static void main(String[] args) {
		Account ac = new Account("81343-1811", "서성민", 6861);
		System.out.println(ac);
		System.out.println(ac.accountNo);
		System.out.println(ac.ownerName);
		System.out.println(ac.balance);
		
		
		Account ac2 = new Account();
		System.out.println(ac2.accountNo);
		System.out.println(ac2.ownerName);
		System.out.println(ac2.balance);
	}

}
