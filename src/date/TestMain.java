/**
 * 
 */
package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-4 ����4:25:34
 * @version
 */
public class TestMain {

    // public static long convert2long(String date, String format)
    // throws Exception {
    //
    // SimpleDateFormat sf = new SimpleDateFormat(format);
    // return sf.parse(date).getTime();
    // }

    // 获得当前日期与本周日相差的天数
    private static int getMondayPlus() {
	Calendar cd = Calendar.getInstance();
	// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
	int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
	if (dayOfWeek == 1) {
	    return 0;
	} else {
	    return 1 - dayOfWeek;
	}
    }

    // 获得本周一的日期
    private static String getMondayOFWeek() {
	int mondayPlus = getMondayPlus();
	GregorianCalendar currentDate = new GregorianCalendar();
	currentDate.add(GregorianCalendar.DATE, mondayPlus);
	Date monday = currentDate.getTime();

	DateFormat df = DateFormat.getDateInstance();
	String preMonday = df.format(monday);
	return preMonday;
    }

    public static String getCurrentWeekday() {
	int weeks = 0;
	int mondayPlus = getMondayPlus();
	GregorianCalendar currentDate = new GregorianCalendar();
	currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
	Date monday = currentDate.getTime();

	DateFormat df = DateFormat.getDateInstance();
	// SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String preMonday = df.format(monday);
	return preMonday;
    }

    public static String getPreviousWeekMonday() {
	int weeks = 0;
	weeks--;

	int mondayPlus = getMondayPlus();

	GregorianCalendar currentDate = new GregorianCalendar();

	currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);

	Date monday = currentDate.getTime();

	SimpleDateFormat df = new SimpleDateFormat("MM月-dd日");

	String preMonday = df.format(monday);

	return preMonday;
    }

    public static String getPreviousWeekSunday() {

	int weeks = 0;

	weeks--;

	int mondayPlus = getMondayPlus();

	GregorianCalendar currentDate = new GregorianCalendar();

	currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);

	Date monday = currentDate.getTime();

	SimpleDateFormat df = new SimpleDateFormat("MM月-dd日");

	String preMonday = df.format(monday);

	return preMonday;

    }

    private static boolean isActivityOn(String startDate, String endDate) {
	try {

	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date start = df.parse(startDate);
	    Date end = df.parse(endDate);

	    long currentTime = System.currentTimeMillis();
	    if (currentTime >= start.getTime() && currentTime <= end.getTime()) {
		return true;
	    } else {
		return false;
	    }

	} catch (Exception e) {
	    return false;
	}
    }

    public static void main(String args[]) throws Exception {

	System.out.println(isActivityOn("2013-12-17", "2013-12-18"));

    }
}
