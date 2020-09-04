package DBInterface;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.Buy_DAO;
import DAO.Car_DAO;
import DTO.Buy_DTO;
import DTO.Car_DTO;

public class UserServiceINFImpl implements UserServiceINF {

//	private Car_DAO cdao = new Car_DAO();
//	private Buy_DAO bdao = new Buy_DAO();
	Car_DAO cdao = Car_DAO.getInstance();
	Buy_DAO bdao = Buy_DAO.getInstance();
	
	@Override // 메서드 재정의
	public void carlist() {
		ArrayList<Car_DTO> cList = cdao.selectAll();
		System.out.println("고객님 저희가 가지고 있는 차량입니다.");
		System.out.println("=======================");
		for(int i = 0; i < cList.size(); i++) {
			Car_DTO cdto = new Car_DTO();
			cdto = cList.get(i);
			System.out.println("<"+cdto.getNo()+"번 차량입니다>");
			System.out.println("제조사 : "+cdto.getBrand());
			System.out.println("모델명 : "+cdto.getName());
			System.out.println("차   종 : "+cdto.getModel());
			System.out.println("배기량 : "+cdto.getCc()+"cc");
			System.out.println("가   격 : "+cdto.getPrice()+"만원");
			System.out.println("재고량 : "+cdto.getEa()+"EA");
			System.out.println("=======================");
		}
	}

	@Override
	public void buy() {
		int selnum = -1;
		String username = null;
		int selea = -1;
		Scanner in = new Scanner(System.in);
		carlist();
		System.out.println("구매를 원하시면 y, 없으시면 n을 입력하세요.");
		String buy = in.nextLine();
		if(buy.equals("y")) {
			Buy_DTO bdto = new Buy_DTO();
			System.out.println("구매자분의 성함을 입력해 주세요.");
			username = in.nextLine();
			bdto.setUsername(username);
			System.out.println("번호를 입력해 주세요.");
			selnum = in.nextInt();
			in.nextLine();
			bdto.setNo(selnum);
			System.out.println("구매수량을 입력해 주세요.");
			selea = in.nextInt();
			in.nextLine();
			bdto.setEa(selea);
			
			bdao.buy(bdto);
			cdao.updateea(selnum, selea);
			System.out.println("구매가 완료되었습니다.");
		}
		
	}

	@Override
	public void buylist() {
		ArrayList<Buy_DTO> bList = bdao.selectAll();
		System.out.println("구매 내역");
		System.out.println("=======================");
		for(int i = 0; i < bList.size(); i++) {
			Buy_DTO bdto = new Buy_DTO();
			bdto = bList.get(i);
			System.out.println("<"+i+">번 내역");
			System.out.println("구     매     자 : "+bdto.getUsername());
			System.out.println("구매 차량번호 : "+"<"+bdto.getNo()+"번 차량입니다>");
			System.out.println("구  매   수  량 : "+bdto.getEa()+"대");
		}
		
	}

}
