package com.siemens.eadvantage.ie.types;


public enum DisplayMode {
	
	METER_READING(1),
	INCREMENTAL(2);
	
	private final int id;
    
    private DisplayMode(int id) { this.id = id; }
    
    public int getValue() { return id; }
	
}
