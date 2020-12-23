package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException { //초기화 (인스턴스 실행시 실행)
		
		//encoding utf-8값 가져오기
		encoding = filterConfig.getInitParameter("encoding"); //name
		
		if(encoding == null) { //web.xml filter에 등록 안했을 시
			encoding = "utf-8";
			
		}
		
		
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding); // 요청 들어오면 모든 요청에 encoding 
		
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {

	}
}
