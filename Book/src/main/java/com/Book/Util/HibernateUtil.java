package com.Book.Util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
public class HibernateUtil {
private static SessionFactory sessionFactory;
public static SessionFactory getSessionFactory() {
try {
sessionFactory = new 
Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
} catch (Exception e) {
System.out.println(e);
}
return sessionFactory;
}
}
