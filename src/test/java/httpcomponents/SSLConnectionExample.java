package httpcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SSLConnectionExample {
	
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {
		
		String URL = "https://eadvantage.siemens.com/";
		
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		FileInputStream stream = new FileInputStream("src/test/resources/keystore2.jks");
		trustStore.load(stream, "test".toCharArray());
		
		SSLContext context = SSLContexts.custom().loadTrustMaterial(trustStore).build();
		SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context);
		
		CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(factory).build();
		HttpGet httpget = new HttpGet(URL);
		
		try {
			CloseableHttpResponse response = client.execute(httpget);
			System.out.println("Got response: " + response.toString());
		} catch (SSLException e) {
			System.out.println("Certificate not found");
		}
	}

}
