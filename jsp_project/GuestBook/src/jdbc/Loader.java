package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

// Servlet class (JDBC 드라이버 로딩)
public class Loader extends HttpServlet {

	@Override
	public void init() throws ServletException { //초기화
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("QuestBook Mysql 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("QuestBook Mysql 드라이버 로드 실패");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
