package test.db;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.*;
/*스프링은 하나의 설정에 문제가 있다면 정상적으로 로딩되지 않기 때문에 
최대한 빨리 변경된 설정에 대해 테스트를 진행해야 한다.
스프링은 별도의 test라이브러리를 활용해서 개발자가 손쉽게 테스트할 수 
있는 방법을 제공한다.
spring-test모듈의 도움을 받으면 스프링을 WAS상에서 동작시키지 않고도 
제대로 동작하는지 확인할 수 있다.

@RunWith,@ContextConfiguration 어노테이션은 현재 테스트 코드를 실행할 때
스프링이 로딩되도록 하는 부분. locations 속성 경로에 지정된 xml파일을 이용해서
스프링이 로딩된다.
DataSource는 root-context.xml 에 빈으로 등록해놓고 있으며 해당 빈 id를 dataSource로
주었는데 이를 @Resource어노테이션을 이용해 주입하고 있음.
DataSource가 주입이 잘 된다면 ds를 통해 Connection을 얻어올 수 있다.
 * 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/root-context.xml"})
public class DataSourceTest {

	@Resource(name="dataSource")
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try(Connection con=ds.getConnection()){
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
