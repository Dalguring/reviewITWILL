package enum_;

public class Test2 {

	public static void main(String[] args) {
		Week2 w = Week2.월;
		switch (w) {
		case 월:
		case 화:
		case 수:
		case 목:	
		case 금:
			System.out.println("오늘은 " + w.name() + "요일...주말까지 " + -(w.compareTo(Week2.토)) + "일 남았다!");
			break;
		case 토: case 일: System.out.println("이미 주말!!!");break;
		}
	}

}

enum Week2 { 월,화,수,목,금,토,일 }


