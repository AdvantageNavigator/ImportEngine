package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The METER_DEACTIVATE command deactivates the specified meter. This command only greys out the meter in the Advantage Navigator web front-end, but does not prevent the import of further meter readings. 
 * Note: The deactivation of a meter is irreversible. <i>(Source: import engine documentation)</i>
 * 
 * @author Mike Pichler
 *
 */
public class MeterDeactivateCommand extends Command {

	private final String datasource;
	
	/**
	 * 
	 * @param datasource the ID string that uniquely identifies the datasource of the meter
	 */
	public MeterDeactivateCommand(final String datasource) {
		
		if(datasource == null) throw new IllegalArgumentException("datasource must not be null");
		if(datasource.length()<1||datasource.length()>255) throw new IllegalArgumentException("datasource length must be 1-255 characters");
		
		this.datasource = datasource;
	}
	
	@Override
	public File createUploadFile() throws IOException {
		
		File uploadFile = File.createTempFile("AdvantageNavigator", "upload");
		
		PrintWriter writer = new PrintWriter(uploadFile, "UTF-8");	
		writer.println("command=METER_DEACTIVATE");
		writer.println(datasource);
		writer.flush();
		writer.close();
		
		return uploadFile;
	}

	public String getDatasource() {
		return datasource;
	}
	
}
