/**
 * 
 */
package annotation;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-11 ионГ11:27:12
 * @version 
 */
@MyAnnotation1("this isannotation1")
public class AnnotationDemo {
        public void sayHello() {
                 System.out.println("hello world!");
        }
        
        public static void main(String args[]){
        	AnnotationDemo obj = new AnnotationDemo();
        	obj.sayHello();
        }
}
