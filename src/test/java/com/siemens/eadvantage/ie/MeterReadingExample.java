package com.siemens.eadvantage.ie;

import java.io.IOException;
import java.text.ParseException;

import com.siemens.eadvantage.ie.command.MeterReadingCommand;
import com.siemens.eadvantage.ie.types.DateTime;
import com.siemens.eadvantage.ie.types.MeterReading;

public class MeterReadingExample {

	public static void main(String[] args) throws ParseException, IOException {
		
		ImportEngineClient client = new ImportEngineClient("user", "secret");
		
		MeterReading reading1 = new MeterReading("meter_001", new DateTime("01/01/2015 12:00:00"), 10.0);
		MeterReading reading2 = new MeterReading("meter_001", new DateTime("01/01/2015 13:00:00"), 11.0);
		MeterReading reading3 = new MeterReading("meter_001", new DateTime("01/01/2015 14:00:00"), 12.0);
		
		MeterReadingCommand command = new MeterReadingCommand();
		command.addMeterReading(reading1);
		command.addMeterReading(reading2);
		command.addMeterReading(reading3);
		
		command.setOptionalColumns(true, false, false);
		
		System.out.println("Executing meter reading command...");
		String result = client.executeCommand(command);
		
		System.out.println("Result: " + result);
		
	}

}
