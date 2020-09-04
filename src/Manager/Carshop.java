package Manager;

import java.util.Scanner;

import DBInterface.UserServiceINFImpl;

public class Carshop {

	private Scanner in = new Scanner(System.in);
	private UserServiceINFImpl usi = new UserServiceINFImpl();
	
	public Carshop() {
		int selnum = -1;
		while(true) {
			menu();
			System.out.println("선택해 주세요.");
			selnum = in.nextInt();
			in.nextLine();
			
			switch(selnum) {
			case 1: mycarlist(); break;
			case 2: buy(); break;
			case 3: buylist(); break;
				default:
			}
			
		}
	}
	
	public void mycarlist() {
		usi.carlist();
	}
	
	public void buy() {
		usi.buy();
	}
	
	public void buylist() {
		usi.buylist();
	}
	
	
	public void menu() {
		System.out.println("1. 차량보기");
		System.out.println("2. 구매하기");
		System.out.println("3. 구매내역보기");
	}
}
