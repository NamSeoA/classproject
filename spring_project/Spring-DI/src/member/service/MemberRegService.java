package member.service;

import member.dao.Dao;
import member.dao.MemberDao;

public class MemberRegService implements MemberService{

	// Dao dao = new MemberDao(); 의존성이 높은 코드
	
	private Dao dao; //주입 받아야 하는 참조 변수 (의존성 낮음)
	
	//생성자를 통해서 Dao 타입의 인스턴스를 주입 받는다 (생성자 public)
	//Dao dao = new MemberDao(); //다형성
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberRegService 실행");
		
		dao.insert();
		
		return null;
	}

}
