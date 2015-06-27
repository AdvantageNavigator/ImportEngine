package com.siemens.eadvantage.ie;

import java.io.IOException;

import com.siemens.eadvantage.ie.command.DeviceStatusCommand;
import com.siemens.eadvantage.ie.types.DeviceStatus;
import com.siemens.eadvantage.ie.types.DeviceStatusClass;

public class DeviceStatusExample {

	public static void main(String[] args) throws IOException {
		
		ImportEngineClient client = new ImportEngineClient("user", "secret");
		
		DeviceStatus status = new DeviceStatus(DeviceStatusClass.OK, "Device up and running", "1.1");
		DeviceStatusCommand command = new DeviceStatusCommand(status);
		
		String result = client.executeCommand(command);
		System.out.println("Device status result: " + result);

	}

}
