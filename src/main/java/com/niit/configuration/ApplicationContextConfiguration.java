/*package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.BlogDAOImpl;
import com.niit.DAO.ForumDAO;
import com.niit.DAO.ForumDAOImpl;
import com.niit.DAO.FriendDAO;
import com.niit.DAO.FriendDAOImpl;
import com.niit.DAO.JobDAO;
import com.niit.DAO.JobDAOImpl;
import com.niit.DAO.UserDAO;
import com.niit.DAO.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfiguration {

	
	@Bean(name="dataSource")
	 public DataSource getDataSource(){
	DriverManagerDataSource dataSource=new DriverManagerDataSource();	
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("KRISHNA");
	dataSource.setPassword("3132");
	return dataSource;
	}

private Properties getHibernateProperties(){
	Properties properties=new Properties();
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	properties.put("hibernate.hbm2ddl.auto", "update");
	return properties;
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource){
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(Blog.class);
	sessionBuilder.addAnnotatedClass(User.class);
	sessionBuilder.addAnnotatedClass(Forum.class);
	sessionBuilder.addAnnotatedClass(Job.class);
	sessionBuilder.addAnnotatedClass(Friend.class);
	return sessionBuilder.buildSessionFactory();
	
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
HibernateTransactionManager transactionManager=new 	HibernateTransactionManager(sessionFactory);
return transactionManager;
	
}
@Autowired
@Bean(name="blogDAO")
public BlogDAO getBlogDAO(SessionFactory sessionFactory){
	
	return new BlogDAOImpl(sessionFactory);
}

@Autowired
@Bean(name="usersDAO")
public UserDAO getUsersDAO(SessionFactory sessionFactory){
	
	return new UserDAOImpl(sessionFactory);
}
@Autowired
@Bean(name="forumDAO")
public ForumDAO getForumDAO(SessionFactory sessionFactory){
	
	return new ForumDAOImpl(sessionFactory);
}
@Autowired
@Bean(name="jobDAO")
public JobDAO getJobDAO(SessionFactory sessionFactory){
	
	return new JobDAOImpl(sessionFactory);
}

@Autowired
@Bean(name="friendDAO")
public FriendDAO getFriendDAO(SessionFactory sessionFactory){
	
	return new FriendDAOImpl(sessionFactory);
}
}*/