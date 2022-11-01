package ajax;

import java.sql.Connection;

public class MemberJoinProService {

	public boolean registMember(MemberBean member) {
		System.out.println("MemberJoinProService - registMember()");
		
		boolean isRegistSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertMember(member);
		
		if(insertCount > 0) {	
			JdbcUtil.commit(con); 
			isRegistSuccess = true;
		} else {				
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		return isRegistSuccess;
	}
	
	
}
