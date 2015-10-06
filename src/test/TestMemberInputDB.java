package test;

import java.util.Scanner;
import vo.MemberVO;
import service.MemberService;

// 검색 수정 부문 오류 잡기

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
			System.out.println("1. 등록");
			System.out.println("2. 검색");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 전체출력");
			System.out.println("6. 종료");
			menu = sc.nextInt();
			
			switch(menu)
			{
			case 1 :
				System.out.println("id를 입력하세요.");
				id = sc.next();
				System.out.println("name을 입력하세요.");
				name = sc.next();
				System.out.println("tel을 입력하세요.");
				tel = sc.next();
				System.out.println("addr 입력하세요.");
				addr = sc.next();
				
				ms.addMemberVO(new MemberVO(id, name, tel, addr));
				
				break;
			case 2 :
				System.out.println("검색하실 id를 입력하세요.");
				id = sc.next();
				m = ms.findMemberVO(id);
				System.out.println(m);
				break;
			case 3 :
				System.out.println("수정하실 id를 입력하세요.");
				id = sc.next();
				System.out.println("name을 입력하세요.");
				name = sc.next();
				System.out.println("tel을 입력하세요.");
				tel = sc.next();
				System.out.println("addr을 입력하세요.");
				addr = sc.next();
				MemberVO m2 = new MemberVO(id, name, tel, addr);
				ms.updateMemberVO(m2);
				break;
			case 4 :
				System.out.println("삭제하실 id를 입력하세요.");
				id = sc.next();
				ms.deleteMemberVO(id);
				break;
			case 5 :
				ms.printAll();
				break;
			case 6 :
				System.out.println("프로그램 종료");
				flag = false;
				break;
			}
		}
	}
}
