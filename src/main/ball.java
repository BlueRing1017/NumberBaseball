package main;

import java.util.Scanner;

public class ball {
	Scanner sc = new Scanner(System.in);
	int fir;
	int scd;
	int thr;
	int afir;
	int ascd;
	int athr;
	int strike = 0;
	int ball = 0;
	int out = 0;
	int number;
	boolean pass = false;
	boolean err = false;
	
	void roll() {
		fir = (int)(Math.random() * 10);
		while (scd == fir) {
			scd = (int)(Math.random() * 10);
		}
		while (thr == scd) {
			thr = (int)(Math.random() * 10);
		}
		while (thr == fir) {
			thr = (int)(Math.random() * 10);
		}
		System.out.println("숫자가 설정되었습니다."/* + fir + scd + thr*/);
	}
	
	void check() {
		try {
			number = Integer.parseInt(sc.nextLine());
			err = false;
			what();
		}catch(NumberFormatException e) {
			System.out.println("숫자 이외의 것을 입력하셨습니다.");
			System.out.print("다시 입력하세요 : ");
			err = true;
			check();
		}
	}
	void what() {	
		if (err == false) {
			afir = number / 100;
			ascd = (number - (afir * 100)) / 10;
			athr = (number - (afir * 100)) - (ascd * 10);
			//System.out.println(afir + " : " + ascd + " : " + athr);
			if (afir == ascd) {
				System.out.println("각 자리의 숫자는 서로 중복되지 않습니다.");
				System.out.print("다시 입력하세요 : ");
				check();
			}else if (afir == athr) {
				System.out.println("각 자리의 숫자는 서로 중복되지 않습니다.");
				System.out.print("다시 입력하세요 : ");
				check();
			}else if (ascd == athr) {
				System.out.println("각 자리의 숫자는 서로 중복되지 않습니다.");
				System.out.print("다시 입력하세요 : ");
				check();
			}else {
				num();
				if (out == 1) {
					System.out.println("OUT!");
				}else {				
					System.out.println("Strike : " + strike + " | Ball : " + ball);
				}
				reset();
			}
		}
	}
	
	void num() {
		pass = false;
		if (afir == fir) {
			strike++;
			pass = true;
		}else if (afir == scd){
			ball++;
			pass = true;
		}else if (afir == thr){
			ball++;
			pass = true;
		}
		
		if (ascd == scd) {
			strike++;
			pass = true;
		}else if (ascd == fir){
			ball++;
			pass = true;
		}else if (ascd == thr){
			ball++;
			pass = true;
		}
		
		if (athr == thr) {
			strike++;
			pass = true;
		}else if (athr == fir){
			ball++;
			pass = true;
		}else if (athr == scd){
			ball++;
			pass = true;
		}
		
		if (pass == false) {
			out = 1;
		}
		
		
	}
	
	void reset() {
		strike = 0;
		ball = 0;
		out = 0;
	}
	
	void answer(int num) {
		int answer = (fir * 100) + (scd * 10) + thr;
		if (num == answer) {
			System.out.println("정답!");
		}else {
			System.out.println("오답입니다.");
			System.out.println("정답은 " + answer + " 입니다.");
		}
	}

}
