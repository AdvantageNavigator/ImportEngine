package com.siemens.eadvantage.ie.types;

public enum AlarmStatusClass {
	
	NORMAL(0),
	NORMAL_UNACKNOWLEDGED(1),
	NORMAL_UNRESETED(2),
	ALARM_ACKNOWLEDGED(3),
	ALARM_UNACKNOWLEDGED(4),
	UNKNOWN(5);
	
	private final int id;
    
    private AlarmStatusClass(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
