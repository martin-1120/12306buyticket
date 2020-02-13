package com.buyticket.dto;

import java.io.Serializable;
import java.lang.reflect.Method;


@SuppressWarnings("serial")
public class BaseDTO implements Serializable{
	public String toString(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<getClass().getDeclaredFields().length;i++){
			String pname=getClass().getDeclaredFields()[i].getName();
			
			String setMethodName="get"+Character.toUpperCase(pname.charAt(0))+pname.substring(1);
			try {
				Method method=getClass().getMethod(setMethodName);
				Object value=method.invoke(this);
				sb.append(pname+":"+value+",");
			}catch(NoSuchMethodException e){
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return sb.toString();
	}
}
