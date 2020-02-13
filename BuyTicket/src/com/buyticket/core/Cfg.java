package com.buyticket.core;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;

public class Cfg {
	/*private static String username;
	private static String userpwd;*/
	//private static PropertiesUtil p=new PropertiesUtil();
	static PropertiesConfiguration p=new PropertiesConfiguration();
	
	public static String getUsername() {
		return (String) p.getProperty("username");
	}
	public static String getUserpwd() {
		return (String) p.getProperty("userpwd");
	}	
	public static void setUsername(String name) {
		p.setProperty("username", name);
	}
	public static void setUserpwd(String pwd) {
		p.setProperty("userpwd", pwd);
	}	
	static String filePath="cfg.properties";
	static{
		readPropertie();
	}
	public static void readPropertie(){

		/*if(!new File(filePath).exists()){
			try {
				FileUtils.write(new File(filePath),"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		try {
			File f=new File(filePath);
			if(!f.exists()){
				IOUtils.copy(Cfg.class.getResourceAsStream("/resource/data/cfg.properties"), new FileOutputStream(f));
				//f.createNewFile();
			}
			p.load(f);
		}catch (Exception e) {
			e.printStackTrace();
		}/*
		for(Entry<Object, Object> entry : p.entrySet()){
			Field f;
			try {
				String key=(String)entry.getKey();
				String value=(String)entry.getValue();
				try{
					f = Cfg.class.getDeclaredField(key);
					if(f != null){
						f.set(null, value);
					} 
				}catch(java.lang.NoSuchFieldException e){

				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}*/
	
	}
	public static String get(String key){
		return (String) p.getProperty(key);
	}
	/*public static void saveCfg(String[] keys,String[] values){
		try {
			for(int i=0;i< keys.length;i++){
				p.setProperty(keys[i],values[i]);
				try{
					Cfg.class.getDeclaredField(keys[i]).set(null,values[i]);
				}catch(Exception e){
					
				}
			}
			p.store(new FileOutputStream(filePath),null);//new Date().toLocaleString()
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}*/
	public static void saveCfg(){
		try {
			p.save(new File(filePath));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static PropertiesConfiguration getConfig(){
		return p;
	}
	public static void main(String[] args) {
		
		
		System.out.println(p.getProperty("username"));
	}
}
