package com.siemens.eadvantage.ie.types;

/**
 * Implementations of this interface represent a data line in an import engine command file.
 * 
 * @author Mike Pichler
 *
 */
public interface DataLine {
	
	/**
	 * Gets a string representation of the data line using the specified delimiter.
	 * 
	 * @param delimiter the delimiter for the data line string
	 * @return  a string representation of the data line
	 */
	public String getDataLine(char delimiter);
	
	/**
	 * Gets a list of optional columns as string, which can be used in the import file header.
	 * 
	 * @return
	 */
	public String getOptionalColumnList();
}
