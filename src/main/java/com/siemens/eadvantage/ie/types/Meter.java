package com.siemens.eadvantage.ie.types;

import static com.siemens.eadvantage.util.ArgumentValidationUtils.*;

/**
 * This class stores a meter used for the METER_CREATE command.
 * 
 * @author Mike Pichler
 *
 */
public class Meter implements DataLine {

	private final String datasource;
	private final String meterName;
	private final DateTime startDateTime;
	private final Integer valueType;
	private final Integer medium;
	private final Integer unit;
	
	// optional attributes
	private DisplayMode displayMode = null;
	private Double startValue = null;
	private FlowNature flownature = null;
	private Boolean isActive = null;
	private Double readingOffset = null;
	private Double readingFactor = null;
	private Double deltaMax = null;
	private Double deltaMin = null;
	private Double maxMeterValue = null;
	private CompressFunction compressFunction = null;
	private CompressInterval compressInterval = null;
	private ManualRead manualRead = null;
	private String supplierId = null;
	private Integer parentNodeId = null;
	private String comment = null;
	private String location = null;
	private ReminderInterval reminderInterval = null;
	private Boolean allowNegativeValues = null;
	private Boolean allowNullValues = null;
	private Boolean missingAlarms = null;
	private SplitMethod splitMethod = null;
	private String vendor = null;
	private String account = null;
	private String rateClass = null;
	
	/**
	 * Creates a new <code>Meter</code> instance with the specified mandatory arguments. For possible values
	 * of <code>valueType</code>, <code>medium</code> and <code>unit</code> see the <a href="https://eadvantage.siemens.com/ieg/docs/documentation.jsp">Import Engine documentation</a>.
	 * 
	 * @param datasource an ID string that uniquely identifies a data source with 1-255 characters
	 * @param meterName the display name of the meter in the Advantage Navigator web front-end with 1-255 characters
	 * @param startDateTime the local date and time of the earliest acceptable meter reading (Valid From in the Advantage Navigator web front-end), not before '01/01/1950 00:00:00'
	 * @param valueType indicates the purpose the measured resource is used for (Media Group in the Advantage Navigator web front-end)
	 * @param medium indicates the type of resource that is measured (Medium in the Advantage Navigator web front-end)
	 * @param unit indicates the unit the resource is measuerd in (Unit in the Advantage Navigator web front-end)
	 */
	public Meter(final String datasource, final String meterName, final DateTime startDateTime, final Integer valueType,
			final Integer medium, final Integer unit) {
		
		validateStringArgument(datasource, 1, 255);
		validateStringArgument(meterName, 1, 255);
		validateNotNull(startDateTime);
		validateNotNull(valueType);
		validateNotNull(medium);
		validateNotNull(unit);
		
		this.datasource = datasource;
		this.meterName = meterName;
		this.startDateTime = startDateTime;
		this.valueType = valueType;
		this.medium = medium;
		this.unit = unit;		
	}
	
	@Override
	public String getDataLine(char delimiter) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(datasource);
		builder.append(delimiter);
		
		builder.append(meterName);
		builder.append(delimiter);
		
		builder.append(startDateTime.getUTCString());
		builder.append(delimiter);
		
		builder.append(valueType.toString());
		builder.append(delimiter);
		
		builder.append(medium.toString());
		builder.append(delimiter);
		
		builder.append(unit.toString());
		
		if(displayMode != null) {
			builder.append(delimiter);
			builder.append(displayMode.getValue());
		}
		
		if(startValue != null) {
			builder.append(delimiter);
			builder.append(startValue);
		}
		
		if(flownature != null) {
			builder.append(delimiter);
			builder.append(flownature.getValue());
		}
		
		if(isActive != null) {
			builder.append(delimiter);
			builder.append(getIntValue(isActive));
		}
		
		if(readingOffset != null) {
			builder.append(delimiter);
			builder.append(readingOffset);
		}
		
		if(readingFactor != null) {
			builder.append(delimiter);
			builder.append(readingFactor);
		}
		
		if(deltaMax != null) {
			builder.append(delimiter);
			builder.append(deltaMax);
		}
		
		if(deltaMin != null) {
			builder.append(delimiter);
			builder.append(deltaMin);
		}
		
		if(maxMeterValue != null) {
			builder.append(delimiter);
			builder.append(maxMeterValue);
		}
		
		if(compressFunction != null) {
			builder.append(delimiter);
			builder.append(compressFunction.getValue());
		}
		
		if(compressInterval != null) {
			builder.append(delimiter);
			builder.append(compressInterval.getValue());
		}
		
		if(manualRead != null) {
			builder.append(delimiter);
			builder.append(manualRead.getValue());
		}
		
		if(supplierId != null) {
			builder.append(delimiter);
			builder.append(supplierId);
		}
		
		if(parentNodeId != null) {
			builder.append(delimiter);
			builder.append(parentNodeId);
		}
		
		if(comment != null) {
			builder.append(delimiter);
			builder.append(comment);
		}
		
		if(location != null) {
			builder.append(delimiter);
			builder.append(location);
		}
		
		if(reminderInterval != null) {
			builder.append(delimiter);
			builder.append(reminderInterval.getValue());
		}
		
		if(allowNegativeValues != null) {
			builder.append(delimiter);
			builder.append(getIntValue(allowNegativeValues));
		}
		
		if(allowNullValues != null) {
			builder.append(delimiter);
			builder.append(getIntValue(allowNullValues));
		}
		
		if(missingAlarms != null) {
			builder.append(delimiter);
			builder.append(getIntValue(missingAlarms));
		}
		
		if(splitMethod != null) {
			builder.append(delimiter);
			builder.append(splitMethod.getValue());
		}
		
		if(vendor != null) {
			builder.append(delimiter);
			builder.append(vendor);
		}
		
		if(account != null) {
			builder.append(delimiter);
			builder.append(account);
		}
		
		if(rateClass != null) {
			builder.append(delimiter);
			builder.append(rateClass);
		}
		
		return builder.toString();
	}

	@Override
	public String getOptionalColumnList() {
		
		boolean firstColumn = true;
		StringBuilder builder = new StringBuilder();
		
		if(this.displayMode != null) {
			builder.append("displayMode");
			firstColumn = false;
		}
		
		if(this.startValue != null) {
			if(!firstColumn) builder.append(",");
			builder.append("startValue");
			firstColumn = false;
		}
		
		if(this.flownature != null) {
			if(!firstColumn) builder.append(",");
			builder.append("flownature");
			firstColumn = false;
		}
		
		if(this.isActive != null) {
			if(!firstColumn) builder.append(",");
			builder.append("bActive");
			firstColumn = false;
		}
		
		if(this.readingOffset != null) {
			if(!firstColumn) builder.append(",");
			builder.append("readingOffset");
			firstColumn = false;
		}
		
		if(this.readingFactor != null) {
			if(!firstColumn) builder.append(",");
			builder.append("readingFactor");
			firstColumn = false;
		}
		
		if(this.deltaMax != null) {
			if(!firstColumn) builder.append(",");
			builder.append("deltaMax");
			firstColumn = false;
		}
		
		if(this.deltaMin != null) {
			if(!firstColumn) builder.append(",");
			builder.append("deltaMin");
			firstColumn = false;
		}
		
		if(this.maxMeterValue != null) {
			if(!firstColumn) builder.append(",");
			builder.append("maxMeterValue");
			firstColumn = false;
		}
		
		if(this.compressFunction != null) {
			if(!firstColumn) builder.append(",");
			builder.append("compressFunction");
			firstColumn = false;
		}
		
		if(this.compressInterval != null) {
			if(!firstColumn) builder.append(",");
			builder.append("compressInterval");
			firstColumn = false;
		}
		
		if(this.manualRead != null) {
			if(!firstColumn) builder.append(",");
			builder.append("manualRead");
			firstColumn = false;
		}
		
		if(this.supplierId != null) {
			if(!firstColumn) builder.append(",");
			builder.append("supplierId");
			firstColumn = false;
		}
		
		if(this.parentNodeId != null) {
			if(!firstColumn) builder.append(",");
			builder.append("parentNodeId");
			firstColumn = false;
		}
		
		if(this.comment != null) {
			if(!firstColumn) builder.append(",");
			builder.append("comment");
			firstColumn = false;
		}
		
		if(this.location != null) {
			if(!firstColumn) builder.append(",");
			builder.append("location");
			firstColumn = false;
		}
		
		if(this.reminderInterval != null) {
			if(!firstColumn) builder.append(",");
			builder.append("reminderInterval");
			firstColumn = false;
		}
		
		if(this.allowNegativeValues != null) {
			if(!firstColumn) builder.append(",");
			builder.append("allowNegativeValues");
			firstColumn = false;
		}
		
		if(this.allowNullValues != null) {
			if(!firstColumn) builder.append(",");
			builder.append("allowNullValues");
			firstColumn = false;
		}
		
		if(this.missingAlarms != null) {
			if(!firstColumn) builder.append(",");
			builder.append("missingAlarms");
			firstColumn = false;
		}
		
		if(this.splitMethod != null) {
			if(!firstColumn) builder.append(",");
			builder.append("splitMethod");
			firstColumn = false;
		}
		
		if(this.vendor != null) {
			if(!firstColumn) builder.append(",");
			builder.append("vendor");
			firstColumn = false;
		}
		
		if(this.account != null) {
			if(!firstColumn) builder.append(",");
			builder.append("account");
			firstColumn = false;
		}
		
		if(this.rateClass != null) {
			if(!firstColumn) builder.append(",");
			builder.append("rateClass");
		}
		
		return builder.toString();
	}

	/**
	 * Gets the specified display mode or <code>null</code>, if the optional attribute is not set.
	 * 
	 * @return the specified display mode
	 */
	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	/**
	 * Specifies how the meter reading must be interpreted.
	 * 
	 * @param displayMode
	 */
	public void setDisplayMode(DisplayMode displayMode) {
		this.displayMode = displayMode;
	}

	/**
	 * Gets the starting value for the meter when it is created.
	 * 
	 * @return the starting value for the meter when it is created
	 */
	public Double getStartValue() {
		return startValue;
	}

	/**
	 * Sets the starting value for the meter when it is created.
	 * 
	 * @param startValue the starting value for the meter when it is created
	 */
	public void setStartValue(Double startValue) {
		this.startValue = startValue;
	}

	/**
	 * Gets the type of the meter (Meter Type in the Advantage Navigator web front-end).
	 * 
	 * @return the type of the meter
	 */
	public FlowNature getFlownature() {
		return flownature;
	}

	/**
	 * Sets the type of the meter (Meter Type in the Advantage Navigator web front-end).
	 * 
	 * @param flownature the type of the meter
	 */
	public void setFlownature(FlowNature flownature) {
		this.flownature = flownature;
	}

	/**
	 * Indicates whether or not the meter is active.
	 * @return
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Indicates whether or not the meter is active.
	 * 
	 * @param isActive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Specifies an offset that is added to each meter reading in order to compute the actual meter reading.
	 * 
	 * @return
	 */
	public Double getReadingOffset() {
		return readingOffset;
	}

	/**
	 * Specifies an offset that is added to each meter reading in order to compute the actual meter reading.
	 * 
	 * @param readingOffset
	 */
	public void setReadingOffset(Double readingOffset) {
		this.readingOffset = readingOffset;
	}

	/**
	 * Specifies a factor each meter reading is multiplied with. (e.g. if meter only measures thousands of units, the factor to be apllied to get to units will be 1000.0)
	 * @return
	 */
	public Double getReadingFactor() {
		return readingFactor;
	}

	/**
	 * Specifies a factor each meter reading is multiplied with. (e.g. if meter only measures thousands of units, the factor to be apllied to get to units will be 1000.0)
	 * @param readingFactor
	 */
	public void setReadingFactor(Double readingFactor) {
		this.readingFactor = readingFactor;
	}

	/**
	 * Specifies the maximum reading value deviation permitted for the meter. Shown as "Alarm level" in Advantage Navigator.
	 * @return
	 */
	public Double getDeltaMax() {
		return deltaMax;
	}

	/**
	 * Specifies the maximum reading value deviation permitted for the meter. Shown as "Alarm level" in Advantage Navigator.
	 * @param deltaMax
	 */
	public void setDeltaMax(Double deltaMax) {
		this.deltaMax = deltaMax;
	}

	/**
	 * Specifies the minimum reading value deviation permitted for the meter. Shown as "Warning level" in Advantage Navigator.
	 * @return
	 */
	public Double getDeltaMin() {
		return deltaMin;
	}

	/**
	 * Specifies the minimum reading value deviation permitted for the meter. Shown as "Warning level" in Advantage Navigator.
	 * @param deltaMin
	 */
	public void setDeltaMin(Double deltaMin) {
		this.deltaMin = deltaMin;
	}

	/**
	 * Specifies the maximum reading value permitted for the meter.
	 * @return
	 */
	public Double getMaxMeterValue() {
		return maxMeterValue;
	}

	/**
	 * Specifies the maximum reading value permitted for the meter.
	 * @param maxMeterValue
	 */
	public void setMaxMeterValue(Double maxMeterValue) {
		this.maxMeterValue = maxMeterValue;
	}

	/**
	 * Specifies the function how meter readings should be interpolated.
	 * @return
	 */
	public CompressFunction getCompressFunction() {
		return compressFunction;
	}

	/**
	 * Specifies the function how meter readings should be interpolated.
	 * @param compressFunction
	 */
	public void setCompressFunction(CompressFunction compressFunction) {
		this.compressFunction = compressFunction;
	}

	/**
	 * Specifies the time interval between the individual meter readings.
	 * @return
	 */
	public CompressInterval getCompressInterval() {
		return compressInterval;
	}

	/**
	 * Specifies the time interval between the individual meter readings.
	 * @param compressInterval
	 */
	public void setCompressInterval(CompressInterval compressInterval) {
		this.compressInterval = compressInterval;
	}

	/**
	 * Specifies how the meter reading is performed.
	 * @return
	 */
	public ManualRead getManualRead() {
		return manualRead;
	}

	/**
	 * Specifies how the meter reading is performed.
	 * @param manualRead
	 */
	public void setManualRead(ManualRead manualRead) {
		this.manualRead = manualRead;
	}

	/**
	 * Supplier ID of the meter device manufacturer.
	 * @return
	 */
	public String getSupplierId() {
		return supplierId;
	}

	/**
	 * Supplier ID of the meter device manufacturer.
	 * @param supplierId
	 */
	public void setSupplierId(String supplierId) {
		validateStringLength(supplierId, 0, 30);
		this.supplierId = supplierId;
	}

	/**
	 * The node ID under which the meter should be created. If not specified, the new meter will
	 * be created under the "ImportedMeters" node in the Advantage Navigator web front-end. If the
	 * "ImportedMeters" node does not yet exist, it will automatically be created. 
	 * @return
	 */
	public Integer getParentNodeId() {
		return parentNodeId;
	}

	/**
	 * The node ID under which the meter should be created. If not specified, the new meter will
	 * be created under the "ImportedMeters" node in the Advantage Navigator web front-end. If the
	 * "ImportedMeters" node does not yet exist, it will automatically be created.
	 * 
	 * @param parentNodeId
	 */
	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	/**
	 * An arbitrary comment.
	 * @return
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * An arbitrary comment.
	 * @param comment
	 */
	public void setComment(String comment) {
		validateStringLength(comment, 0, 1024);
		this.comment = comment;
	}

	/**
	 * Location of the meter.
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Location of the meter.
	 * @param location
	 */
	public void setLocation(String location) {
		validateStringLength(location, 0, 40);
		this.location = location;
	}

	/**
	 * Interval in which reminders are sent.
	 * @return
	 */
	public ReminderInterval getReminderInterval() {
		return reminderInterval;
	}

	/**
	 * Interval in which reminders are sent.
	 * @param reminderInterval
	 */
	public void setReminderInterval(ReminderInterval reminderInterval) {
		this.reminderInterval = reminderInterval;
	}

	/**
	 * Flags if negative values are allowed for the meter.
	 * @return
	 */
	public Boolean getAllowNegativeValues() {
		return allowNegativeValues;
	}

	/**
	 * Flags if negative values are allowed for the meter.
	 * @param allowNegativeValues
	 */
	public void setAllowNegativeValues(Boolean allowNegativeValues) {
		this.allowNegativeValues = allowNegativeValues;
	}

	/**
	 * Flags if NULL or 0 values are allowed for the meter.
	 * @return
	 */
	public Boolean getAllowNullValues() {
		return allowNullValues;
	}

	/**
	 * Flags if NULL or 0 values are allowed for the meter.
	 * @param allowNullValues
	 */
	public void setAllowNullValues(Boolean allowNullValues) {
		this.allowNullValues = allowNullValues;
	}

	/**
	 * Flags if alarms are missing.
	 * @return
	 */
	public Boolean getMissingAlarms() {
		return missingAlarms;
	}

	/**
	 * Flags if alarms are missing.
	 * @param missingAlarms
	 */
	public void setMissingAlarms(Boolean missingAlarms) {
		this.missingAlarms = missingAlarms;
	}

	/**
	 * The split method defines how a value should be split across a smaller timeframe. The
	 * split method value 1 will divide this equally according to the chosen timeframe. The
	 * value 4 uses the value as an average and the same value would be used in the case of
	 * reporting on a smaller timeframe.
	 * 
	 * @return
	 */
	public SplitMethod getSplitMethod() {
		return splitMethod;
	}

	/**
	 * The split method defines how a value should be split across a smaller timeframe. The
	 * split method value 1 will divide this equally according to the chosen timeframe. The
	 * value 4 uses the value as an average and the same value would be used in the case of
	 * reporting on a smaller timeframe.
	 * 
	 * @param splitMethod
	 */
	public void setSplitMethod(SplitMethod splitMethod) {
		this.splitMethod = splitMethod;
	}

	/**
	 * The vendor of the meter. Not available in the front end.
	 * @return
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * The vendor of the meter. Not available in the front end.
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		validateStringLength(vendor, 0, 256);
		this.vendor = vendor;
	}

	/**
	 * Not available in the front end.
	 * @return
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Not available in the front end.
	 * 
	 * @param account
	 */
	public void setAccount(String account) {
		validateStringLength(account, 0, 256);
		this.account = account;
	}

	/**
	 * Not available in the front end.
	 * @return
	 */
	public String getRateClass() {
		return rateClass;
	}

	/**
	 * Not available in the front end.
	 * 
	 * @param rateClass
	 */
	public void setRateClass(String rateClass) {
		validateStringLength(rateClass, 0, 256);
		this.rateClass = rateClass;
	}

	public String getDatasource() {
		return datasource;
	}

	public String getMeterName() {
		return meterName;
	}

	public DateTime getStartDateTime() {
		return startDateTime;
	}

	public Integer getValueType() {
		return valueType;
	}

	public Integer getMedium() {
		return medium;
	}

	public Integer getUnit() {
		return unit;
	}
	
	private int getIntValue(Boolean value) {
		if(value) return 1;
		else return 0;
	}
	
}
