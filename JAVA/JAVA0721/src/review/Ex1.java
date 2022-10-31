package review;

public class Ex1 {

	public static void main(String[] args) {
		Hero 뽀삐 = new Hero();
		뽀삐.damage = 100;
		뽀삐.hp = 500;
	
		Hero 가렌 = new Hero();
		가렌.damage = 150;
		가렌.hp = 700;
		
		뽀삐.showHeroInfo();
		System.out.println("===================================");
		가렌.showHeroInfo();
		System.out.println("===================================");
		뽀삐.attack(가렌);
		가렌.showHeroInfo();
		System.out.println("===================================");
		가렌.attack(뽀삐);
		뽀삐.showHeroInfo();
	}

}

class Hero {
	
	int damage;
	int hp;
	int mp;
	
	public void showHeroInfo() {
		System.out.println("damage : " + damage);
		System.out.println("hp : " + hp);
	}
	
	public void attack(Hero target) {
		target.hp -= damage;
	}
	
}







