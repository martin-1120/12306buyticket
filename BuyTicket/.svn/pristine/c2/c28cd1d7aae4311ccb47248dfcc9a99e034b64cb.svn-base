package com.buyticket.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map.Entry;
import java.util.Properties;

public class Test {
	@SuppressWarnings("unused")
	private String username;
	@SuppressWarnings("unused")
	private String userpwd;
	Test(){

		Properties p=new Properties();
		try {
			p.load(new FileInputStream("cfg.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Entry<Object, Object> entry : p.entrySet()){
			Field f;
			try {
				f = this.getClass().getDeclaredField((String)entry.getKey());
				if(f != null){
					f.set(this, entry.getValue());
				} 
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
			
		
	
	}
	public static void main(String[] args) throws IOException {
		
		/*JSONObject yupiao=JSONObject.fromObject(FileUtils.readFileToString(new File("yupiao.json")));
		JSONArray datas=yupiao.getJSONArray("data");
		for(int i=0;i<datas.size();i++){
			JSONObject queryLeftNewDTO=datas.getJSONObject(i).getJSONObject("queryLeftNewDTO");
			String secretStr =datas.getJSONObject(i).getString("secretStr");
			String buttonTextInfo =datas.getJSONObject(i).getString("buttonTextInfo");
			
			System.out.println(secretStr.length());
			
			JSONObject.fromObject(null,new JsonConfig());
		}*/
		
		/*String s="@abcd@";
		String[] result=s.split("@");
		for(String str: result){
			System.out.println("-"+str);
		}*/
		
		/*int pageCount=(int) Math.round((36/30.0d));
		System.out.println(pageCount);*/
		/*int i=0;
		for( i=0;i<10;++i){
			System.out.println(i);
			if(i==9)
				break;
		}
		System.out.println("应该=10 "+i);*/
		
	/*	String s="@aaaaa@bbbbbbb@ccccc@ddddd@eee@ff";
		String[] strs=s.split("@",5);
		System.out.println(Arrays.toString(strs));
		*/
		/*StringBuffer s=new StringBuffer("20150101").insert(4, "-").insert(7, "-");
		System.out.println(s);*/
		//MjAxNS0wOS0yMSMwMCNUMzk4IzA2OjAwIzA3OjM1IzY1MDAwMFQzOTgwMSNTWlEjR1pHIzEzOjM1I%2Ba3seWcsyPotaPlt54jMDEjMDYjMTAwNzIwMzExMTQwMTk3MDAwMDIxMDA3MjAwMTUyMzAxMjkwMDAyMiNRNyMxNDQyNzI5NzIwNjY5IzE0Mzc3MDE0MDAwMDAjOUE5OEVEQTFERjM0NUEwQUJFMUIzNzMxQjk3RjMyOUMzNjQ3NkI3RjFBMzY1ODY4Qjg0Q0Q3MjY%3D
		/*String s ="secretStr=&train_date=2015-09-21&back_train_date=2015-09-20&tour_flag=dc&purpose_codes=ADULT&query_from_station_name=深圳&query_to_station_name=赣州&undefined";
		System.out.println(s.length());//MjAxNS0wOS0yMSMwMCNUMzk4IzA2OjAwIzA3OjM1IzY1MDAwMFQzOTgwMSNTWlEjR1pHIzEzOjM1I%2Ba3seWcsyPotaPlt54jMDEjMDYjMTAwNzIwMzExMTQwMTk3MDAwMDIxMDA3MjAwMTUyMzAxMjkwMDAyMiNRNyMxNDQyNzI5NjY3Mzc1IzE0Mzc3MDE0MDAwMDAjOTYzRDQ0MEMyNEJCQ0UyRTFFMERGQ0ZFMTJCMDkyOTRDQkU3N0NCODM5ODJBODNDMEJCMDI5Q0Y%3D
		String s2="secretStr=&train_date=2015-09-21&back_train_date=2015-09-20&tour_flag=dc&purpose_codes=ADULT&query_from_station_name=深圳&query_to_station_name=赣州&undefined=";
		System.out.println(s2.length());*/
//		String output = URLDecoder.decode("%u6DF1%u5733%2CSZQ", "UTF-8");
//		System.out.println(output);
		/*String strInput=new String("深圳");//深圳,SZQ
		StringBuffer output=new StringBuffer();
		System.out.println("\""+strInput+ "\" 的utf8编码：");
        for (int i = 0; i < strInput.length(); i++)
        {
        	String temp=Integer.toString(strInput.charAt(i), 16)+"";
            output.append("%u" +temp.toUpperCase());
            //System.out.println((int)strInput.charAt(i));
        } 
        //String result=output.toString().replaceAll("\\\\","%").toUpperCase();
        System.out.println(output+URLEncoder.encode(",SZQ"));
        
        
        */
		
		
		/*String s="MjAxNS0wOS0wOCMwMCNLMTM0IzA2OjQ4IzExOjM1IzY5MDAwMEsxMzQwOSNPU1EjR1pHIzE4OjIzI%2Ba3seWcs%2BilvyPotaPlt54jMDEjMDUjMTAwNzUwMzE3NzQwMjA1MDAwMjIzMDEzMzAwMTYyMTAwNzUwMDE4MCNRNiMxNDQxNjMwNDY5MTU0IzE0MzY1ODE4MDAwMDAjMDkxNjFEOTgyNzlBOTU2M0RCQTE0NjM0NzIwRDdFMERGQjRCRTA1RTAyMkE0MDI5MUE0NjM1NUQ%3D";
		String s2=URLEncoder.encode(s);
		//System.out.println(URLDecoder.decode(s));
		System.out.println(s);
		System.out.println(s2);*/
		
		System.out.println("{'cardTypes':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u4E8C\u4EE3\u8EAB\u4EFD\u8BC1'},{'end_station_name':null,'end_time':null,'id':'C','start_station_name':null,'start_time':null,'value':'\u6E2F\u6FB3\u901A\u884C\u8BC1'},{'end_station_name':null,'end_time':null,'id':'G','start_station_name':null,'start_time':null,'value':'\u53F0\u6E7E\u901A\u884C\u8BC1'},{'end_station_name':null,'end_time':null,'id':'B','start_station_name':null,'start_time':null,'value':'\u62A4\u7167'}],'isAsync':'1','key_check_isChange':'F7507CD02636DB74E5D071BF99D1F1A11102FB59BC1AD51DFA45F32D','leftDetails':['\u786C\u5367(129.00\u5143)15\u5F20\u7968','\u786C\u5EA7(72.00\u5143)\u6709\u7968','\u8F6F\u5367(197.00\u5143)6\u5F20\u7968','\u65E0\u5EA7(72.00\u5143)\u6709\u7968'],'leftTicketStr':'1007203111401970000610072000963012900015','limitBuySeatTicketDTO':{'seat_type_codes':[{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u786C\u5367'},{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u786C\u5EA7'},{'end_station_name':null,'end_time':null,'id':'4','start_station_name':null,'start_time':null,'value':'\u8F6F\u5367'}],'ticket_seat_codeMap':{'3':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u786C\u5EA7'},{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u786C\u5367'}],'2':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u786C\u5EA7'},{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u786C\u5367'},{'end_station_name':null,'end_time':null,'id':'4','start_station_name':null,'start_time':null,'value':'\u8F6F\u5367'}],'1':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u786C\u5EA7'},{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u786C\u5367'},{'end_station_name':null,'end_time':null,'id':'4','start_station_name':null,'start_time':null,'value':'\u8F6F\u5367'}],'4':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u786C\u5EA7'},{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u786C\u5367'},{'end_station_name':null,'end_time':null,'id':'4','start_station_name':null,'start_time':null,'value':'\u8F6F\u5367'}]},'ticket_type_codes':[{'end_station_name':null,'end_time':null,'id':'1','start_station_name':null,'start_time':null,'value':'\u6210\u4EBA\u7968'},{'end_station_name':null,'end_time':null,'id':'2','start_station_name':null,'start_time':null,'value':'\u513F\u7AE5\u7968'},{'end_station_name':null,'end_time':null,'id':'3','start_station_name':null,'start_time':null,'value':'\u5B66\u751F\u7968'},{'end_station_name':null,'end_time':null,'id':'4','start_station_name':null,'start_time':null,'value':'\u6B8B\u519B\u7968'}]},'maxTicketNum':'5','orderRequestDTO':{'adult_num':0,'apply_order_no':null,'bed_level_order_num':null,'bureau_code':null,'cancel_flag':null,'card_num':null,'child_num':0,'disability_num':0,'end_time':{'date':1,'day':4,'hours':13,'minutes':35,'month':0,'seconds':0,'time':20100000,'timezoneOffset':-480,'year':70},'from_station_name':'\u6DF1\u5733','from_station_telecode':'SZQ','get_ticket_pass':null,'id_mode':'Y','order_date':null,'reserve_flag':'A','seat_detail_type_code':null,'seat_type_code':null,'sequence_no':null,'start_time':{'date':1,'day':4,'hours':7,'minutes':35,'month':0,'seconds':0,'time':-1500000,'timezoneOffset':-480,'year':70},'start_time_str':null,'station_train_code':'T398','student_num':0,'ticket_num':0,'ticket_type_order_num':null,'to_station_name':'\u8D63\u5DDE','to_station_telecode':'GZG','tour_flag':'dc','trainCodeText':null,'train_date':{'date':21,'day':1,'hours':0,'minutes':0,'month':8,'seconds':0,'time':1442764800000,'timezoneOffset':-480,'year':115},'train_date_str':null,'train_location':null,'train_no':'650000T39801','train_order':null},'purpose_codes':'00','queryLeftNewDetailDTO':{'BXRZ_num':'-1','BXRZ_price':'0','BXYW_num':'-1','BXYW_price':'0','EDRZ_num':'-1','EDRZ_price':'0','EDSR_num':'-1','EDSR_price':'0','ERRB_num':'-1','ERRB_price':'0','GG_num':'-1','GG_price':'0','GR_num':'-1','GR_price':'0','HBRW_num':'-1','HBRW_price':'0','HBRZ_num':'-1','HBRZ_price':'0','HBYW_num':'-1','HBYW_price':'0','HBYZ_num':'-1','HBYZ_price':'0','RW_num':'6','RW_price':'01970','RZ_num':'-1','RZ_price':'0','SRRB_num':'-1','SRRB_price':'0','SWZ_num':'-1','SWZ_price':'0','TDRZ_num':'-1','TDRZ_price':'0','TZ_num':'-1','TZ_price':'0','WZ_num':'111','WZ_price':'00720','WZ_seat_type_code':'1','YB_num':'-1','YB_price':'0','YDRZ_num':'-1','YDRZ_price':'0','YDSR_num':'-1','YDSR_price':'0','YRRB_num':'-1','YRRB_price':'0','YW_num':'15','YW_price':'01290','YYRW_num':'-1','YYRW_price':'0','YZ_num':'96','YZ_price':'00720','ZE_num':'-1','ZE_price':'0','ZY_num':'-1','ZY_price':'0','arrive_time':'1335','control_train_day':'','day_difference':null,'end_station_name':null,'end_station_telecode':null,'from_station_name':'\u6DF1\u5733','from_station_telecode':'SZQ','is_support_card':null,'lishi':'06:00','seat_feature':'','start_station_name':null,'start_station_telecode':null,'start_time':'0735','start_train_date':'','station_train_code':'T398','to_station_name':'\u8D63\u5DDE','to_station_telecode':'GZG','train_class_name':null,'train_no':'650000T39801','train_seat_feature':'','yp_ex':''},'queryLeftTicketRequestDTO':{'arrive_time':'13:35','bigger20':'Y','from_station':'SZQ','from_station_name':'\u6DF1\u5733','from_station_no':'01','lishi':'06:00','login_id':null,'login_mode':null,'login_site':null,'purpose_codes':'00','query_type':null,'seatTypeAndNum':null,'seat_types':'1413','start_time':'07:35','start_time_begin':null,'start_time_end':null,'station_train_code':'T398','to_station':'GZG','to_station_name':'\u8D63\u5DDE','to_station_no':'06','train_date':'20150921','train_flag':null,'train_headers':null,'train_no':'650000T39801','useMasterPool':true,'useWB10LimitTime':true,'usingGemfireCache':false,'ypInfoDetail':'1007203111401970000610072000963012900015'},'tour_flag':'dc','train_location':'Q7'};");
		
		
	}
}

