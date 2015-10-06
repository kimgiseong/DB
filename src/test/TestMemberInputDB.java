package test;

import java.util.Scanner;
import vo.MemberVO;
import service.MemberService;

// �˻� ���� �ι� ���� ���

public class TestMemberInputDB {
	public static void main(String [] args)
	{
		int menu;
		boolean flag = true;
		String id, name, tel, addr;
		MemberVO m;
		Scanner sc = new Scanner(System.in);
		MemberService ms = new MemberService();
		
		while(flag)
		{
			System.out.println("1. ���");
			System.out.println("2. �˻�");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.println("5. ��ü���");
			System.out.println("6. ����");
			menu = sc.nextInt();
			
			switch(menu)
			{
			case 1 :
				System.out.println("id�� �Է��ϼ���.");
				id = sc.next();
				System.out.println("name�� �Է��ϼ���.");
				name = sc.next();
				System.out.println("tel�� �Է��ϼ���.");
				tel = sc.next();
				System.out.println("addr �Է��ϼ���.");
				addr = sc.next();
				
				ms.addMemberVO(new MemberVO(id, name, tel, addr));
				
				break;
			case 2 :
				System.out.println("�˻��Ͻ� id�� �Է��ϼ���.");
				id = sc.next();
				m = ms.findMemberVO(id);
				System.out.println(m);
				break;
			case 3 :
				System.out.println("�����Ͻ� id�� �Է��ϼ���.");
				id = sc.next();
				System.out.println("name�� �Է��ϼ���.");
				name = sc.next();
				System.out.println("tel�� �Է��ϼ���.");
				tel = sc.next();
				System.out.println("addr�� �Է��ϼ���.");
				addr = sc.next();
				MemberVO m2 = new MemberVO(id, name, tel, addr);
				ms.updateMemberVO(m2);
				break;
			case 4 :
				System.out.println("�����Ͻ� id�� �Է��ϼ���.");
				id = sc.next();
				ms.deleteMemberVO(id);
				break;
			case 5 :
				ms.printAll();
				break;
			case 6 :
				System.out.println("���α׷� ����");
				flag = false;
				break;
			}
		}
	}
}
