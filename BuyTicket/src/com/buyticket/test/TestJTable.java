package com.buyticket.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestJTable extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panTitle=new JPanel();
	JPanel panBody=new JPanel();
	public TestJTable() {
		setSize(500,500);
		
		getContentPane().setLayout(new BorderLayout());
		
		JButton bt1=new JButton("bt1");
		bt1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bt1_onclicked();
			}
		});
		panTitle.add(bt1);
		JButton bt2=new JButton("bt2");
		bt2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bt2_onclicked();
			}
		});
		panTitle.add(bt2);
//		
		panBody.setBorder(BorderFactory.createLineBorder(Color.red));
		panBody.setLayout(new BorderLayout());
		getContentPane().add(panTitle,BorderLayout.NORTH);
		getContentPane().add(panBody,BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new TestJTable();
	}
	 JTable table = new JTable();
	public void bt1_onclicked(){
	     DefaultTableModel myModel = new DefaultTableModel(new String[][]{new String[]{"111","222","333"},new String[]{"4444","555","666"}},new String[]{"aaa","bbb","ccc"});
	     table = new JTable(myModel);	
	     
	     JScrollPane scrollPanel = new JScrollPane(table);
	     
	     scrollPanel.setBackground(Color.pink);
	     panBody.add(scrollPanel,BorderLayout.CENTER);
	     table.setFillsViewportHeight(true);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	     //getContentPane().validate();
	     panBody.validate(); //靠你大爷， 找了那么久 原来要这样才能现实出来， 我擦擦，真tm难用  比微软的C# winfrom差多了
	     //panBody.repaint(); 
	   	     
	}
	public void bt2_onclicked(){
		DefaultTableModel myModel = new DefaultTableModel(new String[][]{new String[]{"111uu","222uu","333uu"},new String[]{"4444uu","555uu","666uu"}},new String[]{"aaauu","bbbuu","cccuuu"});
		table.setModel(myModel);	
		
		//panBody.validate(); //靠你大爷， 找了那么久 原来要这样才能现实出来， 我擦擦，真tm难用  比微软的C# winfrom差多了
		
	}
}
