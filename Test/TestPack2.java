import kingdom.*;

//kingdom.jar(���̺귯��)�� ������ ����Ϸ���
//jdk/jre/lib/ext �Ʒ� ������ ���´�.
//jvm�� �ܺ� ���̺귯���� �����ϰ��� �Ҷ� �̰��� ���� ���� ã�´�/

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
