package test.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/root-context.xml"})
public class MyControllerTest {

	private static final Logger logger=LoggerFactory.getLogger(MyControllerTest.class);
	
	@Autowired
	private WebApplicationContext webCtx;
	private MockMvc mock;
	
	@Before
	public void setup(){
		//가상의 요청과 응답을 처리하기 위해 테스트 실행전에(Before) MockMvc객체를 얻어온다.
		//MockMvc는 브라우저에서 요청과 응답을 의미하는 객체로 생각하면 됨
		this.mock=MockMvcBuilders.webAppContextSetup(webCtx).build();
		logger.info("setup....");
	}
	
	@Test
	public void testHi() throws Exception {
		mock.perform(MockMvcRequestBuilders.get("/hi.do"));
		logger.info("testHi called...");
		//get방식일 때는 get()메소드를 post방식일 때는 post()를 호출하고 이를
		//MockMvc perform()메소드를 이용해서 실행시키자.
	}
}
