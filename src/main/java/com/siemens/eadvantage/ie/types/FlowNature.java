package com.siemens.eadvantage.ie.types;

public enum FlowNature {

	OTHER_METER(0),
	MAIN_METER(2),
	SUB_METER(4),
	BILLING_METER(128);
	
	private final int id;
    
    private FlowNature(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
