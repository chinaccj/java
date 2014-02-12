package get_repeate_cal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMain {
    private Map<String, Order> map = new HashMap<String, Order>();
    private List<Order> bugOrders = new ArrayList<Order>();

    public void readFile(File file) {
	InputStream stream = null;
	try {

	    Order order = new Order();

	    stream = new FileInputStream(file);
	    LineNumberReader reader = new LineNumberReader(new InputStreamReader(stream));
	    String line = null;
	    while ((line = reader.readLine()) != null) {
		String datas[] = line.split("\\|");
		String newOrderIdString = datas[2];

		if (order.getOrderId() == null || order.getOrderId().equals(newOrderIdString)) {
		    Log log = new Log();
		    log.setId(datas[0]);
		    log.setDriver_id(datas[1]);
		    log.setOrder_id(datas[2]);
		    log.setEvent(datas[3]);
		    log.setDlt(datas[4]);
		    log.setCreate_time(datas[5]);

		    order.setOrderId(newOrderIdString);

		    order.addLog(log);
		} else {
		    map.put(order.getOrderId(), order);

		    order = new Order();
		    Log log = new Log();
		    log.setId(datas[0]);
		    log.setDriver_id(datas[1]);
		    log.setOrder_id(datas[2]);
		    log.setEvent(datas[3]);
		    log.setDlt(datas[4]);
		    log.setCreate_time(datas[5]);

		    order.setOrderId(newOrderIdString);

		    order.addLog(log);
		}

	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (stream != null) {
		try {
		    stream.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}

    }

    public void recover(File file) {
	readFile(file);

	Set<String> keySet = map.keySet();
	for (Iterator<String> ite = keySet.iterator(); ite.hasNext();) {
	    String keyString = ite.next();
	    Order order = map.get(keyString);
	    if (order.isOverCal()) {
		bugOrders.add(order);
		// order.printAll();
	    }
	}

	for (Order order : bugOrders) {
	    if (order.getList().size() == 4) {
		String eventString0 = order.getList().get(0).getEvent();
		String eventString1 = order.getList().get(1).getEvent();
		String eventString2 = order.getList().get(2).getEvent();
		String eventString3 = order.getList().get(3).getEvent();
		if (eventString0.equals(eventString2) && eventString1.equals(eventString3)) {
		    int dlt3 = Integer.parseInt(order.getList().get(2).getDlt());
		    int dlt4 = Integer.parseInt(order.getList().get(3).getDlt());

		    int recover = (-(dlt3 + dlt4));
		    if (recover != 0) {

			String recoverString = "";
			if (recover > 0) {
			    recoverString = "+" + recover;
			} else if (recover < 0) {
			    recoverString = "" + recover;
			}
			// order.printAll();
			System.out.println("update T_DriverStar set ScoreTotal = ScoreTotal"
				+ recoverString + " where DriverId="
				+ order.getList().get(0).getDriver_id() + " limit 1;");
		    }
		}
	    }
	}
    }

    public static void main(String[] args) {
	TestMain main = new TestMain();
	main.recover(new File("D:\\driver_score_log1.txt"));
    }
}
