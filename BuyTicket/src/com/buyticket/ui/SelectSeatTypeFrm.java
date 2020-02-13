package com.buyticket.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.buyticket.core.Cfg;
import com.buyticket.dto.QueryLeftNewDTO;

import net.sf.json.JSONObject;

public class SelectSeatTypeFrm extends JDialog{
	/**
	 * 
	 */
	static Log log=LogFactory.getLog(SelectSeatTypeFrm.class);
	private static final long serialVersionUID = 1L;

	private JLabel lblTicketInfo=new JLabel("车票信息:",JLabel.CENTER);
	private JLabel lblChengke=new JLabel("乘客:",JLabel.CENTER);
	private JLabel lblChengkeInfo=new JLabel();
	
	private JLabel lblSeatType=new JLabel("座位类型:",JLabel.CENTER);
	private JComboBox<KeyValueComboxItem> cboSeatType=new JComboBox<KeyValueComboxItem>();
	
	private JButton btnSelect=new JButton("确定");

	KeyValueComboxItem result=null;
	public SelectSeatTypeFrm(QueryLeftNewDTO dto,String[] passengerStr) {
		setModal(true);//
		ImageIcon icon=new ImageIcon(getClass().getResource("/resource/img/select.png"));
		setIconImage(icon.getImage());
		
		//getContentPane().add(new JPanel(),BorderLayout.WEST);
		//getContentPane().add(new JPanel(),BorderLayout.EAST);

		setTitle("选择座位类型");
		setLayout(null);//new GridLayout(3, 2)
		lblTicketInfo.setText(dto.toString());
		lblTicketInfo.setToolTipText(lblTicketInfo.getText());
		
		lblChengkeInfo.setToolTipText(lblChengkeInfo.getText());
		add(lblTicketInfo);
		add(lblChengke);
		add(lblChengkeInfo);
		add(lblSeatType);
		add(cboSeatType);
		//add(new JLabel(""));
		add(btnSelect);
		
		lblTicketInfo.setBounds(20, 0,300 , 30);//x y  width height
		
		
		lblChengke.setBounds(20, 40,100 ,30);//x y  width height
		lblChengkeInfo.setBounds(100, 40,200 ,30);//x y  width height
		
		lblSeatType.setBounds(20, 80,100 ,30);//x y  width height
		cboSeatType.setBounds(100, 80,200 ,30);//x y  width height
		
		btnSelect.setBounds(150, 130,100 ,30);//x y  width height
		
		lblChengkeInfo.setText(Arrays.toString(passengerStr));
		//cboSeatType.setText();
		List<String> seatTypes=dto.getHasTiketSeatTypes(null);
		for(String t : seatTypes){
			String[] keypair=t.split(":");
			cboSeatType.addItem(new KeyValueComboxItem(keypair[0], keypair[1]));
		}
		
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionevent) {
				KeyValueComboxItem seatType= (KeyValueComboxItem) cboSeatType.getSelectedItem();
				
				//JOptionPane.showMessageDialog(SelectSeatTypeFrm.this, " 你选择的座位类型:"+seatType.getValue()+","+seatType.getText());
				
				result=seatType;
				setVisible(false);
			}
		});
		
		//setAlwaysOnTop(true);
		// frame.setUndecorated(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//EXIT_ON_CLOSE
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setResizable(false);
		//pack();
		setSize(350,200);
		//放在pack调整大小之后frame才有width和height
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-getHeight())/2;
		setLocation(x, y);*/
		setLocationRelativeTo(null);
		
		//setVisible(true);
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//srv.loginOut();
				logCon("退出 登录 ....");
			}
		});*/
	}
	
	public KeyValueComboxItem getResult(){
		result=null;
		setVisible(true);
		return result;
	}
	
	public static void main(String[] args) {
		QueryLeftNewDTO dto=new QueryLeftNewDTO();
		SelectSeatTypeFrm f=new SelectSeatTypeFrm(dto,new String[]{"zhagns","abc"});
			f.setVisible(true);
	}
	
	
}
