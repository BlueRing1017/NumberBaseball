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
					System.out.print("[ Round " + round + " ] ���ڸ� �Է��ϼ��� : ");
					b.check();
					round++;
				}else {
					System.out.print("[ Final ] ���� ���ڸ� �����ּ��� : ");
					b.answer(Integer.parseInt(sc.nextLine()));
					play = false;
				}
			}else {
				System.out.print("������ �����Ͻðڽ��ϱ�? (y/n) ");
				cmd = sc.nextLine();
				if (cmd.equals("n")) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}else if (cmd.equals("y")) {
					System.out.println("������ �����մϴ�.");
					b.roll();
					play = true;
					round = 1;
				}
			}
		}
	}
}
