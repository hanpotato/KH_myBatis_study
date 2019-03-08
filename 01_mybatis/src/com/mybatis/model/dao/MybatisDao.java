package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Rstudent;
import com.mybatis.model.vo.Student;

public interface MybatisDao {

	int insertStudent(SqlSession session);
	int insertStudent(SqlSession session, String name);
	int insertStudent(SqlSession session, Student s);
	int insertStudent(SqlSession session, Map<String,Object> map);
	int selectCount(SqlSession session);
	int selectCount1(SqlSession session);
	Rstudent selectOne(SqlSession session, int no);
	Map selectMap(SqlSession session, int no);
	int DelOne(SqlSession session, int no);
	int delete(SqlSession session, int no);
	/*List<Rstudent> selectTotal(SqlSession session);*/
	List selectTotal(SqlSession session);
	List<Map<String, String>> selectTotalMap(SqlSession session);
}
