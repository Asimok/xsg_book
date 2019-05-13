package tools;
/*
 * date.after(begin):date表示的时间是否在begin代表的时间之后，是返回true,否则返回false
 * date.after(end):date表示的时间是否在end代表的时间之后，是返回true,否则返回false
 * */
import java.util.Calendar;
import java.util.Date;

public class TimePartDelay {
 public static boolean belongCalender(Date nowTime,Date beginTime,Date endTime)
 {
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar date=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 date.setTime(nowTime);
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar begin=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 begin.setTime(beginTime);
	 
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar end=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 end.setTime(endTime);
	 if(date.after(begin)&&date.before(end))
	 {
		 /*date.after(begin):date表示的时间是否在begin代表的时间之后，是返回true,否则返回false
		  * date.after(end):date表示的时间是否在end代表的时间之后，是返回true,否则返回false
		  * */
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	 
 }
 public static boolean beforeCalender(Date nowTime,Date beginTime)
 {
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar date=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 date.setTime(nowTime);
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar begin=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 begin.setTime(beginTime);
	 
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar end=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
//	 end.setTime(endTime);
	 if(date.before(begin))
	 {
		 /*date.after(begin):date表示的时间是否在begin代表的时间之后，是返回true,否则返回false
		  * 
		  * */
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	 
 }
 public static boolean afterCalender(Date nowTime,Date endTime)
 {
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar date=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
	 date.setTime(nowTime);
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar begin=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
//	 begin.setTime(beginTime);
	 
	 
	 /* 使用默认时区和语言环境获得一个日历*/
	 Calendar end=Calendar.getInstance();
	 
	 /* 使用给定的Date 设置此Calendar的时间*/
//	 end.setTime(endTime);
	 if(date.after(end))
	 {
		 /*
		  * date.after(end):date表示的时间是否在end代表的时间之后，是返回true,否则返回false
		  * */
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	 
 }
}
