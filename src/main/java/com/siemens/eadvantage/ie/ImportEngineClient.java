package com.siemens.eadvantage.ie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
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
	
	private final char[] keystorePassword = "ImportEngine".toCharArray();
	
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
		SSLConnectionSocketFactory factory = null;
		
		try {
			
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
						
			URL keystoreURL = getClass().getClassLoader().getResource("keystore.jks");
			if(keystoreURL == null) throw new IOException("Keystore could not be found or no privileges to access");
			
			// converting the URL to a URI is necessary because the URL.getFile() command escapes spaces with %20
			// see http://bugs.java.com/bugdatabase/view_bug.do?bug_id=4466485 for details
			URI keystoreURI = new URI(keystoreURL.toString());			
			File keystoreFile = new File(keystoreURI.getPath());
			FileInputStream keystoreStream = new FileInputStream(keystoreFile);
			
			trustStore.load(keystoreStream, keystorePassword);
			
			SSLContext context = SSLContexts.custom().loadTrustMaterial(trustStore).build();
			factory = new SSLConnectionSocketFactory(context);
		
		} catch (KeyManagementException e) {
			throw new IOException(e.getMessage(), e);
		} catch (KeyStoreException e) {
			throw new IOException(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			throw new IOException(e.getMessage(), e);
		} catch (CertificateException e) {
			throw new IOException(e.getMessage(), e);
		} catch (URISyntaxException e) {
			throw new IOException(e.getMessage(), e);
		}
		
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(factory)
				.setRedirectStrategy(new LaxRedirectStrategy())
				.build();
		
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
