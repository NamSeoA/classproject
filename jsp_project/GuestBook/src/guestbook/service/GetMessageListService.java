package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import guestbook.model.MessageListView;
import jdbc.ConnectionProvider;

// 요청한 페이지, 목록, 개수 등 출력
public class GetMessageListService {
	
	// 한 페이지에 보여줄 메시지의 수
	final int messageCountPerPage = 3;
	
	// 싱글톤 패턴 적용
	private GetMessageListService() {}
	private static GetMessageListService service = new GetMessageListService();
	
	public static GetMessageListService getInstance() { // 값을 반환하는 메서드
		return service;
	}
	
	
	// MessageListView 객체를 반환하는 메서드
	// 페이지 번호를 받아서 해당 페이지(messageListView)에 알맞는 데이터를 출력해야한다.
	public MessageListView getMessageList(int pageNumber) {
		
		
		MessageListView listView = null;
		
		// MessageListView가 가지는 변수의 데이터들을 MessageDao를 이용해서 생성
		Connection conn = null;
		MessageDao dao = null;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// 게시물의 전체 개수 -> 페이지 개수
			int totalMessageCount = dao.selctAllcount(conn);
			
			// 현재 페이지의 메세지 리스트 구하기
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			
			firstRow = (pageNumber -1)* messageCountPerPage;
			endRow = firstRow + messageCountPerPage -1;
			
			messageList = dao.selctList(conn, firstRow, messageCountPerPage);
			
			listView = new MessageListView(totalMessageCount, pageNumber, messageList, messageCountPerPage, firstRow, endRow);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return listView;
	}
	
}
