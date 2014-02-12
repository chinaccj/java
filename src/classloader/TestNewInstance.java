/**
 * 
 */
package classloader;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年1月15日 下午2:11:44
 * @version
 */
public class TestNewInstance {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	try {
	    Monkey monkey = (Monkey) Class.forName("classloader.Monkey").newInstance();
	    monkey.sayHello();

	    Monkey monkey1 = (Monkey) BeanUtils.instantiate(Monkey.class);
	    // TODO Auto-generated catch block

	} catch (RuntimeException e) {

	} catch (Throwable e) {
	    e.printStackTrace();
	} catch (BeanInstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
