
public class Show_move {
	public static int show_move(Hero h) {
		int i;
		// 移動時
		
		if(h.stage == 1 || h.stage==7||h.stage==13||h.stage==19) {
			System.out.println("どうする？");
			System.out.println("1.すすむ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.print(">>>");
			i = new java.util.Scanner(System.in).nextInt();
		}else {		
			System.out.println("どうする？");
			System.out.println("1.すすむ");
			System.out.println("2.もどって　やすむ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.print(">>>");
			i = new java.util.Scanner(System.in).nextInt();
		}
		return i;
	}
}
