package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			/*
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(inputStream);
			session = factory.openSession(false);
			*/
			
			session = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
