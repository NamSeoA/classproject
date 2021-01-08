package com.aia.firstspring.member.domain;

public class SearchType {

	private int value;
	private String label;
	
	public SearchType(int value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	// view쪽에서 데이터 쓸 수 있게 하기위해
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
