/**
 * 
 */
package taxi;

/**
 * 通讯录分�?
 * @author chaojian.chen (ccj)
 * @modify date 2013-8-6 上午10:53:27
 * @version 
 */
public class ShareEvent {
	private Long passengerId  ;//分享者乘客id
	private String mob;//被分享�?电话号码
	
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	
}
