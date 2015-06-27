package com.siemens.eadvantage.ie.types;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestDeviceStatusClass {

	@Test
	public void testStringValues() {
		DeviceStatusClass status = DeviceStatusClass.OK;	
		assertThat(status.toString(), is("OK"));
		
		status = DeviceStatusClass.WARNING;
		assertThat(status.toString(), is("WARNING"));
		
		status = DeviceStatusClass.ERROR;
		assertThat(status.toString(), is("ERROR"));
	}

}
