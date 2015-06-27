package com.siemens.eadvantage.ie.types;

public enum AlarmCategory {
	
	TEST_A(1),
	TEST_B(2),
	TEST_C(3),
	EXCLUSION(4),
	FAULT(5),
	ALARM(6),
	SEVERE_ALARM(7),
	EXTERNAL_ALARM(8),
	AUTO_EXT_RELEASE_OFF(9),
	TEST_ALARM(10);

    private final int id;
    
    private AlarmCategory(int id) { this.id = id; }
    
    public int getValue() { return id; }
    
}
