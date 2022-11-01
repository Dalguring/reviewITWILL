package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JdbcUtil;
import vo.AuthInfoBean;
import vo.MemberBean;

public class MemberDAO {
	
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	// ------------------------------------------------------
	
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	// ------------------------------------------------------
	
	public int insertMember(MemberBean member) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			// member 테이블에 회원정보 INSERT
			// => 단 회원번호(idx)는 null 값 전달 시 AUTO_INCREMENT에 의해 번호 자동 증가
			String sql = "INSERT INTO member VALUES(null,?,?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, "N");
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! insertMember()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return insertCount;
	}
	
	public boolean memberLogin(MemberBean member) {
		boolean isLoginSuccess = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=? AND passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - memberLogin()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isLoginSuccess;
	}
	
	public MemberBean selectMember(String sId) {
		MemberBean member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberBean();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setDate(rs.getDate("date"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectMember()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	public int insertAuthInfo(AuthInfoBean authInfo) {
		int insertCount = 0;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM auth_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authInfo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql = "UPDATE auth_info SET auth_code=? WHERE id=?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getAuth_code());
				pstmt2.setString(2, authInfo.getId());
				
				insertCount = pstmt2.executeUpdate();
			} else {
				sql = "INSERT INTO auth_info VALUES(?,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getId());
				pstmt2.setString(2, authInfo.getAuth_code());
				
				insertCount = pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertAuthInfo()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(pstmt);
		}
		
		return insertCount;
	}

	public boolean isAuthenticatedUser(MemberBean member) {
		boolean isAuthenticatedUser = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=? AND auth_status=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, "Y");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isAuthenticatedUser = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isAuthenticatedUser;
	}

	public boolean selectAuthInfo(AuthInfoBean authInfo) {
		boolean isAuthenticationSuccess = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달받은 AuthInfoBean 객체의 인증정보(아이디, 인증코드)를 사용하여
		// auth_info 테이블의 인증정보 조회
		try {
			String sql = "SELECT * FROM auth_info WHERE id=? AND auth_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authInfo.getId());
			pstmt.setString(2, authInfo.getAuth_code());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isAuthenticationSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isAuthenticationSuccess;
	}

	public int updateAuthStatus(AuthInfoBean authInfo) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member SET auth_status=? WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Y");
			pstmt.setString(2, authInfo.getId());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생 ! - updateAuthStatus()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteAuthInfo(AuthInfoBean authInfo) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM auth_info WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authInfo.getId());
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생 ! - deleteAuthInfo()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return deleteCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
