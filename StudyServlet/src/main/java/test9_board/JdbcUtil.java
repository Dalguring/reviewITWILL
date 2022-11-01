package test9_board;

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
	
	
}
