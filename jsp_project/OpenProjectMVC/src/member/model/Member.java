package member.model;

import java.sql.Timestamp;
import java.util.Date;

// 회원 정보를 저장하는 beans 클래스 정의
public class Member {

	// 변수(속성)은 private
	private String userId;
	private String pw;
	private String userName;
	private String userPhoto;
	private Timestamp regDate;
	
	// 기본 생성자 필수
	public Member() {}

	
	public Member(String userId, String pw, String userName, String userPhoto, Timestamp regDate) {
		this.userId = userId;
		this.pw = pw;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.regDate = regDate;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	// EL에서 ${member.date} 할 수 있도록! TimeStamp -> java.util.Date
	public Date getDate() {
		return new Date(regDate.getTime());
	}
	


	// Member -> LoginInfo
	public LoginInfo toLoginInfo() {
		return new LoginInfo(this.userId, this.userName, this.userPhoto);
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", pw=" + pw + ", userName=" + userName + ", userPhoto=" + userPhoto + "]";
	}
	
	
	
	
	
	
}
