package com.buyticket.test;

import java.util.ArrayList;
import java.util.List;

public class TestIFElse {
	public static String getWz_num(){
		return "有";
	}
	public static String getYz_num(){
		return "无";
	}
	public static String getYw_num(){
		return "无";
	}
	public static String getRw_num(){
		return "无";
	}
	public static String getZy_num(){
		return "无";
	}
	public static String getZe_num(){
		return "有";
	}
	public static String getSwz_num(){
		return "无";
	}
	public static String getGr_num(){
		return "无";
	}
	public static String getTz_num(){
		return "无";
	}
	public static void main(String[] args) {
			//无座0是我自己定义的 方便区分开
			//"0:无座","1:硬座","3:硬卧","4:软卧","M:一等座","O:二等座","9:商务座","6:高级软卧","P:特等座"
			System.out.println("xxx");
			List<String> validSeatType=new ArrayList<String>();
			if(!"--".equals(getWz_num()) && !"无".equals(getWz_num())){
				validSeatType.add("0:无座");//0:无座 
			}
			if((!"--".equals(getYz_num())) && (!"无".equals(getYz_num()))){
				validSeatType.add("1:硬座");//1:硬座
			}
			if(!"--".equals(getYw_num()) && !"无".equals(getYw_num())){
				validSeatType.add("3:硬卧");//3:硬卧
			}
			if(!"--".equals(getRw_num()) && !"无".equals(getRw_num())){
				validSeatType.add("4:软卧");//4:软卧
			}
			if((!"--".equals(getZy_num())) && (!"无".equals(getZy_num()))){
				validSeatType.add("M:一等座");//M:一等座
			}
			if((!"--".equals(getZe_num())) && (!"无".equals(getZe_num()))){
				validSeatType.add("O:二等座");//O:二等座
			}
			if(!"--".equals(getSwz_num()) && !"无".equals(getSwz_num())){
				validSeatType.add("9:商务座");//9:商务座
			}
			if(!"--".equals(getGr_num()) && !"无".equals(getGr_num())){
				validSeatType.add("6:高级软卧");//6:高级软卧
			}
			if(!"--".equals(getTz_num()) && !"无".equals(getTz_num())){
				validSeatType.add("P:特等座");//P:特等座
			}
			 System.out.println(validSeatType);;
	}
}
