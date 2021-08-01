
public class Hero {
	String name;
	int hp;
	int hp_max;
	int level;
	int exp;
	int next_level_exp;
	int total_exp;
	int stage;
	
	//勇者の攻撃
	public void attack(Hero h,Enemy e) {
		System.out.println("ゆうしゃはこうげきした");
//		System.out.println(e.name + "　は　" + h.level + "の　ダメージ");
		System.out.println(e.name + "　は　" + 5 + "の　ダメージ");
//		e.hp -= h.level;
		e.hp -= 5;
		System.out.println("つづいて、"+e.name+"のこうげき！");
		System.out.println("ゆうしゃは"+h.level+"の　ダメージ");
		h.hp -= 1;
		Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp,stage);
		Show_status_Enemy.status_show(e.name, e.hp, e.hp_max, e.level);
	}
	
	//勇者の回復魔法
	public void heal() {
		System.out.println("ゆうしゃはかいふくまほうをとなえた");
		
	}
	
	//勇者の逃走
	public void run() {
		System.out.println("ゆうしゃはにげだした");
		
	}
}
