package com.aia.firstspring.member.domain;

public class LoginRequest {

	// Form에 있는 uid와 같게
	private String uid;
	private String pw;

	// getter, setter
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", pw=" + pw + "]";
	}

}
