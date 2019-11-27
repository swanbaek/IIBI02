package mytest;

import java.awt.Color;
import java.awt.Container;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/* MVC
 * Model=> 데이터를 갖는다. DefaultTableModel, DefaultComboBoxModel,	
 * 							DefaultListModel...
 * View=> 컴포넌트 JButton, JTable, JComboBox, JList...
 * Controller=> XXXRenderer, XXXEditor...
 * */
public class SwingMVC extends JFrame {
	JPanel p = new JPanel();
	String[] data= {"Windows","Unix","Mac","Android"};//데이터
	Object[][]data2= {
			{1,"홍길동","안녕","2019-11-27"},
			{2,"김길동","하이","2019-11-22"},
			{3,"최길동","헬로","2019-11-23"},
			{4,"이길동","바이","2019-11-24"}
	};
	
	JList<String> lst;//View
	JComboBox<String> combo;
	JTable table;
	
	DefaultListModel<String> model1; //Model=>데이터를 갖는다
	DefaultComboBoxModel<String> model2;
	DefaultTableModel model3;
	public SwingMVC() {
		super("::SwingMVC::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		lst=new JList<>();//View
		
		model1=new DefaultListModel<>();//Model
		for(String item:data) {
			model1.addElement(item);
		}
		//View와 Model을 연결
		lst.setModel(model1);
		
		p.add(new JScrollPane(lst));
		
		combo=new JComboBox();//View
		model2=new DefaultComboBoxModel<>(data);//Model
		combo.setModel(model2);
		p.add(combo);
		
		String[] colHeader= {"글번호","작성자","글내용","작성일"};
		//JTable
		model3=new DefaultTableModel(data2, colHeader);
		table=new JTable();
		table.setModel(model3);
		table.setRowHeight(25);
		
		
		p.add(new JScrollPane(table));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingMVC my = new SwingMVC();
		my.setSize(500, 500);
		my.setVisible(true);
	}
}
