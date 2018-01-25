package com.hp.onlinexamqfnu.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.StuClass;

public class StuclassDao implements IStuClassDao{
	private DBUtil db=new DBUtil();

	@Override
	public List<Map<String, Object>> findAllStuClassInfo() {
		// TODO Auto-generated method stub
		String sql="select * from stuclass";
		List stuClassList=new ArrayList();
		try {
			stuClassList=db.getQueryList(StuClass.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuClassList=new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		String sql = "select * from stuclass where id = ?";
		try {
			return (Map<String, Object>)db.getObject(sql,new Object[] {classId});
		} catch (Exception e) {
			e.printStackTrace();
			return (Map<String, Object>) new StuClass();
		}
	}

	@Override
	public void addStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql="insert into stuclass values(?,?,?)";
		try {
			db.execute(sql, new Object[] {sc.getId(),sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql="update stuclass set id=?, name=?, deptName=? where id=? ";
		try {
			db.execute(sql,new Object[] {sc.getId(),sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List findClassNamesByIds(String ids) {
		
		String sql = "select name from stuclass where find_in_set(id,?)";
		List namelist=new ArrayList();
		try {
			namelist=db.getQueryList(sql,new Object[] {ids});
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return namelist;
	}

	@Override
	public List<Map<String,Object>> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql="SELECT * from stuclass where id in (select DISTINCT classId from teachercourse where teaId = ?)";
		List stuClassList=new ArrayList();
		try {
			stuClassList=db.getQueryList(StuClass.class,sql,new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuClassList=new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

}
