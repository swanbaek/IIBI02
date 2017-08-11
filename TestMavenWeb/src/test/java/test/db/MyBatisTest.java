package test.db;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/root-context.xml"})
public class MyBatisTest {

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory factory;
	
	@Test
	public void testFactory() {
		System.out.println("SqlSessionFactory="+factory);
	}
	
	@Test
	public void testSession(){
		try(SqlSession session=factory.openSession()){
			System.out.println("session="+session);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
