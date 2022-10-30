package static_;

public class Ex1 {

	public static void main(String[] args) {
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		Hero h3 = new Hero();
		
		h1.job="궁수";
		h2.job="전사";
		h3.job="도적";
		
		//------------h1 접속-----------
		Item i = new Item();
		i.kind = "활";
		
		h1.setItem(i, 0);
		h1.showItems();
		
		Item i2 = h1.getItem(0);
		h1.setSharedItem(i, 0);
		//------------h1 접속종료-----------
		
		//------------h2 접속-----------
		h2.showItems();
		h2.showSharedItems();
		//------------h3 접속-----------
		h3.showItems();
		h3.showSharedItems();
	}

}

class Hero {
	
	static Item[] 공유창고 = new Item[10];
	Item[] 개인창고 = new Item[10];
	
	String job;
	int damage;
	int hp;
	int mp;
	//---------------개인창고에 대한 get, set, print 메서드-----------------
	public void setItem(Item item, int index) {
		개인창고[index] = item;
	}
	
	public Item getItem(int index) {
		Item item = 개인창고[index];
		개인창고[index] = null;
		return 개인창고[index];
	}
	
	public void showItems() {
		
		System.out.println("---- 개인창고 정보 ----");
		for(Item item : 개인창고) {
			String str = item == null ? null : item.kind;
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("--------------------");
	}
	
	//---------------공유창고에 대한 get, set, print 메서드-----------------
	public void setSharedItem(Item item, int index) {
		공유창고[index] = item;
	}
	
	public Item getSharedItem(int index) {
		Item item = 공유창고[index];
		공유창고[index] = null;
		return 공유창고[index];
	}
	
public void showSharedItems() {
		
		System.out.println("---- 공유창고 정보 ----");
		for(Item item : 공유창고) {
			String str = item == null ? null : item.kind;
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("--------------------");
	}
	
	
	
	public void skill1() {}
	public void skill2() {}
	public void skill3() {}
}

class Item {
	String kind;
	int price;
}



