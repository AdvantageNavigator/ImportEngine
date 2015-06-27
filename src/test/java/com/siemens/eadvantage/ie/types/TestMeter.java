package com.siemens.eadvantage.ie.types;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class TestMeter {

	private Meter instance;
	
	@Test
	public void testGetOptionalColumnList() {
		
		DateTime startDateTime = new DateTime(new Date());
		instance = new Meter("testSoure", "testMeter", startDateTime, 0, 0, 0);
		assertThat(instance.getOptionalColumnList(), is(""));
		
		// spot checks
		instance.setDeltaMin(1.2d);
		assertThat(instance.getOptionalColumnList(), is("deltaMin"));
		
		instance.setManualRead(ManualRead.VIRTUAL);
		assertThat(instance.getOptionalColumnList(), is("deltaMin,manualRead"));
	}

}
