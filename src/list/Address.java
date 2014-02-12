/**
 * 
 */
package list;

import java.io.Serializable;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-10-22 ÏÂÎç5:33:12
 * @version 
 */
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5780317355724375162L;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	private String addr;
	private Double lat;
	private Double lng;
	private String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}