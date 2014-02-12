/**
 * 
 */
package mob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-26 下午8:40:16
 * @version 
 */
public class ClassPathResource {
	public static boolean isRegualMob(String mobiles){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(\\+8613[0-9])|(\\+8615[^4,\\D])|(\\+8618[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(ClassPathResource.isRegualMob("8615397121712"));
		
		List<String>listToMobs = new ArrayList<String>();
		listToMobs.add("3777490725");
		listToMobs.add("+861377749072003");
		listToMobs.add("13777490725");
		listToMobs.add("+8613777490724");
		listToMobs.add("137774925");
		listToMobs.add("+8613777490723");
		
		
		for (int i=0;i<listToMobs.size();i++) {
			//如果不是正常的电话号码    过滤掉，打个错误日志
			if(!isRegualMob(listToMobs.get(i))){
				listToMobs.remove(i);
				i--;
			}
			else {//正常号码
				if(listToMobs.get(i).startsWith("+86")){
					listToMobs.set(i, listToMobs.get(i).replace("+86", ""));
				}
			}
			//if(nonalmal code)  filter;
		}
		
		for(String str:listToMobs){
			System.out.println(str);
		}
	}
}

