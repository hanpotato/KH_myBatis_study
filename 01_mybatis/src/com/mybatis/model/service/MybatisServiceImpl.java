package com.mybatis.model.service;

import static common.SessionTemplate.getSession;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;
import com.mybatis.model.vo.Student;

public class MybatisServiceImpl implements MybatisService {

	@Override
	public int selectCount() {
		SqlSession session = getSession();
		int result = dao.selectCount(session);
		session.close();
		return result;
	}

	private MybatisDao dao = new MybatisDaoImpl();
	
	@Override
	public int insertStudent() {
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	// alt+s+v 하면 추가된 인터페이스 값이 들어간다.
	@Override
	public int insertStudent(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session,name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	@Override
	public int insertStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session,s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	@Override
	public int insertStudent(Map<String, Object> map) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session,map);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
}
