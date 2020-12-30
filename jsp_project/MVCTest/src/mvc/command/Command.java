package mvc.command;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 추상 클래스
public abstract class Command {
	
	// 요청의 처리와 속성에 결과를 저장하는 기능, view 페이지의 경로를 반환
	abstract public String getViewPage(HttpServletRequest request, HttpServletResponse response);
}
