import kingdom.*;

//kingdom.jar(라이브러리)를 가져다 사용하려면
//jdk/jre/lib/ext 아래 가져다 놓는다.
//jvm이 외부 라이브러리를 참조하고자 할때 이곳을 가장 먼저 찾는다/

public class  TestPack2
{
	public static void main(String[] args) 
	{
		King k = new King();
		System.out.println(k.giveBread());

		Prince k2 = new Prince();
		System.out.println(k2.giveBread());
	}
}
