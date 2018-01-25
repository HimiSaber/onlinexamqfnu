package com.hp.onlinexamqfnu.po;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DBUtilObjectTest {
	public static void main(String[] args )throws Exception{
	ResultSet rs=null;
	Teacher t=new Teacher();
/*	while(rs.next()) {
		int id=rs.getInt("id");
		String name=rs.getString("name");
		t.setId(id);
		t.setName(name);
		
	}*/
	DBUtil db=new DBUtil();
	
	String sql="SELECT * FROM TEACHER WHERE ID=1";
	Map<String,Object> teacherMap=db.getObject(sql);
	
	/*
	 * Map遍历
	 * Map的存储是键值对形式存储
	 * map值唯一
	 * map迭代可以使用iterator替代
	 * map里的key-value可以看成一个entry
	 * 
	 * 泛型的好处
	 */
	
	Iterator<Entry<String, Object>> it =teacherMap.entrySet().iterator();
	/*while(it.hasNext()) {
		Entry<String,Object> entry=it.next();
		System.out.println(entry.getKey()+"@@@"+entry.getValue());
		
	}*/
	String sql2="select * from teacher where id=?";
	Map<String,Object> teacherMap2=db.getObject(sql2,new Object[] {1});
	/*
	 * getObject三个参数用法
	 * 1.用于一条记录的查询
	 * 2.用于封装成对象
	 * 
	 */
	
	Teacher t2=(Teacher)db.getObject(Teacher.class,sql2,new Object[] {1});
	
	String sql3="select * from Questions where id=?";
	//Map<String, Object> questionMap3=db.getObject(sql3);
	Question q3=(Question)db.getObject(Question.class,sql3,new Object[]{1});
	System.out.println(q3.getQueTitle());
	
  }
	
}
