package com.siemens.eadvantage.ie.types;

import java.util.EnumSet;

public class QualityAttribute {
	
	private final EnumSet<QualityFlag> qualityFlags = EnumSet.noneOf(QualityFlag.class);

	public EnumSet<QualityFlag> getQualityFlags() {
		return qualityFlags;
	}
	
	/**
	 * Gets the bitmask value of all flags set.
	 * 
	 * @return
	 */
	public int getValue() {
		
		if(qualityFlags.isEmpty()) return 0;
		
		int value = 0;
		for (QualityFlag flag : qualityFlags) {
			value += flag.getValue();
		}
		
		return value;
	}
}
