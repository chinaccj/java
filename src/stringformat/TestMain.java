/**
 * 
 */
package stringformat;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-11-19 下午8:42:56
 * @version
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// Calendar c = Calendar.getInstance();
	// Calendar c1 = Calendar.getInstance();
	// c1.add(Calendar.DAY_OF_MONTH, -2);
	// System.out.println(c1.get(Calendar.MONTH));
	//
	// String s =
	// String.format("Duke's Birthday: %1$tm %1$te,%1$tY,month %2$te %3b",
	// c,c1,null);

	String s = String.format("%01x%01x%04x%s", 8, 7, 11, "你好吗");

	System.out.println(s);
	String modelsString = "1,2,3,4";
	String idsString[] = modelsString.split(",");
	for (String str : idsString) {
	    System.out.println(str);
	}
    }

}
