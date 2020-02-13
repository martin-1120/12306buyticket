package com.buyticket.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.SliderUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.buyticket.core.Cfg;
import com.buyticket.core.HttpService12306;
import com.buyticket.core.HttpService12306.SubmitTokenInfo;
import com.buyticket.core.My12306Exception;
import com.buyticket.dto.MyOrdersDTO;
import com.buyticket.dto.QueryLeftNewDTO;
import com.buyticket.dto.ResultData;
import com.buyticket.dto.TicketPriceDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class MainFrm extends JFrame{
	/**
	 * 
	 */
	static Log log=LogFactory.getLog(MainFrm.class);
	private static final long serialVersionUID = 1L;

	HttpService12306 srv=null;
	PictureSelectDialog picDialog=null;
	
	private JPanel panSearch=new JPanel();
	private JPanel panList=new JPanel();
	private JPanel panSetings=new JPanel();
	
	private JButton btnSet=new JButton("设置(A)");
	private JButton btnLogin=new JButton("登录(L)");//登录

	private JLabel lblStartStation=new JLabel("出发地");//出发地
	private FilterComboBox cbbStartStation=null;
	private JLabel lblEndStation=new JLabel("目的地");//目的地
	private FilterComboBox cbbEndStation=null;
	private JLabel lblGoDate=new JLabel("出发日期");//出发日期
	private DateTimePicker dateTimePicker=new DateTimePicker(this);
	private JButton btnQuery=new JButton("查询(S)");//查询
	private JButton btnBegin=new JButton("开刷(B)");//
	private JButton btnOrderInfo=new JButton("订单信息(O)");//
	private JButton btnLoginUseSession=new JButton("session登录(E)");
	private JButton btnShowPassenger=new JButton("查询乘客");
	private JButton btnTest=new JButton("test");
	
	private JTable table=new JTable();
	
	
	JLabel lblPriceInfo=new JLabel("票价信息:");
	
	static Color blue=new Color(0,128,255);//蓝色
	static Color lightBlue=new Color(206, 231, 255);//浅蓝色
	static Color orange=new Color(255, 128, 9);//橘黄色
	static Font blodFont=new Font("宋体", Font.BOLD, 20);
	//private static final String COLUMN_NAME="COLUMN_NAME_";
	public MainFrm(HttpService12306 srv) {
		this.srv=srv;
		picDialog=new PictureSelectDialog(srv);
		
		lblPriceInfo.setForeground(orange);
		lblPriceInfo.setFont(blodFont);
		
		//System. getProperties().setProperty("file.encoding", "UTF-8");
		btnSet.setMnemonic(KeyEvent.VK_A);
		btnLogin.setMnemonic(KeyEvent.VK_L);
		btnLoginUseSession.setMnemonic(KeyEvent.VK_E);
		
		btnQuery.setMnemonic(KeyEvent.VK_S);
		btnQuery.setBackground(orange);
		btnQuery.setForeground(Color.white);
		
		btnBegin.setMnemonic(KeyEvent.VK_B);
		btnOrderInfo.setMnemonic(KeyEvent.VK_O);
		
		log.info("当前JVM字符集：" + System.getProperty("file.encoding"));
		//城市数据 不要时实查询，容易被封
		/*try {
			srv.refreshStationJS();
		} catch (My12306Exception e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}*/
		
		ImageIcon icon=new ImageIcon(getClass().getResource("/resource/img/select.png") );
		setIconImage(icon.getImage());
		
		getContentPane().setLayout(new BorderLayout());
		
		getContentPane().add(panSearch,BorderLayout.NORTH);
		getContentPane().add(panList,BorderLayout.CENTER);
		getContentPane().add(panSetings,BorderLayout.SOUTH);
		
		initPanSearch();
		initPanList();
		initPanSetings();
		
		

		//getContentPane().add(new JPanel(),BorderLayout.WEST);
		//getContentPane().add(new JPanel(),BorderLayout.EAST);

		setTitle("12306BuyTicket1.1  夕星银梦 ");
		
		
		//setAlwaysOnTop(true);
		// frame.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setResizable(false);
		pack();
		//setSize(1185,620);
		//放在pack调整大小之后frame才有width和height
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		int x = (int)(toolkit.getScreenSize().getWidth()-getWidth())/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-getHeight())/2;
		setLocation(x, y);*/
		setLocationRelativeTo(null);
		loadProperties();
		
		//自动查询
		/*if(cbbStartStation.getValue()!=null && cbbEndStation.getValue()!=null && !dateTimePicker.getText().equals("")){
			btnQuery_onclick();
		}*/
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//srv.loginOut();
				logCon("退出 登录 ....");
			}
		});
	}
	public static String CBB_START_STATION_INIT_VALUE="cbbStartStation.Value";
	public static String CBB_END_STATION_INIT_VALUE="cbbEndStation.Value";
	public static String DATE_TIMER_PICKER_TEXT="dateTimePicker.Text";
	private void loadProperties(){
		cbbStartStation.setValue(Cfg.get(CBB_START_STATION_INIT_VALUE));
		cbbEndStation.setValue(Cfg.get(CBB_END_STATION_INIT_VALUE));
		//dateTimePicker.setText(Cfg.get(DATE_TIMER_PICKER_TEXT));
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH,29);
		
		dateTimePicker.setText(sdf.format(c.getTime()));
	}
	private static void InitGlobalFont(Font font) {  
		  FontUIResource fontRes = new FontUIResource(font);  
		  for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {  
			  Object key = keys.nextElement();  
			  Object value = UIManager.get(key);  
			  if (value instanceof FontUIResource) {  
				  UIManager.put(key, fontRes);  
			  }  
		  }  
	}
	public void showPassager(){
		logCon("登陆成功！");
		
		JSONArray arr=null;
		try {
			arr = srv.queryPassengers();
		} catch (My12306Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}
		for(int i=0;i<arr.size();i++){
			String passengerName=arr.getJSONObject(i).getString("passenger_name");
			String isUserSelf=arr.getJSONObject(i).getString("isUserSelf");
			JCheckBox ckbox=new JCheckBox(passengerName);
			if("Y".equals(isUserSelf)){
				ckbox.setSelected(true);
			}
			panCustomer.add(ckbox);
		}	
		panCustomer.setVisible(true);
		panCustomer.repaint();
		getContentPane().repaint();
		setTitle(getTitle()+" 账号:"+Cfg.getUsername());
		
		/*for(int i=0;i<10;i++){
			panCustomer.add(new JCheckBox(" checkbox"+(i+1)));
		}*/
		panCustomer.validate();
//		panSetings.repaint();
	}
	Map<String,TicketPriceDTO> priceCash=new HashMap<String,TicketPriceDTO>();
	LoginFrm loginFrm=new LoginFrm(this);
	public void initPanSearch(){
		
		panSearch.add(btnSet);
		panSearch.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionevent) {		
				//if(!checkCfg()){
				loginFrm.setVisible(true);
					//return;
				//}
				
			}
		});
		btnSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionevent) {		
				CfgFrm cfgFrm=new CfgFrm(srv);
				cfgFrm.setVisible(true);
				
			}
		});
		
		panSearch.add(btnLoginUseSession);
		btnLoginUseSession.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!checkCfg()){
					return;
				}
				String cookie=JOptionPane.showInputDialog(MainFrm.this, "输入  JSESSIONID,BIGipServerotn");
				
				boolean b=false;
				try {
					b = srv.loginUseSession(cookie);
				} catch (My12306Exception e1) {
					logCon("登陆失败:"+e1.getMessage());
				}
				if(b){
					loginName=Cfg.getUsername();
					showPassager();
				}
				//JOptionPane.showMessageDialog(MainFrm.this, b?"成功!":"失败");
				
			}
		});
		btnShowPassenger.setVisible(false);
		panSearch.add(btnShowPassenger);
		btnShowPassenger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				showPassager();
			}
		});

		final JPopupMenu popMenuTable = new JPopupMenu();
		JMenuItem itSelect = new JMenuItem("选择车次");
		JMenuItem itClear = new JMenuItem("清空所选车次");
		popMenuTable.add(itSelect);
		popMenuTable.add(itClear);
		
		itSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int[] rowIndex =table.getSelectedRows();
				if(rowIndex.length>=1){
					for(int row : rowIndex){
						String trainNo=(String) table.getModel().getValueAt(row, 0);
						for(Component c : panTrainNo.getComponents()){
							JCheckBox ck=(JCheckBox)c;
							if(ck.getText().equals(trainNo))
							return ;
						}
						JCheckBox ckbox=new JCheckBox(trainNo);
						ckbox.setSelected(true);
						panTrainNo.add(ckbox);
						
					}
					panTrainNo.validate();
				}
				popMenuTable.setVisible(false);
			}
		});
		itClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllTrainNo();		
				popMenuTable.setVisible(false);
			}
		});
		
		MyTableModel myModel =new MyTableModel(null);
	    table.setModel(myModel);
	    table.setRowHeight(40);
	    table.getTableHeader().setPreferredSize(new Dimension(30, 30));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    //log.error(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn())+"  "+table.getSelectedRow()+","+table.getSelectedColumn());
				/*if(table.getSelectedColumn()==table.getColumnCount()-1){
					//最后一个按钮单击事件不要跟这个搞混了
					return;
				}*/
			    System.out.println("点击了");	
				MyTableModel mode= (MyTableModel)table.getModel();
				if(mode.getDataSource().size()==0)
					return ;
				
				int rowIndex =table.getSelectedRow();
				
				String trainCode=null;
				QueryLeftNewDTO dto=null;
				if(rowIndex!=-1){
					trainCode=(String)table.getValueAt(rowIndex, 0);
				    dto= mode.getByTrainCode(trainCode);
				}
				
				if(e.getButton()==MouseEvent.BUTTON3){//右键单击
					Point p=MouseInfo.getPointerInfo().getLocation();
					//popMenuTable.show(MainFrm.this, e.getX()+3, e.getY()+86);
					popMenuTable.show(null,p.x,p.y);
					return ;
				}else if(e.getClickCount()==1 && rowIndex>-1){
					lblPriceInfo.setText("");
					TicketPriceDTO priceDto=priceCash.get(trainCode);
					if(priceDto==null){
						try {
							priceDto=srv.queryTicketPrice(dto.getTrain_no(),dto.getFrom_station_no(),dto.getTo_station_no(),dto.getSeat_types(),DateFormatUtil.getSplitDateStr(dto.getStart_train_date()));
							priceCash.put(trainCode,priceDto);
						} catch (My12306Exception ex) {
							//JOptionPane.showMessageDialog(this,ex.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
							lblPriceInfo.setText("票价信息:"+dto.getButtonTextInfo());//+ex.getMessage()+" 可能原因:"+
							//lblPriceInfo.setText(ex.getMessage());
						}
					}
					System.out.println("设置票价："+dto.getStation_train_code());
					lblPriceInfo.setText("票价信息:"+(priceDto==null?dto.getStation_train_code():dto.getStation_train_code()+":"+priceDto.getPriceInfoStr()));
					
					
				}else if(e.getClickCount()==2 && rowIndex>-1){
					//JTable table=((JTable)e.getSource());
					for(Component c : panTrainNo.getComponents()){
						JCheckBox ck=(JCheckBox)c;
						if(ck.getText().equals(trainCode))
						return ;
					}
					JCheckBox ckbox=new JCheckBox(trainCode);
					ckbox.setSelected(true);
					panTrainNo.add(ckbox);
					panTrainNo.validate();
					
				}
			}
		});
		
		btnTest.setVisible(false);
		panSearch.add(btnTest);
		btnTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*int rowIndex=table.getSelectedRow();
				if(rowIndex==-1)
					return ;
				String trainzCode=(String) table.getValueAt(rowIndex, 0);
				
				buyTicket();*/
				//initPanList();
				//table.updateUI();
			}
		});
		btnQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnQuery_onclick();
			}
		});
		btnBegin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!srv.isLogin){
					logCon("还没登录呢");
					loginFrm.setVisible(true);
					return ;
				}
					toggleStartStop();
			}
		});
		
		
		
		btnOrderInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showOrderInfo();
			}
		});
		
		String[] stations=null;
		
		
			/*String favoriteJs=IOUtils.readLines(getClass().getResourceAsStream("/resource/data/favorite_name")).get(0);
			String stationJs=IOUtils.readLines(getClass().getResourceAsStream("/resource/data/station_name")).get(0);
			stations=new String[]{favoriteJs,stationJs};*/
			stations=srv.getStationInfo();
		
		/*try {
			stations = srv.getStaionNames();
		} catch (My12306Exception e1) {
			JOptionPane.showMessageDialog(this,e1.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}*/
		cbbStartStation=new FilterComboBox(this,stations);
		cbbEndStation=new FilterComboBox(this,stations);
		
		
		panSearch.add(lblStartStation);
		panSearch.add(cbbStartStation);
		
		panSearch.add(lblEndStation);
		panSearch.add(cbbEndStation);
		
		panSearch.add(lblGoDate);
		panSearch.add(dateTimePicker);
		
		panSearch.add(btnQuery);
		panSearch.add(btnBegin);
		
		
		panSearch.add(btnOrderInfo);
		
		
		//cboStartStation.addItem(item);
		
	}
	Thread buyThread= new Thread(){
		
		public void run() {
			while(true){
				
				if(!isBegin){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					
					//没选好乘客，座位车次，   也没勾自动选车次
					if(!getSettingInfo() && (selectedPassenger.length==0 && !ckbAuto.isSelected())){
						try {
							//log.info("!getSettingInfo() :"+!getSettingInfo()+ " ''.equals(selectedPassenger) && !ckbAuto.isSelected():"+("".equals(selectedPassenger) && !ckbAuto.isSelected()));
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									logCon("请选择选择乘客，座位，车次...");
								}
							});
							Thread.sleep(5000);//10s
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}else{
					
						try {
							boolean isSuccess=buyTicketOnce();
							//没买成功我就刷新一遍
							if(!isSuccess){
								try {
									int sleepTime= (new Random().nextInt(25)+25)*100;//2.5-4s 
									Thread.sleep(sleepTime);
									//Thread.currentThread().sleep(sleepTime); 
//									线程可以用继承Thread类或者实现Runnable接口来实现.
//									Thread.sleep()是Thread类的方法,只对当前线程起作用,睡眠一段时间.
//									如果线程是通过继承Thread实现的话这2个方法没有区别；
//									如果线程是通过实现Runnable接口来实现的,则不是Thread类,不能直接使用Thread.sleep()
//									必须使用Thread.currentThread()来得到当前线程的引用才可以调用sleep(),
//									所以要用Thread.currentThread().sleep()来睡眠...
									btnQuery_onclick();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					
					}
				}
			}
			
		};
	};
	public String loginName=null;
	public boolean login(String name,String pwd){
		boolean b=false;
		try {
				//b = srv.login(name,pwd);
			srv.loginInit();
			String randCode=null;
			while(true){
				randCode = picDialog.getLoginRandCode();
				if(randCode==null){
					return false;
				}
				boolean randCodePass=srv.checkLoginRandCode(randCode);
				if(randCodePass){
					picDialog.close();
					picDialog.isPass();
					break;
				}
				
			}
			
			b=srv.login(name, pwd, randCode);
			
		} catch (My12306Exception e) {
			loginFrm.btnLogin.setText(e.getMessage());
			//logCon("12306异常"+e.getMessage());
			//JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}
		if(b){
			loginName=name;
			Cfg.setUsername(name);
			Cfg.setUserpwd(pwd);
			Cfg.saveCfg();
			loginFrm.setVisible(false);
			//添加乘客
		
			showPassager();
//			((JButton)actionevent.getSource()).setText("退出");
		}
		
		return b;
	}
	protected void showOrderInfo() {
		MyOrdersDTO dto=null;
		try {
			dto = srv.queryMyOrderNoComplete();
		} catch (My12306Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
			//ssJOptionPane.showMessageDialog(this,e.getMessage());
			return;
		}
		//JOptionPane.showMessageDialog(this,"请用记事本打开 cfg.properties文件配置12306账号 username=账号  userpwd=密码 ");
		int result=-1;
		try {
			if("".equals(dto.getOrderInfo())){
				JOptionPane.showMessageDialog(this,"没有未完成订单","未完成订单信息",JOptionPane.INFORMATION_MESSAGE);
				return ;
			}else{
				result = JOptionPane.showConfirmDialog(this, dto.getOrderInfo(), "取消订单？", JOptionPane.YES_NO_OPTION);
			}
		} catch (My12306Exception e1) {
			JOptionPane.showMessageDialog(this,e1.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}
		if(result==JOptionPane.YES_OPTION){
			
			String[] seqs=dto.getSequence_no();
			if(seqs!=null){
				for(String s:seqs){
					try {
						srv.cancelNoCompleteMyOrder(s);
					} catch (My12306Exception e) {
						JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
					}
				}
				JOptionPane.showMessageDialog(this, "取消成功!");
			}
		}
		
	}
	protected boolean checkCfg() {
		if(Cfg.getUsername()==null ||Cfg.getUsername().trim().equals("")|| Cfg.getUserpwd()==null|| Cfg.getUserpwd().trim().equals("")){
			JOptionPane.showMessageDialog(this,"请用记事本打开 cfg.properties文件配置12306账号 username=账号  userpwd=密码 ");
			return false;
		}
		return true;
	}
	public void btnQuery_onclick(){

		if(cbbStartStation.getValue()==null || cbbEndStation.getValue()==null){
			JOptionPane.showMessageDialog(MainFrm.this, "你sb啊，不填信息怎么查!");
			return ;
		}
		queryTicketInfo(cbbStartStation.getText(),cbbStartStation.getValue(),cbbEndStation.getText(),cbbEndStation.getValue(),dateTimePicker.getText());
		
		//save cfg
		PropertiesConfiguration p=Cfg.getConfig();
		p.setProperty(CBB_START_STATION_INIT_VALUE, cbbStartStation.getValue());
		p.setProperty(CBB_END_STATION_INIT_VALUE, cbbEndStation.getValue());
		p.setProperty(DATE_TIMER_PICKER_TEXT,dateTimePicker.getText() );
		Cfg.saveCfg();
	
	}
	//public boolean isBegin=false;
	
	protected void queryTicketInfo(String fromStationName,String fromStationCode, String toStationName, String toStationCode, String date) {
		
		Date begin=new Date();
		System.out.println("from:"+fromStationCode+"  to:"+toStationCode+" date:"+date);
		//设置cookie
		srv.putCookie("_jc_save_fromDate="+date+";_jc_save_fromStation="+encodeStationName(fromStationName,fromStationCode)+";_jc_save_toDate="+sdf.format(new Date())+";_jc_save_toStation="+encodeStationName(toStationName,toStationCode)+";_jc_save_wfdc_flag=dc");
		List<QueryLeftNewDTO> datas=new ArrayList<QueryLeftNewDTO>();
		try {
			datas = srv.queryTicket(fromStationCode, toStationCode, date);
		} catch (My12306Exception e) {
			logCon(e.getMessage());
			
			//JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
		}
		
		refreshTableData(datas);		
//		refreshTableData(dataVec,QueryLeftNewDTO.getColHeader());		
	    //panListPanl.validate(); //靠你大爷， 找了那么久 原来要这样才能现实出来， 我擦擦，真tm难用  比微软的C# winfrom差多了
		logCon("共查询到:"+datas.size()+" 趟列车     耗时 "+(new Date().getTime()-begin.getTime())/1000+" 秒");
		
	}
	private int getPreferredWidthForColumn(TableColumn col) {
        int hw = columnHeaderWidth(col);  // hw = header width
        int cw = widestCellInColumn(col);  // cw = column width
        return hw > cw ? hw : cw;
    }

    private int columnHeaderWidth(TableColumn col) {
        TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
        Component comp = renderer.getTableCellRendererComponent(
                             table, col.getHeaderValue(),
                             false, false, 0, 0);

        return comp.getPreferredSize().width+11;
    }

    private int widestCellInColumn(TableColumn col) {
        int c = col.getModelIndex();
        int width = 0, maxw = 0;

        for (int r =0; r < table.getRowCount(); r++) {
            TableCellRenderer renderer = table.getCellRenderer(r, c);
            Component comp = renderer.getTableCellRendererComponent(
                                 table, table.getValueAt(r, c),
                                 false, false, r, c);
            width = comp.getPreferredSize().width;
            maxw = width > maxw ? width : maxw;
        }
        return maxw;
    }
    int offsetColWidth=5;
    public void autoSetTaleColumnWidth(){
    	for(int i=0;i<table.getModel().getColumnCount();i++){
    		TableColumn column=table.getColumnModel().getColumn(i);
    		int width=getPreferredWidthForColumn(column);
            column.setPreferredWidth(width+offsetColWidth);
           // column.setWidth(width+offsetColWidth);
            System.out.println("宽度 :"+(width+offsetColWidth));
    	}
    }
	public void initPanList(){
		
		panList.setLayout(new BorderLayout());
		
		panList.add(lblPriceInfo,BorderLayout.NORTH);
		
		JScrollPane scrollPanel = new JScrollPane(table);
		//scrollPanel.setBorder(BorderFactory.createLineBorder(Color.green));
		
		panList.add(scrollPanel, BorderLayout.CENTER);
		table.setAutoscrolls(true);
		table.setFillsViewportHeight(true);
		
		//出现横向滚动条
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	    
	    //
	    refreshTableData(null);

	}
	private class MyTableModel extends AbstractTableModel  
    {  
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		List<QueryLeftNewDTO> dataSource=new ArrayList<QueryLeftNewDTO>();
		Map<String,QueryLeftNewDTO> map=new HashMap<String,QueryLeftNewDTO>();
		public List<String> getColHeader(){
			return QueryLeftNewDTO.getColHeader();
		}
		public List<QueryLeftNewDTO> getDataSource(){
			return dataSource;
		}
		/*public void refreshData(List<QueryLeftNewDTO> dataSource){
			if(dataSource==null){
				this.dataSource=new ArrayList<QueryLeftNewDTO>();
			}else{
				this.dataSource=dataSource;
			}
		}*/
		
        /** 
         * 构造方法，初始化二维数组data对应的数据 
         */  
        public MyTableModel(List<QueryLeftNewDTO> dataSource){
        	if(dataSource!=null && dataSource.size()>0){
        		this.dataSource=dataSource;
        		map=new HashMap<>();
        		for(QueryLeftNewDTO d : dataSource){
        			map.put(d.getStation_train_code(),d);
        		}
        	}
        }
       /* public QueryLeftNewDTO getByTrainNo(String trainNo){
        	if(dataSource!=null && dataSource.size()>0){
        		for(int i=0;i<dataSource.size();i++){
        			QueryLeftNewDTO dto = dataSource.get(i);
        			if(dto.getTrain_no().equals(trainNo)){
        				return dto;
        			}
        		}
        	}
			return null;
        }  */
      
		public QueryLeftNewDTO getByTrainCode(String trainCode){
			return map.get(trainCode);
        	/*if(dataSource!=null && dataSource.size()>0){
        		for(int i=0;i<dataSource.size();i++){
        			QueryLeftNewDTO dto = dataSource.get(i);
        			if(dto.getStation_train_code().equals(trainCode)){
        				return dto;
        			}
        		}
        	}
        	return null;*/
        }  
        // 以下为继承自AbstractTableModle的方法，可以自定义  
        /** 
         * 得到列名 
         */  
        @Override  
        public String getColumnName(int column){
			return QueryLeftNewDTO.getColumnName(column);
        }  
          
        /** 
         * 重写方法，得到表格列数 
         */  
        @Override  
        public int getColumnCount(){  
            return  QueryLeftNewDTO.getColHeader().size();
        }  
  
        /** 
         * 得到表格行数 
         */  
        @Override  
        public int getRowCount(){  
            return dataSource.size();  
        }  
  
        /** 
         * 得到数据所对应对象 
         */  
        @Override  
        public Object getValueAt(int rowIndex, int columnIndex){  
        	Object value=QueryLeftNewDTO.getValueAt(dataSource.get(rowIndex),columnIndex);
			// return   "<html><font   color=red>"+rowIndex*columnIndex+"</font></html>"; 
			if(value!=null && !value.equals("") && (value.equals("有")|| (value.toString().indexOf(":")==-1 && Character.isDigit(value.toString().charAt(0))&&value.toString().length()<4)) ){
				return "<html><font color=green>"+value+"</font></html>";
			}else if(value!=null && (value.equals("预定"))){
				return "<html><font color=blue>"+value+"</font></html>";
			}
            return value;
        }  
        
        /** 
         * 得到指定列的数据类型 
         */  
        @Override  
        public Class<?> getColumnClass(int columnIndex){  
        	
        	return QueryLeftNewDTO.getColumnClass(columnIndex);
        }  
        /** 
         * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑 
         */  
        @Override  
        public boolean isCellEditable(int rowIndex, int columnIndex){ 
        	if(columnIndex==table.getColumnCount()-1){
        		return true;
        	}
            return false;
        }  
        @SuppressWarnings("unused")
		public QueryLeftNewDTO getValue(int rowIndex){
        	return dataSource.get(rowIndex);
        }
        /** 
         * 如果数据单元为可编辑，则将编辑后的值替换原来的值 
         */  
        @Override  
        public void setValueAt(Object value, int rowIndex, int columnIndex){  
        	QueryLeftNewDTO.setValueAt(dataSource.get(rowIndex),columnIndex,value);
            /*通知监听器数据单元数据已经改变*/  
            fireTableCellUpdated(rowIndex, columnIndex);  
        }  
  
    }  
	List<javax.swing.RowSorter.SortKey> sortKeys=new ArrayList<javax.swing.RowSorter.SortKey>();
	public void refreshTableData(final List<QueryLeftNewDTO> dataSource){//Vector<Vector<Object>> rowData,Vector<String> colHeader
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				System.out.println("before rerrsh "+sortKeys.size());
				MyTableModel myModel=new MyTableModel(dataSource);//(MyTableModel)table.getModel();
				
				table.setModel(myModel);
				RowSorter<MyTableModel> sorter = new TableRowSorter<MyTableModel>(myModel); 
				if(sortKeys!=null){
					sorter.setSortKeys(sortKeys);
				}
				sorter.addRowSorterListener(new RowSorterListener() {
					@Override
					public void sorterChanged(RowSorterEvent e) {
						/*System.out.println("e.getSource().getSortKeys().size() :"+e.getSource().getSortKeys().size());
						for(SortKey kk : (List<SortKey>) e.getSource().getSortKeys()){
							System.out.println(kk.getColumn()+":"+kk.getSortOrder());
						}*/
						if(e.getSource().getSortKeys().size()>0){
							sortKeys.clear();
							sortKeys.add((SortKey) e.getSource().getSortKeys().get(0));
						}
						
						/*for(int i=0;i<e.getSource().getSortKeys().size();i++){
							sortKeys.add((SortKey) e.getSource().getSortKeys().get(i));
						}*/
						/*System.out.println("sortKeys.size() :"+sortKeys.size());
						for(SortKey kk : sortKeys){
							System.out.println(kk.getColumn()+":"+kk.getSortOrder());
						}*/
						
					}
				});
				
		        table.setRowSorter(sorter);
			   
		        /*DefaultTableCellRenderer fontColor = new DefaultTableCellRenderer() {   
				    private static final long serialVersionUID = 1L;
				    public Component getTableCellRendererComponent(JTable table,
			                Object value, boolean isSelected, boolean hasFocus,
			                int row, int column) {
				    	    if(dataSource.get(row).getCanWebBuy().equals("Y")){
				    	    	setForeground(Color.decode("#9DD28F"));//绿色
				    	    }else{
				    	    	setForeground(Color.lightGray);
				    	    }
			            	
			            	return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
			        }
					public void setValue(Object value) { //重写setValue方法，从而可以动态设置列单元字体颜色   
		                //double a = (value instanceof Double) ? ((Double) value).doubleValue() : 0.0; //获取月薪列中的值
		            	Font font=new Font("宋体", Font.BOLD, 20);//"宋体", Font.BOLD + Font.ITALIC, 16
		            	setFont(font);
		                setForeground(Color.black); //如果月薪大于3099元，就将字体设置为红色   
		                
		                setText(value==null?"":value.toString());   
		            }   
		        };
		        table.getColumnModel().getColumn(0).setCellRenderer(fontColor); */
		       
		        @SuppressWarnings("serial")
				DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
		            public Component getTableCellRendererComponent(JTable table,
		                Object value, boolean isSelected, boolean hasFocus,
		                int row, int column) {
		            	 
		            	 if (row % 2 == 0)
		                	setBackground(Color.white); //设置奇数行底色
		              	 else if (row % 2 == 1)
		                	setBackground(lightBlue); //设置偶数行底色
	            	 			                 
		            	Component c= super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
		            	
		            	if(column==0){
		            		Font font=new Font("宋体", Font.BOLD,18);//"宋体", Font.BOLD + Font.ITALIC, 16
		            		c.setFont(font);
		            		
		            		if(dataSource.get(row).getCanWebBuy().equals("Y")){
			            		c.setForeground(Color.blue);
		            		}else{
		            			c.setForeground(Color.black);
		            		}
		            	}else{
		            		Font font=new Font("宋体", Font.PLAIN,18);//"宋体", Font.BOLD + Font.ITALIC, 16
		            		c.setFont(font);
		            		
		            		c.setForeground(Color.black);
		            	}
		            	
		            	
		            	
		            	//会导致选中的行没有颜色
		            	/*if(dataSource.get(row).getCanWebBuy().equals("Y")){
			    	    	c.setBackground(lightBlue);
			    	    }else{
			    	    	//c.setEnabled(false);
			    	    	c.setBackground(Color.white);
			    	    }*/
		            	return c;
		            }
		          };
		          for (int i = 0; i < table.getColumnCount(); i++) {
	        		  table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		          }

		        
			    //autoSetTaleColumnWidth();
		        final int remarkIndex=table.getColumnModel().getColumnCount()-1;
		        DefaultTableCellRenderer buttonRender=new  DefaultTableCellRenderer() {
					private static final long serialVersionUID = 1L;
					JButton label=null;
					public Component getTableCellRendererComponent(JTable table, Object value,
		        			boolean isSelected, boolean hasFocus, int row, int column) {
		        		if (column!=remarkIndex){
		        			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        		} else {
		        			//预定按钮
		        			label = new JButton(""+value);
		        			label.setToolTipText(label.getText());
		        			label.setForeground(Color.white);
		        			//label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
		        			label.setPreferredSize(new Dimension(120, 30));
		        			
		        			if(!dataSource.get(row).getCanWebBuy().equals("Y")){
		        				label.setEnabled(false);
		        			}else{
		        				label.setBackground(blue);
		        			}
		        			JPanel p=new JPanel();;
		        			p.add(label);
		        			p.setToolTipText(label.getText());
		        			return p;
		        			
		        		}		
		        	}
					/*@Override
					public void setBackground(Color c) {
						if(label==null){
							super.setBackground(c);
						}else{
							label.getParent().setBackground(c);
						}
					}*/
		        };
		        DefaultCellEditor  buttonCellEditor=new DefaultCellEditor(new JTextField()){
					private static final long serialVersionUID = 1L;
						JButton label=null;    
						
		        		public Component getTableCellEditorComponent(final JTable table, Object value,
			                    boolean isSelected, int row, int column) {
			                if (column!=remarkIndex){
			                    return super.getTableCellEditorComponent(table, value, isSelected,  row, column);
			                } else {
			                	//预定按钮
			                	label = new JButton(""+value);
			                	label.setToolTipText(label.getText());
			                	label.setForeground(Color.white);
			                	
			                	// label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(),20));
			                	label.setPreferredSize(new Dimension(120, 30));
			                	if(!dataSource.get(row).getCanWebBuy().equals("Y")){
			        				label.setEnabled(false);
			        			}else{
			        				label.setBackground(blue);
			        			}
			                	
			                    label.addActionListener(new ActionListener(){
			                        public void actionPerformed(ActionEvent e) {
			                        	if(loginName==null){
			                        		JOptionPane.showMessageDialog(null, "请先登录");
			                        		//btnLogin.doClick();
			                        		return;
			                        	}
			                        	QueryLeftNewDTO dto= ((MyTableModel)table.getModel()).getDataSource().get(table.getSelectedRow());
			                        	String[] passengers=getSelectedPassengers();
			                        	if(passengers.length!=0){
			                        		//System.out.println(passengerStr);
			                        		KeyValueComboxItem result=new SelectSeatTypeFrm(dto, passengers).getResult();
				                            if(result==null){
				                            	return;
				                            }
				                            log.debug("选择的座位类型是: "+result.getValue()+","+result.getText());
				                            //买票
				                            //真他妈的fuck you啊 ，这里卡了我好多天  一个汉字 utf-8编码没有设置的问题导致406,一个过度编码，导致结果出不来
				                			String secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name;
				                			secretStr=URLDecoder.decode(dto.getSecretStr());//这里取出的是编码后的，  后面参数设置会再编码一次  ，所以这里得 先解码 ， 防止过度解码
				                			train_date=DateFormatUtil.getSplitDateStr(dto.getStart_train_date()) ;//"20150101" -> 2015-01-01
				                			back_train_date=sdf.format(new Date());//不知道行不
				                			tour_flag="dc";//单程
				                			purpose_codes="ADULT";//ADULT 成年人
				                			query_from_station_name=cbbStartStation.getText();
				                			query_to_station_name=cbbEndStation.getText();
			                        		try {
												//boolean buySucc=srv.buy(dto, secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name, passengers, result.getValue());
			                        			boolean buySucc=buyTicket(secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name, passengers, result.getValue());
												if(buySucc){
													JOptionPane.showMessageDialog(null,srv.msg,"购买成功",JOptionPane.INFORMATION_MESSAGE);
												}else{
													JOptionPane.showMessageDialog(null,srv.msg,"购买失败",JOptionPane.WARNING_MESSAGE);
												}
											} catch (My12306Exception e1) {
												JOptionPane.showMessageDialog(null,e1.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
												e1.printStackTrace();
											}

			                        	}
			                            //JOptionPane.showMessageDialog(null, dto);
			                        }               
			                    });
			                    JPanel p=new JPanel();
			        			p.add(label);
			        			p.setToolTipText(label.getText());
			        			return p;
			                }
			            }
			            @Override
			            public Object getCellEditorValue() {
				            return label.getText();
			            }
		        	};
		        table.getColumnModel().getColumn(remarkIndex).setCellRenderer(buttonRender); 
		        table.getColumnModel().getColumn(remarkIndex).setCellEditor(buttonCellEditor); 
		        buttonCellEditor.setClickCountToStart(0);
		        
		        
		        for(int i=0;i<table.getModel().getColumnCount();i++){
		    		TableColumn column=table.getColumnModel().getColumn(i);
		    		
		    		int width=getPreferredWidthForColumn(column);
		    		String name=(String) myModel.getColHeader().get(i);
		    		if(name.indexOf("{")>-1){
		    			Matcher m=Pattern.compile("width:(\\d+),*").matcher(name);
		    			if(m.find()){
		    				width=Integer.valueOf(m.group(1));
		    			}
		    		}
		            column.setPreferredWidth(width);
		    	}
			}
		});
		
	}
	/*public void refreshTableData(Object[][] rowData,Object[] colHeader){
		DefaultTableModel myModel = new DefaultTableModel(rowData,colHeader);
		table.setModel(myModel);
		autoSetTaleColumnWidth();
	}*/
	public void removeAllTrainNo(){
		if(panTrainNo.getComponents().length>0){
			panTrainNo.removeAll();
//			panTrainNo.validate();
			panTrainNo.repaint();
		}
	}
	//
	String[] seatTypes={"0:无座","1:硬座","3:硬卧","4:软卧","M:一等座","O:二等座","9:商务座","6:高级软卧","P:特等座"};//,不能乱来 自己定义的 没有就不提交    
	//无座0是我自己定义的 方便区分开
	//"0:无座","1:硬座","3:硬卧","4:软卧","M:一等座","O:二等座","9:商务座","6:高级软卧","P:特等座"
	//无座就是硬座的
	
	JPanel panCustomer=new JPanel();
	JPanel panSeatType=new JPanel();
	
	JPanel panTrainNoSet=new JPanel();
	JCheckBox ckbAuto=new JCheckBox("自动选择",true);
	JPanel panTrainNo=new JPanel();
	TextArea txtCon=new TextArea();
	
	public void initPanSetings(){

		
		/*panCustomer.add(new JCheckBox("乘客1"));
		panCustomer.add(new JCheckBox("乘客2"));
		panCustomer.add(new JCheckBox("乘客3"));*/
		
		panSeatType.setLayout(new GridLayout(5, 1));
		for(String s: seatTypes){
			String[] type=s.split(":");
			JCheckBox ckBox=new JCheckBox(type[1]);
			if(ckBox.getText().equals("硬座")){
				ckBox.setSelected(true);
			}
			ckBox.setName(type[0]);//
			
			String def="1,3,4,";
			if(def.indexOf(type[0]+",")>-1){
				ckBox.setSelected(true);
			}
			panSeatType.add(ckBox);
		}				
		
		panSetings.setLayout(new FlowLayout(0));//new GridLayout(1,4)
		
		panCustomer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue),"选择乘客"));
		panSeatType.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue),"选择座位类型"));
		
		panTrainNoSet.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue),"车次设置"));
		panTrainNoSet.add(ckbAuto);
		ckbAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ckbAuto.isSelected()){
					for(Component c :panTrainNo.getComponents()){
						JCheckBox ckbox=(JCheckBox)c;
						ckbox.setSelected(false);
					}
				}
				
			}
		});
		panTrainNo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue),"选择车次"));
		
		JPanel pan=new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(panTrainNoSet,BorderLayout.NORTH);
		pan.add(panTrainNo,BorderLayout.CENTER);
		
		panTrainNo.setLayout(new GridLayout(5, 1));
		//panCustomer.setBackground(Color.pink);
		
		panCustomer.setPreferredSize(new Dimension(200,200));//w h
		panSeatType.setPreferredSize(new Dimension(200,200));//w h
		pan.setPreferredSize(new Dimension(200,200));//w h
		txtCon.setPreferredSize(new Dimension(600,200));//w h
		
		panSetings.add(panCustomer);
		panSetings.add(panSeatType);
		panSetings.add(pan);
		panSetings.add(txtCon);
		
		logCon("超级鹰验证码识别账号注册请登录!");
		logCon("http://www.chaojiying.com");
		logCon("bug反馈");
		logCon("12306buyticket@sina.com");
		
	}
	static int logCount=0;
	public void logCon(final String msg){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if(logCount==500){
					txtCon.setText("");
					logCount=0;
				}
				logCount++;
				txtCon.append(msg+"\r\n");						
			}
		});
	}
	
	String[] selectedPassenger=null;
	//String[] selectedSeateTypeName=null;
	String[] selectedSeateType=null;
	String[] selectedTrainNo=null;
	public boolean getSettingInfo(){
		selectedPassenger=getSelectedPassengers();
		selectedSeateType=getSelectedSeatType();
		selectedTrainNo=getSelectedTrainNo();
		if(selectedPassenger.length==0||selectedSeateType.length==0||selectedTrainNo.length==0){
			//JOptionPane.showMessageDialog(MainFrm.this,"请选好乘客，座位，车次信息");
			return false;
		}
		return true;
	}
	
	public String[] getSelectedPassengers(){
		List<String> selectedPassenger=new ArrayList<>();
		for(Component c :panCustomer.getComponents()){
			JCheckBox ckbox=(JCheckBox)c;
			if(ckbox.isSelected()){
				selectedPassenger.add(ckbox.getText());
				//selectedPassenger+=ckbox.getText()+",";
			}
		}		
		return selectedPassenger.toArray(new String[]{});
	}
	public String[] getSelectedSeatType(){
		List<String> selectedSeateType=new ArrayList<>();
		for(Component c :panSeatType.getComponents()){
			JCheckBox ckbox=(JCheckBox)c;
			if(ckbox.isSelected()){
				selectedSeateType.add(ckbox.getName());
				//selectedSeateType+=ckbox.getName()+",";//这里取编码
				//selectedSeateTypeName+=ckbox.getText()+",";//这里取文本
			}
		}	
		return selectedSeateType.toArray(new String[]{});
	}
	public String[] getSelectedTrainNo(){
		List<String> selectedTrainNo=new ArrayList<>();
		for(Component c :panTrainNo.getComponents()){
			JCheckBox ckbox=(JCheckBox)c;
			if(ckbox.isSelected()){
				selectedTrainNo.add(ckbox.getText());
				//selectedTrainNo+=ckbox.getText()+",";
			}
		}
		return  selectedTrainNo.toArray(new String[]{});
	}
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	public boolean buyTicket(String secretStr,String train_date,String back_train_date,String tour_flag,String purpose_codes,String query_from_station_name,String query_to_station_name,String[] passagers,String seatType)
	throws My12306Exception{
		HttpService12306.SubmitTokenInfo ret=srv.getGlobalRepeatSubmitToken( secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name);
		String globalRepeatSubmitToken=ret.globalRepeatSubmitToken;
		

		if(globalRepeatSubmitToken==null){
			logCon("initDc 失败   没有 globalRepeatSubmitToken ");
			return false;
		}
		//购票验证码效验
		String randCode=null;
		while(true){
			HashMap<String,String> params=new HashMap<String,String>();
			randCode = picDialog.getBuyRandCode();
			if(randCode==null){
				logCon("停止自动刷票");
				return false;
			}
			boolean checkSucc;
			
			checkSucc = srv.checkBuyRandCode(randCode,globalRepeatSubmitToken);
			
			if(checkSucc){
				picDialog.close();
				picDialog.isPass();
				break;
			}else{
				picDialog.isNotPass();
				logCon("验证码失败:"+randCode);
			}
			
		}

		boolean buySucc = srv.buy(randCode,ret.globalRepeatSubmitToken,ret.ticketInfoForPassengerForm,ret.orderRequestDTO,secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name,passagers,seatType);
		return buySucc;
		
	}
	public boolean buyTicketOnce() throws InterruptedException{
		
		//logCon("车次"+selectedTrainNo);
		//logCon("乘客:"+selectedPassenger);
		//logCon("座位:"+selectedSeateTypeName)
		boolean b=false;
		String[] trainCodes= null;
		
		if(ckbAuto.isSelected()){
			List<QueryLeftNewDTO> dataSource=((MyTableModel)table.getModel()).getDataSource();
			//没查询到票
			if(dataSource.size()==0){
				btnQuery_onclick();
				if(((MyTableModel)table.getModel()).getDataSource().size()==0){
					logCon("没查询到车次信息 ...");
					return false;
				}else{
					dataSource=((MyTableModel)table.getModel()).getDataSource();
				}
			}
			Map<String,String> reason=new HashMap<String,String>();
			StringBuffer sb=new StringBuffer("");
			for(QueryLeftNewDTO dto : dataSource){
				if("Y".equals(dto.getCanWebBuy())){
					if(dto.getHasTiketSeatTypes(getSelectedSeatType()).size()>0){ // hasTicket(dto)
						//有yz票
						sb.append(dto.getStation_train_code()+",");
					}else{
						reason.put("只剩无座", "只剩无座");
					}
				}else if("N".equals(dto.getCanWebBuy())){
					reason.put("无票", "无票");
				}else{
					reason.put(dto.getCanWebBuy(), dto.getButtonTextInfo());
				}
			}
			//没有能买的票
			if(sb.toString().equals("")){
				/*btnQuery_onclick();
				return beginBuyTicket();*/
				logCon(""+reason.values());
				
				btnQuery.doClick();
				
				return false;
			}
			
			trainCodes=sb.toString().split(",");
			logCon("自动选择有票的车次:"+sb.toString());
		}else{
			trainCodes=selectedTrainNo;//.split(",");
		}
		
		
		 /* Collections.sort(dataSource, new Comparator<QueryLeftNewDTO>() {
	            public int compare(QueryLeftNewDTO arg0, QueryLeftNewDTO arg1) {
	            	String[] temp0=arg0.getLishi().split(":");
	            	int i0=Integer.valueOf(temp0[0])*60+Integer.valueOf(temp0[1]);
	            	String[] temp1=arg0.getLishi().split(":");
	            	int i1=Integer.valueOf(temp1[0])*60+Integer.valueOf(temp1[1]);
	            	if("Y".equals(arg0.getCanWebBuy())){
	            		if("Y".equals(arg1)){
	            			// y =y 接下来看数量
	            			
	            		}else{
	            			
	            		}
	            	}else{
	            		
	            	}
	                return i1-i0;//倒叙  时间最短的  放前面
	            }
	        });*/
		String[] selectedPassegers = selectedPassenger;//getSelectedPassengers();
		String[] selecteTypes=selectedSeateType;//.split(",");
		for(int i=0;i<trainCodes.length;i++){
			
			//logCon(" "+trainCodes[i]+"...开始刷票频率1.5-4s ");			
			//买票
			QueryLeftNewDTO dto=((MyTableModel)table.getModel()).getByTrainCode(trainCodes[i]);
			List<String> hasTiketSeatType=dto.getHasTiketSeatTypes(selecteTypes);
			
			if(hasTiketSeatType.size()==0){
				//logCon(dto.getStation_train_code()+" 没你想要的票 : "+Arrays.toString(dto.convertSeatTypeCode2Name(selecteTypes)));
				continue;
			}
			
			//真他妈的fuck you啊 ，这里卡了我好多天  一个汉字 utf-8编码没有设置的问题导致406,一个过度编码，导致结果出不来
			String secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name;
			secretStr=URLDecoder.decode(dto.getSecretStr());//这里取出的是编码后的，  后面参数设置会再编码一次  ，所以这里得 先解码 ， 防止过度解码
			train_date=DateFormatUtil.getSplitDateStr(dto.getStart_train_date()) ;//"20150101" -> 2015-01-01
			back_train_date=sdf.format(new Date());//不知道行不
			tour_flag="dc";//单程
			purpose_codes="ADULT";//ADULT 成年人
			query_from_station_name=cbbStartStation.getText();
			query_to_station_name=cbbEndStation.getText();
			
			try {
				if(!isBegin){
					return false;
				}
				for(int j=0;j<hasTiketSeatType.size();j++){
					String seatType=hasTiketSeatType.get(j).split(":")[0];
					int tryCount=0;
					while(!b && ++tryCount <= 3){
						logCon("第"+tryCount+" 次 "+dto.getStation_train_code()+" "+QueryLeftNewDTO.convertSeatTypeCode2Name(seatType)+"...");
						
						b=buyTicket( secretStr, train_date, back_train_date, tour_flag, purpose_codes, query_from_station_name, query_to_station_name, selectedPassegers, seatType);
						
						if(!b && "停止自动刷票".equals(srv.msg)){
							toggleStartStop();
							logCon("停止自动刷票");
							return false;
						}
					}
				}
				
			} catch (My12306Exception e) {
				e.printStackTrace();
				if(e.getMessage().indexOf("您还有未处理的订单")>-1 || e.getMessage().indexOf("用户未登录")>-1 || e.getMessage().indexOf("由于您取消次数过多")>-1){//对不起，由于您取消次数过多，今日将不能继续受理您的订票请求。8月15日您可继续使用订票功能
					toggleStartStop();
					logCon(e.getMessage());
					JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
					return false;
				}
				//JOptionPane.showMessageDialog(this,e.getMessage(),"12306异常",JOptionPane.ERROR_MESSAGE);
				logCon(e.getMessage());
				//车票信息已过期，请重新查询最新车票信息
				if(e.getMessage().indexOf("车票信息已过期")>-1){
					//btnQuery_onclick();
					return false;
				}
				
				
			} 
			
			if(b){
				toggleStartStop();
				JOptionPane.showMessageDialog(MainFrm.this, "购票成功!:"+srv.msg);
				logCon("购票成功!:"+srv.msg);
				return true;
			}
			
		}
		return false;
		
	}
	/*private boolean hasTicket(QueryLeftNewDTO dto) {
		return "Y".equals(dto.getCanWebBuy()) &&
				 (!dto.getYz_num().equals("无") && !dto.getYz_num().equals("--"))
				 ||(!dto.getYw_num().equals("无") && !dto.getYw_num().equals("--"))
				 ||(!dto.getRw_num().equals("无") && !dto.getRw_num().equals("--"));
	}*/
	boolean isBegin = true;
	public void toggleStartStop(){
		if(btnBegin.getText().equals("开刷(B)")){
			//开刷
			btnBegin.setText("停止(B)");
			logCon("启动 ...");
			if(!buyThread.isAlive()){
				buyThread.start();
				txtCon.setText("");
			}
			isBegin=true;
		}else{
			//停止
			btnBegin.setText("开刷(B)");
			isBegin=false;
			//buyThread.stop();
		}
		
		
	}
	public String encodeStationName(String stationName,String stationCode){
		//String strInput=strInput;//new String("深圳");//深圳,SZQ
		StringBuffer output=new StringBuffer();
		//System.out.println("\""+stationName+ "\" 的utf8编码：");
        for (int i = 0; i < stationName.length(); i++){
        	String temp=Integer.toString(stationName.charAt(i), 16)+"";
            output.append("%u" +temp.toUpperCase());
        } 
        //String result=output.toString().replaceAll("\\\\","%").toUpperCase();
        //System.out.println(output);//+URLEncoder.encode(",SZQ")
		return output.toString()+"%2C"+stationCode;
	}
	public static void main(String[] args) {
		
		log.info("Main Frm start....");
		HttpService12306 srv=new HttpService12306();
		if(Cfg.get("https.proxySet")!=null && !Cfg.get("https.proxySet").trim().equals("") && Cfg.get("https.proxySet").trim().equals("true")){
			//这样设置httpConnect的代理，还要设置httpClient的代理
			System.setProperty("https.proxyPort", Cfg.get("https.proxyPort"));
			System.setProperty("https.proxyHost", Cfg.get("https.proxyHost"));
			System.setProperty("https.proxySet", Cfg.get("https.proxySet"));
			log.info("设置http代理:"+Cfg.get("https.proxyHost")+":"+Cfg.get("https.proxyPort"));
			
			srv.setProxy(Cfg.get("https.proxyHost"),Integer.valueOf(Cfg.get("https.proxyPort")), Cfg.get("https.proxyUserName"), Cfg.get("https.proxyPwd"));

		}
		
		try {
			//new com.sun.java.swing.plaf.windows.WindowsLookAndFeel();
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			InitGlobalFont(new Font("宋体", Font.PLAIN, 15));//new Font("宋体", Font.PLAIN, 15)
			log.info("Main Frm InitGlobalFont....");
			@SuppressWarnings("unused")
			MainFrm f=new MainFrm(srv);
			
			log.info("Main Frm new....");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Main Frm Exception..."+e.getMessage());
			//还是得退出否则麻烦
			System.exit(0);
		} 
		
		
	}
}
