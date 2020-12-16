package form;

// beans 정의
public class LoginData {
	
	private String id; // 아이디
	private String pw; // 비밀번호
	
	//생성자
	public LoginData() {
	}

	public LoginData(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	
	//getter&setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
	@Override
	public String toString() {
		return "loginData [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
	
	

}
