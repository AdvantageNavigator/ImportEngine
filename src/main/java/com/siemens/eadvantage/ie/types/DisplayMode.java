package com.siemens.eadvantage.ie.types;

/**
 * Specifies how a meter reading must be interpreted.
 * 
 * @author Mike Pichler
 *
 */
public enum DisplayMode {
	
	/**
	 * Meter reading (standard meter reading) 
	 */
	METER_READING(1),
	
	/**
	 * Incremental (meter measures the consumption from reading to reading and is therefore reset after each reading)
	 */
	INCREMENTAL(2);
	
	private final int id;
    
    private DisplayMode(int id) { this.id = id; }
    
    /**
     * Gets the numeric value of the enumeration choice according to the IE documentation.
     * 
     * @return the numeric value of the enumeration choice
     */
    public int getValue() { return id; }
	
}
