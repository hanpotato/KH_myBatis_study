package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Rstudent;
import com.mybatis.model.vo.Student;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public List<Map> memberSearch(SqlSession session, String keyword) {
		return session.selectList("student.memberSearch", keyword);
	}
	@Override
	public List<Map> memberAllMap(SqlSession session) {
		return session.selectList("student.memberAllMap");
	}
	@Override
	public List<Map<String, String>> selectTotalMap(SqlSession session) {
		return session.selectList("student.totalMap");

	}
/*
	@Override
	public List<Rstudent> selectTotal(SqlSession session) {
		return session.selectList("student.total");
	}
*/
	@Override
	public List selectTotal(SqlSession session) {
		return session.selectList("student.total");
	}

	@Override
	public int delete(SqlSession session, int no) {
		return session.delete("student.delete", no);
	}

	@Override
	public int DelOne(SqlSession session, int no) {
		return session.delete("student.deleteOne", no);
	}

	@Override
	public List<Student> memberAll(SqlSession session) {
		return session.selectList("student.memberAll");
	}
	
	@Override
	public int selectCount1(SqlSession session) {
		return session.selectOne("student.selectCount1");
	}

	@Override
	public Map selectMap(SqlSession session, int no) {
		return session.selectOne("student.selectMap",no);
	}

	@Override
	public Rstudent selectOne(SqlSession session, int no) {
		return session.selectOne("student.selectOne",no);
	}

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