package test.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver2";
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="myjava";
	private static final String pwd="tiger";
	
	@Test
	public void testConnection() throws ClassNotFoundException {
		Class.forName(DRIVER);
		try(Connection con=DriverManager.getConnection(url,user,pwd)){
			//System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
