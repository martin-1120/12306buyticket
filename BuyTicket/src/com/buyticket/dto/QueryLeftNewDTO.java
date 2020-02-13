package com.buyticket.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONObject;

public class QueryLeftNewDTO extends BaseDTO {
	
	static Log log=LogFactory.getLog(QueryLeftNewDTO.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String train_no;//@Description("列车编号")
	@Description("车次{width:60}")
	private String station_train_code;
	private String start_station_telecode;// @Description("始发站编码")
	
	private String start_station_name;//@Description("始发站")
	private String end_station_telecode;// @Description("终到站编码")

	private String end_station_name;//@Description("终点站")
	private String from_station_telecode;// @Description("查询输入经过站编码")
	@Description("出发地{width:150}")
	private String from_station_name="";
	private String to_station_telecode;// @Description("查询输入到站编码")
	@Description("目的地{width:205}")
	private String to_station_name="";
	
	private String start_time;//@Description("出发时间")

	private String arrive_time;	//@Description("到站时间")
	
	private String day_difference="";//@Description("跨天")
	private String train_class_name;// @Description("火车类型名称")
	@Description("历时{width:48}")
	private String lishi;
	
	private String canWebBuy;//@Description("是否可以预定")
	private String yp_info;
	private String control_train_day;
	private String start_train_date;
	private String seat_feature;
	private String yp_ex;
	private String train_seat_feature;
	private String seat_types;
	private String location_code;
	private String from_station_no;
	private String to_station_no;
	private Integer control_day;
	@Description("出票{width:48}")
	private String sale_time;
	private String is_support_card;
	private String gg_num;
	@Description("商务座{width:57}")
	private String swz_num;
	@Description("特等座{width:57}")
	private String tz_num;
	@Description("一等座{width:57}")
	private String zy_num;
	@Description("二等座{width:57}")
	private String ze_num;
	@Description("高级软卧{width:70}")
	private String gr_num;
	@Description("软卧{width:44}")
	private String rw_num;
	@Description("硬卧{width:44}")
	private String yw_num;
	@Description("软座{width:44}")
	private String rz_num;
	@Description("硬座{width:44}")
	private String yz_num;
	@Description("无座{width:44}")
	private String wz_num;
	private String yb_num;
	@Description("其他{width:44}")
	private String qt_num;
	private String secretStr;// "预定请求令牌字符串"
	@Description("备注{width:140}")
	private String buttonTextInfo;
	
	//
	private TicketPriceDTO priceDto; 
	public QueryLeftNewDTO(JSONObject obj){
		if(obj==null || obj.isNullObject())
			return;
		for(int i=0;i<getClass().getDeclaredFields().length;i++){
			String pname=getClass().getDeclaredFields()[i].getName();
			
			Object value=obj.get(pname)==null?obj.getJSONObject("queryLeftNewDTO").get(pname):obj.get(pname);
			if(value==null)
				continue ;
			@SuppressWarnings("rawtypes")
			Class valueClass=obj.get(pname)==null?obj.getJSONObject("queryLeftNewDTO").get(pname).getClass():obj.get(pname).getClass();
			String setMethodName="set"+Character.toUpperCase(pname.charAt(0))+pname.substring(1);
			try {
				getClass().getMethod(setMethodName,valueClass).invoke(this,value);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	public QueryLeftNewDTO(){
		
	}
	private static List<String> colHeader=new ArrayList<String>();
	private static List<String> propertys=new ArrayList<String>();
	private static List<String> allPropertys=new ArrayList<String>();
	static{
		for(Field f :QueryLeftNewDTO.class.getDeclaredFields()){
			Description des=f.getAnnotation(Description.class);
			if(des!=null){
//				name{width:70}
				String name=des.value();
				colHeader.add(name);
				propertys.add(f.getName());
			}
			allPropertys.add(f.getName());
		}
	}
	public static List<String> getColHeader(){
		return colHeader;
	}
	public static List<String> getColumns(){
		return propertys;
	}
	public static List<String> getAllColumns(){
		return allPropertys;
	}
	public static String getColumnName(int column){
		String name=colHeader.get(column);
		if(name.indexOf("{")>-1){
			name=name.substring(0,name.indexOf("{"));
		}
		return name;
	} 
	
	public static Object getValueAt(QueryLeftNewDTO dto,int columnIndex){
		try {
			//log.info("getValueAt "+columnIndex);
			String pro=propertys.get(columnIndex);
			//log.info("pro "+pro);
			Method get =  QueryLeftNewDTO.class.getDeclaredMethod("get"+Character.toUpperCase( pro.charAt(0))+pro.substring(1));
			//log.info("get "+get);
			Object value=get.invoke(dto);
			//log.info(pro+":"+value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void setValueAt(QueryLeftNewDTO dto,int columnIndex,Object value){
		String pro=propertys.get(columnIndex);
		try {
			Method set =  QueryLeftNewDTO.class.getDeclaredMethod("set"+Character.toUpperCase(pro.charAt(0))+pro.substring(1), QueryLeftNewDTO.class.getDeclaredField(propertys.get(columnIndex)).getType());
			set.invoke(dto, value);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static Class<?> getColumnClass(int columnIndex){
		try {
			return  QueryLeftNewDTO.class.getDeclaredField(propertys.get(columnIndex)).getType();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	public List<String> getHasTiketSeatTypes(String[] seatTypesSetting){
		//无座0是我自己定义的 方便区分开
		//"0:无座","1:硬座","3:硬卧","4:软卧","M:一等座","O:二等座","9:商务座","6:高级软卧","P:特等座"
		
		List<String> validSeatType=new ArrayList<String>();
		if(!"--".equals(getWz_num()) && !"无".equals(getWz_num())){
			validSeatType.add("0:无座:"+getWz_num());//0:无座   
		}
		if(!"--".equals(getYz_num()) && !"无".equals(getYz_num()) ){
			validSeatType.add("1:硬座:"+getYz_num());//1:硬座 
		}
		if(!"--".equals(getYw_num()) && !"无".equals(getYw_num())){
			validSeatType.add("3:硬卧:"+getYw_num());//3:硬卧 
		}
		if(!"--".equals(getRw_num()) && !"无".equals(getRw_num())){
			validSeatType.add("4:软卧:"+getRw_num());//4:软卧  
		}
		if(!"--".equals(getZy_num()) && !"无".equals(getZy_num())){
			validSeatType.add("M:一等座:"+getZy_num());//M:一等座  
		}
		if(!"--".equals(getZe_num()) && !"无".equals(getZe_num())){
			validSeatType.add("O:二等座:" +getZe_num() );//O:二等座
		}
		if(!"--".equals(getSwz_num()) && !"无".equals(getSwz_num())){
			validSeatType.add("9:商务座:"+getSwz_num());//9:商务座   
		}
		if(!"--".equals(getGr_num()) && !"无".equals(getGr_num())){
			validSeatType.add("6:高级软卧:"+getGr_num());//6:高级软卧 
		}
		if(!"--".equals(getTz_num()) && !"无".equals(getTz_num())){
			validSeatType.add("P:特等座:"+getTz_num());//P:特等座  
		}
		if(seatTypesSetting!=null &&seatTypesSetting.length>0){
			
			for(int i=validSeatType.size()-1;i>=0;i--){
				String types=Arrays.toString(seatTypesSetting);
				//[a, b]
				if(types.indexOf(validSeatType.get(i).split(":")[0]) == -1){
					validSeatType.remove(i);
				}
			}
			
		}
		return validSeatType;
	}
	public static Map<String,String> seatTypesMap=new HashMap<>();
	static{
		seatTypesMap.put("0", "无座");
		seatTypesMap.put("1", "硬座");
		seatTypesMap.put("3", "硬卧");
		seatTypesMap.put("4", "软卧");
		seatTypesMap.put("M", "一等座");
		seatTypesMap.put("O", "二等座");
		seatTypesMap.put("9", "商务座");
		seatTypesMap.put("6", "高级软卧");
		seatTypesMap.put("P", "特等座");
	}
	public static String convertSeatTypeCode2Name(String seatType){
		return seatTypesMap.get(seatType);
		/*switch (seatTypes){
			case "0":return "无座";
			case "1":return "硬座";
			case "3":return "硬卧";
			case "4":return "软卧";
			case "M":return "一等座";
			case "O":return "二等座";
			case "9":return "商务座";
			case "6":return "高级软卧";
			case "P":return "特等座";
			default :return null;
		}*/
	}
	public String[] convertSeatTypeCode2Name(String[] seatTypes){
		String[] seatTypeNames=new String[seatTypes.length];
		for(int i=0;i<seatTypes.length;i++){
			seatTypeNames[i]=convertSeatTypeCode2Name(seatTypes[i]);
		}
		return seatTypeNames;
	}
	public String getTrain_no() {
		return train_no;
	}
	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}
	public String getStation_train_code() {
		return station_train_code;
	}
	public void setStation_train_code(String station_train_code) {
		this.station_train_code = station_train_code;
	}
	public String getStart_station_telecode() {
		return start_station_telecode;
	}
	public void setStart_station_telecode(String start_station_telecode) {
		this.start_station_telecode = start_station_telecode;
	}
	public String getStart_station_name() {
		return start_station_name;
	}
	public void setStart_station_name(String start_station_name) {
		this.start_station_name = start_station_name;
	}
	public String getEnd_station_telecode() {
		return end_station_telecode;
	}
	public void setEnd_station_telecode(String end_station_telecode) {
		this.end_station_telecode = end_station_telecode;
	}
	public String getEnd_station_name() {
		return end_station_name;
	}
	public void setEnd_station_name(String end_station_name) {
		this.end_station_name = end_station_name;
	}
	public String getFrom_station_telecode() {
		return from_station_telecode;
	}
	public void setFrom_station_telecode(String from_station_telecode) {
		this.from_station_telecode = from_station_telecode;
	}
	public String getFrom_station_name() {
		if(from_station_name.equals(start_station_name)){
			return "(始)"+from_station_name+start_time;	
		}
		return from_station_name+start_time;
	}
	public void setFrom_station_name(String from_station_name) {
		this.from_station_name = from_station_name;
	}
	public String getTo_station_telecode() {
		return to_station_telecode;
	}
	public void setTo_station_telecode(String to_station_telecode) {
		this.to_station_telecode = to_station_telecode;
	}
	public String getTo_station_name() {
		if(to_station_name.equals(end_station_name)){
			return "(终)"+from_station_name+arrive_time+" "+(day_difference.equals("0")?"当天到":day_difference+"天后");	
		}
		return to_station_name+arrive_time+" "+(day_difference.equals("0")?"当天到":day_difference+"天后");
	}
	public void setTo_station_name(String to_station_name) {
		this.to_station_name = to_station_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}
	public String getDay_difference() {
		return day_difference;
	}
	public void setDay_difference(String day_difference) {
		this.day_difference = day_difference;
	}
	public String getTrain_class_name() {
		return train_class_name;
	}
	public void setTrain_class_name(String train_class_name) {
		this.train_class_name = train_class_name;
	}
	public String getLishi() {
		return lishi;
	}
	public void setLishi(String lishi) {
		this.lishi = lishi;
	}
	public String getCanWebBuy() {
		return canWebBuy;
	}
	public void setCanWebBuy(String canWebBuy) {
		this.canWebBuy = canWebBuy;
	}
	public String getYp_info() {
		return yp_info;
	}
	public void setYp_info(String yp_info) {
		this.yp_info = yp_info;
	}
	public String getControl_train_day() {
		return control_train_day;
	}
	public void setControl_train_day(String control_train_day) {
		this.control_train_day = control_train_day;
	}
	public String getStart_train_date() {
		return start_train_date;
	}
	public void setStart_train_date(String start_train_date) {
		this.start_train_date = start_train_date;
	}
	public String getSeat_feature() {
		return seat_feature;
	}
	public void setSeat_feature(String seat_feature) {
		this.seat_feature = seat_feature;
	}
	public String getYp_ex() {
		return yp_ex;
	}
	public void setYp_ex(String yp_ex) {
		this.yp_ex = yp_ex;
	}
	public String getTrain_seat_feature() {
		return train_seat_feature;
	}
	public void setTrain_seat_feature(String train_seat_feature) {
		this.train_seat_feature = train_seat_feature;
	}
	public String getSeat_types() {
		return seat_types;
	}
	public void setSeat_types(String seat_types) {
		this.seat_types = seat_types;
	}
	public String getLocation_code() {
		return location_code;
	}
	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}
	public String getFrom_station_no() {
		return from_station_no;
	}
	public void setFrom_station_no(String from_station_no) {
		this.from_station_no = from_station_no;
	}
	public String getTo_station_no() {
		return to_station_no;
	}
	public void setTo_station_no(String to_station_no) {
		this.to_station_no = to_station_no;
	}
	public Integer getControl_day() {
		return control_day;
	}
	public void setControl_day(Integer control_day) {
		this.control_day = control_day;
	}
	public String getSale_time() {
		if(sale_time!=null){
			return sale_time.substring(0,2)+":"+sale_time.substring(2);
		}
		return sale_time;
	}
	public void setSale_time(String sale_time) {
		this.sale_time = sale_time;
	}
	public String getIs_support_card() {
		return is_support_card;
	}
	public void setIs_support_card(String is_support_card) {
		this.is_support_card = is_support_card;
	}
	public String getGg_num() {
		return gg_num;
	}
	public void setGg_num(String gg_num) {
		this.gg_num = gg_num;
	}
	public String getSwz_num() {
		return swz_num;
	}
	public void setSwz_num(String swz_num) {
		this.swz_num = swz_num;
	}
	public String getTz_num() {
		return tz_num;
	}
	public void setTz_num(String tz_num) {
		this.tz_num = tz_num;
	}
	public String getZy_num() {
		return zy_num;
	}
	public void setZy_num(String zy_num) {
		this.zy_num = zy_num;
	}
	public String getZe_num() {
		return ze_num;
	}
	public void setZe_num(String ze_num) {
		this.ze_num = ze_num;
	}
	public String getGr_num() {
		return gr_num;
	}
	public void setGr_num(String gr_num) {
		this.gr_num = gr_num;
	}
	public String getRw_num() {
		return rw_num;
	}
	public void setRw_num(String rw_num) {
		this.rw_num = rw_num;
	}
	public String getYw_num() {
		return yw_num;
	}
	public void setYw_num(String yw_num) {
		this.yw_num = yw_num;
	}
	public String getRz_num() {
		return rz_num;
	}
	public void setRz_num(String rz_num) {
		this.rz_num = rz_num;
	}
	public String getYz_num() {
		return yz_num;
	}
	public void setYz_num(String yz_num) {
		this.yz_num = yz_num;
	}
	public String getWz_num() {
		return wz_num;
	}
	public void setWz_num(String wz_num) {
		this.wz_num = wz_num;
	}
	public String getYb_num() {
		return yb_num;
	}
	public void setYb_num(String yb_num) {
		this.yb_num = yb_num;
	}
	public String getQt_num() {
		return qt_num;
	}
	public void setQt_num(String qt_num) {
		this.qt_num = qt_num;
	}
	public String getSecretStr() {
		return secretStr;
	}
	public void setSecretStr(String secretStr) {
		this.secretStr = secretStr;
	}
	public String getButtonTextInfo() {
		return buttonTextInfo;
	}
	public void setButtonTextInfo(String buttonTextInfo) {
		this.buttonTextInfo = buttonTextInfo;
	}

	public TicketPriceDTO getPriceDto() {
		return priceDto;
	}

	public void setPriceDto(TicketPriceDTO priceDto) {
		this.priceDto = priceDto;
	}
	
	@Override
	public String toString() {
		return "车次:"+getStation_train_code()+" 发车时间:"+getStart_train_date()+getStart_time()+" 历时 "+getLishi()+"  从 "+getFrom_station_name()+" 到  "+getTo_station_name()+" 是否能买票:"+getCanWebBuy()+" 剩余票座位类型:"+getHasTiketSeatTypes(null);
	}
	
}
