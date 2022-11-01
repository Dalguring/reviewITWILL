package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberLoginProService {
	public boolean memberLogin(MemberBean member) {
		boolean isLoginSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isLoginSuccess = dao.memberLogin(member);
		
		JdbcUtil.close(con);
		
		return isLoginSuccess;
	}
	
	public boolean isAuthenticatedUser(MemberBean member) {
		boolean isAuthenticatedUser = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isAuthenticatedUser = dao.isAuthenticatedUser(member);

		JdbcUtil.close(con);
		return isAuthenticatedUser;
	}
	
	
	
	
	
}
