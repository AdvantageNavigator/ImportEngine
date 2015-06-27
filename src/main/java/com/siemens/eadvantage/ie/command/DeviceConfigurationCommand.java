package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.siemens.eadvantage.ie.types.DeviceConfiguration;

public class DeviceConfigurationCommand extends Command {

	private DeviceConfiguration configuration = null;
	
	public DeviceConfigurationCommand(DeviceConfiguration configuration) {
		this.configuration = configuration;
	}
	
	@Override
	public File createUploadFile() throws IOException {
		
		File uploadFile = File.createTempFile("AdvantageNavigator", "upload");
		
		PrintWriter writer = new PrintWriter(uploadFile, "UTF-8");
		writer.println("command=DEVICE_CONFIGURATION filename=" + configuration.getFilename());
		writer.print(configuration.getContent());
		writer.flush();
		writer.close();
		
		return uploadFile;
	}
	
}
