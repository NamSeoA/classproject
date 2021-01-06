package member.service;

import member.dao.Dao;

public class MemberInfoService implements MemberService {

	Dao dao ;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	
	
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		
		dao.select();
		
		return null;
	}

}
