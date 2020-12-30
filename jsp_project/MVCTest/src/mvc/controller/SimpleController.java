package mvc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

//기본 Controller
public class SimpleController extends HttpServlet {

	
	// 1. 모든 요청을 받도록 처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	//모든 요청을 처리하고 view 페이지로 포워딩 해주는 메서드
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 요청을 분석 : 파라미터를 이용해서 요청을 분석
		// request 객체를 이용해서 사용자의 요청을 분석
		// http://localhost:8080/mvc/simple?type=[ greeting | date |...]
		String type = request.getParameter("type");
		
		// 3. 요청에 맞는 기능 실행 (분기) -> 결과 data 나옴
		Object resultObj = null;
		
		if(type==null || type.equals("greeting")) {
			resultObj = "안녕하세요"; // 요청에 맞는 응답들
		}else if(type.equals("date")) {
			resultObj = new Date(); 
		}else {
			resultObj = "Invalid Type"; //invalid(인식 불가한, 무효한)
		}
		
		// 4. 결과 데이터를 기본 객체의 속성에 저장해서 view 페이지로 데이터를 전달
		request.setAttribute("result", resultObj);
		
		// 5. view 페이지를 선택하고 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/simpleView.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	
	
	
	
	
	
}
