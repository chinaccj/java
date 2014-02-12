package generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Test {
	protected List<String> stringList = new ArrayList<String>();

	  public List<String> getStringList(){
	    return this.stringList;
	  }
	  
	  public void test()throws Exception{
			//================  get runtime  genericFieldType via Method ====================================
			Method method = Test.class.getMethod("getStringList", null);

			Type returnType = method.getGenericReturnType();

			if(returnType instanceof ParameterizedType){
			    ParameterizedType type = (ParameterizedType) returnType;
			    Type[] typeArguments = type.getActualTypeArguments();
			    for(Type typeArgument : typeArguments){
			        Class typeArgClass = (Class) typeArgument;
			        System.out.println("typeArgClass = " + typeArgClass);
			    }
			}
			
			
			//================  get runtime  genericFieldType via field ====================================
			
			Field field = Test.class.getDeclaredField("stringList");

			Type genericFieldType = field.getGenericType();
			    
			if(genericFieldType instanceof ParameterizedType){
			    ParameterizedType aType = (ParameterizedType) genericFieldType;
			    Type[] fieldArgTypes = aType.getActualTypeArguments();
			    for(Type fieldArgType : fieldArgTypes){
			        Class fieldArgClass = (Class) fieldArgType;
			        System.out.println("fieldArgClass = " + fieldArgClass);
			    }
			}
			
			
	  }
	  
	  public  void chill(List<?> aListWithTypeSpiderMan) { 
		//get runtime generic type via class
			Class genericParameter0OfThisClass = 
				    (Class)
				        ((ParameterizedType)
				        		aListWithTypeSpiderMan.getClass()
				                .getGenericSuperclass())
				                    .getActualTypeArguments()[0];
			System.out.println(genericParameter0OfThisClass.getName());
	    }
	  
	  
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Test t = new Test();
		//t.test();
		List<String> list= new ArrayList<String>();
		list.add("hello");
		
		t.chill(list);
	
		
	}

}
