package common.persistence;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("select systimestamp from dual")
	public String getTime();
	
	@Select("select addr1||' '||addr2 from member where userid=#{userid} and pwd=#{pwd}")
	public String getAddress(@Param("userid") String id, @Param("pwd") String pwd);
	
	public String getUserName(@Param("userid") String userid, @Param("pwd") String pwd);
	public String getUserName2(@Param("userid") String userid);
	
	@Insert("insert into memo values(memo_idx_seq.nextval,#{name}, #{msg}, sysdate)")
	public int insertUser(@Param("name")String name,@Param("msg")String msg);
}
