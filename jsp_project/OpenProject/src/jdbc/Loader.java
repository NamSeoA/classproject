package jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	// 서블릿 객체를 실행할 때 처음 한번 실행해주는 메서드
	// 서블릿은 web.xml에 등록하고 컨테이너가 실행할 때 한번 서블릿이 실행하도록 설정
	// 초기화 작업시 서블릿 사용  init() -> ????????????????????????????????????
	@Override
	public void init() throws ServletException {

		// mysql의 드라이버를 로드	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 한번 시작시 실행됨
			System.out.println("Mysql 드라이버 로드 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 로드 실패!");
			e.printStackTrace();
		}
		
		
	
	
	
	}

	
	
	
	
}
