/**
 * 
 */
package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年1月29日 下午2:14:21
 * @version
 */
public class ThreadPoolExecutorTest {
    private final static ExecutorService executor = new ThreadPoolExecutor(4, 4, 0,
	    TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1000));

    private static class SayHello implements Runnable {
	@Override
	public void run() {
	    System.out.println("say hello...");
	    // throw new NullPointerException("test");
	}

    }

    public static void main(String[] args) {
	Future ft = executor.submit(new SayHello(), "good morning");
	try {
	    String string = ft.get().toString();
	    // System.out.println();
	    System.out.println(Long.MAX_VALUE);
	    System.out.println(Long.MAX_VALUE >> 1);
	    System.out.println(Long.MAX_VALUE << 1);

	} catch (InterruptedException e) {
	    e.printStackTrace();
	} catch (ExecutionException e) {
	    e.printStackTrace();
	}

    }

}
