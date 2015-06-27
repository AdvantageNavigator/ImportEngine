package com.siemens.eadvantage.ie;

import java.io.IOException;
import java.util.Date;

import com.siemens.eadvantage.ie.command.MeterCreateCommand;
import com.siemens.eadvantage.ie.types.DateTime;
import com.siemens.eadvantage.ie.types.Meter;

public class MeterCreateExample {

	public static void main(String[] args) throws IOException {
		
		ImportEngineClient client = new ImportEngineClient("user", "secret");
		
		Meter meter = new Meter("test_meter_01", "Testmeter", new DateTime(new Date()), 2, 1, 18);
		meter.setParentNodeId(1234);
		
		MeterCreateCommand command = new MeterCreateCommand(meter);
		System.out.println("Result: " + client.executeCommand(command));

	}

}
