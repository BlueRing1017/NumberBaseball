package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ball b = new ball();
		
		String cmd;
		boolean play = false;
		int round = 1;
		
		while(true) {
			if(play) {
				if (round <= 10) {					
					System.out.print("[ Round " + round + " ] 숫자를 입력하세요 : ");
					b.check();
					round++;
				}else {
					play = false;
				}
			}else {
				System.out.print("게임을 진행하시겠습니까? (y/n) ");
				cmd = sc.nextLine();
				if (cmd.equals("n")) {
					System.out.println("프로그램을 종료합니다.");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {e.printStackTrace();}
					break;
				}else if (cmd.equals("y")) {
					System.out.println("게임을 시작합니다.");
					b.roll();
					play = true;
				}
			}
			
			
		}

	}

}
