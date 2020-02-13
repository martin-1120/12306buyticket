package com.buyticket.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.buyticket.core.Cfg;

public class LoginFrm extends JFrame{
	/**
	 * 
	 */
	static Log log=LogFactory.getLog(LoginFrm.class);
	private static final long serialVersionUID = 1L;

	
	private JLabel lblAccount=new JLabel("账号:",JLabel.CENTER);
	private JTextField txtAccount=new JTextField();
	
	private JLabel lblPwd=new JLabel("密码:",JLabel.CENTER);
	private JPasswordField txtPwd=new JPasswordField();
	
	public JButton btnLogin=new JButton("登录");//登录

	public LoginFrm(final MainFrm mainFrm) {
		this.mainFrm=mainFrm;
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/resource/img/select.png"));
		setIconImage(icon.getImage());
		
		//getContentPane().add(new JPanel(),BorderLayout.WEST);
		//getContentPane().add(new JPanel(),BorderLayout.EAST);

		setTitle("登陆 ");
		setLayout(null);//new GridLayout(3, 2)
		
		add(lblAccount);
		add(txtAccount);
		add(lblPwd);
		add(txtPwd);
		//add(new JLabel(""));
		add(btnLogin);
		
		lblAccount.setBounds(20, 10,50 ,30);//x y  width height
		txtAccount.setBounds(70, 10,200 ,30);//x y  width height
		
		lblPwd.setBounds(20, 50,50 ,30);//x y  width height
		txtPwd.setBounds(70, 50,200 ,30);//x y  width height
		
		btnLogin.setBounds(150, 100,100 ,30);//x y  width height
		
		txtAccount.setText(Cfg.getUsername());
		txtPwd.setText(Cfg.getUserpwd());
		
		
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent actionevent) {
				String name=txtAccount.getText();
				String pwd=txtPwd.getText();//getPassword().toString()
				if(!"".equals(name.trim()) &&  !"".equals(pwd.trim()))
					mainFrm.login(name, pwd);
				else{
					JOptionPane.showMessageDialog(LoginFrm.this, "请输入账号密码!");
				}
				
			}
		});
		
		//setAlwaysOnTop(true);
		// frame.setUndecorated(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//EXIT_ON_CLOSE
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setResizable(false);
		//pack();
		setSize(300,200);
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
	MainFrm mainFrm=null;

	public static void main(String[] args) {
			/*LoginFrm f=new LoginFrm();
			f.setVisible(true);*/
	}
}
