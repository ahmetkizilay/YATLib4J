package com.ahmetkizilay.yatlib4j.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;

public final class GenericUtils {
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
	private static char[] hexMap = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static byte[] hexByteMap = {0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 }; 
	private static char[] b64Map = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
		'9', '+', '/' };
	
	public static Date parseDateString(String dateStr) throws ParseException {
		return dateFormatter.parse(dateStr);			
	}
	
	public static String convertToHexString(byte[] input) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0, len = input.length; i < len; ++i) {
			sb.append(hexMap[0x0F & input[i] >> 4]);
			sb.append(hexMap[0xF & input[i]]);
		}
		
		return sb.toString();
	}
	
	public static byte[] convertFromHexString(String str) throws Exception {		
		if((str.length() % 2) != 0) throw new Exception("Incompatible Hex String Length");
		byte[] buffer = new byte[str.length() / 2];
		for(int i = 0, j = 0, len = buffer.length; i < len; i = i + 2, ++j) {
			buffer[j] = (byte) Integer.parseInt(str.substring(i, i+2), 16);
		}
		
		return buffer;
	}
	
	public static String percentDecode(String str) throws Exception {
		StringBuilder sb = new StringBuilder();
		for(int i = 0, len = str.length(); i < len; ++i) {
			char thisChar = str.charAt(i);
			if(thisChar == '%') {
				String subStr = str.substring(i+1, i+3);
				sb.append((char) convertFromHexString(subStr)[0]);
				i=i+2;
			}
			else {
				sb.append((char) getCharFromPercentEncodeMap((byte) thisChar));
			}
		}
		
		return sb.toString();
	}
		
	public static String percentEncode(String str) throws Exception {
		byte[] bytes = str.getBytes("UTF-8");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0, len = bytes.length; i < len; ++i) {
			char encodedChar = getCharFromPercentEncodeMap(bytes[i]);
			if(encodedChar == ' ') {
				byte[] cArr = getHexPartsInBytes(bytes[i]);
				sb.append('%');
				sb.append(getCharFromPercentEncodeMap(cArr[0]));
				sb.append(getCharFromPercentEncodeMap(cArr[1]));
			}
			else {
				sb.append(encodedChar);
			}
		}
		return sb.toString();
	}
	
	public static String base64Encode(byte[] input) {
		int len = input.length - (input.length % 3);
		int i = 0;
		StringBuilder sb = new StringBuilder();

		// 6 - 0;
		// 2 - 4;
		// 4 - 2;
		// 0 - 6

		for (i = 0; i < len; i = i + 3) {
			sb.append(b64Map[0x3F & input[i] >> 2]);
			sb.append(b64Map[(0x30 & input[i] << 4) | (0x0F & input[i + 1] >> 4)]);
			sb.append(b64Map[((0x0F & input[i + 1]) << 2) | (0x03 & input[i + 2] >> 6)]);
			sb.append(b64Map[(0x3F & input[i + 2])]);
		}

		int remainder = input.length - i;
		switch (remainder) {
		case 1:
			sb.append(b64Map[0x3F & input[i] >> 2]);
			sb.append(b64Map[(0x30 & input[i] << 4) | (0x0F & 0 >> 4)]);
			sb.append("==");
			break;
		case 2:
			sb.append(b64Map[0x3F & input[i] >> 2]);
			sb.append(b64Map[(0x30 & input[i] << 4) | (0x0F & input[i + 1] >> 4)]);
			sb.append(b64Map[((0x0F & input[i + 1]) << 2) | (0x03 & 0 >> 6)]);
			sb.append("=");
			break;
		default:
			break;
		}
		return sb.toString();
	}
	
	public static String httpStringifyHashtable(Hashtable<String, String> hashtable) throws Exception {
		StringBuilder sb = new StringBuilder();
		for(Enumeration<String> httpParamKeys = hashtable.keys(); httpParamKeys.hasMoreElements();) {
			String key = httpParamKeys.nextElement();
			sb.append(key);
			sb.append("=");
			sb.append(GenericUtils.percentEncode(hashtable.get(key)));
			sb.append("&");
		}
		
		sb.setLength(sb.length() - 1);
		return sb.toString();
		
		
	}
	
	public static String decompressGZIPData(byte[] data) {
		BufferedReader in = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			GZIPInputStream gzis = new GZIPInputStream(bais);
			InputStreamReader reader = new InputStreamReader(gzis);
			in = new BufferedReader(reader);
			
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
			    sb.append(line); sb.append("\n");
			}
			sb.setLength(sb.length() - 1);
			return sb.toString();
		}
		catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		finally {
			if(in != null) try { in.close(); } catch(Exception exp) {}
		}
	}
	
	public static String readTextFromFile(String filePath) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
			StringBuffer sb = new StringBuffer();
			String line;
			while((line = in.readLine()) != null) {
				sb.append(line); sb.append("\n");
			}
			
			sb.setLength(sb.length() - 1);
			
			return sb.toString();					
		}
		catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
		finally {
			if(in != null) try { in.close(); } catch(Exception exp){}
		}
		
	}
	
	public static void writeTextToFile(String content, String filePath) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(new File(filePath)));
			out.write(content);
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			if(out != null) try { out.close(); } catch(Exception exp){}
		}
		
	}
	
	private static char getCharFromPercentEncodeMap(byte value) {
		switch(value) {
		case 0x30:
			return '0';
		case 0x31:
			return '1';
		case 0x32:
			return '2';
		case 0x33:
			return '3';
		case 0x34:
			return '4';
		case 0x35:
			return '5';
		case 0x36:
			return '6';
		case 0x37:
			return '7';
		case 0x38:
			return '8';
		case 0x39:
			return '9';
		case 0x41:
			return 'A';
		case 0x42:
			return 'B';
		case 0x43:
			return 'C';
		case 0x44:
			return 'D';
		case 0x45:
			return 'E';
		case 0x46:
			return 'F';
		case 0x47:
			return 'G';
		case 0x48:
			return 'H';
		case 0x49:
			return 'I';
		case 0x4A:
			return 'J';
		case 0x4B:
			return 'K';
		case 0x4C:
			return 'L';
		case 0x4D:
			return 'M';
		case 0x4E:
			return 'N';
		case 0x4F:
			return 'O';
		case 0x50:
			return 'P';
		case 0x51:
			return 'Q';
		case 0x52:
			return 'R';
		case 0x53:
			return 'S';
		case 0x54:
			return 'T';
		case 0x55:
			return 'U';
		case 0x56:
			return 'V';
		case 0x57:
			return 'W';
		case 0x58:
			return 'X';
		case 0x59:
			return 'Y';
		case 0x5A:
			return 'Z';
		case 0x61:
			return 'a';
		case 0x62:
			return 'b';
		case 0x63:
			return 'c';
		case 0x64:
			return 'd';
		case 0x65:
			return 'e';
		case 0x66:
			return 'f';
		case 0x67:
			return 'g';
		case 0x68:
			return 'h';
		case 0x69:
			return 'i';
		case 0x6A:
			return 'j';
		case 0x6B:
			return 'k';
		case 0x6C:
			return 'l';
		case 0x6D:
			return 'm';
		case 0x6E:
			return 'n';
		case 0x6F:
			return 'o';
		case 0x70:
			return 'p';
		case 0x71:
			return 'q';
		case 0x72:
			return 'r';
		case 0x73:
			return 's';
		case 0x74:
			return 't';
		case 0x75:
			return 'u';
		case 0x76:
			return 'v';
		case 0x77:
			return 'w';
		case 0x78:
			return 'x';
		case 0x79:
			return 'y';
		case 0x7A:
			return 'z';
		case 0x2D:
			return '-';
		case 0x2E:
			return '.';
		case 0x5F:
			return '_';
		case 0x7E:
			return '~';
		default:
			break;		
		}
		
		return ' ';
	}
	
	private static byte[] getHexPartsInBytes(byte value) {
		byte[] result = new byte[2];
		result[0] = hexByteMap[0x0F & value >> 4];
		result[1] = hexByteMap[0xF & value];
		return result;
	}
}
