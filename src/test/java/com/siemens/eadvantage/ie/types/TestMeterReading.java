package com.siemens.eadvantage.ie.types;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestMeterReading {

	@Test
	public void testOptionalColumnsList() {
		
		MeterReading reading = new MeterReading("test", new DateTime(new Date()), 10.0d);
		assertThat(reading.getOptionalColumnList(), is(""));
		
		reading.setDescription("description");
		assertThat(reading.getOptionalColumnList(), is("description"));
		
		reading.setQualityAttribute(new QualityAttribute());
		assertThat(reading.getOptionalColumnList(), is("qualityAttribute,description"));
		
		reading.setBeginDate(new DateTime(new Date()));
		assertThat(reading.getOptionalColumnList(), is("qualityAttribute,description,beginDate"));
	}
	
}
