package get_repeate_cal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {
    private String orderId;

    public String getOrderId() {
	return orderId;
    }

    public void setOrderId(String orderId) {
	this.orderId = orderId;
    }

    private List<Log> list = new ArrayList<Log>();

    public List<Log> getList() {
	return list;
    }

    public void addLog(Log log) {
	list.add(log);
    }

    public void printAll() {
	for (Log log : list) {
	    System.out.println(log.toString());
	}
    }

    // 是否过度计算
    public boolean isOverCal() {
	int size = list.size();
	Set<String> set = new HashSet<String>();
	for (Log log : list) {
	    String oidString = log.getOrder_id();
	    set.add(log.getEvent());
	}

	if (set.size() < size && size > 3) {
	    set.clear();
	    return true;
	} else {
	    set.clear();
	    return false;
	}
    }
}
