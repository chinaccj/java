/**
 * 
 */
package thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-9 ����5:20:04
 * @version
 */
public class DelayExcutor {
    private static ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);

    // ����
    protected static void Execute(Runnable command, long delay) {
	ScheduledFuture future = executor.schedule(command, delay, TimeUnit.MILLISECONDS);

	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	future.cancel(false);

	if (future.isDone()) {
	    System.out.println("executor done");
	    // executor.scheduleWithFixedDelay(command, 500, 500,
	    // TimeUnit.MILLISECONDS);
	}
	// executor.scheduleWithFixedDelay(, initialDelay, delay, );
    }
}
