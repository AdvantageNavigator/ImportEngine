package com.siemens.eadvantage.ie.types;

public enum SplitMethod {

	LINEAR(1),
	FORECAST(2),
	KEY(3),
	NONE(4);
	
	private final int id;
    
    private SplitMethod(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
