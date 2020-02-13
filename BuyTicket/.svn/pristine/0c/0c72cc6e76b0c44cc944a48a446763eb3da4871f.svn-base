package com.buyticket.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.ColorUIResource;

import org.apache.commons.io.FileUtils;

import com.buyticket.core.JSEngineUtil;
import com.buyticket.dto.ResultData;

@SuppressWarnings("serial")
public class FilterComboBox extends JPanel {
	private JFrame owner;
	
	private JTextField textField=new JTextField(10);
	private String value=null;
	private JPanel panQuicklySelect=new JPanel();
	private JPanel panReMen=new JPanel();
	private JPanel panAE=new JPanel();
	private JPanel panFJ=new JPanel();
	private JPanel panKO=new JPanel();
	private JPanel panPT=new JPanel();
	private JPanel panUZ=new JPanel();
	
	private JPanel panDownDrop=new JPanel();
	private String[] stations;
	
	public String getText() {
		return textField.getText();
	}
	public String getValue() {
		return value;
	}
	private String[] getCityDataByAttribute(String nameOrCode,String leftSplite,String rightSplite){
		String str=leftSplite+nameOrCode+rightSplite;
		int index=stations[1].indexOf(str);
		if(index>-1){
			//@开始index
			int startIndex=stations[1].lastIndexOf("@",index);
			//@结束 index
			int endIndex=stations[1].indexOf("@",index);

			String[] data=stations[1].substring(startIndex-1, endIndex).split("\\|");
			//bjb|北京北|VAP|beijingbei|bjb|
			return data;
		}
		return null;
	}
	public void setValue(String cityCode) {
		String[] data =getCityDataByAttribute(cityCode,"|","|");
		if(data!=null){
			this.value = data[2];
			this.textField.setText(data[1]);
		}
		return;
	}
	public void setText(String cityName) {
		String[] data =getCityDataByAttribute(cityName,"|","|");
		if(data!=null){
			this.value = data[2];
			this.textField.setText(data[1]);
		}
		return;
	}
	public String[] getStations() {
		return stations;
	}

	public void setStations(String[] stations) {
		this.stations = stations;
	}
	public FilterComboBox(JFrame owner,String[] stations){
		this.owner=owner;
		this.stations=stations;
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				/*if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}*/
				showPanDownDrop(((JTextField)e.getSource()).getText());
				//panQuicklySelect.add(new JLabel());
				//System.out.println(arg0.getKeyChar());
			}
		
		});
		textField.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				showPanQuicklySelect();
			}
		});
		
		this.add(textField);
		((JFrame)this.owner).getLayeredPane().setLayout(new BorderLayout());
		initPanQuicklySelect();
		//initPanDownDrop();
	}
	javax.swing.JDialog quickDialog =null, downDropDialog =null;
//	int quickSelectWidth=375, quickSelectHeight=255;
	int quickSelectWidth=100, quickSelectHeight=100;
	int downDropSelectWidth=115, downDropSelect=195;
	public void showPanQuicklySelect(){
		//showPanDialog(quickDialog,textField, quickSelectWidth, quickSelectHeight, panQuicklySelect);
		showPan(textField, quickSelectWidth, quickSelectHeight, panQuicklySelect);
	}
	
	public void showPanDownDrop(String filter) {
		/*if(quickDialog!=null)
			quickDialog.setVisible(false);
		
		refreshDownDropData(filter);
		if(downDropDialog==null || !downDropDialog.isVisible()){
			showPanDialog(downDropDialog,textField, downDropSelectWidth, downDropSelect, panDownDrop);
		}
		textField.setFocusable(true);*/
		showPan(textField, downDropSelectWidth, downDropSelect, panDownDrop);
	}
	
	private void reSetDialogPosition(JDialog quickDialog,JTextField textField,Integer width,Integer height){
		//int width=375, height=255;
		java.awt.Rectangle r = textField.getBounds();
        Point pOnScreen = textField.getLocationOnScreen();

        Point result = new Point(pOnScreen.x, pOnScreen.y + r.height);
        Point powner = owner.getLocation();
        int offsetX = (pOnScreen.x + width) - (powner.x + owner.getWidth());
        int offsetY = (pOnScreen.y + r.height + height) -
            (powner.y + owner.getHeight());

        if (offsetX > 0) {
            result.x -= offsetX;
        }

        if (offsetY > 0) {
            result.y -= height + r.height;
        }
        quickDialog.setLocation(result);
	}
	public void showPanDialog(JDialog quickDialog,JTextField textField,Integer width,Integer height,JPanel pan) {
		if(quickDialog==null){
			quickDialog = new javax.swing.JDialog();
			//dialog init
			reSetDialogPosition(quickDialog,textField,width, height);
	        quickDialog.setModal(false);
	        quickDialog.setUndecorated(true);
	        quickDialog.setSize(quickSelectWidth, quickSelectHeight);
	        quickDialog.addWindowListener(new WindowAdapter() {
	            //在任意的非日期选择区单击，则日期选择组件将变为非活动状态，自动释放资源。
	            public void windowDeactivated(WindowEvent e) {
	                javax.swing.JDialog f = (javax.swing.JDialog) e.getSource();
	                f.setVisible(false);
				                f.dispose();
	            }
	        });
	        quickDialog.getContentPane().setLayout(new BorderLayout());
	        quickDialog.getContentPane().add(pan);
	        quickDialog.setVisible(true);
		}else{
			reSetDialogPosition(quickDialog,textField, quickSelectWidth, quickSelectHeight);
			quickDialog.setVisible(true);
		}
		
    }
	public void showPan(JTextField textField,Integer panWidth,Integer panHeight,JPanel pan) {
		
		reSetPanlPosition(pan,textField, panWidth,panHeight);
		pan.setVisible(true);
    }
	private void reSetPanlPosition(JPanel pan,JTextField textField,Integer width,Integer height){
		//int width=375, height=255;
		java.awt.Rectangle r = textField.getBounds();
        Point pOnScreen = textField.getLocation(); //getLocationOnScreen();

        Point result = new Point(pOnScreen.x, pOnScreen.y + r.height);
        //Point powner = owner.getLocation();
        int offsetX = pOnScreen.x + width;
        int offsetY = pOnScreen.y + r.height + height ;

        if (offsetX > 0) {
            result.x -= offsetX;
        }

        if (offsetY > 0) {
            result.y -= height + r.height;
        }
        pan.setBounds(textField.getX(), textField.getY(), quickSelectWidth, quickSelectHeight);
//        pan.setLocation(textField.getX(), textField.getY());
       //pan.setLocation(result);
	}
	
	public void initPanQuicklySelect(){
		((JFrame)this.owner).getLayeredPane().add(panQuicklySelect);
		panQuicklySelect.setVisible(false);
		
		 
		JPanel panTitle=new JPanel();
		panTitle.setLayout(new BorderLayout());
		
		panTitle.setBackground(ColorUtil.String2Color("#EEF1F8"));//
		
		//panTitle.setBackground(Color.red);
		int hgvp=0,vgap=0;
		final JPanel panColumn=new JPanel();
		panColumn.setBackground(ColorUtil.String2Color("#298CCE"));
		panColumn.setLayout(new GridLayout(1,6,hgvp,vgap));
		panColumn.setSize(quickSelectWidth,30);
		panTitle.setSize(quickSelectWidth, 50);
		panTitle.add(panColumn,BorderLayout.SOUTH);
		
		final JPanel panBody=new JPanel();
		final CardLayout cardLayout= new CardLayout();
		panBody.setLayout(cardLayout);
		
		panReMen.setLayout(new GridLayout(7,5,hgvp,vgap));
		panAE.setLayout(new GridLayout(7,5,hgvp,vgap));
		panFJ.setLayout(new GridLayout(7,5,hgvp,vgap));
		panKO.setLayout(new GridLayout(7,5,hgvp,vgap));
		panPT.setLayout(new GridLayout(7,5,hgvp,vgap));
		panUZ.setLayout(new GridLayout(7,5,hgvp,vgap));
		
		panBody.add("panReMen",panReMen);
		panBody.add("panAE",panAE);
		panBody.add("panFJ",panFJ);
		panBody.add("panKO",panKO);
		panBody.add("panPT",panPT);
		panBody.add("panUZ",panUZ);
		cardLayout.show(panBody, "panReMen");
		panQuicklySelect.setLayout(new BorderLayout());//new GridLayout(3, 1)
		panQuicklySelect.setBorder(BorderFactory.createLineBorder(ColorUtil.String2Color("#298CCE"),1));//new TitledBorder(new EtchedBorder(), "退出")
		panQuicklySelect.add(panTitle,BorderLayout.NORTH);
		panQuicklySelect.add(panBody,BorderLayout.CENTER);
		
//		panTitle.setLayout(new FlowLayout());
		JLabel lblTitle=new JLabel("拼音支持首字母输入");
		//lblTitle.setOpaque(false);//opaque是不透明的意思，我擦
		panTitle.add(lblTitle,BorderLayout.WEST);
		final JLabel lblClose=new JLabel(new ImageIcon("img/close_show_citys.jpg"));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quickDialog.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent mouseevent) {
				JLabel lbl=((JLabel)mouseevent.getSource());
				//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
				//lbl.setForeground(Color.red);
				lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent mouseevent) {
				JLabel lbl=((JLabel)mouseevent.getSource());
				//lbl.setText(lbl.getToolTipText());
				//lbl.setForeground(Color.black);
				lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
		});
		panTitle.add(lblClose,BorderLayout.EAST);
		
		String[] jLabel=new String[]{"热门","A-E","F-J","K-O","P-T","U-Z"};
		String[] panName=new String[]{"panReMen","panAE","panFJ","panKO","panPT","panUZ"};
		for(int i=0;i<jLabel.length;i++){
			String labText =jLabel[i];
			String labName =panName[i];
			JLabel lblCurrent=new JLabel(labText,JLabel.CENTER);//"<html><u>"+labText+"</u></html>"
			lblCurrent.setName(labName);
			lblCurrent.setOpaque(true);
			lblCurrent.setForeground(Color.white);
			
			lblCurrent.setBackground(i==0?ColorUtil.String2Color("#66C8E8"):ColorUtil.String2Color("#298CCE"));//
			lblCurrent.setFont(new Font("宋体",Font.BOLD,17));
			
			lblCurrent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for(Component c :panColumn.getComponents()){
						JLabel lab=(JLabel)c;
						lab.setBackground(null);						
					}
					JLabel lbl=((JLabel)e.getSource());
					lbl.setBackground(ColorUtil.String2Color("#66C8E8"));//
					System.out.println(panAE.getSize().toString());
					cardLayout.show(panBody, lbl.getName());
					showPanQuicklySelect();
					System.out.println("width height : "+panBody.getSize().width+":"+panBody.getSize().height);
					
				}
				
				@Override
				public void mouseEntered(MouseEvent mouseevent) {
					/*JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
					//lbl.setForeground(Color.red);
					lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					mouseClicked(mouseevent);*/
				}
				@Override
				public void mouseExited(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText(lbl.getToolTipText());
					//lbl.setForeground(Color.black);
					lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				
			});
			
			panColumn.add(lblCurrent);
		}
		
		
		String[] temp=stations[0].split("@");//第一个是空的
		for(String s : temp){
			if("".equals(s)||s.trim().equals("")){
				continue;
			}
			String[] datas=s.split("\\|");
			JLabel lab=new JLabel(datas[1],JLabel.CENTER);//中文名
			lab.setName(datas[2]);//code
			lab.setToolTipText(lab.getText());//datas[0]拼音首字母
			lab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel lab= ((JLabel)e.getSource());
					FilterComboBox.this.textField.setText(lab.getText());
					FilterComboBox.this.value=lab.getName();
					quickDialog.setVisible(false);
				}
				
			
				@Override
				public void mouseEntered(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
					//lbl.setForeground(Color.red);
					lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText(lbl.getToolTipText());
					//lbl.setForeground(Color.black);
					lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
					
				
			});
			panReMen.add(lab);			
		}
		
		List<JLabel> aeList=new ArrayList<JLabel>(),fjList=new ArrayList<JLabel>(),koList=new ArrayList<JLabel>(),ptList=new ArrayList<JLabel>(),uzList=new ArrayList<JLabel>();
		
		String[] temp2=stations[1].split("@");
		for(String s : temp2){
			if("".equals(s)||s.trim().equals("")){
				continue;
			}
			String[] datas=s.split("\\|");
			JLabel lab=new JLabel(datas[1],JLabel.CENTER);//中文名
			lab.setName(datas[2]);//code
			lab.setToolTipText(lab.getText());
			String firstPingYin=datas[0];//拼音首字母
			lab.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JLabel lab= ((JLabel)e.getSource());
					FilterComboBox.this.textField.setText(lab.getText());
					FilterComboBox.this.value=lab.getName();
					quickDialog.setVisible(false);
				}
				
				@Override
				public void mouseEntered(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
					//lbl.setForeground(Color.red);
					lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText(lbl.getToolTipText());
					//lbl.setForeground(Color.black);
					lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				
				
			});
			Character firstChar=firstPingYin.toUpperCase().charAt(0);
			if('A'<=firstChar && firstChar<='E'){
				aeList.add(lab);
				//panAE.add(lab);
			}else if('F'<=firstChar && firstChar<='J'){
				fjList.add(lab);
				//panFJ.add(lab);	
			}else if('K'<=firstChar && firstChar<='O'){
				koList.add(lab);
				//panKO.add(lab);	
			}else if('P'<=firstChar && firstChar<='T'){
				ptList.add(lab);	
				//panPT.add(lab);	
			}else if('U'<=firstChar && firstChar<='Z'){
				uzList.add(lab);
				//panUZ.add(lab);	
			}
		}
		
		processPage(panAE,aeList);
		processPage(panFJ,fjList);
		processPage(panKO,koList);
		processPage(panPT,ptList);
		processPage(panUZ,uzList);
		
	}
	public void processPage(final JPanel pan,List<JLabel> labList){
		
		int pageCount=labList.size()/30+(labList.size()% 30>0?1:0);
		
		System.out.println("pageCount:"+pageCount+" JLabelCount:"+labList.size());
		final CardLayout cardLayout=new CardLayout();
		pan.setLayout(cardLayout);
		int labIndex=0;
		for(int i=0;i<pageCount;i++){
			int pageNo=i+1;
			JLabel lblPre=new JLabel("《上一页");
			lblPre.setToolTipText(lblPre.getText());
			lblPre.setName("page"+(pageNo-1));
			if(i!=0){
				lblPre.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						//lbl.setText("<u>"+lbl.getToolTipText()+"</u>");
						lbl.setForeground(Color.red);
						//lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						lbl.setText(lbl.getToolTipText());
						lbl.setForeground(Color.black);
						lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mouseClicked(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						cardLayout.show(pan, lbl.getName());
						System.out.println("show:"+lbl.getName());
					}
				});
			}
			JLabel lblNext=new JLabel("下一页》");
			lblNext.setToolTipText(lblNext.getText());
			lblNext.setName("page"+(pageNo+1));
			if(i!=pageCount-1){
				lblNext.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
						lbl.setForeground(Color.red);
						lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						lbl.setText(lbl.getToolTipText());
						lbl.setForeground(Color.black);
						lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
					@Override
					public void mouseClicked(MouseEvent mouseevent) {
						JLabel lbl=((JLabel)mouseevent.getSource());
						cardLayout.show(pan, lbl.getName());
						System.out.println("show:"+lbl.getName());
					}
				});
			}
			JPanel panPageed=new JPanel();
			panPageed.setName("page"+pageNo);
			//System.out.println(panPageed.getName());
			panPageed.setLayout(new GridLayout(7,5));
			
			for(;labIndex<labList.size();labIndex++){
				//Component lab=pan.getComponents()[j];
				panPageed.add(labList.get(labIndex));//每次添加完成会从原容器减掉一个
				System.out.println("page"+(i+1)+" add Label "+(labIndex+1));
				if((labIndex+1)%30==0 ){
					labIndex++;
					break;//break会导致j来不及加j++ 整除循环完结束则不会
				}
			}
			if(pageCount>1){//添加分页部分
				int fillCount=1,notFillCount=0;
				if(pageNo==pageCount){
					notFillCount =30-panPageed.getComponents().length;
				}
				for(;fillCount<=notFillCount+5;fillCount++){
					if(fillCount==notFillCount+3){
						JLabel lblPageInfo=new JLabel(pageNo+"/"+pageCount);
						panPageed.add(lblPageInfo);
					}else if(fillCount==notFillCount+4){
						panPageed.add(lblPre);
					}else if(fillCount==notFillCount+5){
						panPageed.add(lblNext);
					}else{
						panPageed.add(new JPanel());
					}
				}
			}
			pan.add(panPageed.getName(),panPageed);//cardlayout添加要起名字 方便显示		
			System.out.println("new Page"+pageNo);
		}
		cardLayout.show(pan, "page1");
		
		
	}
	
	String des="简拼/全拼/汉字或↑↓";
	String strPrefix="按\"";
	String strSuffix="\"检索:";
	JPanel panDownDropTitle=new JPanel();		
	JPanel panDownDropBody=new JPanel();
	JPanel panDownDropPage=new JPanel();
	JLabel lblDownDropText=new JLabel();
	//init downDropPanel
	public void initPanDownDrop(){
		((JFrame)this.owner).getRootPane().getLayeredPane().add(panDownDrop);
//		showPanDownDrop
		panDownDrop.setBorder(BorderFactory.createLineBorder(ColorUtil.String2Color("#298CCE"),1));//new TitledBorder(new EtchedBorder(), "退出")
		panDownDrop.setLayout(new BorderLayout());
		panDownDrop.add(panDownDropTitle,BorderLayout.NORTH);
		panDownDrop.add(panDownDropBody,BorderLayout.CENTER);
		panDownDrop.add(panDownDropPage,BorderLayout.SOUTH);
		
		lblDownDropText.setText(des);
		//BorderFactory.createEmptyBorder(30, 30, 10, 30)
		panDownDropTitle.setBorder(BorderFactory.createDashedBorder(new ColorUIResource(ColorUtil.String2Color("#298CCE"))));//new TitledBorder(new EtchedBorder(), "退出")
		panDownDropTitle.add(lblDownDropText);
		panDownDropTitle.setBackground(Color.white);
		panDownDropBody.setBackground(Color.white);
		panDownDropPage.setBackground(Color.white);
		//6个
//		@bjb|北京北|VAP|beijingbei|bjb|0
		
		panDownDropBody.setLayout(new GridLayout(pageSize,1));
		for(int i=0;i<pageSize;i++){
			JLabel lbl=new JLabel("");
			lbl.setBackground(Color.white);
			lbl.setOpaque(true);//不透明
			lbl.setForeground(ColorUtil.String2Color("#0055AA"));
			lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					if(!lbl.getText().equals("")){
						for(Component c :panDownDropBody.getComponents()){
							c.setBackground(Color.white);
						}
						lbl.setBackground(ColorUtil.String2Color("#C8E3FC"));
					}
				}
				@Override
				public void mouseExited(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					/*for(Component c :panDownDropBody.getComponents()){
						c.setBackground(Color.white);
					}*/
					if(!lbl.getText().equals("")){
						lbl.setBackground(Color.white);
					}
				}
				@Override
				public void mouseClicked(MouseEvent mouseevent) {
					JLabel lbl=((JLabel)mouseevent.getSource());
					if(!lbl.getText().equals("")){
						textField.setText(lbl.getText());
						FilterComboBox.this.value=lbl.getName();
						downDropDialog.setVisible(false);
					}
				}
			});
			
			/*lbl.addKeyListener(new KeyAdapter() {
				
			});*/
			panDownDropBody.add(lbl);
		}
		
		JLabel lblPre=new JLabel("《向前");
		JLabel lblNext=new JLabel("向后》");
		lblPre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseevent) {
				prePage();
			}
			@Override
			public void mouseEntered(MouseEvent mouseevent) {
				if(FilterComboBox.this.currentPageNo!=1){
					JLabel lbl=((JLabel)mouseevent.getSource());
					//lbl.setText("<html><u>"+lbl.getToolTipText()+"</u></html>");
					lbl.setForeground(Color.red);
					lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				
			}
			@Override
			public void mouseExited(MouseEvent mouseevent) {
				if(FilterComboBox.this.currentPageNo!=1){
					JLabel lbl=((JLabel)mouseevent.getSource());
					lbl.setText(lbl.getToolTipText());
					lbl.setForeground(Color.black);
					lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseevent) {
				nextPage();
			}
			@Override
			public void mouseEntered(MouseEvent mouseevent) {
				if(FilterComboBox.this.currentPageNo!=getPageCount()){
					JLabel lbl=((JLabel)mouseevent.getSource());
					lbl.setForeground(Color.red);
					lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent mouseevent) {
				if(FilterComboBox.this.currentPageNo!=getPageCount()){
					JLabel lbl=((JLabel)mouseevent.getSource());
					lbl.setForeground(Color.black);
					lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		panDownDropPage.setLayout(new BorderLayout());
		panDownDropPage.add(lblPre,BorderLayout.WEST);
		panDownDropPage.add(lblNext,BorderLayout.EAST);
	}
	
	public void refreshDownDropData(String filter){
		List<String[]> pageList=filterData(filter);
		for(int i=0;i<pageSize;i++){
			JLabel lbl=(JLabel) panDownDropBody.getComponent(i);
			if(i>pageList.size()-1){
				lbl.setName(null);
				lbl.setText(null);
			}else{
				String[] data =pageList.get(i);
				//bjb|北京北|VAP|beijingbei|bjb|0
				lbl.setName(data[2]);
				lbl.setText(data[1]);
			}
		} 		
	}
	public int getPageCount(){
		return dataList.size()/pageSize+(dataList.size()%pageSize>0?1:0);
	}
	public void prePage(){
		pageMethod("pre");
	}
	public void nextPage(){
		pageMethod("next");
	}
	public void pageMethod(String method){
		if(method.equals("pre")){
			if(this.currentPageNo==1){
				return ;
			}
			currentPageNo--;
		}else{
			if(this.currentPageNo==getPageCount()){
				return ;
			}
			currentPageNo++;
		}
		refreshDownDropData(this.oldFilter);
		
	}
	
	List<String[]> dataList=new ArrayList<String[]>();
	//String currentPageStr=null;
	Integer currentPageNo=1;
	int pageSize=6;
	String oldFilter=null;
	public List<String[]> filterData(String filter){
		List<String[]> pageList=new ArrayList<String[]>();
		
		if(filter.equals(oldFilter)){//翻页
			for(int rowindex=(currentPageNo-1)*pageSize ;rowindex<dataList.size();rowindex++){
				pageList.add(dataList.get(rowindex));
				if(pageList.size()==6){
					return pageList;
				}
			}
		}
		
		boolean needFilterAll=oldFilter==null||!filter.startsWith(oldFilter);
		if(needFilterAll){
			dataList.clear();
		}
		oldFilter=filter;
		
				
		/*if(currentPageStr==null || filter==null || filter.equals("")){
			currentPageStr=stations[1];
		}*/
		/*int startFromIndex=currentPageStr.indexOf("|"+(currentPageNo-1)*pageSize+"@");//以当前页面第一条的位置
		int startIndex=currentPageStr.lastIndexOf("@",startFromIndex);//当前页第一条记录开始处@
		
		int endFromIndex=currentPageStr.indexOf("|"+currentPageNo * pageSize+"@");//以当前页面第一条的位置
		int endIndex=currentPageStr.lastIndexOf("@",endFromIndex);//当前页第一条记录开始处@
		
		currentPageStr =currentPageStr.substring(startIndex+1,endIndex);*/
		if(needFilterAll){
			String[] temp=stations[1].split("@");
			for(String dataStr : temp){
				if(!dataStr.equals("")){
					String[] dt=dataStr.split("\\|");
					//bjb|北京北|VAP|beijingbei|bjb|0
					if(filter==null || dt[3].startsWith(filter)||dt[4].startsWith(filter)){
						dataList.add(dt);
						if(pageList.size()<pageSize){
							pageList.add(dt);
						}
					}
					
				}
			}
		}else{
			for(int i=dataList.size()-1;i>=0;i--){
				String[] data=dataList.get(i);
				//bjb|北京北|VAP|beijingbei|bjb|0
				if(!data[3].startsWith(filter) && !data[4].startsWith(filter)){
					dataList.remove(i);
				}
			}
			for(int i=0;i<pageSize;i++){
				pageList.add(dataList.get(i));
			}
		}
		if(pageList.size()==0){
			this.currentPageNo=1;
			return null;
		}/*else{
			if(dataList.get(0).equals(""))
				dataList.remove(0);
		}*/		
		return pageList;
	}
	
	public List<String[]> getDownDropDataByPage(int pageNo){
		
		int maxCount=pageNo*pageNo;
		
		//pageNo
		for(int i=0;i<6;i++){
			String[] data=getCityDataByAttribute(i+"","|","@");
			//dataList.add();
//			@bjb|北京北|VAP|beijingbei|bjb|0
			
		}
		return null;
	}
	
	
	public static void main(String[] args) throws IOException, ScriptException {
		MainFrm.main(args);
		/*String content=JSEngineUtil.getStationName("temp/station_name_text.javascript");
		FilterComboBox combox=new FilterComboBox(null,new String[]{"@bjb|北京北|VAP|beijingbei|bjb|0",content});
		List<String[]> lst=combox.filterData("s");
		for(String[] data :lst){
			//@bjb|北京北|VAP|beijingbei|bjb|0
			System.out.println(data[0]+":"+data[1]+":"+data[2]+":"+data[3]+"："+data[4]);
		}
		System.out.println("========sz====");
		lst=combox.filterData("sz");
		for(String[] data :lst){
			//@bjb|北京北|VAP|beijingbei|bjb|0
			System.out.println(data[0]+":"+data[1]+":"+data[2]+":"+data[3]+"："+data[4]);
		}*/
	}
	
}
class StationEntity{
	String firstPingYin;
	String chineseName;
	String code;
	String fullPinYin;
	String firstPinYin2;
	int index;
	public StationEntity(){
		
	}
	public String getFirstPingYin() {
		return firstPingYin;
	}
	public void setFirstPingYin(String firstPingYin) {
		this.firstPingYin = firstPingYin;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullPinYin() {
		return fullPinYin;
	}
	public void setFullPinYin(String fullPinYin) {
		this.fullPinYin = fullPinYin;
	}
	public String getFirstPinYin2() {
		return firstPinYin2;
	}
	public void setFirstPinYin2(String firstPinYin2) {
		this.firstPinYin2 = firstPinYin2;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String toString(){

		Field[] fileds= ResultData.class.getDeclaredFields();
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < fileds.length; i++) {
			try {
				sb.append(fileds[i].getName()+":"+fileds[i].get(this)+"\r\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	
	}
	
}