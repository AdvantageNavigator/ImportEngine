package com.siemens.eadvantage.ie.types;

public enum CompressInterval {

	ONE_MINUTE(10),
	FIVE_MINUTES(20),
	FIFTEEN_MINUTES(40),
	THIRTY_MINUTES(50),
	ONE_HOUR(60),
	ONE_DAY(70);
	
	private final int id;
    
    private CompressInterval(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
