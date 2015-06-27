package com.siemens.eadvantage.ie.types;

/**
 * Stores a device configuration.
 * 
 * @author Mike Pichler
 *
 */
public class DeviceConfiguration {
	
	private final String filename;
	private final String content;
	
	/**
	 * Constructs a new <code>DeviceConfiguration</code> instance with the specified arguments. None
	 * of the arguments is allowed to be <code>null</code> (otherwise, an <i>IllegalArgumentException</i> will
	 * be thrown).
	 * 
	 * @param filename the filename for the configuration file with 1-255 characters. This file name will be shown in the Advantage Navigator application
	 * @param content the content of the configuration file with at least 1 character. The imported file can be downloaded in the Advantage Navigator application
	 */
	public DeviceConfiguration(String filename, String content) {
		if(filename == null) throw new IllegalArgumentException("filename must not be null");
		if(filename.length()<1||filename.length()>255) throw new IllegalArgumentException("filename length must be 1-255 characters");
		this.filename = filename;
		
		if(content == null) throw new IllegalArgumentException("content must not be null");
		if(content.length()<1) throw new IllegalArgumentException("content length must be 1-2.147.483.647");
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return content;
	}
}
