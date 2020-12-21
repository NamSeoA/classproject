package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() {
		
		Connection conn=null;
		
		//2. DB 연결 : Connection 객체를 얻어온다.
		String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
		String user = "aia";
		String password = "aia";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패!"); //연결 실패(주소, 포트, 스키마정보, 파라미터 등등 틀릴 때 -2)
			e.printStackTrace();
		}
		
		return conn;
	}
}
