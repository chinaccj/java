/**
 * 
 */
package exception;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-3 обнГ8:24:23
 * @version 
 */
public class MyException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7706886527988887535L;
	public MyException() {
	        super();
	    }
	 
	public MyException(String message) {
        super(message);
    }
	public MyException(String message, Throwable cause) {
        super(message, cause);
    }

}
