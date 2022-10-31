import java.util.Random;

public class Exam {

	public static void main(String[] args) {
		Unit u = new GroundUnit();
		Tank t = new Tank();
		AirCraft ac = new AirCraft();
		
		u = ac;
		System.out.println(u.b);
		
		
	}

}

class Unit {
	int b = 5;
}
class AirUnit extends Unit {}
class GroundUnit extends Unit {
	int a = 3;
}
class Tank extends GroundUnit {}
class AirCraft extends AirUnit {
	int c = 1;
}
