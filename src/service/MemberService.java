package service;

import vo.MemberVO;

public class MemberService {
	private Dao dao;
	
	public MemberService()
	{
		dao = new MemberDao();
	}
	
	public void addMemberVO(MemberVO memberVo)
	{
		dao.insert(memberVo);
	}
	
	public MemberVO findMemberVO(String id)
	{
		return dao.selectMember(id);
	}
	
	public void printAll()
	{
		System.out.println(dao.selectAll());
	}
	
	public void deleteMemberVO(String id)
	{
		dao.delete(id);
	}
	public void updateMemberVO(MemberVO memberVO)
	{
		dao.update(memberVO);
	}
}
