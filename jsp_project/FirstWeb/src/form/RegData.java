package form;

public class RegData {

	private String id; //아이디
	private String pw; //비밀번호
	private String username; //사용자 이름
	private Object userPhoto; //사진
	
	//생성자
	public RegData() {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(Object userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "regData [id=" + id + ", pw=" + pw + ", username=" + username + ", userPhoto=" + userPhoto + "]";
	}
	
	
	
	
}
