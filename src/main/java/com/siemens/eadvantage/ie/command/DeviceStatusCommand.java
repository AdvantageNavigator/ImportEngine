package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.siemens.eadvantage.ie.types.DeviceStatus;

public class DeviceStatusCommand extends Command {

	private DeviceStatus status;
	
	public DeviceStatusCommand(DeviceStatus status) {
		this.status = status;
		setDelimiter(',');	// default delimiter for device status
	}
	
	@Override
	public File createUploadFile() throws IOException {		
		
		File uploadFile = File.createTempFile("AdvantageNavigator", "upload");
		
		PrintWriter writer = new PrintWriter(uploadFile, "UTF-8");	
		writer.println("command=DEVICE_STATUS delimiter=" + getDelimiter());
		writer.println(status.getDataLine(getDelimiter()));
		writer.flush();
		writer.close();
		
		return uploadFile;
	}

	public DeviceStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceStatus status) {
		if(status == null) throw new IllegalArgumentException("status must not be null");
		this.status = status;
	}
	
}
