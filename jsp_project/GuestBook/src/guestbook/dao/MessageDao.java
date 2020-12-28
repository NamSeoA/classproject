package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;
import jdbc.jdbcUtil;

public class MessageDao {

	
	// 싱글톤 패턴 : Dao 인스턴스는 여러 개가 생성될 필요가 없다.
	private MessageDao() {}
	
	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}
	
	
	// 방명록에 데이터를 저장해주는 메서드 (동적으로 값이 할당됨)
	public int insertMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0; // 반환할 결과 값
		PreparedStatement pstmt = null;
		try {
			// 입력을 위한 sql문(insert)
			String sql = "INSERT INTO guestbook_message (guest_name,password, message) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql); //쿼리를 준비하는 statement라는 의미로  prepareStatement() 메서드를 호출
			
			// 그러면 PreparedStatement 객체( pstmt )를 반환하는데, pstmt.setString() 메서드를 통해 동적으로 값을 할당할 수 있음
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();  // 결과 반환 (영향을 미친 row의 개수)
			
		} finally {
			pstmt.close();
		}
		

		return resultCnt;
	}

	//전체 게시물의 개수를 구하는 메소드
	public int selctAllcount(Connection conn) throws SQLException {
			
		int totalCnt = 0;
			
		Statement stmt = null;
		ResultSet rs = null; // 결과를 담아야해서 select할 때만 필요
			
			// 
			try {
				// 쿼리 수행을 위한 Statement 객체 생성 ( 동적으로 할당되는 값이 없으므로 createStatement() 메서드를 호출)
				stmt = conn.createStatement();
				String sql =  "select count(*) from guestbook_message";
				
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					totalCnt = rs.getInt(1);
				}
				
			} finally {
				jdbcUtil.close(rs);
				jdbcUtil.close(stmt);
			}
			
			return totalCnt;
		}

		
		public List<Message> selctList(
				Connection conn, 
				int firstRow, 
				int messageCountPerPage) throws SQLException {
			
			//Message list에 데이터 넣을 것
			List<Message> list = new ArrayList<Message>();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// sql 쿼리 작성
			String sql = "select * from guestbook_message order by message_id desc limit ?, ?"; 
			try {
				pstmt = conn.prepareStatement(sql); //실행 준비 완료
				pstmt.setInt(1, firstRow);
				pstmt.setInt(2, messageCountPerPage);
				
				// sql 실행 결과를 가져온다
				rs = pstmt.executeQuery();
				
				// 실행 결과 출력
				while(rs.next()) {
					list.add(makeMessage(rs));
				}
				
			} finally { // 사용 후 연결 해제. 해제를 시키지 않으면 다른 사용자가 쓸 수 없음.
				jdbcUtil.close(rs);
				jdbcUtil.close(pstmt);
			}
			
			return list;
		}
		
		//메세지 객체 반환
		private Message makeMessage(ResultSet rs) throws SQLException {
			
			// 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작
			// 데이터 베이스에서 가져오는 데이터의 타입에 맞게 호출
			Message message = new Message();
			message.setId(rs.getInt(1));
			message.setGuestName(rs.getString(2));
			message.setPassword(rs.getString(3));
			message.setMessage(rs.getString(4));
			message.setWritedate(rs.getTimestamp(5));
			
			return message;
			
		}
	
	
}
