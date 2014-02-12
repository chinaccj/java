/**
 * 
 */
package exception;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-3 ����8:24:36
 * @version
 */
public class TestMain {

    public static void test() {
	throw new RuntimeException("");

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	try {
	    test();
	} catch (Error e) {
	    System.err.println("error ...");
	    System.err.println(e);
	} catch (Exception e) {
	    System.err.println("exception ...");
	    System.err.println(e);
	} catch (Throwable e) {
	    System.err.println("Throwable ...");
	    System.err.println(e);
	}
    }

}
