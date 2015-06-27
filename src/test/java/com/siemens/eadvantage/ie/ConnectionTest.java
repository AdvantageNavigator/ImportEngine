package com.siemens.eadvantage.ie;

import java.io.IOException;

public class ConnectionTest {
	
	public static void main(String[] args) throws IOException {
		
		ImportEngineClient client = new ImportEngineClient("user", "secret");
		
		String result = client.performConnectionTest();
		System.out.println("Connection test result: " + result);
		
	}
	
}
