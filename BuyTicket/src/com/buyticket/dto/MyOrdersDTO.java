package com.buyticket.dto;

import com.buyticket.core.My12306Exception;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@SuppressWarnings("serial")
public class MyOrdersDTO extends BaseDTO {
	
	/*{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,
		"data":{"orderDBList":[{"sequence_no":"E855155171","order_date":"2015-11-30 21:37:42"
		,"ticket_totalnum":1,"ticket_price_all":37200.0,"cancel_flag":"Y",
		"resign_flag":"4","return_flag":"N","print_eticket_flag":"N","pay_flag":"Y","pay_resign_flag":"N",
		"confirm_flag":"N",
		"tickets":[{"stationTrainDTO":{"trainDTO":{},"station_train_code":"Z182",
		"from_station_telecode":"BJQ","from_station_name":"深圳东","start_time":"1970-01-01 10:20:00",
		"to_station_telecode":"GZG","to_station_name":"赣州","arrive_time":"1970-01-01 16:07:00","distance":"503"}
		,"passengerDTO":{"passenger_name":"赖扬文","passenger_id_type_code":"1",
		"passenger_id_type_name":"二代身份证","passenger_id_no":"36070219921120063X","total_times":"98"}
		,"ticket_no":"E8551551711050151","sequence_no":"E855155171","batch_no":"1","train_date":"2015-12-01 00:00:00",
		"coach_no":"05","coach_name":"05","seat_no":"0151","seat_name":"15号下铺","seat_flag":"0","seat_type_code":"6
		","seat_type_name":"高级软卧","ticket_type_code":"1","ticket_type_name":"成人票","reserve_time":"2015-11-30 21:37:42","limit_time":"2015-11-30 21:37:42","lose_time":"2015-11-30 22:07:43","pay_limit_time":"2015-11-30 22:07:43","ticket_price":37200.0,"print_eticket_flag":"N","resign_flag":"4","return_flag":"N","confirm_flag":"N","pay_mode_code":"Y","ticket_status_code":"i","ticket_status_name":"待支付","cancel_flag":"Y","amount_char":0,"trade_mode":"","start_train_date_page":"2015-12-01 10:20","str_ticket_price_page":"372.0","come_go_traveller_ticket_page":"N","return_deliver_flag":"N","deliver_fee_char":"","is_need_alert_flag":false,"is_deliver":"N","dynamicProp":"","fee_char":"","insure_query_no":""}],"reserve_flag_query":"p","if_show_resigning_info":"N","recordCount":"1","isNeedSendMailAndMsg":"N","array_passser_name_page":["赖扬文"],"from_station_name_page":["深圳东"],"to_station_name_page":["赣州"],"start_train_date_page":"2015-12-01 10:20","start_time_page":"10:20","arrive_time_page":"16:07","train_code_page":"Z182","ticket_total_price_page":"372.0","come_go_traveller_order_page":"N","canOffLinePay":"N","if_deliver":"N","insure_query_no":""}]
		,"to_page":"db"},"messages":[],"validateMessages":{}}*/
	
	private JSONObject obj;
	public MyOrdersDTO(JSONObject obj){
		this.obj=obj;
	}
	
	public MyOrdersDTO() {
	}
	public boolean getIsOrderCachDTO(){
		if(obj!=null && obj.containsKey("orderCacheDTO")){
			return true;
		}else{
			return false;
		}
	}
	public String[] getSequence_no(){
		if(this.obj!=null && !this.obj.isNullObject()){
			if(obj.containsKey("orderCacheDTO")){
				return null;
			}else{
				//orderDBList
				JSONArray orderList =obj.getJSONArray("orderDBList");
				String[] arr=new String[orderList.size()];
				for(int i=0;i<orderList.size();i++){
					JSONObject order=orderList.getJSONObject(i);
					//sequence_no : "E855155171"
					arr[i]=order.getString("sequence_no");
				}
				return arr;
			}
			
		}
		return null;
	}
	public static void main(String[] args) throws My12306Exception {
		/*String jsonStr="{\"validateMessagesShowId\":\"_validatorMessage\",\"status\":true,\"httpstatus\":200,\"data\":{\"orderCacheDTO\":{\"requestId\":6218952794560954709,\"userId\":1500037939541,\"number\":0,\"tourFlag\":\"dc\",\"requestTime\":\"2016-12-26 08:58:08\",\"queueOffset\":168011103,\"queueName\":\"74_ORDER_SL42_2\",\"trainDate\":\"2016-12-28 00:00:00\",\"startTime\":\"1970-01-01 07:35:00\",\"stationTrainCode\":\"T398\",\"fromStationCode\":\"SZQ\",\"fromStationName\":\"深圳\",\"toStationCode\":\"GZG\",\"toStationName\":\"赣州\",\"status\":8,\"modifyTime\":\"2016-12-26 08:58:08\",\"tickets\":[{\"seatTypeName\":\"软卧\",\"seatTypeCode\":\"4\",\"ticketTypeName\":\"成人票\",\"passengerName\":\"赖扬文\",\"passengerIdTypeName\":\"二代身份证\"}],\"waitTime\":0,\"waitCount\":0,\"ticketCount\":1,\"startTimeString\":\"2016-12-28 07:35\",\"array_passser_name_page\":[\"赖扬文\"]},\"to_page\":\"cache\"},\"messages\":[],\"validateMessages\":{}}";
		JSONObject jsonObj=new JSONObject().fromObject(jsonStr);
		MyOrdersDTO dt=new MyOrdersDTO(jsonObj.getJSONObject("data"));
		String[] s=dt.getSequence_no();
		System.out.println(s);*/
		
		MyOrdersDTO o=new MyOrdersDTO();
		System.out.println(o.toString());
		
		
	}
	public String getSimpleInfo(boolean jiami) throws My12306Exception{

		if(this.obj!=null && !this.obj.isNullObject()){
			//obj=content/data
			if(obj.containsKey("orderCacheDTO")){
				//购票成功 立马查询 返回的是缓存dto
				//{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,"data":{"orderCacheDTO":{"requestId":6166608608595968341,"userId":1500037939541,"number":0,"tourFlag":"dc","requestTime":"2016-08-03 22:21:02","queueOffset":6585791035,"queueName":"26_ORDER_Q9_0","trainDate":"2016-09-28 00:00:00","startTime":"1970-01-01 15:39:00","stationTrainCode":"K1282","fromStationCode":"BJQ","fromStationName":"深圳东","toStationCode":"GZG","toStationName":"赣州","status":1,"modifyTime":"2016-08-03 22:21:02","tickets":[{"seatTypeName":"硬卧","seatTypeCode":"3","ticketTypeName":"成人票","passengerName":"赖扬文","passengerIdTypeName":"二代身份证"}],"waitTime":4,"waitCount":0,"ticketCount":1,"startTimeString":"2016-09-28 15:39","array_passser_name_page":["赖扬文"]},"to_page":"cache"},"messages":[],"validateMessages":{}}


				JSONObject orderCacheDTO=obj.getJSONObject("orderCacheDTO");
				
				//这一段也许没用了 返回数据中没有
				String msg="";
				if(orderCacheDTO.containsKey("message")){
					msg = obj.getJSONObject("orderCacheDTO").getJSONObject("message").getString("message");
					if(msg!=null && !msg.equals("")){
						throw new My12306Exception("这段应该没用的代码，你应该永远看不到 购票失败 :"+msg);
					}
				}
				String requestTime=orderCacheDTO.getString("requestTime");
				String trainDate=orderCacheDTO.getString("trainDate").replace("00:00:00", "");
				String startTime=orderCacheDTO.getString("startTime").replace("1970-01-01", "");
				String fromStationName=orderCacheDTO.getString("fromStationName");
				String toStationName=orderCacheDTO.getString("toStationName");
				String trainCode=orderCacheDTO.getString("stationTrainCode");
				String ticketPrice="未知";
						
				StringBuffer passenger=new StringBuffer();
				StringBuffer seatTypeName=new StringBuffer();
				JSONArray tickets=orderCacheDTO.getJSONArray("tickets");
				for (int i = 0; i < tickets.size(); i++) {
					JSONObject t=tickets.getJSONObject(i);
					if(i!=0){
						passenger.append(",");
						seatTypeName.append(",");
					}
					String tp=t.getString("passengerName");
					if(jiami){
						tp=tp.substring(0, tp.length()-1)+"*";
					}
					passenger.append(tp);
					seatTypeName.append(t.getString("seatTypeName"));
				}
				
				return passenger+"在"+requestTime+"抢到了"+(trainDate+startTime)+","+fromStationName+"-"+toStationName+","+trainCode+","+ticketPrice+"元的"+seatTypeName;
				
			}else if(obj.containsKey("orderDBList")){
				//购票成功  再点按钮  查询未完成订单 
				//{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,"data":{"orderDBList":[{"sequence_no":"E874136062","order_date":"2016-08-03 22:18:46","ticket_totalnum":1,"ticket_price_all":12900.0,"cancel_flag":"Y","resign_flag":"4","return_flag":"N","print_eticket_flag":"N","pay_flag":"Y","pay_resign_flag":"N","confirm_flag":"N","tickets":[{"stationTrainDTO":{"trainDTO":{},"station_train_code":"K1282","from_station_telecode":"BJQ","from_station_name":"深圳东","start_time":"1970-01-01 15:39:00","to_station_telecode":"GZG","to_station_name":"赣州","arrive_time":"1970-01-01 22:43:00","distance":"503"},"passengerDTO":{"passenger_name":"赖扬文","passenger_id_type_code":"1","passenger_id_type_name":"二代身份证","passenger_id_no":"36070219921120063X","total_times":"98"},"ticket_no":"E8741360621090013","sequence_no":"E874136062","batch_no":"1","train_date":"2016-09-28 00:00:00","coach_no":"09","coach_name":"09","seat_no":"0013","seat_name":"01号上铺","seat_flag":"0","seat_type_code":"3","seat_type_name":"硬卧","ticket_type_code":"1","ticket_type_name":"成人票","reserve_time":"2016-08-03 22:18:46","limit_time":"2016-08-03 22:18:46","lose_time":"2016-08-03 22:51:01","pay_limit_time":"2016-08-03 22:51:01","ticket_price":12900.0,"print_eticket_flag":"N","resign_flag":"4","return_flag":"N","confirm_flag":"N","pay_mode_code":"Y","ticket_status_code":"i","ticket_status_name":"待支付","cancel_flag":"Y","amount_char":0,"trade_mode":"","start_train_date_page":"2016-09-28 15:39","str_ticket_price_page":"129.0","come_go_traveller_ticket_page":"N","return_deliver_flag":"N","deliver_fee_char":"","is_need_alert_flag":false,"is_deliver":"N","dynamicProp":"","fee_char":"","insure_query_no":""}],"reserve_flag_query":"p","if_show_resigning_info":"N","recordCount":"1","isNeedSendMailAndMsg":"N","array_passser_name_page":["赖扬文"],"from_station_name_page":["深圳东"],"to_station_name_page":["赣州"],"start_train_date_page":"2016-09-28 15:39","start_time_page":"15:39","arrive_time_page":"22:43","train_code_page":"K1282","ticket_total_price_page":"129.0","come_go_traveller_order_page":"N","canOffLinePay":"N","if_deliver":"N","insure_query_no":""}],"to_page":"db"},"messages":[],"validateMessages":{}}
				StringBuffer sb =new StringBuffer();
				JSONArray orderList =obj.getJSONArray("orderDBList");
				for(int i=0;i<orderList.size();i++){
					JSONObject order=orderList.getJSONObject(i);
					
					String requestTime=order.getString("order_date");
					
					JSONArray ticketList =order.getJSONArray("tickets");
					for(int j=0;j<ticketList.size();j++){
						JSONObject ticket=ticketList.getJSONObject(j);
						String trainDate_startTime=ticket.getString("start_train_date_page");
						String fromStationName=ticket.getJSONObject("stationTrainDTO").getString("from_station_name");
						String toStationName=ticket.getJSONObject("stationTrainDTO").getString("to_station_name");
						String trainCode=ticket.getJSONObject("stationTrainDTO").getString("station_train_code");
						String ticketPrice=ticket.getString("str_ticket_price_page");
						
						String passenger=ticket.getJSONObject("passengerDTO").getString("passenger_name");
						
						
						if(jiami){
							passenger=passenger.substring(0, passenger.length()-1)+"*";
						}
						
						String seatTypeName=ticket.getString("seat_type_name");
						if(j!=0);{
							sb.append(",");
						}
						sb.append( passenger+"在"+requestTime+"抢到了"+trainDate_startTime+","+fromStationName+"-"+toStationName+","+trainCode+","+ticketPrice+"元的"+seatTypeName);

						
					}
					return sb.toString();
					
					
					
				}
			}
			
		}
		return "";
				
	
	}
	public String getOrderInfo() throws My12306Exception{
		StringBuffer sb=new StringBuffer();
		if(this.obj!=null && !this.obj.isNullObject()){
			//obj=content/data
			if(obj.containsKey("orderCacheDTO")){
				//购票成功 立马查询 返回的是缓存dto
				//{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,"data":{"orderCacheDTO":{"requestId":6166608608595968341,"userId":1500037939541,"number":0,"tourFlag":"dc","requestTime":"2016-08-03 22:21:02","queueOffset":6585791035,"queueName":"26_ORDER_Q9_0","trainDate":"2016-09-28 00:00:00","startTime":"1970-01-01 15:39:00","stationTrainCode":"K1282","fromStationCode":"BJQ","fromStationName":"深圳东","toStationCode":"GZG","toStationName":"赣州","status":1,"modifyTime":"2016-08-03 22:21:02","tickets":[{"seatTypeName":"硬卧","seatTypeCode":"3","ticketTypeName":"成人票","passengerName":"赖扬文","passengerIdTypeName":"二代身份证"}],"waitTime":4,"waitCount":0,"ticketCount":1,"startTimeString":"2016-09-28 15:39","array_passser_name_page":["赖扬文"]},"to_page":"cache"},"messages":[],"validateMessages":{}}

				
				
				JSONObject orderCacheDTO=obj.getJSONObject("orderCacheDTO");
				
				//这一段也许没用了 返回数据中没有
				String msg="";
				if(orderCacheDTO.containsKey("message")){
					msg = obj.getJSONObject("orderCacheDTO").getJSONObject("message").getString("message");
					if(msg!=null && !msg.equals("")){
						throw new My12306Exception("这段应该没用的代码，你应该永远看不到 购票失败 :"+msg);
					}
				}
				
				sb.append("下单时间："+orderCacheDTO.getString("requestTime")+" "+orderCacheDTO.getString("stationTrainCode")+" "+orderCacheDTO.getString("fromStationName")+"至"+orderCacheDTO.getString("toStationName")+" 发车时间:"+orderCacheDTO.getString("trainDate").replace("00:00:00", "")+orderCacheDTO.getString("startTime").replace("1970-01-01", ""));
				JSONArray tickets=orderCacheDTO.getJSONArray("tickets");
				for (int i = 0; i < tickets.size(); i++) {
					JSONObject t=tickets.getJSONObject(i);
					sb.append(t.getString("seatTypeName")+" "+t.getString("ticketTypeName")+" "+t.getString("passengerName")+" "+t.getString("passengerIdTypeName") +"\r\n");
				}
				
				
			}else if(obj.containsKey("orderDBList")){
				//购票成功  再点按钮  查询未完成订单 
				//{"validateMessagesShowId":"_validatorMessage","status":true,"httpstatus":200,"data":{"orderDBList":[{"sequence_no":"E874136062","order_date":"2016-08-03 22:18:46","ticket_totalnum":1,"ticket_price_all":12900.0,"cancel_flag":"Y","resign_flag":"4","return_flag":"N","print_eticket_flag":"N","pay_flag":"Y","pay_resign_flag":"N","confirm_flag":"N","tickets":[{"stationTrainDTO":{"trainDTO":{},"station_train_code":"K1282","from_station_telecode":"BJQ","from_station_name":"深圳东","start_time":"1970-01-01 15:39:00","to_station_telecode":"GZG","to_station_name":"赣州","arrive_time":"1970-01-01 22:43:00","distance":"503"},"passengerDTO":{"passenger_name":"赖扬文","passenger_id_type_code":"1","passenger_id_type_name":"二代身份证","passenger_id_no":"36070219921120063X","total_times":"98"},"ticket_no":"E8741360621090013","sequence_no":"E874136062","batch_no":"1","train_date":"2016-09-28 00:00:00","coach_no":"09","coach_name":"09","seat_no":"0013","seat_name":"01号上铺","seat_flag":"0","seat_type_code":"3","seat_type_name":"硬卧","ticket_type_code":"1","ticket_type_name":"成人票","reserve_time":"2016-08-03 22:18:46","limit_time":"2016-08-03 22:18:46","lose_time":"2016-08-03 22:51:01","pay_limit_time":"2016-08-03 22:51:01","ticket_price":12900.0,"print_eticket_flag":"N","resign_flag":"4","return_flag":"N","confirm_flag":"N","pay_mode_code":"Y","ticket_status_code":"i","ticket_status_name":"待支付","cancel_flag":"Y","amount_char":0,"trade_mode":"","start_train_date_page":"2016-09-28 15:39","str_ticket_price_page":"129.0","come_go_traveller_ticket_page":"N","return_deliver_flag":"N","deliver_fee_char":"","is_need_alert_flag":false,"is_deliver":"N","dynamicProp":"","fee_char":"","insure_query_no":""}],"reserve_flag_query":"p","if_show_resigning_info":"N","recordCount":"1","isNeedSendMailAndMsg":"N","array_passser_name_page":["赖扬文"],"from_station_name_page":["深圳东"],"to_station_name_page":["赣州"],"start_train_date_page":"2016-09-28 15:39","start_time_page":"15:39","arrive_time_page":"22:43","train_code_page":"K1282","ticket_total_price_page":"129.0","come_go_traveller_order_page":"N","canOffLinePay":"N","if_deliver":"N","insure_query_no":""}],"to_page":"db"},"messages":[],"validateMessages":{}}
				JSONArray orderList =obj.getJSONArray("orderDBList");
				for(int i=0;i<orderList.size();i++){
					JSONObject order=orderList.getJSONObject(i);
					//sequence_no : "E855155171"
					sb.append(order.getString("sequence_no")+"   ");
					sb.append(order.getString("train_code_page")+"   \t"+ order.getString("start_train_date_page")+"-"+order.getString("arrive_time_page")+"\t");
					sb.append("   ￥"+order.getString("ticket_total_price_page")+"   ");
					
					JSONArray ticketList =order.getJSONArray("tickets");
					for(int j=0;j<ticketList.size();j++){
						JSONObject ticket=ticketList.getJSONObject(j);
						sb.append(ticket.getJSONObject("passengerDTO").getString("passenger_name")+"  "+ticket.getString("seat_name")+" "+ticket.getString("seat_type_name")+" "+ticket.getString("ticket_type_name")+" "+ticket.getString("ticket_status_name")+"  请在之前付款:"+ticket.getString("pay_limit_time"));
					}
					
				}
			}
			
		}
		return sb.toString();
				
	}
	
}