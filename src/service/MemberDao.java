package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

public class MemberDao implements Dao{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void con() {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		try
		{
			pstmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void insert(MemberVO m) {
		// TODO Auto-generated method stub
		
		try
		{
			con();
			String sql = "insert into member(id,name,tel,addr)"+"values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getAdd());
			int result = pstmt.executeUpdate();
			System.out.println("result = "+result);
			discon();
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public MemberVO selectMember(String id) {
		// TODO Auto-generated method stub
		MemberVO vo = null;
		
		try
		{
			con();
			String sql = "select id, tel, name, address from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				vo = new MemberVO(id, rs.getString(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void update(MemberVO m) {
		// TODO Auto-generated method stub
		con();
		String sql = "update member set name = ?, tel =?, address = ?, where id =? ";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3, m.getAdd());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
			discon();
		}catch(SQLException e)
		{
			System.out.println(e);
		
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		con();
		String sql = "delete from member where id = ?";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public ArrayList selectAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<MemberVO> m = new ArrayList<MemberVO>();
		String sql = "select * from member";
		
		try
		{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				m.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		discon();
		return m;
	}

}
