package com.siemens.eadvantage.ie.types;

import static com.siemens.eadvantage.util.ArgumentValidationUtils.*;

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
		// TODO Auto-generated method stub
		return null;
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

	public Double getStartValue() {
		return startValue;
	}

	public void setStartValue(Double startValue) {
		this.startValue = startValue;
	}

	public FlowNature getFlownature() {
		return flownature;
	}

	public void setFlownature(FlowNature flownature) {
		this.flownature = flownature;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Double getReadingOffset() {
		return readingOffset;
	}

	public void setReadingOffset(Double readingOffset) {
		this.readingOffset = readingOffset;
	}

	public Double getReadingFactor() {
		return readingFactor;
	}

	public void setReadingFactor(Double readingFactor) {
		this.readingFactor = readingFactor;
	}

	public Double getDeltaMax() {
		return deltaMax;
	}

	public void setDeltaMax(Double deltaMax) {
		this.deltaMax = deltaMax;
	}

	public Double getDeltaMin() {
		return deltaMin;
	}

	public void setDeltaMin(Double deltaMin) {
		this.deltaMin = deltaMin;
	}

	public Double getMaxMeterValue() {
		return maxMeterValue;
	}

	public void setMaxMeterValue(Double maxMeterValue) {
		this.maxMeterValue = maxMeterValue;
	}

	public CompressFunction getCompressFunction() {
		return compressFunction;
	}

	public void setCompressFunction(CompressFunction compressFunction) {
		this.compressFunction = compressFunction;
	}

	public CompressInterval getCompressInterval() {
		return compressInterval;
	}

	public void setCompressInterval(CompressInterval compressInterval) {
		this.compressInterval = compressInterval;
	}

	public ManualRead getManualRead() {
		return manualRead;
	}

	public void setManualRead(ManualRead manualRead) {
		this.manualRead = manualRead;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ReminderInterval getReminderInterval() {
		return reminderInterval;
	}

	public void setReminderInterval(ReminderInterval reminderInterval) {
		this.reminderInterval = reminderInterval;
	}

	public Boolean getAllowNegativeValues() {
		return allowNegativeValues;
	}

	public void setAllowNegativeValues(Boolean allowNegativeValues) {
		this.allowNegativeValues = allowNegativeValues;
	}

	public Boolean getAllowNullValues() {
		return allowNullValues;
	}

	public void setAllowNullValues(Boolean allowNullValues) {
		this.allowNullValues = allowNullValues;
	}

	public Boolean getMissingAlarms() {
		return missingAlarms;
	}

	public void setMissingAlarms(Boolean missingAlarms) {
		this.missingAlarms = missingAlarms;
	}

	public SplitMethod getSplitMethod() {
		return splitMethod;
	}

	public void setSplitMethod(SplitMethod splitMethod) {
		this.splitMethod = splitMethod;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRateClass() {
		return rateClass;
	}

	public void setRateClass(String rateClass) {
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
	
}
