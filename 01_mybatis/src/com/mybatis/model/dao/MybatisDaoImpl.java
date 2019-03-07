package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public int selectCount(SqlSession session) {
		return session.selectOne("student.selectCount");
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> map) {
		return session.insert("student.insertMap", map);
	}

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("student.insertStudent");
		//insert 안에 mapper 이름이 student 이고, 그 mapper 안에 insertStudent로 선언된 sql문을 실행하라.
		return result;
	}
	
	// alt+s+v 누르면 새로 추가된 인터베이스가 들어감.
	// 오토박싱, 오토언박싱이라는 개념으로 인해서 오브젝트안에 기본자료형 값이 들어간다.
	@Override
	public int insertStudent(SqlSession session, String name) {
		return session.insert("student.insertName",name);
	}

	@Override
	public int insertStudent(SqlSession session, Student s) {
		return session.insert("student.insertAll",s);
	}
	
}