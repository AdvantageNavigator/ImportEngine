package com.siemens.eadvantage.ie.types;

/**
 * Stores a single meter reading .
 * 
 * @author Mike Pichler
 *
 */
public class MeterReading implements DataLine {

	// required fields
	private final String dataSource;
	private final DateTime dateTime;
	private final double value;
	
	// optional fields
	private QualityAttribute qualityAttribute = null;
	private String description = null;
	private DateTime beginDate = null;
	
	/**
	 * 
	 * @param dataSource the ID string that uniquely identifies the datasource of the meter with 1-255 characters
	 * @param dateTime the date and time of the meter reading (Reading Date in the Advantage Navigator web front-end), not before '01/01/1950 00:00:00'
	 * @param value the value of the meter reading
	 */
	public MeterReading(String dataSource, DateTime dateTime, double value) {
	
		if(dataSource == null) throw new IllegalArgumentException("dataSource must not be null");
		if(dataSource.length()<1||dataSource.length()>255) throw new IllegalArgumentException("dataSource length must be 1-255 characters");
		this.dataSource = dataSource;
		
		if(dateTime == null) throw new IllegalArgumentException("dateTime must not be null");
		this.dateTime = dateTime;
		
		this.value = value;
	}
	
	
	public QualityAttribute getQualityAttribute() {
		return qualityAttribute;
	}

	/**
	 * 
	 * @param qualityAttribute the qualityAttribute is a bit mask that can be obtained by applying 
	 * the Boolean OR operation to respective attribute values or <code>null</code>
	 */
	public void setQualityAttribute(QualityAttribute qualityAttribute) {
		this.qualityAttribute = qualityAttribute;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description an arbitrary description with 0-1024 characters or <code>null</code>
	 */
	public void setDescription(String description) {
		if(description != null && description.length()>1024) throw new IllegalArgumentException("description must have 0-1024 characters");
		this.description = description;
	}

	public DateTime getBeginDate() {
		return beginDate;
	}

	/**
	 * 
	 * @param beginDate the begin date and time of the meter reading period, not before '01/01/1950 00:00:00' or <code>null</code>
	 */
	public void setBeginDate(DateTime beginDate) {
		this.beginDate = beginDate;
	}

	public String getDataSource() {
		return dataSource;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String getDataLine(char delimiter) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(dataSource);
		builder.append(delimiter);
		builder.append(dateTime.getUTCString());
		builder.append(delimiter);
		builder.append(Double.toString(value));
		
		if(qualityAttribute != null) {
			builder.append(delimiter);
			builder.append(qualityAttribute.getValue());
		}
		
		if(description != null) {
			builder.append(delimiter);
			builder.append(description);
		}
		
		if(beginDate != null) {
			builder.append(delimiter);
			builder.append(beginDate.getUTCString());
		}
		
		return builder.toString();
	}


	@Override
	public String getOptionalColumnList() {
		
		boolean firstColumn = true;
		StringBuilder builder = new StringBuilder();
		
		if(this.qualityAttribute != null) {
			builder.append("qualityAttribute");
			firstColumn = false;
		}
		
		if(this.description != null) {
			if(!firstColumn) builder.append(",");
			builder.append("description");
			firstColumn = false;
		}
		
		if(this.beginDate != null) {
			if(!firstColumn) builder.append(",");
			builder.append("beginDate");
		}
		
		return builder.toString();
	}
	
}
