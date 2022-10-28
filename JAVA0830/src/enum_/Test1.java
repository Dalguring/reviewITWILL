package enum_;

public class Test1 {

	public static void main(String[] args) {
		GetWeek w = new GetWeek();
		w.setWeek(Week.FRIDAY);
		w.printWeek();
	}

}

enum Week {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

class GetWeek {
	Week week;

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	
	public void printWeek() {
		switch (week) {
		case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY: System.out.println("하...");	break;
		case FRIDAY:											  System.out.println("불금!");	break;
		case SATURDAY: case SUNDAY:								  System.out.println("주말!");	break;
		}
	}
	
}



