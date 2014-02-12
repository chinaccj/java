/**
 * 
 */
package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年1月2日 下午4:12:46
 * @version
 */
public class MainTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Set<String> set = new HashSet<String>();
	set.add("1111");
	set.add("1111");
	set.add("1111");

	System.out.println(set.size());
    }

}
