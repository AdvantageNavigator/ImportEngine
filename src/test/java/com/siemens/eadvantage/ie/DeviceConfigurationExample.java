package com.siemens.eadvantage.ie;

import java.io.IOException;

import com.siemens.eadvantage.ie.command.DeviceConfigurationCommand;
import com.siemens.eadvantage.ie.types.DeviceConfiguration;

public class DeviceConfigurationExample {

	public static void main(String[] args) throws IOException {
		
		ImportEngineClient client = new ImportEngineClient("user", "secret");
		
		String content = String.format("property1 = value1%nproperty2 = value2%nproperty3 = value3");
		DeviceConfiguration config = new DeviceConfiguration("anotherfile.properties", content);
		DeviceConfigurationCommand command = new DeviceConfigurationCommand(config);
		
		String result = client.executeCommand(command);

		
		System.out.println("Got result " + result);
		
	}

}
