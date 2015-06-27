package com.siemens.eadvantage.ie.types;

/**
 * Stores the current device status.
 * 
 * @author Mike Pichler
 *
 */
public class DeviceStatus implements DataLine {
	
	private final DeviceStatusClass statusClass;
	private final String statusText;
	private final String version;
	
	/**
	 * Constructs a new <code>DeviceStatus</code> instance with the specified arguments. None
	 * of the arguments is allowed to be <code>null</code> (otherwise, an <i>IllegalArgumentException</i> will
	 * be thrown).
	 * 
	 * @param statusClass the status class that the status text belongs to
	 * @param statusText an arbitrary status text with 1-50 characters
	 * @param version the version information of the device with 1-1024 characters
	 */
	public DeviceStatus(DeviceStatusClass statusClass, String statusText, String version) {		
		if(statusClass == null) throw new IllegalArgumentException("statusClass must not be null");
		this.statusClass = statusClass;
		
		if(statusText == null) throw new IllegalArgumentException("statusText must not be null");
		if(statusText.length()<1||statusText.length()>50) throw new IllegalArgumentException("statusText length must be 1-50 characters");
		this.statusText = statusText;
		
		if(version == null) throw new IllegalArgumentException("version must not be null");
		if(version.length()<1||version.length()>1024) throw new IllegalArgumentException("version length must be 1-1024 characters");
		this.version = version;
	}

	public DeviceStatusClass getStatusClass() {
		return statusClass;
	}

	public String getStatusText() {
		return statusText;
	}

	public String getVersion() {
		return version;
	}
	
	@Override
	public String toString() {
		return statusClass.toString() + "," + statusText + "," + version;
	}
	
	@Override
	public String getDataLine(char delimiter) {
		return statusClass.toString() + delimiter + statusText + delimiter + version;
	}

	@Override
	public String getOptionalColumnList() {
		return ""; // no optional columns
	}

}
