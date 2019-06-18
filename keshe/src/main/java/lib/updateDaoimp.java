package lib;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
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
@Transactional
public class updateDaoimp implements updateDao{
	
	SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	//×Ô¶¯É¨Ãè×¢Èë(IoC)
	@Autowired  
	public updateDaoimp(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Train findTrain(String Tra_id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Train.class,Tra_id);

	}
	@Override
	public boolean addTrain(Train train) {
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(train);
			tx.commit();
			s.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		return true;
	}
	@Override
	public List<Train> allTrain() {
		// TODO Auto-generated method stub
		return (List<Train>)this.hibernateTemplate.find("from Train");
	}
	@Override
	public boolean deleteTrain(String Tra_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println(Tra_id);
		try{
			Session s = sessionFactory.openSession();
			s.beginTransaction();
			Train train=s.get(Train.class,Tra_id);
			if(train!=null){
				s.delete(train);
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
	@Override
	public boolean findTT(int TT_id) {
		// TODO Auto-generated method stub
		if(this.hibernateTemplate.get(TT.class,TT_id)!=null)
			return true;
		else
			return  false;
	}
	@Override
	public TT searchTT(int TT_id) {
		return this.hibernateTemplate.get(TT.class, TT_id);
	}
	@Override
	public boolean addTT(TT tt) {
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(tt);
			tx.commit();
			s.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		return true;
	}
	@Override
	public List<TT> allTT() {
		return (List<TT>)this.hibernateTemplate.find("from TT");
	}
	@Override
	public boolean deleteTT(int  TT_id) {
//		boolean flag = false;
//		System.out.println(TT_id);
//		try{
//			Session s = sessionFactory.openSession();
//			s.beginTransaction();
//			TT tt=s.get(TT.class,TT_id);
//			if(tt!=null){
//				s.delete(tt);
//				flag=true;
//			}
//			else
//				flag=false;
//			s.getTransaction().commit();
//			s.close();
//			}catch(Exception e ){
//				e.printStackTrace();
//			}
//		return flag;
		System.out.println("DEl");
		Session s = sessionFactory.openSession();
			s.doWork(new Work(){
				  public void execute(Connection conn) throws SQLException {
			         ResultSet rs = null;
					 CallableStatement call = conn.prepareCall("{call Del_TT(?)}");
					 call.setInt(1, TT_id);
					 call.execute();
					 call.close();
				  }
			});
		
		return true;
	}
	@Override
	public boolean addTime(Time time) {
		try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(time);
			tx.commit();
			s.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		return true;
	}
	@Override
	public Time findTime(int Tim_id) {
		return this.hibernateTemplate.get(Time.class, Tim_id);
	}
	@Override
	public List<Time> searchTim(String TT_id, String sId, String eId) {
		String hql="from Time t where t.TT_id="+TT_id+" and t.Tim_id between "+sId+"and "+eId;
		return (List<Time>)this.hibernateTemplate.find(hql);
	}
	@Override
	public List<Time> findSE_Time(int TT_id,int seq) {
		String hql = "from Time a where a.Tim_seq="+seq+"and a.TT_id="+TT_id;
		return (List<Time>)this.hibernateTemplate.find(hql);
	}
	@Override
	public List<Time> findTimebyTT_id(int TT_id) {
		String hql = "from Time a where  a.TT_id="+TT_id;
		return (List<Time>)this.hibernateTemplate.find(hql);
	}
	

}
