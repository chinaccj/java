/**
 * 
 */
package encode;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-12-17 下午4:54:24
 * @version
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	String dec = java.net.URLDecoder
		.decode("http://m.gome.com.cn/Promotion_zone.html?actId=179200402&actUrl=http%3A%2F%2Fprom.gome.com.cn%2Fhtml%2Fprodhtml%2Ftopics%2Fdfesfnafhjsafsasafcxh.html&cmpid=kuaidi_179200402_sy_sj_5",
			"UTF-8");
	System.out.println(dec);

    }

}
