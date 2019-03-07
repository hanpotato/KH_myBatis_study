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
	//		- mybatis 안에 있는 Resources.getResourceAsStream 를 이용해서 inputStream안에 담는다.
	//		- 
	public static SqlSession getSession() {
		String resource = "/mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(inputStream);
			session = factory.openSession(false);//트랜젝션 설정 auto commit 을 못하게 하기 위해 'false' 값을 준다.
		} catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
}
