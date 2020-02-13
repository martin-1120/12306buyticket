package com.buyticket.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyDialog extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyDialog(){
		JButton bt1=new JButton("bt1");
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JButton bt2=new JButton("bt2");
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		pack();
	}
	@SuppressWarnings("deprecation")
	public String getValue(){
		System.out.println("getvaue111");
		Thread.currentThread().suspend();
		this.setVisible(true);
		System.out.println("getvaue222");
		return "abc";
	}
}
public class TestThread {
	static Object obj=new Object();
	static String name=null;
	public  static void main(String[] args) throws InterruptedException {
		
		new Thread(){
			 public void  run() {//Thread.sleep(5000);
				System.out.println("begin ...");
				MyDialog d=new MyDialog();
				String result=d.getValue();
				System.out.println("end ...."+result);
				//f.setVisible(true);
				
			};
		}.start();
		 
		/*MyDialog d=new MyDialog();
		while(true){
		String result=d.getValue();
		System.out.println("end ...."+result);
		}*/
	}
}
