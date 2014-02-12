/**
 * 
 */
package classloader;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2014年1月7日 下午7:31:27
 * @version
 */
public class GrandFather {

    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void sayHello() {
	System.out.println("hello world");
    }
}
