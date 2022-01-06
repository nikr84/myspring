package com.nikorp.myspring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nikorp.myspring.aop.AccountDAO;
import com.nikorp.myspring.aop.MembershipDAO;
import com.nikorp.myspring.config.NewSportsConfig;
import com.nikorp.myspring.hibernate.entity.Employee;
import com.nikorp.myspring.ioc.Coach;

@SpringBootApplication
//@ComponentScan("com.nikorp.myspring")
public class MySpringApplication {

	private final static Logger logger = LoggerFactory.getLogger(MySpringApplication.class);
	private Session session;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringApplication.class, args);
		
		logger.info("shit");
		
		MySpringApplication mySpringApplication = new MySpringApplication();
//		new Thread(() -> new Runnable() {
//		public void run() {
			mySpringApplication.run();
//		}
//	}).start();
//			mySpringApplication.hibernate();
	}
	
	private void hibernate() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			if (session.createQuery("from Employee e where e.firstName='Nikhil'").getResultStream().findAny().isPresent()) {
				logger.debug("Nikhil as First Name already exists !");
			} else {
				Employee employee = new Employee("Nikhil", "Rastogi", "rastogi.nik@gmail.com");
				session.save(employee);
				
				session.getTransaction().commit();
				session.close();
				logger.debug("Employee SAVED!");
				
				session = sessionFactory.getCurrentSession();
				logger.debug("Employee1=" + employee);
				session.beginTransaction();
				Employee e2 = session.get(Employee.class, employee.getId());
				e2.setLastName("Kapoor");
				logger.debug("Employee2=" + e2);
				session.getTransaction().commit();
				session.close();
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				session.createQuery("update Employee set email='chhichhi@goo.com' where lastName='Kapoor'").executeUpdate();
				session.getTransaction().commit();
				session.close();
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				session.delete(employee);
				logger.debug("Employee DELETED!");
			}
			session.getTransaction().commit();
			session.close();
			
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	private void run() {
		ClassPathXmlApplicationContext context = null;
		AnnotationConfigApplicationContext context2 = null;
		try {
//			context2 = new AnnotationConfigApplicationContext(OldSportsConfig.class);
//			context = new ClassPathXmlApplicationContext("applicationContext.xml");
//			
//			Coach basketballCoach = context.getBean("myCoach", Coach.class);
//			logger.debug("basketballCoach.getDailyWorkout()="+basketballCoach.getDailyWorkout());
//			logger.debug("basketballCoach.getDailyFortune(1)="+basketballCoach.getDailyFortune());
//			logger.debug("basketballCoach.getDailyFortune(2)="+basketballCoach.getDailyFortune());
//			logger.debug("basketballCoach.getDailyFortune(3)="+basketballCoach.getDailyFortune());
//			
//			Coach trackCoachCoach = context2.getBean("trackCoach", Coach.class);
//			logger.debug("trackCoachCoach.getDailyWorkout()="+trackCoachCoach.getDailyWorkout());
//			logger.debug("trackCoachCoach.getDailyFortune(1)="+trackCoachCoach.getDailyFortune());
//			logger.debug("trackCoachCoach.getDailyFortune(2)="+trackCoachCoach.getDailyFortune());
//			logger.debug("trackCoachCoach.getDailyFortune(3)="+trackCoachCoach.getDailyFortune());
			
			context2 = new AnnotationConfigApplicationContext(NewSportsConfig.class);
			Coach swimCoachCoach = context2.getBean("swimCoach", Coach.class);
			logger.debug("swimCoachCoach.getDailyWorkout()="+swimCoachCoach.getDailyWorkout());
			logger.debug("swimCoachCoach.getDailyFortune(1)="+swimCoachCoach.getDailyFortune());
			
			AccountDAO theADAO = context2.getBean("accountDAO", AccountDAO.class);
			theADAO.addAccount();
			theADAO.getX();
			
			MembershipDAO theMDAO = context2.getBean("membershipDAO", MembershipDAO.class);
			theMDAO.addAccount(5);
			theMDAO.getFff();
		} finally {
			if (context != null)
				context.close();
			
			if (context2 != null)
				context2.close();
		}
	}

}
