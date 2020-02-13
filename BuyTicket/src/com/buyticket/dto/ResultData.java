package com.buyticket.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.buyticket.core.My12306Exception;
import com.buyticket.ui.LoginFrm;
import com.buyticket.ui.MainFrm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
@SuppressWarnings("unused")
public class ResultData implements Serializable{
	static Log log=LogFactory.getLog(ResultData.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String validateMessagesShowId;
	private boolean status;
	private int httpstatus;
	private JSONObject dataObj;//{"result":"0","msg":"EXPIRED"} 
	private JSONArray dataArr;//["result":"0","msg":"EXPIRED"] 
	private String dataStr;//data:""
	private Object messages;//[]JSONArray
	private JSONObject validateMessages;//{}
	private String url;
	JSONObject jsonObj=null;
	public ResultData(String json) throws My12306Exception{
		/*if(json==null||json.ch>-1){
			throw new My12306Exception("要json,但是是html,12306返回错误");
		}*/
		
		try{
			jsonObj= JSONObject.fromObject(json);
		}catch(Exception e){
			log.error("12306 返回错误,没返回json:"+json);
			throw new My12306Exception("12306 返回错误,没返回json:"+json);
		}
		for(Object e :jsonObj.entrySet()){
			@SuppressWarnings("unchecked")
			Map.Entry<String,Object> entry=(Entry<String, Object>)e;
			String field=entry.getKey();
			try {
				if(field.equals("data")){
					if(entry.getValue() instanceof JSONObject){
						field=field+"Obj";
					}else if(entry.getValue() instanceof JSONArray){
						field=field+"Arr";
					}else if(entry.getValue() instanceof String){
						field=field+"Str";
					}
				}
				
				try{
					java.lang.reflect.Field f = ResultData.class.getDeclaredField(field);
					f.set(this, entry.getValue());
				}catch(NoSuchFieldException noEx){
					log.error(noEx.getMessage());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new My12306Exception("12306返回内容异常："+jsonObj);

			} 
			
		}
		String errMsg=getErrorMessage();
		if(errMsg!=null && !"".equals(errMsg)){
			log.error(errMsg);
			throw new My12306Exception(getErrorMessage());
		}
		
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
	public String getValidateMessagesShowId() {
		return validateMessagesShowId;
	}
	public void setValidateMessagesShowId(String validateMessagesShowId) {
		this.validateMessagesShowId = validateMessagesShowId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(int httpstatus) {
		this.httpstatus = httpstatus;
	}
	
	public JSONObject getDataObj() {
		return dataObj;
	}
	public void setDataObj(JSONObject dataObj) {
		this.dataObj = dataObj;
	}
	public JSONArray getDataArr() {
		return dataArr;
	}
	public void setDataArr(JSONArray dataArr) {
		this.dataArr = dataArr;
	}
	
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	public Object getMessages() {
		return messages;
	}
	public void setMessages(Object messages) {
		this.messages = messages;
	}
	public JSONObject getValidateMessages() {
		return validateMessages;
	}
	public void setValidateMessages(JSONObject validateMessages) {
		this.validateMessages = validateMessages;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	public String getErrorMessage(){
		
		if(messages!=null  ){
			if( messages instanceof JSONArray) {
				if(((JSONArray)messages).size()>0 && ((JSONArray)messages).get(0)!=null) {
					return ((JSONArray)messages).get(0).toString();
				}
			}else {
				return messages.toString();
			}
			
		}else if(getDataObj()!=null && getDataObj().containsKey("errMsg")){
			return getDataObj().getString("errMsg");
		}
		return "";
	}
	public static void main(String[] args) throws My12306Exception {
		String s="{\"validateMessagesShowId\":\"_validatorMessage\",\"status\":true,\"httpstatus\":200,\"data\":{\"otherMsg\":\"\",\"loginCheck\":\"Y\"},\"messages\":[],\"validateMessages\":{}}";
		ResultData r=new ResultData(s);
		System.out.println(r);
	}
}