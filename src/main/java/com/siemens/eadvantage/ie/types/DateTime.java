package com.siemens.eadvantage.ie.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Stores a local date/time and provides conversion to UTC.
 * 
 * @author Mike Pichler
 *
 */
public class DateTime {
	
	private final SimpleDateFormat utcFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private final SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	private Date localDate = null;
	
	public DateTime(Date localDateTime) {
		
		try {
			Date firstDate = dateParser.parse("01/01/1950 00:00:00");
			if(getUTCDate(localDateTime).before(firstDate)) throw new IllegalArgumentException("localDateTime must not be before '01/01/1950 00:00:00'");
		} catch (ParseException ignore) {
			throw new AssertionError();	// cannot happen
		}
		
		this.localDate = localDateTime;
	}
	
	/**
	 * 
	 * @param localDateTime value with format MM/dd/yyyy HH:mm:ss
	 * @throws ParseException if the beginning of the specified string cannot be parsed
	 */
	public DateTime(String localDateTime) throws ParseException {
		Date date = dateParser.parse(localDateTime);
		Date firstDate = dateParser.parse("01/01/1950 00:00:00");
		if(getUTCDate(date).before(firstDate)) throw new IllegalArgumentException("localDateTime must not be before '01/01/1950 00:00:00'");
		this.localDate = date;
	}
	
	private Date getUTCDate(Date local) {
		try {
			return dateParser.parse(utcFormatter.format(local));
		} catch (ParseException ignore) {
			throw new AssertionError();	// cannot happen
		}
	}
	
	public Date getUTCDate() {
		return getUTCDate(localDate);
	}
	
	public String getUTCString() {
		return utcFormatter.format(localDate);
	}

	public Date getLocalDate() {
		return localDate;
	}
	
}
