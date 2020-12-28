package guestbook.model;

import java.util.List;

// 게시물의 리스트 (방명록)
public class MessageListView { // -> list.jsp 전달
	
	private int messageTotalCount; // 게시물의 전체 개수 -> 페이지 개수
	private int currentPageNumber; // 현재 페이지 번호 : List<message> 
	private List<Message> messageList; // 페이지 번호에 따라서 게시물의 리스트 3개씩 출력
	private int pageTotalCount; 	   // 아래 넘버링 출력해줘야하기 때문에 페이지 전체 개수 필요
	private int messageCountPerPage;   // 한 페이지 당 출력할 게시글의 개수
	private int firstRow;			   // DB에서 테이블의 시작 행 / Oracle 사용 시 필요
	private int endRow;
	
	
	
	
	public MessageListView(
			int messageTotalCount, 
			int currentPageNumber, 
			List<Message> messageList,
			int messageCountPerPage, 
			int firstRow, 
			int endRow) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calculatePageTotalCount();
	} 				
	
	//messageTotalCount , messageCountPerPage 를 이용해 한 페이지당 출력할 게시물 개수 계산
	private void calculatePageTotalCount() {
		if(messageTotalCount==0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount/messageCountPerPage;  // ex) 10/3=3
			if(messageTotalCount%messageCountPerPage>0) { // ex) 10%3=1
				pageTotalCount++; // 페이지 번호 +1
			}
		}
	}
	
	
	
	// DB에서 가져온 데이터 수정 막기위해 GETTER만 둠
	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	
	public boolean isEmpty() { //boolean 타입의 get메서드 만들때는 is사용
		return messageTotalCount==0;
	}
	
	
	
	
	
	
	
	
	
	
}

	
	