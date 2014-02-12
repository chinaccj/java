/**
 * 
 */
package getMobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013年12月29日 下午8:26:26
 * @version
 */
public class TestMain {

    /**
     * @param args
     */
    private String getHtmlOfHomePage(String homeUrl) {
	try {
	    String strURL = "http://hz.tobosu.com/zx/";
	    URL url;

	    url = new URL(strURL);

	    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
	    InputStreamReader input;

	    input = new InputStreamReader(httpConn.getInputStream(), "utf-8");

	    BufferedReader bufReader = new BufferedReader(input);
	    String line = "";
	    StringBuilder contentBuf = new StringBuilder();
	    while ((line = bufReader.readLine()) != null) {
		contentBuf.append(line);
	    }
	    String buf = contentBuf.toString();

	    System.out.println(buf);
	    return buf;
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	    return null;
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}
    }

    private void parseEachPage(String homeHtml) {
	// <a class="tubiao a8" href="/member/19457/about-contant.html"
	// target="_blank">联系我们</a>
    }

    public static void main(String[] args) throws Exception {

    }
}
