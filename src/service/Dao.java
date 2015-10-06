package service;

import java.util.ArrayList;
import vo.MemberVO;

public interface Dao {
	void con();
	void discon();
	void insert(MemberVO m);
	MemberVO selectMember(String id);
	void update(MemberVO m);
	void delete(String id);
	ArrayList selectAll();
}