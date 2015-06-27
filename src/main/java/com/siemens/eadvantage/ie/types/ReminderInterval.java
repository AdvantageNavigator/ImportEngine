package com.siemens.eadvantage.ie.types;

public enum ReminderInterval {

	ONE_WEEK(13),
	ONE_MONTH(15),
	THREE_MONTHS(17),
	TWO_MONTHS(21);
	
	private final int id;
    
    private ReminderInterval(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
