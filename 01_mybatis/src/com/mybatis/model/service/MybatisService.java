package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import com.mybatis.model.vo.Rstudent;
import com.mybatis.model.vo.Student;

public interface MybatisService {
	
	//오버로딩 개념 : 같은 메소드의 명칭을 쓸 수 있다.(매개변수만 다르게 하면 쓸수 있는..)
	int insertStudent();
	int insertStudent(String name);
	int insertStudent(Student s);
	int insertStudent(Map<String,Object> map);
	int selectCount();
	int selectCount1();
	Rstudent selectOne(int no);
	Map selectMap(int no);
	int DelOne(int no);
	int delete(int no);
	/*List<Rstudent> selectTotal();*/
	List selectTotal();
	List<Map<String,String>> selectTotalMap();
}
