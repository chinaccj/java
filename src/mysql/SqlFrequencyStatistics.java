package mysql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年2月12日 下午8:40:12
 * @version
 */
public class SqlFrequencyStatistics {
    final File output = new File("C:\\Users\\Administrator\\Documents\\query_log_out.txt");

    final String IDENTITY = "10.10.0.16:36360";
    final char BLANK = ' ';

    public void readFile(File file) {
	FileInputStream fs = null;
	FileOutputStream fso = null;
	try {
	    fs = new FileInputStream(file);
	    fso = new FileOutputStream(output);
	    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fso));

	    LineNumberReader reader = new LineNumberReader(new InputStreamReader(fs));
	    String lineString = null;
	    String completeSql = "";
	    int index = 0;
	    while ((lineString = reader.readLine()) != null) {
		int sqlBegin = lineString.indexOf(IDENTITY);
		if (sqlBegin != -1 && (index == 0)) {// 上一条sql开始
		    completeSql += lineString.substring(sqlBegin + IDENTITY.length(),
			    lineString.length());

		    index++;
		} else if (sqlBegin != -1 && (index == 1)) {// 上一条sql结束
		    completeSql = discardExtraBlank(completeSql);
		    completeSql = completeSql.replaceAll("\t", "");
		    completeSql = filterStringValue(completeSql);
		    completeSql = filterDigit(completeSql);
		    // System.out.println(completeSql);
		    bufferedWriter.write(completeSql);
		    bufferedWriter.newLine();
		    // sql截取结束
		    completeSql = "";
		    index = 0;

		    completeSql += lineString.substring(sqlBegin + IDENTITY.length(),
			    lineString.length());

		    index = 1;

		} else {//
		    completeSql += lineString;
		}

	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return;
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (fs != null) {
		try {
		    fs.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }

	    if (fso != null) {
		try {
		    fso.close();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
    }

    private String discardExtraBlank(String str) {
	StringBuilder buf = new StringBuilder();
	if (str == null)
	    return null;

	int consequentBlank = 0;
	for (int i = 0; i < str.length(); i++) {
	    if (str.charAt(i) != BLANK) {
		buf.append(str.charAt(i));

		consequentBlank = 0;
	    } else {
		if (consequentBlank == 0) {
		    buf.append(str.charAt(i));
		    consequentBlank++;
		}
	    }
	}

	return buf.toString();

    }

    private String filterStringValue(String str) {
	StringBuilder buf = new StringBuilder();
	if (str == null)
	    return null;

	int singleQuotesNum = 0;
	for (int i = 0; i < str.length(); i++) {
	    if (str.charAt(i) == '\'') {
		singleQuotesNum++;
		buf.append(str.charAt(i));
	    } else {
		if (singleQuotesNum % 2 != 1) {
		    buf.append(str.charAt(i));
		}
	    }
	}

	return buf.toString();
    }

    private String filterDigit(String str) {
	if (str == null)
	    return null;

	if (str.length() < 10)
	    return str; // SELECT 1 的sql不做处理
	StringBuilder buf = new StringBuilder();

	for (int i = 0; i < str.length(); i++) {
	    // 如果为0-9的数字 过滤掉
	    if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {

	    } else {
		buf.append(str.charAt(i));
	    }
	}

	return buf.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	SqlFrequencyStatistics statistics = new SqlFrequencyStatistics();
	statistics.readFile(new File("C:\\Users\\Administrator\\Documents\\query_log.txt"));
    }
}