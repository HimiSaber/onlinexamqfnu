package com.hp.onlinexamqfnu.po;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DBUtilQueryTest {
	public static void main(String[] args) throws Exception {
		DBUtil db=new DBUtil();
		String sql="select * from teacher";
		List<Map<String,Object>> teacherList=db.getQueryList(sql);
		
		for(int i=0;i<teacherList.size();i++) {
			Map<String,Object> teaMap=teacherList.get(i);
			Iterator<Entry<String,Object>> it=teaMap.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String,Object> entry=it.next();
				System.out.println(entry.getKey()+"@@@"+entry.getValue());
			}
			System.out.println();
		}
		String sql2="SELECT * FROM STUDENT WHERE SEX=? AND COURSEID=? ";
		@SuppressWarnings("unused")
		List<Map<String,Object>> stuList =db.getQueryList(sql2,new Object[] {"男",3});
		String sql3="SELECT * FROM course";
		List courseList =db.getQueryList(Course.class,sql2,new Object[] {});
	}

}
