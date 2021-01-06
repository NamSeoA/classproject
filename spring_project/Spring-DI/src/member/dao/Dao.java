package member.dao;

public interface Dao {

	// public abstract void insert(); 생략가능
	
	// 추상메서드  : 가이드 역할
	void insert();
	void select();
	void delete();
	void update();
}
