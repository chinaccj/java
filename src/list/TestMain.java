/**
 * 
 */
package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-10-22 ÏÂÎç5:34:29
 * @version 
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Address> homecfg = new ArrayList<Address>();
		Address address = new Address();
		address.setAddr(null);
		address.setDesc(null);
		
		Address address1 = new Address();
		address1.setAddr(null);
		address1.setDesc(null);
		
		Address address2 = new Address();
		address2.setAddr("hello");
		address2.setDesc("world");
		
		homecfg.add(address);
		homecfg.add(address1);
		homecfg.add(address2);
		
		for(int i=0;i<homecfg.size();i++){
			Address addr = homecfg.get(i);
			if(addr.getAddr() == null|| addr.getDesc()==null){
				homecfg.remove(addr);
				i--;
			}
		}
		
		System.out.println(homecfg.size());
		for(Address addr:homecfg){		
			System.out.println(addr.getAddr());	
		}
	}

}

