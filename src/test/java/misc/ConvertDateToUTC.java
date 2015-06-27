package misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConvertDateToUTC {
	
	public static void main(String[] args) throws ParseException {
		
		Date local = new Date();
		SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		SimpleDateFormat localFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Date utc = localFormatter.parse(utcFormatter.format(local));
		
		System.out.println("Local time: " + local.toString());
		System.out.println("UTC time: " + utc.toString());
		
	}
	
}
