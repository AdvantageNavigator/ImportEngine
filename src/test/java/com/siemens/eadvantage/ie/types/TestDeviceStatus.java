package com.siemens.eadvantage.ie.types;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDeviceStatus {

	@Test
	public void testGetDataLine() {	
		DeviceStatus status = new DeviceStatus(DeviceStatusClass.OK, "Device OK", "1.0");
		assertThat(status.getDataLine(','), is("OK,Device OK,1.0"));
	}

}
