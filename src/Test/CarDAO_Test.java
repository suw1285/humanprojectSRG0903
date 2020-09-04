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
	
	@Test // �ڵ��� ��Ϻ��� �׽�Ʈ
	public void selectAllTest() {
		ArrayList<Car_DTO> cList = cdao.selectAll();
		for(int i = 0; i < cList.size(); i++) {
			System.out.println("=============================");
			System.out.println("��   ȣ : "+cList.get(i).getNo());
			System.out.println("������ : "+cList.get(i).getBrand());
			System.out.println("�𵨸� : "+cList.get(i).getName());
			System.out.println("��   �� : "+cList.get(i).getModel());
			System.out.println("��ⷮ : "+cList.get(i).getCc()+"cc");
			System.out.println("��   �� : "+cList.get(i).getPrice()+"����");
			System.out.println("��� : "+cList.get(i).getEa()+"EA");
		}
	}
	
	@Test // �ڵ��� ����ϱ� �׽�Ʈ
	public void insertOneTest() {
		Car_DTO cdto = new Car_DTO();
		System.out.println("�����縦 �Է��� �ּ���.");
		cdto.setBrand(in.nextLine());
		System.out.println("�𵨸��� �Է��� �ּ���.");
		cdto.setName(in.nextLine());
		System.out.println("������ �Է��� �ּ���");
		cdto.setModel(in.nextLine());
		System.out.println("��ⷮ�� �Է��� �ּ���.");
		cdto.setCc(in.nextInt());
		in.nextLine();
		System.out.println("���� ������ �Է��� �ּ���.");
		cdto.setPrice(in.nextInt());
		in.nextLine();
		System.out.println("����� �Է��� �ּ���.");
		cdto.setEa(in.nextInt());
		in.nextLine();
		cdao.insertone(cdto);
		System.out.println("��� �Ǿ����ϴ�.");
	}
	
	@Test // ��� �����̸����� ���� �׽�Ʈ
	public void deleteTest() {
		cdao.delete(in.nextLine());
		System.out.println("���� �Ǿ����ϴ�.");
	}
	
	@Test // ��ȣ�� ������ ���� �׽�Ʈ
	public void updateTest() {
		cdao.updateea(in.nextInt(), in.nextInt());
		in.nextLine();
		System.out.println("����� �����Ͽ����ϴ�");
	}
	
	@Test // �귣��� �˻� �׽�Ʈ
	public void brandsearchTest() {
		Car_DTO c = cdao.brandsearch(in.nextLine());
		System.out.println(c.getBrand());
		System.out.println(c.getName());
		System.out.println(c.getModel());
		System.out.println(c.getCc());
		System.out.println(c.getPrice());
		System.out.println(c.getEa());
	}
	
	@Test // ������ ���� �׽�Ʈ
	public void updateeaminusTest() {
		cdao.updateeaminus(in.nextInt(), in.nextInt());
		in.nextLine();
	}
	
	
	
	
	
}
