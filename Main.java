public class Main {

	public static void main(String[] args) {
		// visual studio codeからのgithub動作確認
		// コメントのテスト
		// タイトルとバージョン番号
		String title = "あーるぴーじー";// 全角7文字にしないとレイアウトが崩れる
		String ver_number = "０．０．１";// カウントアップは最大９．９．９の各桁一桁にしないとレイアウトが(以下略

		Hero h = new Hero();
		h.hp = 90;
		h.hp_max = 100;
		h.level = 1;
		h.exp = 0;
		h.next_level_exp = 10 * h.level;
		h.total_exp = 0;
		h.stage = 1;

		Enemy e = new Enemy();
		e.level = 1;
		e.name = "よわいてき";
		e.hp_max = e.level * 10;// ランダムで*0.8～1.2のゆらぎをもたせる
		e.hp = e.hp_max;
		e.exp = 3;

		Enemy e2 = new Enemy();
		e2.level = 2;
		e2.name = "ふつうのてき";
		e2.hp_max = e2.level * 10;// ランダムで*0.8～1.2のゆらぎをもたせる
		e2.hp = e2.hp_max;
		e2.exp = 7;

		Enemy e3 = new Enemy();
		e3.level = 3;
		e3.name = "つよいてき";
		e3.hp_max = e3.level * 10;// ランダムで*0.8～1.2のゆらぎをもたせる
		e3.hp = e3.hp_max;
		e3.exp = 15;

		Enemy boss = new Enemy();
		boss.level = 9;
		boss.name = "ぼす";
		boss.hp_max = 99;
		boss.hp = boss.hp_max;
		boss.exp = 100;

		Show_Opening.show_opening(title, ver_number);

		// 常に表示(ステータス)
		Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp, h.stage);

		while (h.hp > 0 && h.stage <= 20) {
			if (h.stage == 7 || h.stage == 13 || h.stage == 19) {// stageが7、13、19は温泉地なのでstatusを表示させてstage++して先に進む
				System.out.println("おんせん　に　はいって　ひとやすみ。");
				System.out.println("HP　が　ぜんかいふく　した。");
				h.hp = h.hp_max;
				Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp, h.stage);
				h.stage++;
			}
			switch (Show_move.show_move(h)) {
			case 1:// すすむ
				if (h.stage == 1 || h.stage == 7 || h.stage == 13 || h.stage == 19) {// stageが1は温泉地なのでstage++して先に進む
					h.stage++;
				}

				if (1 <= h.stage && h.stage <= 6) {// stage1～6の間(会敵するステージ)
					Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp,
							h.stage);
					System.out.println(e.name + "があらわれた！");
					while (h.hp > 0) {// 勇者のHPが0にならない限り、ループを回す(戦闘状態)
						Show_fight.show_fight(h, e);

						if (e.hp <= 0) {// 敵のHPが0になったら(コード上では0以下になったら)
							System.out.println(e.name + "を　たおした。");
							h.stage += 1;// 次のステージへ上がる
							e.hp = e.hp_max;// 次に出てくる敵のHPを満タンにしておく
							e.level += 1;// 次に出てくる敵のレベルを1上げておく
							h.exp += e.exp;// 倒した敵に応じた経験値(EXP)をもらう
							h.total_exp += e.exp;// 総獲得経験値にも反映させる
							break;
						}

						if (h.hp <= 0) {
							System.out.println("ゆうしゃ　は　しにました。あーあ");
							System.out.println("セーブ　ちてん　に　もどります");
							h.stage = 1;
							h.hp = h.hp_max;
						}
					}
				}

				if (8 <= h.stage && h.stage <= 12) {// stage8～12の間(会敵するステージ)
					Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp,
							h.stage);
					System.out.println(e.name + "があらわれた！");
					while (h.hp > 0) {// 勇者のHPが0にならない限り、ループを回す(戦闘状態)
						Show_fight.show_fight(h, e);

						if (e.hp <= 0) {// 敵のHPが0になったら(コード上では0以下になったら)
							System.out.println(e.name + "を　たおした。");
							h.stage += 1;// 次のステージへ上がる
							e.hp = e.hp_max;// 次に出てくる敵のHPを満タンにしておく
							e.level += 1;// 次に出てくる敵のレベルを1上げておく
							h.exp += e.exp;// 倒した敵に応じた経験値(EXP)をもらう
							h.total_exp += e.exp;// 総獲得経験値にも反映させる
							break;
						}

						if (h.hp <= 0) {
							System.out.println("ゆうしゃ　は　しにました。あーあ");
							System.out.println("セーブ　ちてん　に　もどります");
							h.stage = 7;
							h.hp = h.hp_max;
						}
					}
				}

				if (14 <= h.stage && h.stage <= 18) {// stage14～18の間(会敵するステージ)
					Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp,
							h.stage);
					System.out.println(e.name + "があらわれた！");
					while (h.hp > 0) {// 勇者のHPが0にならない限り、ループを回す(戦闘状態)
						Show_fight.show_fight(h, e);

						if (e.hp <= 0) {// 敵のHPが0になったら(コード上では0以下になったら)
							System.out.println(e.name + "を　たおした。");
							h.stage += 1;// 次のステージへ上がる
							e.hp = e.hp_max;// 次に出てくる敵のHPを満タンにしておく
							e.level += 1;// 次に出てくる敵のレベルを1上げておく
							h.exp += e.exp;// 倒した敵に応じた経験値(EXP)をもらう
							h.total_exp += e.exp;// 総獲得経験値にも反映させる
							break;
						}

						if (h.hp <= 0) {
							System.out.println("ゆうしゃ　は　しにました。あーあ");
							System.out.println("セーブ　ちてん　に　もどります");
							h.stage = 12;
							h.hp = h.hp_max;
						}
					}
				}
				if (20 == h.stage) {
					Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp,
							h.stage);
					System.out.println(boss.name + boss.level + "があらわれた！");
					while (h.hp > 0) {// 勇者のHPが0にならない限り、ループを回す(戦闘状態)
						Show_fight.show_fight(h, boss);

						if (boss.hp <= 0) {// 敵のHPが0になったら(コード上では0以下になったら)
							System.out.println(boss.name + "を　たおした。");
							e.level += 1;// 次に出てくる敵のレベルを1上げておく
							h.exp = e.exp;// 倒した敵に応じた経験値(EXP)をもらう
							h.total_exp = e.exp;// 総獲得経験値にも反映させる

							// エンディング
							Show_Ending.show_ending(title, ver_number);
							h.stage++;
							break;
						}

						if (h.hp <= 0) {
							System.out.println("ゆうしゃ　は　しにました。あーあ");
							System.out.println("セーブ　ちてん　に　もどります");
							if (2 <= h.stage && h.stage <= 6) {// stage2～6にいる場合は、stage1に戻る
								h.stage = 1;
							} else if (8 <= h.stage && h.stage <= 12) {// stage8～12にいる場合は、stage7に戻る
								h.stage = 7;
							} else if (13 <= h.stage && h.stage <= 17) {// stage13～17にいる場合は、stage12に戻る
								h.stage = 12;
							}
						}
					}
				}
				break;
			case 2:// もどってやすむ
				if (2 <= h.stage && h.stage <= 6) {
					h.stage = 1;
				} else if (8 <= h.stage && h.stage <= 12) {
					h.stage = 7;
				} else if (13 <= h.stage && h.stage <= 17) {
					h.stage = 12;
				}
				Show_status_Hero.status_show(h.hp, h.hp_max, h.level, h.exp, h.next_level_exp, h.total_exp, h.stage);
				System.out.println("おんせん　に　はいって　ひとやすみ。");
				System.out.println("HP　が　ぜんかいふく　した。");
				h.hp = h.hp_max;
				break;
			}

		}

	}

}
