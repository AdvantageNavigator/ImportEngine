package com.siemens.eadvantage.ie.types;

/**
 * Meter reading quality flags.
 * 
 * @author Mike Pichler
 *
 */
public enum QualityFlag {

	/**
	 * There are no known issues with this reading
	 */
	GOOD(1),
	
	/**
	 * The meter does not deliver a reading
	 */
	NO_VALUE(2),
	
	/**
	 * Power Outage in retrieval cycle of meter
	 */
	POWER_OUTAGE(4),
	
	/**
	 * Original Value was overwritten
	 */
	MODIFIED(8),
	
	/**
	 * There is a hardware fault in the respective data retrieval cycle of the meter
	 */
	HARDWARE_FAULT(16),
	
	/**
	 * This reading is an automatic reading
	 */
	AUTOMATIC_VALUE(32),
	
	/**
	 * Is an unknown error code on the data retrieval side
	 */
	UNKNOWN(64),
	
	/**
	 * The consumption is a negative value
	 */
	NEGATIVE_VALUE(4096),
	
	/**
	 * For this reading 0 was retrieved
	 */
	NULL_VALUE(8192),
	
	/**
	 * This reading is not measured but represents an estimation
	 */
	ESTIMATED(16384);
	
	private final int id;
    
    private QualityFlag(int id) { this.id = id; }
    
    public int getValue() { return id; }
	
}
