package com.buyticket.test;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class TestJtableButton {
	public static JTable table;	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Table Header");
		table = new JTable(6,6);		
		TableRender render = new TableRender();
		table.setRowHeight(20);
		TableEditor editor = new TableEditor(new JTextField());
		table.getColumnModel().getColumn(1).setCellRenderer(render);
		table.getColumnModel().getColumn(1).setCellEditor(editor);
		editor.setClickCountToStart(0);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("点击我");
			}
		});
		JScrollPane pane = new JScrollPane(table);			
		frame.setContentPane(pane);
		frame.setPreferredSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}
}

class TableRender extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (row<0||column!=1)
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		else {
			JButton label = new JButton("1 button");
			label.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "test 11");
					
				}
			});
			label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
			return label;
		}		
	}
}

 class TableEditor extends DefaultCellEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TableEditor(JCheckBox checkBox) {
		super(checkBox);
	}
	public TableEditor(JComboBox<?> comboBox) {
		super(comboBox);
	}
	public TableEditor(JTextField textField) {
		super(textField);
	}
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (row<0||column!=1)
			return super.getTableCellEditorComponent(table, value, isSelected,  row, column);
		else {
			JButton label = new JButton("2 button");
			label.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "test 22");
				}				
			});
			label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
			return label;
		}
	}
}
