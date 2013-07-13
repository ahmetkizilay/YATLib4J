package com.ahmetkizilay.yatlib4j;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;

import com.ahmetkizilay.yatlib4j.utils.GenericUtils;

public class TwitterRequestWrapper {
	private final static String HOST = "api.twitter.com";
	private final static String CONTENT_TYPE = "application/x-www-form-urlencoded";
	private final static String CHARSET = "charset=UTF-8";
	private final static String USER_AGENT = "PERISONiC beta";
	
	public static TwitterResponseWrapper sendRequestAppAuth(String httpMethod, String baseUrl, Hashtable<String, String> httpParams, String authHeader) {
		if(httpMethod.equals("POST")) {
			return sendRequestAppAuthPost(baseUrl, httpParams, authHeader);
		}
		else if(httpMethod.equals("GET")){
			return sendRequestAppAuthGet(baseUrl, httpParams, authHeader);
		}
		else {
			TwitterResponseWrapper response = new TwitterResponseWrapper();
			response.setSuccess(false);
			response.setResponse("Unsupported HTTP Method: " + httpMethod);
			response.setResponseCode(500);
			return response;
		}
	}
	
	private static TwitterResponseWrapper sendRequestAppAuthPost(String baseUrl, Hashtable<String, String> httpParams, String authHeader) {
		HttpURLConnection conn = null;
		InputStream is = null;
		TwitterResponseWrapper response = new TwitterResponseWrapper();
		
		
		try {
			String stringifiedParams = httpParams.size() > 0 ? GenericUtils.httpStringifyHashtable(httpParams) : "";
			
			URL u = new URL(baseUrl);
			conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Host", HOST);
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Authorization", authHeader);
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";" + CHARSET);
			conn.setRequestProperty("Content-Length", "" + stringifiedParams.getBytes("UTF-8").length);
			conn.setRequestProperty("Accept-Encoding",  "gzip");
			
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(stringifiedParams);
			wr.flush();
			wr.close();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			is = conn.getInputStream();
			byte[] buffer = new byte[2048];
			int bytes_read;
			while((bytes_read = is.read(buffer)) != -1) {
				baos.write(buffer, 0, bytes_read);
			}
			baos.close();
			
			response.setResponseCode(200);
			response.setSuccess(true);
			response.setResponse(GenericUtils.decompressGZIPData(baos.toByteArray()));
			
			return response;
						
		}
		catch(IOException ioExp) {
			response.setSuccess(false);
			
			if(conn != null) {
				response.setResponse(getResponseFromGZIPErrorStream(conn.getErrorStream()));
				try {
					response.setResponseCode(conn.getResponseCode());
					response.setResponseMessage(conn.getResponseMessage());					
				}
				catch(IOException exp) {}
			}
			
			return response;
		}
		catch(Exception exp) {
			response.setResponseCode(0);
			response.setResponseMessage(exp.getMessage());
			return response;
		}
		finally {
			if(is != null) { try{ is.close(); }catch(Exception exp){} }
		}
	}
	
	private static TwitterResponseWrapper sendRequestAppAuthGet(String baseUrl, Hashtable<String, String> httpParams, String authHeader) {
		HttpURLConnection conn = null;
		InputStream is = null;
		TwitterResponseWrapper response = new TwitterResponseWrapper();
		
		try {
			String combinedHttpUrl = baseUrl;
			if(!httpParams.isEmpty()) {
				combinedHttpUrl += "?" + GenericUtils.httpStringifyHashtable(httpParams);
			}
			
			URL u = new URL(combinedHttpUrl);
			conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Host", HOST);
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Authorization", authHeader);
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";" + CHARSET);
			conn.setRequestProperty("Accept-Encoding",  "gzip");
						
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			is = conn.getInputStream();
			byte[] buffer = new byte[2048];
			int bytes_read;
			while((bytes_read = is.read(buffer)) != -1) {
				baos.write(buffer, 0, bytes_read);
			}
			baos.close();
			
			response.setResponseCode(200);
			response.setSuccess(true);
			response.setResponse(GenericUtils.decompressGZIPData(baos.toByteArray()));
			
			return response;
						
		}
		catch(IOException ioExp) {
			response.setSuccess(false);
			
			if(conn != null) {
				response.setResponse(getResponseFromGZIPErrorStream(conn.getErrorStream()));
				try {
					response.setResponseCode(conn.getResponseCode());
					response.setResponseMessage(conn.getResponseMessage());					
				}
				catch(IOException exp) {}
			}
			
			return response;
		}
		catch(Exception exp) {
			response.setResponseCode(0);
			response.setResponseMessage(exp.getMessage());
			return response;
		}
		finally {
			if(is != null) { try{ is.close(); }catch(Exception exp){} }
		}
	}
	
	public static TwitterResponseWrapper sendRequest(String httpMethod, String baseUrl, Hashtable<String, String> httpParams, String oauthHeader) {
		if(httpMethod.equals("POST")) {
			return sendRequestPost(httpMethod, baseUrl, httpParams, oauthHeader);
		}
		else if(httpMethod.equals("GET")){
			return sendRequestGet(httpMethod, baseUrl, httpParams, oauthHeader);
		}
		else {
			TwitterResponseWrapper response = new TwitterResponseWrapper();
			response.setSuccess(false);
			response.setResponse("Unsupported HTTP Method: " + httpMethod);
			response.setResponseCode(500);
			return response;
		}
	}
	
	private static TwitterResponseWrapper sendRequestGet(String httpMethod, String baseUrl, Hashtable<String, String> httpParams, String oauthHeader) {
		HttpURLConnection conn = null;
		BufferedReader in = null;
		TwitterResponseWrapper response = new TwitterResponseWrapper();
		
		
		
		try {
			String combinedHttpUrl = baseUrl;
			if(!httpParams.isEmpty()) {
				combinedHttpUrl += "?" + GenericUtils.httpStringifyHashtable(httpParams);
			}
			
			URL u = new URL(combinedHttpUrl);
			conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(httpMethod);
			conn.setRequestProperty("Content-Type", CONTENT_TYPE);
			conn.setRequestProperty("Authorization", oauthHeader);
			conn.setRequestProperty("Accept",  "*/*");
			conn.setRequestProperty("Connection", "close");
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Host", HOST);
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String lineRead;
			
			while((lineRead = in.readLine()) != null) {
				sb.append(lineRead); sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			
			response.setResponseCode(200);
			response.setSuccess(true);
			response.setResponse(sb.toString());
			
			return response;
						
		}
		catch(IOException ioExp) {
			response.setSuccess(false);
			
			if(conn != null) {
				response.setResponse(getResponseFromErrorStream(conn.getErrorStream()));
				try {
					response.setResponseCode(conn.getResponseCode());
					response.setResponseMessage(conn.getResponseMessage());					
				}
				catch(IOException exp) {}
			}
			
			return response;
		}
		catch(Exception exp) {
			response.setResponseCode(0);
			response.setResponseMessage(exp.getMessage());
			return response;
		}
		finally {
			if(in != null) { try{ in.close(); }catch(Exception exp){} }
		}
	}
	
	private static TwitterResponseWrapper sendRequestPost(String httpMethod, String baseUrl, Hashtable<String, String> httpParams, String oauthHeader) {
		HttpURLConnection conn = null;
		BufferedReader in = null;
		TwitterResponseWrapper response = new TwitterResponseWrapper();
				
		try {
			String stringifiedParams = httpParams.size() > 0 ? GenericUtils.httpStringifyHashtable(httpParams) : "";
			
			URL u = new URL(baseUrl);
			conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(httpMethod);
			conn.setRequestProperty("Content-Type", CONTENT_TYPE);
			conn.setRequestProperty("Authorization", oauthHeader);
			conn.setRequestProperty("Accept",  "*/*");
			conn.setRequestProperty("Connection", "close");
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Host", HOST);
			
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(stringifiedParams);
			wr.flush();
			wr.close();
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String lineRead;
			
			while((lineRead = in.readLine()) != null) {
				sb.append(lineRead); sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			
			response.setResponseCode(200);
			response.setSuccess(true);
			response.setResponse(sb.toString());
			
			return response;
						
		}
		catch(IOException ioExp) {
			response.setSuccess(false);
			
			if(conn != null) {
				response.setResponse(getResponseFromErrorStream(conn.getErrorStream()));
				try {				
					response.setResponseCode(conn.getResponseCode());
					response.setResponseMessage(conn.getResponseMessage());					
				}
				catch(IOException exp) {}
			}
			
			return response;
		}
		catch(Exception exp) {
				
			response.setResponseCode(0);
			response.setResponseMessage(exp.getMessage());					
			return response;
		}
		finally {
			if(in != null) { try{ in.close(); }catch(Exception exp){} }
		}
	}
	
	private static String getResponseFromErrorStream(InputStream es) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(es));
			
			StringBuffer sb = new StringBuffer();
			String lineRead;
			
			while((lineRead = in.readLine()) != null) {
				sb.append(lineRead); sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			
			return sb.toString();
		}
		catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		finally {
			if(in != null) try { in.close(); }catch(Exception exp) {}
		}
	}
	
	private static String getResponseFromGZIPErrorStream(InputStream es) {
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			
			byte[] buffer = new byte[2048];
			int bytes_read;
			while((bytes_read = es.read(buffer)) != -1) {
				baos.write(buffer, 0, bytes_read);
			}
			
			return GenericUtils.decompressGZIPData(baos.toByteArray());
		}
		catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		finally {
			if(baos != null) try { baos.close(); }catch(Exception exp) {}
		}
	}
}
