package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import vo.CustomerVo;

public class CustomerDao {

	static AnnotationConfiguration configuration;
	static SessionFactory factory;
	Session session;
	Transaction transaction;
	
	public void getConnection()
	{
		configuration=new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		factory=configuration.buildSessionFactory();
		session=factory.openSession();
	}
	
	public List<CustomerVo> getAllCustomers()
	{
		getConnection();
		session=factory.openSession();
		List<CustomerVo> list=session.createQuery("from CustomerVo").list();
		return list;
	}
	
	public List<CustomerVo> getData(CustomerVo customerVo){
		getConnection();
		session=factory.openSession();
		List<CustomerVo> dataList=session.createQuery("from CustomerVo where customerName='" + customerVo.getCustomerName()+ "'").list();
		return dataList;
	}
	
	public List<CustomerVo> getCustomerData(CustomerVo customerVo){
		getConnection();
		session=factory.openSession();
		List<CustomerVo> dataList=session.createQuery("from CustomerVo where customerNumber='" + customerVo.getCustomerNumber()+ "'").list();
		return dataList;
	}
	
	public List<CustomerVo> getEmail(CustomerVo customerVo){
		getConnection();
		session=factory.openSession();
		List<CustomerVo> list=session.createQuery("from CustomerVo where customerEmail='" + customerVo.getCustomerEmail() + "'").list();
		return list;
	}
}
