/**
 * 
 */
package finalIdentity;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-12-9 下午8:05:40
 * @version
 */
public class TestMain {

    private static void test() throws Exception {
	for (int i = 0; i < 1000; i++) {
	    final byte array[] = new byte[1024 * 10];
	    System.out.println(array.hashCode());
	    Thread.sleep(500);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	test();
    }

}
