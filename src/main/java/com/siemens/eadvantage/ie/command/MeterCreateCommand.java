package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.siemens.eadvantage.ie.types.Meter;

public class MeterCreateCommand extends Command {

	private final Meter meter;
	
	public MeterCreateCommand(final Meter meter) {
		this.meter = meter;
	}
	
	@Override
	public File createUploadFile() throws IOException {
		
		File uploadFile = File.createTempFile("AdvantageNavigator", "upload");
		
		PrintWriter writer = new PrintWriter(uploadFile, "UTF-8");
		
		String header = "command=METER_CREATE delimiter=" + getDelimiter();
		if(!meter.getOptionalColumnList().equals("")) {
			header = header + " optionalColumnList=" + meter.getOptionalColumnList();
		}
		writer.println(header);
		writer.print(meter.getDataLine(getDelimiter()));
		writer.flush();
		writer.close();
		
		return uploadFile;
		
	}

	public Meter getMeter() {
		return meter;
	}
	
}
