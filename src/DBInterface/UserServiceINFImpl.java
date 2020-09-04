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
	
	@Override // �޼��� ������
	public void carlist() {
		ArrayList<Car_DTO> cList = cdao.selectAll();
		System.out.println("���� ���� ������ �ִ� �����Դϴ�.");
		System.out.println("=======================");
		for(int i = 0; i < cList.size(); i++) {
			Car_DTO cdto = new Car_DTO();
			cdto = cList.get(i);
			System.out.println("<"+cdto.getNo()+"�� �����Դϴ�>");
			System.out.println("������ : "+cdto.getBrand());
			System.out.println("�𵨸� : "+cdto.getName());
			System.out.println("��   �� : "+cdto.getModel());
			System.out.println("��ⷮ : "+cdto.getCc()+"cc");
			System.out.println("��   �� : "+cdto.getPrice()+"����");
			System.out.println("��� : "+cdto.getEa()+"EA");
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
		System.out.println("���Ÿ� ���Ͻø� y, �����ø� n�� �Է��ϼ���.");
		String buy = in.nextLine();
		if(buy.equals("y")) {
			Buy_DTO bdto = new Buy_DTO();
			System.out.println("�����ں��� ������ �Է��� �ּ���.");
			username = in.nextLine();
			bdto.setUsername(username);
			System.out.println("��ȣ�� �Է��� �ּ���.");
			selnum = in.nextInt();
			in.nextLine();
			bdto.setNo(selnum);
			System.out.println("���ż����� �Է��� �ּ���.");
			selea = in.nextInt();
			in.nextLine();
			bdto.setEa(selea);
			
			bdao.buy(bdto);
			cdao.updateea(selnum, selea);
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
		}
		
	}

	@Override
	public void buylist() {
		ArrayList<Buy_DTO> bList = bdao.selectAll();
		System.out.println("���� ����");
		System.out.println("=======================");
		for(int i = 0; i < bList.size(); i++) {
			Buy_DTO bdto = new Buy_DTO();
			bdto = bList.get(i);
			System.out.println("<"+i+">�� ����");
			System.out.println("��     ��     �� : "+bdto.getUsername());
			System.out.println("���� ������ȣ : "+"<"+bdto.getNo()+"�� �����Դϴ�>");
			System.out.println("��  ��   ��  �� : "+bdto.getEa()+"��");
		}
		
	}

}
