/**
 * 
 */
package reflect;

import java.lang.reflect.Constructor;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年1月8日 下午3:26:03
 * @version
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	Constructor ctor = TestMain.class.getDeclaredConstructor();
	System.out.println(ctor.getModifiers());
    }

}
