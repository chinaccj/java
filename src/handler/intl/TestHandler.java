package handler.intl;

import java.lang.reflect.ParameterizedType;

public class TestHandler implements LogicHandler<String>{

	@Override
	public Object handle(String t) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParameterizedType pt= (ParameterizedType)(TestHandler.class.getGenericInterfaces()[0]);
		System.out.println(pt.getActualTypeArguments()[0].getClass());
	}

}
