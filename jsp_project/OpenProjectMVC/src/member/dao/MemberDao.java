package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Member;

public class MemberDao {
	
    // 싱글톤 처리
	// 싱글톤 패턴 : 코딩 스타일
	// 외부에서 인스턴스를 생성하지 못한다. 그러나 인스턴스를 반환해주는 메서드가 있어 인스턴스가 필요한 경우 메서드를 이용해서 얻는다.

	// 인스턴스 생성 막는다 : 생성자의 접근 제어자 -> private 처리
	private MemberDao() {}
	
	//오류 발생 -> 객체 하나를 생성해서 사용한다.
	private static MemberDao dao = new MemberDao();
	
	//Dao 객체의 참조변수를 반환해주는 메서드 필요 : 외부 클래스 누구나 접근해서 사용 가능하게 해준다  !!!
	public static MemberDao getInstance() {
		return dao;
	}
	
	
	
	
	//	Member 테이블의 데이터를 CRUD
	//	insert, select, update, delete
	
	// 데이터 입력  (conn, member 데이터 받아와서)
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt = 0; // 0 반환시 처리 되지 않음을 알 수 있음
		
		PreparedStatement pstmt = null;
		
		//sql 실행
		String sqlInsert = "INSERT INTO member (memberid, password, membername, memberphoto) VALUES (?,?,?,?)";
		
		/* try { */
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserPhoto());
			
			//DML(CRUD)시작시켜주는 메서드 -> 실행 갯수 반환
			resultCnt = pstmt.executeUpdate();
			
			
		/*} catch (SQLException e) {
			e.printStackTrace();
		}*/
	
		return resultCnt;
	}



	// 로그인을 위한 select
	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		
		Member member = null;
		
		String sqlSelect ="SELECT * FROM member where memberid=? and password=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*
				 * member = new Member( 
				 * rs.getString("memberid"), 
				 * rs.getString("password"),
				 * rs.getString("membername"), 
				 * rs.getString("memberPhoto"),
				 * rs.getTimestamp("regdate"));
				 */
				
				member = makeMember(rs);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	
	
	//전체 리스트를 반환하는 select
	public List<Member> selectMember(Connection conn){
		
		List<Member> list = new ArrayList<Member>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(makeMember(rs));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	
	public List<Member> selectMember(Connection conn, int firstRow, int count) throws SQLException {
		
		List<Member> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from member order by memberid limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery(); //결과 담기
			
			memberList = new ArrayList<Member>(); // 오류없이 정상적으로 실행 되었을 때 객체 만들어주기
			
			while(rs.next()) {
				memberList.add(makeMember(rs));
			}
			
			
		} finally {
			rs.close();
			pstmt.close();
		}
		
		return memberList;
	}
	
	
	
	
	
		private Member makeMember(ResultSet rs) throws SQLException {
			return new Member(
					rs.getString("memberid"),
					rs.getString("password"),
					rs.getString("membername"),
					rs.getNString("memberphoto"),
					rs.getTimestamp("regdate")
					);
			
		}



		// 전체 회원의 수를 구하는 메서드
		public int selectMemberTotalCount(Connection conn) throws SQLException {
			
			int resultCnt = 0;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "select count(*) from member";
			
			try {
				stmt = conn.createStatement();
				// 결과 (1행 1열)
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					resultCnt = rs.getInt(1);
				}
				
			}finally {
				rs.close();
				stmt.close();
			}
			
			
			return resultCnt;
		}

}



