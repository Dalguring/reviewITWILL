package ajax;

import java.sql.Connection;

public class MemberSendAuthMailService {
	
	public boolean registAuthInfo(AuthInfoBean authInfo) {
		boolean isRegistSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO의 insertAuthInfo() 메서드 호출하여 인증 정보 등록 작업 수행
		
		int insertCount = dao.insertAuthInfo(authInfo);
		
		if(insertCount > 0) { // 작업 성공했을 경우
			JdbcUtil.commit(con);
			isRegistSuccess = true;
		} else { // 작업 실패했을 경우
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		return isRegistSuccess;
	}
	
}
