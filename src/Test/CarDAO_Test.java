package Test;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import DAO.Car_DAO;
import DTO.Car_DTO;

public class CarDAO_Test {

	Car_DAO cdao = null;
	Scanner in = new Scanner(System.in);
	@Before
	public void loading() {
		cdao = Car_DAO.getInstance();
	}
	
	@Test // 자동차 목록보기 테스트
	public void selectAllTest() {
		ArrayList<Car_DTO> cList = cdao.selectAll();
		for(int i = 0; i < cList.size(); i++) {
			System.out.println("=============================");
			System.out.println("번   호 : "+cList.get(i).getNo());
			System.out.println("제조사 : "+cList.get(i).getBrand());
			System.out.println("모델명 : "+cList.get(i).getName());
			System.out.println("차   종 : "+cList.get(i).getModel());
			System.out.println("배기량 : "+cList.get(i).getCc()+"cc");
			System.out.println("가   격 : "+cList.get(i).getPrice()+"만원");
			System.out.println("재고량 : "+cList.get(i).getEa()+"EA");
		}
	}
	
	@Test // 자동차 등록하기 테스트
	public void insertOneTest() {
		Car_DTO cdto = new Car_DTO();
		System.out.println("제조사를 입력해 주세요.");
		cdto.setBrand(in.nextLine());
		System.out.println("모델명을 입력해 주세요.");
		cdto.setName(in.nextLine());
		System.out.println("차종을 입력해 주세요");
		cdto.setModel(in.nextLine());
		System.out.println("배기량을 입력해 주세요.");
		cdto.setCc(in.nextInt());
		in.nextLine();
		System.out.println("차량 가격을 입력해 주세요.");
		cdto.setPrice(in.nextInt());
		in.nextLine();
		System.out.println("재고량을 입력해 주세요.");
		cdto.setEa(in.nextInt());
		in.nextLine();
		cdao.insertone(cdto);
		System.out.println("등록 되었습니다.");
	}
	
	@Test // 목록 차량이름으로 삭제 테스트
	public void deleteTest() {
		cdao.delete(in.nextLine());
		System.out.println("삭제 되었습니다.");
	}
	
	@Test // 번호로 재고수량 조정 테스트
	public void updateTest() {
		cdao.updateea(in.nextInt(), in.nextInt());
		in.nextLine();
		System.out.println("재고량을 변경하였습니다");
	}
	
	@Test // 브랜드로 검색 테스트
	public void brandsearchTest() {
		Car_DTO c = cdao.brandsearch(in.nextLine());
		System.out.println(c.getBrand());
		System.out.println(c.getName());
		System.out.println(c.getModel());
		System.out.println(c.getCc());
		System.out.println(c.getPrice());
		System.out.println(c.getEa());
	}
	
	@Test // 재고수량 감소 테스트
	public void updateeaminusTest() {
		cdao.updateeaminus(in.nextInt(), in.nextInt());
		in.nextLine();
	}
	
	
	
	
	
}
