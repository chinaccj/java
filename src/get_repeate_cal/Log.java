package get_repeate_cal;

public class Log {
    private String id;
    private String driver_id;
    private String order_id;
    private String event;
    private String dlt;
    private String create_time;

    public String toString() {
	StringBuffer bf = new StringBuffer();
	bf.append(" id=").append(id);
	bf.append(" driver_id=").append(driver_id);
	bf.append(" order_id=").append(order_id);
	bf.append(" event=").append(event);
	bf.append(" dlt=").append(dlt);
	bf.append(" create_time=").append(create_time);

	return bf.toString();

    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getDriver_id() {
	return driver_id;
    }

    public void setDriver_id(String driver_id) {
	this.driver_id = driver_id;
    }

    public String getOrder_id() {
	return order_id;
    }

    public void setOrder_id(String order_id) {
	this.order_id = order_id;
    }

    public String getEvent() {
	return event;
    }

    public void setEvent(String event) {
	this.event = event;
    }

    public String getDlt() {
	return dlt;
    }

    public void setDlt(String dlt) {
	this.dlt = dlt;
    }

    public String getCreate_time() {
	return create_time;
    }

    public void setCreate_time(String create_time) {
	this.create_time = create_time;
    }

}
