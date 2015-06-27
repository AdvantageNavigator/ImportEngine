package com.siemens.eadvantage.ie.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AlarmStatus {
	
	private final SimpleDateFormat utcFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private final SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	// required fields
	private final String datasource;
	private final Date dateTime;
	private final String alarmPointName;
	private final AlarmStatusClass status;
	private final AlarmPriority priority;
	
	// optional fields
	private Boolean requiresAcknowledgement = null;
	private Integer parentNodeId = null;
	private String description = null;
	private String comment = null;
	private String toDo = null;
	private String alarmMessage = null;
	private String alarmCondition = null;
	private String alarmValue = null;
	private String alarmLimit = null;
	private String eventText = null;
	private AlarmCategory alarmCategory = null;
	
	public AlarmStatus(String datasource, Date localDateTime, String alarmPointName, AlarmStatusClass status, AlarmPriority priority) {
		
		if(datasource == null) throw new IllegalArgumentException("datasource must not be null");
		if(datasource.length()<1||datasource.length()>255) throw new IllegalArgumentException("datasource length must be 1-255 characters");
		this.datasource = datasource;
		
		utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		if(localDateTime == null) throw new IllegalArgumentException("localDateTime must not be null");
		try {
			Date utcDateTime = dateParser.parse(utcFormatter.format(localDateTime));
			if(utcDateTime.getTime() < dateParser.parse("01/01/1950 00:00:00").getTime()) {
				throw new IllegalArgumentException("localDateTime must not be not before '01/01/1950 00:00:00' UTC");
			}
		} catch (ParseException ignore) {
			throw new AssertionError();	// may not happen
		}
		dateTime = localDateTime;
		
		if(alarmPointName == null) throw new IllegalArgumentException("alarmPointName must not be null");
		if(alarmPointName.length()<1||alarmPointName.length()>255) throw new IllegalArgumentException("alarmPointName length must be 1-255 characters");
		this.alarmPointName = alarmPointName;
		
		if(status == null) throw new IllegalArgumentException("status mast not be null");
		this.status = status;
		
		if(priority == null) throw new IllegalArgumentException("priority must not be null");
		this.priority = priority;
		
	}

	public Boolean getRequiresAcknowledgement() {
		return requiresAcknowledgement;
	}

	/**
	 * Defines if the operator has to acknowledge the alarm in the web application.
	 * 
	 * @param requiresAcknowledgement
	 */
	public void setRequiresAcknowledgement(Boolean requiresAcknowledgement) {
		this.requiresAcknowledgement = requiresAcknowledgement;
	}

	public Integer getParentNodeId() {
		return parentNodeId;
	}

	/**
	 * The node ID under which the Alarm Point should be created. If not specified, the Alarm
	 * Point will be created under the Customer node of the device user in the Advantage
	 * Navigator web front-end.
	 * 
	 * @param parentNodeId
	 */
	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * An arbitrary description with 0-1024 characters.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		if(description != null && description.length()>1024) throw new IllegalArgumentException("description must have 0-1024 characters");
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	/**
	 * An arbitrary comment with 0-1024 characters.
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		if(comment != null && comment.length()>1024) throw new IllegalArgumentException("comment must have 0-1024 characters");
		this.comment = comment;
	}

	public String getToDo() {
		return toDo;
	}

	/**
	 * An comment what are the next steps to do with 0-1024 characters.
	 * 
	 * @param toDo
	 */
	public void setToDo(String toDo) {
		if(toDo != null && toDo.length()>1024) throw new IllegalArgumentException("toDo must have 0-1024 characters");
		this.toDo = toDo;
	}

	public String getAlarmMessage() {
		return alarmMessage;
	}

	/**
	 * The alarm message with 0-1024 characters.
	 * 
	 * @param alarmMessage
	 */
	public void setAlarmMessage(String alarmMessage) {
		if(alarmMessage != null && alarmMessage.length()>1024) throw new IllegalArgumentException("alarmMessage must have 0-1024 characters");
		this.alarmMessage = alarmMessage;
	}

	public String getAlarmCondition() {
		return alarmCondition;
	}

	/**
	 * The alarm condition with 0-1024 characters.
	 * 
	 * @param alarmCondition
	 */
	public void setAlarmCondition(String alarmCondition) {
		if(alarmCondition != null && alarmCondition.length()>1024) throw new IllegalArgumentException("alarmCondition must have 0-1024 characters");
		this.alarmCondition = alarmCondition;
	}

	public String getAlarmValue() {
		return alarmValue;
	}

	/**
	 * The alarm value with 0-255 characters.
	 * 
	 * @param alarmValue
	 */
	public void setAlarmValue(String alarmValue) {
		if(alarmValue != null && alarmValue.length()>255) throw new IllegalArgumentException("alarmValue must have 0-255 characters");
		this.alarmValue = alarmValue;
	}

	public String getAlarmLimit() {
		return alarmLimit;
	}

	/**
	 * The Alarm Point limit with 0-1024 characters.
	 * 
	 * @param alarmLimit
	 */
	public void setAlarmLimit(String alarmLimit) {
		if(alarmLimit != null && alarmLimit.length()>1024) throw new IllegalArgumentException("alarmLimit must have 0-1024 characters");
		this.alarmLimit = alarmLimit;
	}

	public String getEventText() {
		return eventText;
	}

	/**
	 * It's an additional information of a state with 0-1024 characters.
	 * 
	 * @param eventText
	 */
	public void setEventText(String eventText) {
		if(eventText != null && eventText.length()>1024) throw new IllegalArgumentException("eventText must have 0-1024 characters");
		this.eventText = eventText;
	}

	public AlarmCategory getAlarmCategory() {
		return alarmCategory;
	}

	/**
	 * The Id of the AlarmPoint category.
	 * 
	 * @param alarmCategory
	 */
	public void setAlarmCategory(AlarmCategory alarmCategory) {
		this.alarmCategory = alarmCategory;
	}

	public String getDatasource() {
		return datasource;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getAlarmPointName() {
		return alarmPointName;
	}

	public AlarmStatusClass getStatus() {
		return status;
	}

	public AlarmPriority getPriority() {
		return priority;
	}
	
	
	
}
