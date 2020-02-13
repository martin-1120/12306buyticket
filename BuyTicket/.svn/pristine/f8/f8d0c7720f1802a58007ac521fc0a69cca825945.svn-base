package com.buyticket.test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURLProtocol {

	    public static void main(String[] args) {
	        String host = "www.baidu.com";
	        String file = "/index.html";
	        
	        String[] schames = {"http", "https", "ftp", "mailto", "telnet", "file", "ldap", "gopher", 
	                 "jdbc", "rmi", "jndi", "jar", "doc", "netdoc", "nfs", "verbatim", "finger", "daytime", ""
	                        + "systemresource"};
	        for (int i= 0; i < schames.length; i++) {
	            try {
	                @SuppressWarnings("unused")
					URL url = new URL(schames[i], host, file);
	                System.out.println(schames[i] + " is supported\r\n");
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block

	                e.printStackTrace();
	                System.out.println(schames[i] + " is not supported\r\n");
	            }
	        }
	    }
}
