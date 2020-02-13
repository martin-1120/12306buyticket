package com.buyticket.test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestDivFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TestDivFrame(){
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		final JPanel pan=new JPanel();
		final TextField text=new TextField();
		final CardLayout cardLayout=new CardLayout();
		pan.setLayout(cardLayout);

		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		@SuppressWarnings("unused")
		JPanel panTitle = new JPanel();
		
		
		
		pan1.setBackground(Color.red);
		pan2.setBackground(Color.blue);
		pan1.setSize(20, 20);
		pan2.setSize(20,20);
		pan1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mouseevent) {
				cardLayout.show(pan, "pan2");
			}
		});
		pan2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mouseevent) {
				cardLayout.show(pan, "pan1");
			}
		});
		pan.add("pan1",pan1);
		pan.add("pan2",pan2);
				 
		pan.add(text);
		pan.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				/*pan.setLocation(e.getX(), e.getY());
				System.out.println(e.getX()+","+e.getY());*/
				System.out.println("mouseMoved");
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				/*pan.setLocation(e.getX(), e.getY());
				System.out.println(e.getX()+","+e.getY());*/
				System.out.println("mouseDrageed");
			}
			Point from;
			@Override
			public void mousePressed(MouseEvent e) {
				from=e.getPoint();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Point to=e.getPoint();
				if(from!=null){
					System.out.println("x:"+(to.x-from.x));
					System.out.println("y:"+(to.y-from.y));
					pan.setLocation(pan.getLocation().x+ to.x-from.x,pan.getLocation().y+to.y-from.y);
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				/*pan.setLocation(e.getX(), e.getY());
				System.out.println(e.getX()+","+e.getY());		*/	
			}
			
		});
//		pan.setSize(50,50);
		pan.setBackground(Color.red);
		pan.setBounds(20, 20,250, 250);
		
		this.setLayout(new FlowLayout());
		for (int j = 0; j < 100; j++) {
			this.add(new JPanel().add(new JLabel(j+"--")));
		}
		
		this.getLayeredPane().add(pan);
		
		//this.pack();
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new TestDivFrame();
	}
}
