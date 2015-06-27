package com.siemens.eadvantage.ie.types;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestQualityAttribute {

	@Test
	public void testGetValue() {
		
		QualityAttribute quality = new QualityAttribute();
		quality.getQualityFlags().add(QualityFlag.GOOD);
		quality.getQualityFlags().add(QualityFlag.AUTOMATIC_VALUE);
		
		// int value = quality.getValue();	// returns 33
		
		assertThat(quality.getValue(), is(33));	
	}

}
