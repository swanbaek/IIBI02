package jdbc_memo;
import java.sql.*;
import java.util.*;//ArrayList
/*Persistence 객체: 영속성 객체
 * Database에 접근하여 insert,delete, update, select등 biz logic
 *   을 수행하는 객체
 * DAO: Data Access Object  
 * */
public class MemoDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	/**한줄 메모글을 등록하는 메소드-insert문을 수행*/
	public int insertMemo(MemoVO memo) {
		try {
			con=DBUtil.getCon();
			//insert문 작성하기
			String sql="insert into memo values(memo_seq.nextval,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			int n=ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;//오류 발생시는 음수를 반환
		}finally {
			close();
		}		
	}//-----------------------
	/** select문
	 *  where절에서 like로 검색 조건을 갖는다.
	 * */
	public ArrayList<MemoVO> findMemo(int type, String keyword){
		//type(0: 작성자로 검색, 1:메모내용 검색, 2: 작성일로 검색)
		try {
			con=DBUtil.getCon();
			String colName="";
			if(type==0) colName="name";
			else if(type==1) colName="msg";
			else if(type==2) colName="wdate";
			
			String sql="select * from memo where "+colName+" like ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			ArrayList<MemoVO> arr=makeList(rs);
			return arr;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}//-------------------------------
	
	public ArrayList<MemoVO> listMemo(){
		try {
			con=DBUtil.getCon();
			String sql="SELECT idx, name, rpad(msg,80,' ') msg, wdate "
					+ " FROM memo ORDER BY 1 asc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			ArrayList<MemoVO> arr=makeList(rs);
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}//-----------------------
	
	public ArrayList<MemoVO> makeList(ResultSet rs)
	throws SQLException{
		ArrayList<MemoVO> arr=new ArrayList<MemoVO>();
		while(rs.next()) {
			MemoVO voTemp=new MemoVO(rs.getInt("idx"),rs.getString("name"),
					rs.getString("msg"),rs.getDate("wdate"));
			arr.add(voTemp);
		}
		return arr;
	}
	/**글번호(PK)로 삭제처리하는 메소드*/
	public int deleteMemo(Integer idx) {
		try {
			con=DBUtil.getCon();
			String sql="delete from memo where idx=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, idx);
			int n=ps.executeUpdate();
			return n;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}//-------------------------------------
	

	private void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (Exception e) {	}
	}//-------------------
	
}//////////////////////////////////////////
