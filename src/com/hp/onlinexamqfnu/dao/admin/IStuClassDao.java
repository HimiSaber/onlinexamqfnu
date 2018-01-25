package com.hp.onlinexamqfnu.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;

public interface IStuClassDao {

	public List<Map<String, Object>> findAllStuClassInfo();

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClassById(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public List findClassNamesByIds(String ids);
	public List<Map<String, Object>> findStuClassesByTeacherId(int teaId);
}
