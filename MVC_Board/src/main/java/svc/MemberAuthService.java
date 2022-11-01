package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.AuthInfoBean;

public class MemberAuthService {

	public boolean checkAuthInfo(AuthInfoBean authInfo) {
		boolean isAuthenticationSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isAuthenticationSuccess = dao.selectAuthInfo(authInfo);
		
		JdbcUtil.close(con);
		return isAuthenticationSuccess;
	}

	// 회원 인증 정보 갱신
	public boolean updateAuthInfo(AuthInfoBean authInfo) {
		boolean isUpdateSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO 클래스의 updateAuthStatus() 메서드를 호출하여 member 테이블의 아이디가 일치하는 레코드의 인증여부를 Y로 변경
		// => 파라미터 : AuthInfoBean 객체		리턴타입 : int(updateCount)
		int updateCount = dao.updateAuthStatus(authInfo);
		
		// MemberDAO 클래스의 deleteAuthInfo() 메서드 호출하여
		// auth_info 테이블에서 아이디가 일치하는 레코드의 인증 정보를 삭제
		// => 파라미터 : AuthInfoBean 객체		리턴타입 : int(deleteCount)
		int deleteCount = dao.deleteAuthInfo(authInfo);
		
		// 작업 처리 결과에 따른 트렌젝션 처리
		// => updateCount 와 deleteCount 모두 0보다 클 경우 성공, 아니면 실패
		if(updateCount > 0 && deleteCount > 0) {
			JdbcUtil.commit(con);
			isUpdateSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		return isUpdateSuccess;
	}
	
}
