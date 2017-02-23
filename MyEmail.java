//package my.day16;
import java.applet.*;
import java.awt.*;

public class MyEmail extends Applet{
	Label lbName, lbEmail;
	TextField tfName, tfEmail;
	TextArea ta;
	Button btSend, btReset;
	Panel p1,p2, p1West, p1Center;
	
	public void init()
	{
		setLayout(new BorderLayout(10,10));
		setBackground(new Color(122,233,80));//r,g,b
		p1=new Panel();
		p2=new Panel();
		ta=new TextArea("",5,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		//p1.setBackground(Color.yellow);
		//p2.setBackground(Color.green);
		add(p1,"North");
		add(p2,"South");
		add(ta,"Center");
		
		btSend=new Button("   Send   ");
		btReset=new Button("  Reset  ");
		p2.add(btSend);
		p2.add(btReset);
		
		p1.setLayout(new BorderLayout(10,10));
		p1West=new Panel();
		p1Center=new Panel();
		p1.add(p1West, "West");
		p1.add(p1Center, "Center");
		
		//p1West.setBackground(Color.blue);
		//p1Center.setBackground(Color.gray);
		
		lbName=new Label("이  름:");
		lbEmail=new Label("이메일:");
		
		p1West.setLayout(new GridLayout(2,1,10,10));
		p1West.add(lbName);
		p1West.add(lbEmail);
		
		tfName=new TextField();
		tfEmail=new TextField();
		
		p1Center.setLayout(new GridLayout(2,1,10,10));
		p1Center.add(tfName);
		p1Center.add(tfEmail);
		
		setSize(400,400);
	}
	
	public Insets getInsets(){
		return new Insets(10,20,10,20);
	}

}////////////////////////////////////























