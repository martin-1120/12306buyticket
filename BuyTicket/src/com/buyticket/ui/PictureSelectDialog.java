package com.buyticket.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import com.buyticket.core.Cfg;
import com.buyticket.core.ChaoJiYing;
import com.buyticket.core.HttpService12306;
import com.buyticket.core.HttpUtil;
import com.buyticket.core.My12306Exception;

public class PictureSelectDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static ImageIcon img = new ImageIcon(PictureSelectDialog.class.getResource("/resource/img/default.jpg"));
	final static JLabel lblPic = new JLabel(img);
	final static int offsetX = 1, offsetY = -29;
	
	String randCode=null;
	//String picPath=null;
	byte[] imgdata=null;
	
	//String oldPicPath=null;
	JLabel lblMessage=new JLabel(); 
	HttpService12306 util=null;
	public PictureSelectDialog(HttpService12306 httpUtil) {
		this.util=httpUtil;
		this.setModal(true);//必须是true, setVisible(true)才 能阻塞,我擦擦擦坑爹的
		// UI init
		lblPic.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		JButton btnRefresh = new JButton(new ImageIcon(getClass().getResource("/resource/img/refresh.png")));
		btnRefresh.setBounds(220, 2, 55, 24);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshPic();
			}
		});

		JButton btnSubmit = new JButton();//new ImageIcon(getClass().getResource("/resource/img/submit.png"))
		btnSubmit.setBackground(Color.orange);
		btnSubmit.setText("确定");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				submit();
			}
		});
		getContentPane().setLayout(new BorderLayout());
		
		lblMessage.setVisible(true);
		lblMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*if(e.getClickCount()==2){
					try {
						if(oldimgp!=null){
							Runtime.getRuntime().exec("mspaint "+oldPicPath);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}*/
			}
		});
		
		getContentPane().add(lblPic, BorderLayout.CENTER);
		getLayeredPane().add(btnRefresh);
		JPanel pan=new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(lblMessage,BorderLayout.NORTH);
		pan.add(btnSubmit,BorderLayout.SOUTH);
		add(pan,BorderLayout.SOUTH);
//		add(lblMessage,BorderLayout.SOUTH);
//		add(btnSubmit, BorderLayout.SOUTH);
		lblPic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				select(new Point((int) (arg0.getPoint().getX() - (imgSelect.getIconWidth() / 2.0)),
						(int) (arg0.getPoint().getY() - imgSelect.getIconHeight() / 2.0)));
			}
		});
		
		// Point mousepoint = MouseInfo.getPointerInfo().getLocation();
		
		// frame.setLocation((int)mousepoint.getX(),(int)mousepoint.getY());
		setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		// frame.setUndecorated(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);//JFrame.EXIT_ON_CLOSE
		// frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		pack();
		// frame.setVisible(true);
	}
	ImageIcon imgSelect = new ImageIcon(getClass().getResource("/resource/img/select.png"));
	public void select(Point p) {
		//System.out.println("x :"+x+" y:"+y);
		Component lbl=getRootPane().getLayeredPane().getComponentAt(p);
		if(lbl!=null && lbl instanceof JLabel){
			System.out.println(lbl.getClass());
			getRootPane().getLayeredPane().remove(lbl);
			getRootPane().getLayeredPane().repaint();
			return;
		}
		
		final JLabel lab = new JLabel(imgSelect);
		lab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//select(e.getPoint());
				getRootPane().getLayeredPane().remove(lab);
				getRootPane().getLayeredPane().repaint();
			}
		});

		lab.setBounds(
				p.x,p.y,
				imgSelect.getIconWidth(),
				imgSelect.getIconHeight());
		getRootPane().getLayeredPane().add(lab);

		// System.out.println(arg0.getX()+offsetX+","+(arg0.getY()+offsetY));
	
	}

	protected void submit() {
		// ((JButton)arg0.getSource()).getParent().disable();
		Component[] components = getRootPane().getLayeredPane()
				.getComponents();
		boolean hasSelected = false;
		for (Component c : components) {
			if (c instanceof JLabel) {
				hasSelected = true;
				break;
			}
		}
		if (!hasSelected) {
			return;
		}
		//
		setVisible(false);
	
	}

	static Map<Integer, java.awt.Point> keyPoint=new HashMap<Integer, java.awt.Point>();
	static{
		//String row1="x:23 y:60|x:95 y:61|x:168 y:58|x:242 y:58";
		//String row2="x:23 y:133|x:98 y:134|x:165 y:136|x:244 y:138";
		Point p1=new Point(23,60);
		Point p2=new Point(95,60);
		Point p3=new Point(168,60);
		Point p4=new Point(242,60);
		
		Point p5=new Point(23,133);
		Point p6=new Point(95,134);
		Point p7=new Point(168,134);
		Point p8=new Point(242,134);
		
		keyPoint.put(KeyEvent.VK_Q,p1);
		keyPoint.put(KeyEvent.VK_W,p2);
		keyPoint.put(KeyEvent.VK_E,p3);
		keyPoint.put(KeyEvent.VK_R,p4);
		
		keyPoint.put(KeyEvent.VK_A,p5);
		keyPoint.put(KeyEvent.VK_S,p6);
		keyPoint.put(KeyEvent.VK_D,p7);
		keyPoint.put(KeyEvent.VK_F ,p8);// ; SEMICOLON
		
		
		
		//keyPoint.put(KeyEvent.VK_ESCAPE, value);
	}
	 /** 
     * 覆盖父类的方法。实现自己的添加了ESCAPE键监听 
     */  
    @Override  
    protected JRootPane createRootPane(){  
        JRootPane rootPane = new JRootPane();  
        //esc 关闭
        rootPane.registerKeyboardAction(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                escapeKeyProc();  
            }  
        },KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        //刷新
        rootPane.registerKeyboardAction(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	refreshPic();  
            }  
        },KeyStroke.getKeyStroke(KeyEvent.VK_G,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        //确定
        rootPane.registerKeyboardAction(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	submit();  
            }  
        },KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        
        //qwer asdf g 空格
        rootPane.registerKeyboardAction(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	select(keyPoint.get(KeyEvent.VK_Q));
            }  
        },KeyStroke.getKeyStroke(KeyEvent.VK_Q,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_W));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_W,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_E));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_E,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_R));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_R,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        //asdf
        rootPane.registerKeyboardAction(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	select(keyPoint.get(KeyEvent.VK_A));
            }  
        },KeyStroke.getKeyStroke(KeyEvent.VK_A,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_S));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_S,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_D));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_D,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        rootPane.registerKeyboardAction(new ActionListener() {  
        	@Override  
        	public void actionPerformed(ActionEvent e) {  
        		select(keyPoint.get(KeyEvent.VK_F));
        	}  
        },KeyStroke.getKeyStroke(KeyEvent.VK_F,0), JComponent.WHEN_IN_FOCUSED_WINDOW);  
        
  
        return rootPane;  
    }  
      
    /** 
     * 处理ESCAPE按键。子类可以重新覆盖该方法，实现自己的处理方式。 
     */  
    protected  void escapeKeyProc(){  
        setVisible(false);  
    }  
	private String module = "login", rand = "sjrand";// passenger randp
	public String getLoginRandCode(){
		module = "login";
		rand = "sjrand";
		return getPosition("登陆验证码");
	}
	public String getBuyRandCode(){
		module = "passenger";
		rand = "randp";
		return getPosition("购票验证码");
	}
	public boolean useChaojiying(){
		return !module.equals("login") &&  "true".equals(Cfg.get("useChaojiying")) &&  Cfg.get("chaojiyingUserName")!=null && !Cfg.get("chaojiyingUserName").trim().equals("") && Cfg.get("chaojiyingPwd")!=null &&!Cfg.get("chaojiyingPwd").trim().equals("");
	}
	String picId=null;
	@SuppressWarnings("deprecation")
	private String getPosition(String title) {
		picId=null;
		randCode=null;
		
		setTitle(title+" qwerasdf选图 ,g刷新,空格确定");
		refreshPic();
		Thread t = new Thread(){
			public void run() {
				String[] ret=ChaoJiYing.get12306RandCodeAndPicId(imgdata).split("\\|");
				picId=ret[0];
				randCode=ret[1];
				setVisible(false);
			};			 
		};
		if(useChaojiying()){
			t.start();
			setTitle(" 启动超级鹰解码...");
		}
		setVisible(true);//这里就已经阻塞了 模式窗体才行
	
		if(randCode==null){
			if(useChaojiying()){
				t.stop();
				setTitle(" 停止超级鹰解码...");
			}
			StringBuffer sb = new StringBuffer();
			Component[] components = getRootPane().getLayeredPane()
					.getComponents();
			for (Component c : components) {
				if (c instanceof JLabel) {
					JLabel label = (JLabel) c;
					sb.append((label.getLocation().x + label.getWidth() / 2 + offsetX)
							+ ","
							+ (label.getLocation().y
									+ Math.round(label.getHeight() / 2.0) + offsetY)
							+ ",");
				}
			}
			randCode=sb.length()>0 ? sb.toString().substring(0, sb.length() - 1):null;
		}
		return randCode;
	}
	public void isPass(){
		lblMessage.setText("");
		lblMessage.setVisible(false);
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
	public void isNotPass(){
		/*try {
			File destFile=new File("temp/notpass/"+sdf.format(new Date())+"("+randCode+")");
			oldPicPath=destFile.getAbsolutePath();
			FileUtils.copyFile(new File(picPath), destFile);*/
			ChaoJiYing.ReportError(picId);
		/*} catch (IOException e) {
			e.printStackTrace();
		}*/
		lblMessage.setText("验证失败:"+randCode);
		lblMessage.setVisible(true);
	}
	
	/*
	private static javax.net.ssl.SSLSocketFactory getSSLSocketFactory(){
		SSLContext ctx=null;
		try {
			ctx = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		X509TrustManager tm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] xcs, String string)
					throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		try {
			ctx.init(null, new TrustManager[] { tm }, null);
		} catch (KeyManagementException e1) {
			e1.printStackTrace();
		}
		 //javax.net.ssl.SSLSocketFactory
		 //org.apache.http.conn.ssl.SSLSocketFactory.SSLSocketFactory
	
		//从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = ctx.getSocketFactory();
		return ssf;
	}*/
	public void refreshPic() {
		
		
		try {
			/*这样得不到   验证码请求 要返回cookie
			 * HttpsURLConnection httpsConn=null;
			 * URL verityPic = new URL("https","kyfw.12306.cn",
					"/otn/passcodeNew/getPassCodeNew?module="
							+ module + "&rand=" + rand + "&"
							+ new Random().nextFloat());
			"temp", "-" + module + "-"
					+ new Date().toLocaleString().replaceAll("[-:\\s]", ""
			URLConnection conn= verityPic.openConnection();
			httpsConn=(HttpsURLConnection)conn;
			httpsConn.setSSLSocketFactory(getSSLSocketFactory());
			if(httpsConn.getInputStream()==null){
				System.out.println("还未登陆无法获取 购票验证码!");
			}*/
			try {
				imgdata=util.getRandCode(module, rand);
				/*imgdata=util.getBinaryResourceByGet("https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module="
								+ module + "&rand=" + rand + "&"
								+ new Random().nextFloat(), "temp");*/
			} catch (My12306Exception e) {
				JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
				close();
				return ;
			}
			
			InputStream buffin = new ByteArrayInputStream(imgdata,0,imgdata.length);
			BufferedImage bufImg=ImageIO.read(buffin);

		/*	ByteArrayOutputStream byteos=new ByteArrayOutputStream();
			ImageIO.write(bufImg,"gif",byteos);
			imgdata=byteos.toByteArray();*/
			lblPic.setIcon(new ImageIcon(bufImg));//ImageIO.read(new File(picPath))
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Component c : getRootPane().getLayeredPane().getComponents()) {
			if (c instanceof JLabel) {
				getRootPane().getLayeredPane().remove(c);
			}
		}
		getRootPane().getLayeredPane().repaint();
	};
	public void close(){
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		/*PictureSelectDialog dialog=new PictureSelectDialog();
		
		String result=dialog.getLoginRandCode();//dialog.getBuyRandCode();//还未登陆无法获取购票验证码
		System.out.println(result);*/
	}
	
	

}