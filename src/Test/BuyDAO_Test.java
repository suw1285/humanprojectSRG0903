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
	
	@Test // ���� �����ϱ� �׽�Ʈ
	public void buyoneTest() {
		Buy_DTO bdto = new Buy_DTO();
		System.out.println("�����Ͻô� ���� ������ �Է��� �ּ���.");
		bdto.setUsername(in.nextLine());
		System.out.println("������ ��������� ��ȣ�� �Է��� �ּ���.");
		bdto.setNo(in.nextInt());
		in.nextLine();
		System.out.println("������ ������ �����ּ���.");
		bdto.setEa(in.nextInt());
		in.nextLine();
		bdao.buy(bdto);
		System.out.println("������ �����ϼ̽��ϴ�.");
	}
	
	@Test // ���ų��� ���� �׽�Ʈ
	public void selectbuylistTest() {
		ArrayList<Buy_DTO> bList = new ArrayList<>();
		for(int i = 0; i < bList.size(); i++) {
			System.out.println("=============================");
			System.out.println("������ : "+bList.get(i).getUsername());
			System.out.println("���� ���� ��ȣ : "+bList.get(i).getNo());
			System.out.println("���� ���� : "+bList.get(i).getEa());
		}
	}
	
	
	
	
	
	
	
}
