package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    public Test() {
	list.add(new Entity(1, 0));
	list.add(new Entity(2, 5));
	list.add(new Entity(3, 15));
	list.add(new Entity(4, 30));
    }

    List<Entity> list = new ArrayList<Entity>();

    private int percentage = 0;

    public static void doSplit(String jsonString) {
	if (jsonString.startsWith("{") && jsonString.endsWith("}")) {
	    String string = jsonString.substring(1, jsonString.length() - 1);
	    int pos = string.indexOf(",");
	    System.out.println(string.substring(0, pos - 1));
	    System.out.println(string.substring(pos + 1, string.length()));
	} else {
	    System.err.println("not json format");
	}

    }

    public boolean isPush() {
	// TODO Auto-generated method stub
	Random r = new Random();
	int sead = r.nextInt(100);
	if (sead > 0 && sead <= percentage) {
	    return true;
	} else
	    return false;
    }

    private String genZero(int number) {
	switch (number) {
	case 0:
	    return "";
	case 1:
	    return "0";
	case 2:
	    return "00";
	case 3:
	    return "000";
	case 4:
	    return "0000";
	case 5:
	    return "00000";
	case 6:
	    return "000000";
	case 7:
	    return "0000000";
	case 8:
	    return "00000000";
	default:
	    return "";
	}
    }

    public static String extractionObjectString(String str) {
	if (str == null)
	    return "";

	int start = 0;
	int end = str.length() - 1;
	boolean findLeftBraces = false;
	boolean findRightBraces = false;

	char[] chars = str.toCharArray();
	int pos = chars.length;
	while (pos > 0) {
	    if (!findLeftBraces) {
		if (chars[start] == '{') {
		    findLeftBraces = true;
		} else {
		    start++;
		}
	    }

	    if (!findRightBraces) {
		if (chars[end] == '}') {
		    findRightBraces = true;
		} else {
		    end--;
		}
	    }

	    if (findLeftBraces && findRightBraces)
		break;
	    pos--;
	}

	System.out.println("start=" + start);
	System.out.println("end=" + end);

	if (findLeftBraces && findRightBraces) {
	    String objString = str.substring(start, end + 1);

	    System.out.println(objString);

	    return objString;
	} else {
	    return "";
	}
    }

    public static Integer plusdivise(Integer cityid) {
	cityid = cityid / 100 * 100;

	return cityid;
    }

    private int getLevel(int orders) {

	int i = 0;
	for (; i < list.size(); i++) {
	    Entity entity = list.get(i);
	    if (entity.getOrders() == orders)
		return entity.getLevel();
	    else if (entity.getOrders() < orders) {
		continue;
	    } else if (entity.getOrders() > orders) {
		return entity.getLevel() - 1;
	    }
	}

	if (i == list.size()) {
	    return list.get(list.size() - 1).getLevel();
	}

	return -1;
    }

    private int getNextLevelOrders(int level) {

	for (int i = 0; i < list.size(); i++) {
	    Entity entity = list.get(i);
	    if (entity.getLevel() == level) {
		if ((i + 1) < list.size()) {
		    return list.get(i + 1).getOrders();
		} else {
		    // 暂时写死，，预防越界
		    return list.get(i).getOrders() + 2000;
		}
	    }
	}

	return -1;
    }

    public void calLevel(int levelTotal) {
	int mainLevel = (int) (levelTotal / (9.1));
	int minLevel = levelTotal % 9;
	if (minLevel == 0) {
	    minLevel = 9;
	}

	System.out.println("mainLevel=" + mainLevel);
	System.out.println("minLevel=" + minLevel);
    }

    public static void main(String[] args) throws Exception {
	// Test test = new Test();
	// int level = test.getLevel(15);
	// System.out.println(level);
	// System.out.println("new level needs:"+test.getNextLevelOrders(level));

	// test.calLevel(1);

	int result = -1 / 100 * 100;
	System.out.println(result);

    }

    class Entity {
	private Entity(int level, int orders) {
	    super();
	    this.level = level;
	    this.orders = orders;
	}

	public int getLevel() {
	    return level;
	}

	public void setLevel(int level) {
	    this.level = level;
	}

	public int getOrders() {
	    return orders;
	}

	public void setOrders(int orders) {
	    this.orders = orders;
	}

	int level;
	int orders;
    }

}
