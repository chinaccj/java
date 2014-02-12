/**
 * 
 */
package taxi;



/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-7-31 ионГ11:38:42
 * @version 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String mobString = "13777484574,187896665,1323333652";
		String mobs[] = mobString.split(",");
		for(String str:mobs){
			System.out.println(str);
		}
		
		Integer stateInteger = 4;
		
		 if(OrderStatus.TIMEOUT.getCode().equals(stateInteger)){
			 System.out.println("time out meet");
		 }
	}

}
