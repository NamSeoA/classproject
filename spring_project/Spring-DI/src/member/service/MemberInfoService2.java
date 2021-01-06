package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberInfoService2 implements MemberService {

	@Autowired(required = false) //주입이 되지 않더라도 실행되게함(존재의 유무를 확인할 때)
	@Qualifier("guest")
	Dao dao ;
	
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		
		dao.select();
		
		return null;
	}

}
