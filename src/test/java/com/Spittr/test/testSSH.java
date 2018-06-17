package com.Spittr.test;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spittr.entity.Spitter;

public class testSSH {

	private ApplicationContext ctx = null;

	@Test
	public void testDataSource() throws SQLException, SecurityException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SystemException {

		ctx = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		System.out.println(ctx);
		// System.out.println();
		// 测试数据源
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());

		// 测试SessionFactory
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);

		// 测试操作数据库表(session)
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Spitter spitter = new Spitter("222qqqq222", "123123", "123213");
		session.save(spitter);
		transaction.commit();
		session.close();

	}

}
