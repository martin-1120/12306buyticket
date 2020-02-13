package com.buyticket.dto;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class TicketPriceDTO extends BaseDTO {
	//{"3":"1290","A1":"¥72.0","1":"720","A4":"¥197.0","A3":"¥129.0","4":"1970","OT":[],"WZ":"¥72.0","train_no":"65000K162008"}
	//软卧"A4":"¥197.0"    硬卧"A3":"¥129.0"    硬座"A1":"¥72.0"   无座"WZ":"¥72.0"
	private String M;//一等座
	private String O;//二等座
	private String A1;//硬座
	private String A3;//硬卧
	private String A4;//软卧
	private String WZ;//无座
	private String train_no;
	
	public String getPriceInfoStr(){
		
		return " 一等座："+M+","+"二等座:"+O+" 硬座："+A1+","+"硬卧:"+A3+",软卧:"+A4+",无座:"+WZ;
	}
	public TicketPriceDTO(JSONObject obj){
		
		this.setM(obj.has("M")?obj.getString("M"):"--");
		this.setO(obj.has("O")?obj.getString("O"):"--");
		this.setA1(obj.has("A1")?obj.getString("A1"):"--");
		this.setA3(obj.has("A3")?obj.getString("A3"):"--");
		this.setA4(obj.has("A4")?obj.getString("A4"):"--");
		this.setWZ(obj.has("WZ")?obj.getString("WZ"):"--");
		this.setTrain_no( obj.getString("train_no").substring(6,10));
	}
	public TicketPriceDTO() {
	}
	public String getA1() {
		return A1;
	}
	public void setA1(String a1) {
		A1 = a1;
	}
	public String getA3() {
		return A3;
	}
	public void setA3(String a3) {
		A3 = a3;
	}
	public String getA4() {
		return A4;
	}
	public void setA4(String a4) {
		A4 = a4;
	}
	public String getWZ() {
		return WZ;
	}
	public void setWZ(String wZ) {
		WZ = wZ;
	}
	public String getTrain_no() {
		return train_no;
	}
	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	public String getO() {
		return O;
	}
	public void setO(String o) {
		O = o;
	}
	
	
}
