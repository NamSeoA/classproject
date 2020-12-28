package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connection을 제공하는 역할을 가진 클래스를 별도 작성(서비스에서 Connection을 직접 생성할 경우 유지보수에 불리하기 때문에)
public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		
		//데이터 베이스와 연결하는 객체
		Connection conn=null;
		
		//2. DB 연결 : Connection 객체를 얻어온다.
		String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";  //연결 문자열  
		String user = "aia"; //데이터베이스 id
		String password = "aia"; //데이터베이스 pw
		
		// 데이터베이스 연결
		conn = DriverManager.getConnection(jdbcUrl, user, password); 
	
		
		return conn;
	}
}
