
public class Show_fight {
	public static void show_fight(Hero h, Enemy e) {
		// 戦闘時
		
		Show_status_Enemy.status_show(e.name,e.hp,e.hp_max,e.level);
		System.out.println();
		System.out.println("どうする？");
		System.out.println("1.たたかう");
		System.out.println("2.かいふく");
		System.out.println("3:にげる");
		System.out.print(">>>");
		int i = new java.util.Scanner(System.in).nextInt();
		switch (i) {
		case 1:// たたかう
			h.attack(h,e);
			break;
		case 2:// かいふくまほう
			h.heal();
			break;
		case 3:// にげる
			h.run();
			break;
		}

	}
}
