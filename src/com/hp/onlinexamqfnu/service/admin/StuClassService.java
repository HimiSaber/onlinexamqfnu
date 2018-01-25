package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.IStuClassDao;
import com.hp.onlinexamqfnu.dao.admin.StuclassDao;
import com.hp.onlinexamqfnu.po.StuClass;

public class StuClassService implements IStuClassService{
	/*
	 * 向上转型
	 * 1、声明是接口，等号右侧是实现类
	 * 2、声明是父类，等号右侧是子类
	 */
	private IStuClassDao scd=new StuclassDao();

	@Override
	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		
		return scd.findAllStuClassInfo();
	}

	@Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClassById(sc);
		
	}

	@Override
	public void updateStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.updateStuClassById(sc);
		
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		// TODO Auto-generated method stub
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		List nameList=scd.findClassNamesByIds(ids);
		if(nameList==null||nameList.size()<1) {
			return "";}
			StringBuffer sb=new StringBuffer();
		for(int i=0;i<nameList.size();i++) {
			Map stuMap=(Map)nameList.get(i);
			sb.append(stuMap.get("name")).append(" ");
		}
		return sb.toString();
	}

	@Override
	public List<Map<String,Object>> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return scd.findStuClassesByTeacherId(teaId);
	}
	

}
