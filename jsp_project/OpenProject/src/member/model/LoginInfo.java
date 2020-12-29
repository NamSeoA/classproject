package member.model;

public class LoginInfo {
	
	private String memberId;
	private String memberName;
	private String memberPhoto;

	
	public LoginInfo(String memberId, String memberName, String memberPhoto) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhoto = memberPhoto;
	}

	// getter 메서드만 생성. 로그인시 바꿀 수 없기때문
	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberPhoto() {
		return memberPhoto;
	}
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "LoginInfo [memberId=" + memberId + ", memberName=" + memberName + ", memberPhoto=" + memberPhoto + "]";
	}
	
	
	
}
