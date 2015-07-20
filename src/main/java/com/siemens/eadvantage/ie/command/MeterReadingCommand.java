package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.siemens.eadvantage.ie.types.MeterReading;
import com.siemens.eadvantage.ie.types.QualityAttribute;
import com.siemens.eadvantage.ie.types.QualityFlag;

public class MeterReadingCommand extends Command {

	private final List<MeterReading> readings = new ArrayList<MeterReading>();
	private boolean sendQualityAttribute = false;
	private boolean sendDescription = false;
	private boolean sendBeginDate = false;
	
	@Override
	public File createUploadFile() throws IOException {
		
		File uploadFile = File.createTempFile("AdvantageNavigator", "upload");
		
		PrintWriter writer = new PrintWriter(uploadFile, "UTF-8");	
		
		String header = "command=METER_READING delimiter=" + getDelimiter();
		
		if(sendQualityAttribute||sendDescription||sendBeginDate) {
			header = header + " optionalColumnList=" + getOptionalColumnList();
		}
		
		writer.println(header);
		
		for (MeterReading reading : readings) {
			
			if(sendQualityAttribute && reading.getQualityAttribute() == null) {
				QualityAttribute attribute = new QualityAttribute();
				attribute.getQualityFlags().add(QualityFlag.AUTOMATIC_VALUE);
				attribute.getQualityFlags().add(QualityFlag.GOOD);
				reading.setQualityAttribute(attribute);
			}
			if(!sendQualityAttribute) reading.setQualityAttribute(null);
			
			if(sendDescription && reading.getDescription() == null) reading.setDescription("");
			if(!sendDescription) reading.setDescription(null);
			
			if(sendBeginDate && reading.getBeginDate() == null) reading.setBeginDate(reading.getDateTime());
			if(!sendBeginDate) reading.setBeginDate(null);
			
			writer.println(reading.getDataLine(getDelimiter()));
		}
		
		writer.flush();
		writer.close();
		
		return uploadFile;
	}

	/**
	 * Determines which optional columns should be send for each meter reading. If a meter reding dosn't contain
	 * one or more of these attributes, default values will be used.
	 * 
	 * @param qualityAttribute if true, this optional attribute will be sent; default value is 33
	 * @param description if true, this optional attribute will be sent; default value is an empty string
	 * @param beginDate if true, this optional attribute will be sent; default value is equal to dateTime of reading
	 */
	public void setOptionalColumns(boolean qualityAttribute, boolean description, boolean beginDate) {
		this.sendQualityAttribute = qualityAttribute;
		this.sendDescription = description;
		this.sendBeginDate = beginDate;
	}
	
	public void addMeterReading(MeterReading reading) {
		
		if(!readings.isEmpty()) {
			if(!readings.get(0).getOptionalColumnList().equals(reading.getOptionalColumnList())) {
				throw new IllegalArgumentException("Optional column list of all meter readings must be equal");
			}
		}
		readings.add(reading);
	}
	
	public String getOptionalColumnList() {
		
		StringBuilder builder = new StringBuilder();
		boolean isFirst = true;
		
		if(sendQualityAttribute) {
			builder.append("qualityAttribute");
			isFirst = false;
		} if(sendDescription) {
			if(!isFirst) builder.append(",");
			builder.append("description");
			isFirst = false;
		} if(sendBeginDate) {
			if(!isFirst) builder.append(",");
			builder.append("beginDate");
		}
		
		return builder.toString();
	}
	
	/**
	 * Gets a <b>copy</b> of the internal meter readings list.
	 * 
	 * @return list of meter readings
	 */
	public List<MeterReading> getReadings() {
		return new ArrayList<MeterReading>(readings);
	}
	
}
