package com.siemens.eadvantage.ie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

import com.siemens.eadvantage.ie.command.Command;
import com.siemens.eadvantage.ie.command.DeviceStatusCommand;
import com.siemens.eadvantage.ie.types.DeviceStatus;
import com.siemens.eadvantage.ie.types.DeviceStatusClass;

public class ImportEngineClient {
	
	public final static String DEFAULT_IMPORT_ENGINE_URL = "https://eadvantage.siemens.com/ieg/2_0/import.html";
	
	private final String deviceUsername;
	private final String devicePassword;
	
	private String importEngineUrl = DEFAULT_IMPORT_ENGINE_URL;
	private boolean deleteCommandFileAfterUpload = false;
	
	public ImportEngineClient(final String deviceUsername, final String devicePassword) {
		this.deviceUsername = deviceUsername;
		this.devicePassword = devicePassword;
	}

	public String getImportEngineUrl() {
		return importEngineUrl;
	}

	public void setImportEngineUrl(String importEngineUrl) {
		if(importEngineUrl == null) throw new IllegalArgumentException("Argument importEngineUrl must not be null");
		this.importEngineUrl = importEngineUrl;
	}
	
	public String executeCommand(Command command) throws IOException {
		
		String result = null;
		File uplaodFile = null;
		
		CloseableHttpClient httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
		
		try {
			
			HttpPost httppost = new HttpPost(importEngineUrl);
			
			StringBody user = new StringBody(deviceUsername, ContentType.TEXT_PLAIN);
			StringBody pass = new StringBody(devicePassword, ContentType.TEXT_PLAIN);
			uplaodFile = command.createUploadFile();
			FileBody file = new FileBody(uplaodFile);
			
			HttpEntity entity = MultipartEntityBuilder.create()
					.addPart("iegUsername", user)
					.addPart("iegPassword", pass)
					.addPart("swpImportFile", file)
					.build();
			
			httppost.setEntity(entity);
			
			CloseableHttpResponse response = httpclient.execute(httppost);
			result = new BufferedReader(new InputStreamReader(response.getEntity().getContent())).readLine();
			response.close();
			
		} finally {
			httpclient.close();
			if(deleteCommandFileAfterUpload && uplaodFile != null) uplaodFile.delete();
		}
		
		return result;
	}
	
	public String performConnectionTest() throws IOException {
		
		DeviceStatus status = new DeviceStatus(DeviceStatusClass.OK, "Connection test", "1.0");
		DeviceStatusCommand command = new DeviceStatusCommand(status);
		command.setDelimiter(',');
		
		return executeCommand(command);
	}
	
}
