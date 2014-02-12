/**
 * 
 */
package socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-11-29 下午4:26:31
 * @version
 */
public class DateClient {
    /**
     * Runs the client as an application. First it displays a dialog box asking
     * for the IP address or hostname of a host running the date server, then
     * connects to it and displays the date that it serves.
     */
    private static byte[] readSokectStream(final InputStream is) throws IOException {
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	int c = 0;
	byte[] buf = new byte[1024];
	if ((c = is.read(buf)) > -1) {
	    bos.write(buf, 0, c);
	    System.out.println("read from sokcet =" + new Date().toString() + " read size="
		    + bos.size());
	}
	return bos.toByteArray();
    }

    public static void main(String[] args) throws IOException {
	String serverAddress = "localhost";
	Socket s = new Socket(serverAddress, 9090);

	while (true) {
	    byte byteArray[] = readSokectStream(s.getInputStream());
	    // if (byteArray.length == 0)
	    // continue;
	    System.out.println("client read ..." + byteArray.length);

	    if (byteArray.length > 0) {
		String data = new String(byteArray, "UTF8");
		System.out.println(System.currentTimeMillis() + " " + data);
	    } else {
		System.exit(0);
	    }

	}
    }

}
