package If_;

public class Ex2 {

	public static void main(String[] args) {
		int score = -3; String str = "";
		if (score <=100 && score >= 0) {
			if (score >=90) {
				str="A학점";
			} else if (score >= 80) {
				str="B학점";
			} else if (score >= 70) {
				str="C학점";
			} else if (score >= 60) {
				str="D학점";
			} else if (score >= 0) {
				str="F학점";
			}
		} else str="점수입력 오류!";
		System.out.println(str);
	}
}