package com.siemens.eadvantage.ie.types;

public enum AlarmPriority {
	
	LOW(0),
	MEDIUM(1),
	HIGH(2),
	CRITICAL(3);
	
	private final int id;
    
    private AlarmPriority(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
