package ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {

	public static Connection getConnection() {
		// DBCP를 활용한 Connection 객체 리턴
		Connection con = null;
		
		// -------------------------------------------------
		try {
			Context initCtx = new InitialContext();
//		Context envCtx = (Context)initCtx.lookup("java:comp/env");
//		DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQL");
			// 결합 가능
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
			
			con = ds.getConnection();
			
			// ----------------------추가사항(옵션)-------------------------
			// 트랜잭션 처리를 위해 데이터베이스(MySQL)의 Auto Commit 기능 해제
			// => Connection 객체의 setAutoCommit() 메서드를 호출하여 false 값 전달
			con.setAutoCommit(false);
			// => 주의! 이 이후로는 DML 작업(INSERT, UPDATE, DELETE) 및 DDL 등의 작업 수행 후
			//	  반드시 commit 작업을 수동으로 실행해야함!
			//	  (Connection 객체의 commit() 메서드 호출)
			// => 또한, 이전 상태로 되돌리려면 rollback 작업을 수동으로 실행해야함!
			//    (Connection 객체의 rollback() 메서드 호출)
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// -------------------------------------------------
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con != null) { con.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) { pstmt.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// -------------------------------------------------------------
	// 트랜잭션 처리에 필요한 commit, rollback 작업을 수행할 메서드 정의
	// => 단, Connection 객체에 대해 Auto Commit 기능 해제 선행되어야 함
	// => 파라미터 : Connection 객체(con)
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
