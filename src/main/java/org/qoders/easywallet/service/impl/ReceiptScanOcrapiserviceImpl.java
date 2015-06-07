package org.qoders.easywallet.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.service.ReceiptScanService;
import org.springframework.stereotype.Service;

/**
 * Implement receipt scan using ocrapiservice.com api (100 request per API key).
 * This class will take image and send to ocrapiservice.com to recognize text, 
 * then it will parse text and make Receipt object
 * @author Nhu Trinh
 *
 */
@Service
public class ReceiptScanOcrapiserviceImpl implements ReceiptScanService {
	/**
	 * ocrapiservice services end point
	 */
	public final String SERVICE_URL = "http://api.ocrapiservice.com/1.0/rest/ocr";
	
	/**
	 * Parameter for image field in service
	 * Parameter for language field in service
	 * Parameter for apikey field in service
	 */
	private final String PARAM_IMAGE = "image";
	private final String PARAM_LANGUAGE = "language";
	private final String PARAM_APIKEY = "apikey";
	
	/**
	 * ocrapiservice API key, obtain in http://ocrapiservice.com/myaccount/dashboard/
	 */
	private String apiKey = "PstHTpvkpK";
	
	/**
	 * Response code from ocrapiservice
	 */
	private int responseCode;
	/**
	 * Response text from ocrapiservice
	 * This class will parse this response text and create Receipt object
	 */
	private String responseText;

	
	
	/*
	 * Send image to OCR service and read response.
	 * 
	 * @param language The image text language.
	 * @param filePath The image absolute file path.
	 *  
	 */
	private void sendImage(String language, String filePath) throws ClientProtocolException, IOException {
		try (CloseableHttpClient  httpclient = HttpClientBuilder.create().build()){
			HttpPost httppost = new HttpPost(SERVICE_URL);
	
			FileBody image = new FileBody(new File(filePath));
			
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();        
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart(PARAM_IMAGE, image);
			builder.addPart(PARAM_LANGUAGE, new StringBody(language, ContentType.TEXT_PLAIN));
			builder.addPart(PARAM_APIKEY, new StringBody(this.getApiKey(), ContentType.TEXT_PLAIN));
			httppost.setEntity(builder.build());
	
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();
			StringBuilder sb = new StringBuilder();
			if (resEntity != null) {
		    	InputStream stream = resEntity.getContent();
		    	byte bytes[] = new byte[4096];
		    	int numBytes;
		    	while ((numBytes=stream.read(bytes))!=-1) {
		    		if (numBytes!=0) {
		    			sb.append(new String(bytes, 0, numBytes));
		    		}
		    	}
			}
			this.setResponseCode(response.getStatusLine().getStatusCode());
			this.setResponseText(sb.toString());
		}catch (Exception e) {
			//Handle
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Override
	public Receipt getReceiptFromImage(String imagePath) {
		try {
			sendImage("en", imagePath);
			System.out.println(this.getResponseText());
			
			return new Receipt();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}





	public int getResponseCode() {
		return responseCode;
	}





	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}





	public String getApiKey() {
		return apiKey;
	}





	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}





	public String getResponseText() {
		return responseText;
	}





	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

}
