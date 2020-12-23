package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBCPInitListener implements ServletContextListener {

	
	
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		
		ServletContext context = contextEvent.getServletContext();
		
		String driver = context.getInitParameter("jdbcDriver");
		
		try {
			Class.forName(driver);
			System.out.println("Tomcat Listener에서 데이터 베이스 드라이버 로드");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Tomcat Listener에서 데이터 베이스 드라이버 실패");
			e.printStackTrace();
		}
	
		System.out.println("초기화 완료");
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		
	}	

}
