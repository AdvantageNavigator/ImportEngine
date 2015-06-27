package com.siemens.eadvantage.ie.command;

import java.io.File;
import java.io.IOException;

public abstract class Command {
	
	private char delimiter = ';';
	
	public abstract File createUploadFile() throws IOException;

	public char getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	
}
