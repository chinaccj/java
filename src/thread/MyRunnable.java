/**
 * 
 */
package thread;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-6 ����8:12:19
 * @version
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {

	SayHello.sayHello();
    }

}
