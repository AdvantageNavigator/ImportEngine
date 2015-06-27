package com.siemens.eadvantage.ie.types;

public enum ManualRead {
	
	AUTOMATIC(0),
	MANUAL(1),
	VIRTUAL(2);
	
	private final int id;
    
    private ManualRead(int id) { this.id = id; }
    
    public int getValue() { return id; }
}
