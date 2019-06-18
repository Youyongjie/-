package lib;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import table.*;
@Service
public class mainDaoimp implements mainDao{
	SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	//自动扫描注入(IoC)
	@Autowired  
	public mainDaoimp(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<SE> search(String time, String start_sta, String end_sta) {
		Session s = sessionFactory.openSession();
		s.doWork(new Work(){
			  public void execute(Connection conn) throws SQLException {
		         ResultSet rs = null;
				 CallableStatement call = conn.prepareCall("{call search(?,?,?)}");
				 call.setString(1, time);
				 call.setString(2, start_sta);
				 call.setString(3, end_sta);
				 call.execute();
				 call.close();
			  }
		});
	 return (List<SE>)this.hibernateTemplate.find("from SE s where s.selected='未选'");
	}

	@Override
	public boolean buyTicket(String SE_id,String TT_id,String user,String price) {
		Session s = sessionFactory.openSession();
		s.doWork(new Work(){
			  public void execute(Connection conn) throws SQLException {
		         ResultSet rs = null;
				 CallableStatement call = conn.prepareCall("{call buyTicket(?,?,?,?)}");
				 call.setString(1, SE_id);
				 call.setString(2, TT_id);
				 call.setString(3, user);
				 call.setString(4, price);
				 call.execute();
				 call.close();
			  }
		});
		System.out.println("buydaoimp");
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> showTicket(String username) {
		// TODO Auto-generated method stub
		return (List<Ticket>)this.hibernateTemplate.find("from Ticket t where t.User_name='"+username+"'");
	}
	@Override
	public SE findSE(int SE_id) {
		return this.hibernateTemplate.get(SE.class,SE_id);
	}
	@Override
	public Seat findSeat(int Seat_id) {
		return this.hibernateTemplate.get(Seat.class, Seat_id);
	}
	@Override
	public boolean delTicket(String Tic_id) {
		boolean flag = false;
		try{
			Session s = sessionFactory.openSession();
			s.beginTransaction();
			Ticket tic=s.get(Ticket.class,Integer.parseInt(Tic_id));
			if(tic!=null){
				s.delete(tic);
				flag=true;
			}
			else
				flag=false;
			s.getTransaction().commit();
			s.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		return flag;
	}
	
}
