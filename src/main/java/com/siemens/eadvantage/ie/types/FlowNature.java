package com.siemens.eadvantage.ie.types;

/**
 * Type of meter (Meter Type in the Advantage Navigator web front-end).
 * 
 * @author Mike Pichler
 *
 */
public enum FlowNature {

	OTHER_METER(0),
	MAIN_METER(2),
	SUB_METER(4),
	BILLING_METER(128);
	
	private final int id;
    
    private FlowNature(int id) { this.id = id; }
    
    /**
     * Gets the numeric value of the enumeration choice according to the IE documentation.
     * 
     * @return the numeric value of the enumeration choice
     */
    public int getValue() { return id; }
}
