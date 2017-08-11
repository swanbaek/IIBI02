package test.db;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.persistence.SampleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/root-context.xml"})
public class SampleMapperTest {

	@Inject
	private SampleMapper mapper;
	@Test
	public void testTime() {
		System.out.println(mapper.getClass().getName());
		System.out.println(mapper.getTime());
	}
	
	@Test
	public void testAddress(){
		System.out.println(mapper.getAddress("Hong", "111"));
	}
	 
	@Test
	public void testUserName(){
		System.out.println(mapper.getUserName("Hong", "111"));
		System.out.println(mapper.getUserName2("Admin"));
	}
	@Test
	public void testInsert(){
		
		System.out.println(mapper.insertUser("TestKim","Hello MyBatis~"));
	}

}
