package com.siemens.eadvantage.ie.types;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlarmCategory {

	@Test
	public void testValues() {
		
		AlarmCategory cat = AlarmCategory.TEST_A;
		assertThat(cat.getValue(), is(1));
		
		cat = AlarmCategory.TEST_B;
		assertThat(cat.getValue(), is(2));
		
		cat = AlarmCategory.TEST_C;
		assertThat(cat.getValue(), is(3));
		
		cat = AlarmCategory.EXCLUSION;
		assertThat(cat.getValue(), is(4));
		
		cat = AlarmCategory.FAULT;
		assertThat(cat.getValue(), is(5));
		
		cat = AlarmCategory.ALARM;
		assertThat(cat.getValue(), is(6));
		
		cat = AlarmCategory.SEVERE_ALARM;
		assertThat(cat.getValue(), is(7));
		
		cat = AlarmCategory.EXTERNAL_ALARM;
		assertThat(cat.getValue(), is(8));
		
		cat = AlarmCategory.AUTO_EXT_RELEASE_OFF;
		assertThat(cat.getValue(), is(9));
		
		cat = AlarmCategory.TEST_ALARM;
		assertThat(cat.getValue(), is(10));
	}	
}
