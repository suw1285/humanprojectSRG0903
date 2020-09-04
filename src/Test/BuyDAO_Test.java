package Test;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import DAO.Buy_DAO;
import DTO.Buy_DTO;

public class BuyDAO_Test {
	Scanner in = new Scanner(System.in);
	Buy_DAO bdao = null;
	
	@Before
	public void loading() {
		bdao = Buy_DAO.getInstance();
	}
	
	@Test // 차량 구입하기 테스트
	public void buyoneTest() {
		Buy_DTO bdto = new Buy_DTO();
		System.out.println("구입하시는 분의 성함을 입력해 주세요.");
		bdto.setUsername(in.nextLine());
		System.out.println("구입할 차량목록의 번호를 입력해 주세요.");
		bdto.setNo(in.nextInt());
		in.nextLine();
		System.out.println("구입할 수량을 적어주세요.");
		bdto.setEa(in.nextInt());
		in.nextLine();
		bdao.buy(bdto);
		System.out.println("차량을 구매하셨습니다.");
	}
	
	@Test // 구매내역 보기 테스트
	public void selectbuylistTest() {
		ArrayList<Buy_DTO> bList = new ArrayList<>();
		for(int i = 0; i < bList.size(); i++) {
			System.out.println("=============================");
			System.out.println("구매자 : "+bList.get(i).getUsername());
			System.out.println("구매 차량 번호 : "+bList.get(i).getNo());
			System.out.println("구매 수량 : "+bList.get(i).getEa());
		}
	}
	
	
	
	
	
	
	
}
