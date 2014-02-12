/**
 * 
 */
package mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年2月12日 下午8:40:12
 * @version
 */
public class SqlFrequencyStatistics {

    public void readFile(File file) {
	try {
	    FileInputStream fs = new FileInputStream(file);
	    LineNumberReader reader = new LineNumberReader(new InputStreamReader(fs));
	    String lineString = null;
	    while ((lineString = reader.readLine()) != null) {

	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return;
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
