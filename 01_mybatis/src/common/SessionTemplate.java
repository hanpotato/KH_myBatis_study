package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {

	//1. mybatis-config.xml의 설정을 불러와서 적용
	//2. 적용한 session 생성해서 return;
	public static SqlSession getSession() {
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = build.build(is);
			session = factory.openSession(false);//트랜젝션 설정
		} catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
}
