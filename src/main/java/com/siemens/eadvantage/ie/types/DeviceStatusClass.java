package com.siemens.eadvantage.ie.types;

public enum DeviceStatusClass {
	
	OK(0),
	WARNING(1),
	ERROR(2);
	
	private final int id;
    
    private DeviceStatusClass(int id) { this.id = id; }
    
    public int getValue() { return id; }
	
}
