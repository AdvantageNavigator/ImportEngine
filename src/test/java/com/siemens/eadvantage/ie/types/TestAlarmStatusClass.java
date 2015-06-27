package com.siemens.eadvantage.ie.types;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlarmStatusClass {

	@Test
	public void testValues() {
		AlarmStatusClass alarm = AlarmStatusClass.NORMAL;
		assertThat(alarm.getValue(), is(0));
		
		alarm = AlarmStatusClass.NORMAL_UNACKNOWLEDGED;
		assertThat(alarm.getValue(), is(1));
		
		alarm = AlarmStatusClass.NORMAL_UNRESETED;
		assertThat(alarm.getValue(), is(2));
		
		alarm = AlarmStatusClass.ALARM_ACKNOWLEDGED;
		assertThat(alarm.getValue(), is(3));
		
		alarm = AlarmStatusClass.ALARM_UNACKNOWLEDGED;
		assertThat(alarm.getValue(), is(4));
		
		alarm = AlarmStatusClass.UNKNOWN;
		assertThat(alarm.getValue(), is(5));
	}

}
