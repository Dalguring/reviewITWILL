package static_;

class VariableEx {
	String instanceMember = "인스턴스 멤버 변수";
	String instanceMember2;
	static String classMember = "클래스 멤버 변수";
	
	public void instanceMethod(String parameterVariable) {
		String localVariable = "로컬 변수";
		
		System.out.println(instanceMember);
		System.out.println(classMember);
		
		System.out.println(parameterVariable);
		System.out.println(localVariable);
	}
	
	public void instanceMethod2() {
		System.out.println(instanceMember);
		System.out.println(classMember);
		//아래는 로컬 변수이기에 접근이 불가능
//		System.out.println(parameterVariable);
//		System.out.println(localVariable);
		
	}
	
}
public class Ex2 {

	public static void main(String[] args) {
		
		VariableEx ve = new VariableEx();
		System.out.println(ve.instanceMember);
		System.out.println(ve.instanceMember2);
		System.out.println(VariableEx.classMember);
		
		
	}

}
