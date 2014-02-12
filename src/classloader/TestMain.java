/**
 * 
 */
package classloader;

import java.net.URL;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-11-25 上午11:02:31
 * @version
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	ClassLoader clThread = Thread.currentThread().getContextClassLoader();
	System.out.println(clThread.toString());

	ClassLoader clCls = TestMain.class.getClassLoader();
	System.out.println(clCls.toString());

	URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
	for (int i = 0; i < urls.length; i++) {
	    System.out.println(urls[i].toExternalForm());
	}
	if (GrandFather.class.isAssignableFrom(Father.class)) {
	    System.out.println("Grand father ,,,");
	}

	Father father = new Father();
	GrandFather gfFather = new GrandFather();

	if (father instanceof Father) {
	    System.out.println("instanceof ");
	}
    }
}
