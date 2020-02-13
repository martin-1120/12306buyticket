package com.buyticket.test;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;

public class TestStr {
	
	static String s="MjAxNS0wOS0xOCMwMCNUMzk4IzA2OjAwIzA3OjM1IzY1MDAwMFQzOTgwMSNTWlEjR1pHIzEzOjM1I%2Ba3seWcsyPotaPlt54jMDEjMDYjMTAwNzIwMzExMzQwMTk3MDAwMDUxMDA3MjAwMDI1MzAxMjkwMDA2OCNRNyMxNDQyNDk5NjU4MTUxIzE0Mzc0NDIyMDAwMDAjQTU4MjYxRTkzMTVEMzYzM0JGMjk5NTA1OUFENjFERjA0NzZCMjJBNDJENkYxMDZCRTM2MUQzMkY%3D";
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		JSONObject obj=JSONObject.fromObject( FileUtils.readFileToString(new File("temp/testStr")));
		
	}
}
