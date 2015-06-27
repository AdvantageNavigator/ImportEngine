package com.siemens.eadvantage.ie.types;

public enum CompressFunction {

	MAXIMUM(20),
	MINIMUM(30),
	AVERAGE(40),
	TOTAL(70),
	RELATED_MAXIMUM(80);
	
	private final int id;
    
    private CompressFunction(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
