package method;

public class Ex2 {

	public static void main(String[] args) {
		
		AbsNum absNum = new AbsNum();
		int num = absNum.abs(-5);
		System.out.println("-5의 절댓값 : " + num);
		System.out.println("-3.14의 절댓값 : " + absNum.dAbs(-3.14));
		System.out.println("-100L의 절댓값 : " + absNum.lAbs(-100L));
		
		System.out.println("====================================");
		
		OverloadingAbsNum oan = new OverloadingAbsNum();
		System.out.println("정수 -10의 절댓값 " + oan.abs(-10));
		System.out.println("실수 -3.14의 절댓값 " + oan.abs(-3.14));
		System.out.println("정수 -10L의 절댓값 " + oan.abs(-10L));
	}

}


class OverloadingAbsNum {
	public int abs(int num) {
		System.out.println("int 이 호출됨!");
		return num < 0 ? -num : num;
	}
	
//	public int abs(int num2) { // 오버로딩 성립이 안됨 ->변수가 다르더라도 호출하는 입장에서는 식별이 되지 않으므로.
//		return num < 0 ? -num : num;
//	}
	
	public double abs(double num) {
		System.out.println("double 이 호출됨!");
		return num < 0 ? -num : num;
	}
	
	public long abs(long num) {
		System.out.println("long 이 호출됨!");
		return num < 0 ? -num : num;
	}
}

// ===========================================
class AbsNum {
	public int abs(int num) {
		return num < 0 ? -num : num;
	}
	
	public double dAbs(double num) {
		return num < 0 ? -num : num;
	}
	
	public long lAbs(long num) {
		return num < 0 ? -num : num;
	}
	
}
