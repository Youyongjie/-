package lib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import table.*;
@Service
public class userDaoimp implements userDao{
	User user;
	SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	//×Ô¶¯É¨Ãè×¢Èë(IoC)
	@Autowired  
	public userDaoimp(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean register(User user) {
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(user);
			tx.commit();
			s.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		return true;
	}
	@Override
	public User Finduserbyname(String name) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class,name);
	}

}
