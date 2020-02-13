package com.buyticket.ui;

import java.awt.Color;

import javax.swing.JFrame;

public class ColorUtil {
	public static String Color2String(Color color) {  
        String R = Integer.toHexString(color.getRed());  
        R = R.length() < 2 ? ('0' + R) : R;  
        String B = Integer.toHexString(color.getBlue());  
        B = B.length() < 2 ? ('0' + B) : B;  
        String G = Integer.toHexString(color.getGreen());  
        G = G.length() < 2 ? ('0' + G) : G;  
        return '#' + R + B + G;  
    }  
  
	public static Color String2Color(String str) {  
        int i = Integer.parseInt(str.substring(1), 16);  
        return new Color(i);  
    }  
	public static void main(String[] args) {
		JFrame frm=new JFrame();
		frm.getContentPane().setBackground(String2Color("#EEF1F8"));
		frm.setBounds(0, 0, 100, 100);
		frm.setVisible(true);
	}
}
