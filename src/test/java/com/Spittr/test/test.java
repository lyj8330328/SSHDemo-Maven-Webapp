package com.Spittr.test;

import org.springframework.context.ApplicationContext;

public class test {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ctx = new
		// FileSystemXmlApplicationContext("/config/applicationContext.xml");
		// ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// System.out.println(ctx);
		String path[] = System.getProperty("java.class.path").split(";");
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}
		System.out.println(System.getProperty("java.class.path"));
	}

}
