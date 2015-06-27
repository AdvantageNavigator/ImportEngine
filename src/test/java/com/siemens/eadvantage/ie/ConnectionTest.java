package com.siemens.eadvantage.ie;

import java.io.IOException;

public class ConnectionTest {
	
	public static void main(String[] args) throws IOException {
		
		ImportEngineClient client = new ImportEngineClient("Testdevice1.0", "Testdevice1.0");
		
		String result = client.performConnectionTest();
		System.out.println("Connection test result: " + result);
		
	}
	
}
