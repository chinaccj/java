/**
 * 
 */
package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-14 ÏÂÎç3:35:16
 * @version 
 */
public class ReadDriverIds {

	public static String readDriverIds(String filePath)throws Exception{
		InputStream is = new FileInputStream(new File(filePath));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuffer sBuffer = new StringBuffer();
		String line = null;
		while( (line =reader.readLine()) != null){
			sBuffer.append(line+",");
		}
		
		String dataString = sBuffer.toString(); 
		if(dataString.endsWith(",")){
			dataString = dataString.substring(0, dataString.length()-1);
		}
		
		return "("+dataString+")";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string="148412,³ÂÁ¢¸Õ,18600081449,¾©BR6706,267696,263";		
		String strs[] = string.split(",");
		System.out.println("length = "+strs.length);
		for(String str:strs){
			System.out.println(str);
		}
		
		
	}

}
