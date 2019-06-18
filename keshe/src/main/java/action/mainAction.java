package action;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lib.mainDao;
import lib.updateDao;
import lib.userDao;

import com.opensymphony.xwork2.ActionSupport;
import table.*;
@ParentPackage("basicstruts2")
@Namespace("/")
@Results({ 	
    @Result(name = "showSE",type="redirect", location = "/showSE.jsp?"),
    @Result(name = "showTime",type="redirect", location = "/showTime.jsp"),
    @Result(name = "Main",type="redirect", location = "/main.jsp"),
    @Result(name = "showTicket",type="redirect", location = "/showTicket.jsp"),
    @Result(name = "not_enough_money",type="redirect", location = "/not_enough_money.jsp"),
    @Result(name = "User_info",type="redirect", location = "/User_info.jsp"),
})
@AllowedMethods("regex:.*")
public class mainAction extends ActionSupport {
	@Action(value="mainAction")
	public String search(){
		System.out.println(time+start_sta+end_sta);
		List<SE> allSE=dao.search(time,start_sta,end_sta);
		List <Time> sTime=new ArrayList<Time>();
		List <Time> eTime=new ArrayList<Time>();
		List <TT> tt=new ArrayList<TT>();
		int length = allSE.size();
		int i=0;
		while(i<length){
			System.out.println(allSE.get(i).getTim_id_start());
			sTime.add(u_dao.findTime(allSE.get(i).getTim_id_start()));
			eTime.add(u_dao.findTime(allSE.get(i).getTim_id_end()));
			tt.add(u_dao.searchTT(eTime.get(i).getTT_id()));
			i++;
		}
		session.put("allSE", allSE);
		session.put("sTime", sTime);
		session.put("eTime", eTime);
		session.put("tt", tt);
		return "showSE";
	}
	public String SE_showTime (){
		session.put("Time",u_dao.searchTim(TT_id,sId,eId));
		session.put("back", "showSE.jsp");
		return "showTime";
	}
	public String buyTicket(){
		String user=(String)session.get("user");
		System.out.println("TT_id"+TT_id+"SE_id"+SE_id+"Æ±¼Û"+Tic_price+user);
		User u=user_dao.Finduserbyname(user);
			if(u!=null)
				if(u.getBalance()>=Integer.parseInt(Tic_price))
					dao.buyTicket(SE_id,TT_id,user,Tic_price);
				else
					return "not_enough_money";
		time=(String)session.get("time");
		start_sta=(String)session.get("start_sta");
		end_sta=(String)session.get("end_sta");
		System.out.println(time+start_sta+end_sta);
		List<SE> allSE=dao.search(time,start_sta,end_sta);
		List <Time> sTime=new ArrayList<Time>();
		List <Time> eTime=new ArrayList<Time>();
		List <TT> tt=new ArrayList<TT>();
		int length = allSE.size();
		int i=0;
		while(i<length){
			System.out.println(allSE.get(i).getTim_id_start());
			sTime.add(u_dao.findTime(allSE.get(i).getTim_id_start()));
			eTime.add(u_dao.findTime(allSE.get(i).getTim_id_end()));
			tt.add(u_dao.searchTT(eTime.get(i).getTT_id()));
			i++;
		}
		session.put("allSE", allSE);
		session.put("sTime", sTime);
		session.put("eTime", eTime);
		session.put("tt", tt);
		return "showSE";
	}
	public String info(){
		String username=(String )session.get("user");
		User user=user_dao.Finduserbyname(username);
		System.out.println("UseName"+username );
		session.put("User", user);
		return "User_info";
	}
	public String bought(){
		String username=(String )session.get("user");
		List<Ticket> allTicket=dao.showTicket(username);
		List <SE> SE=new ArrayList<SE>();
		List <Seat>Seat=new ArrayList<Seat>();
		List <TT>tt=new ArrayList<TT>();
		List <Time>sTime=new ArrayList<Time>();
		List <Time>eTime=new ArrayList<Time>();
		int i=0;
		int length=allTicket.size();
		while(i<length){
			SE se=dao.findSE(allTicket.get(i).getSE_id());
			SE.add(se);
			Seat s =dao.findSeat(allTicket.get(i).getSeat_id());
			Seat.add(dao.findSeat(allTicket.get(i).getSeat_id()));
			tt.add(u_dao.searchTT(s.getTT_id()));
			sTime.add(u_dao.findTime(se.getTim_id_start()));
			eTime.add(u_dao.findTime(se.getTim_id_end()));
			i++;
		}
		session.put("SE", SE);
		session.put("Seat",Seat);
		session.put("TT", tt);
		session.put("allTicket",allTicket);
		session.put("sTime", sTime);
		session.put("eTime", eTime);
		return "showTicket";
	}
	public String Ticket_showTime(){
		System.out.println("TT_id"+TT_id+"eId"+eId+"sId"+sId );
		session.put("Time",u_dao.searchTim(TT_id,sId,eId));
		session.put("back", "showTicket.jsp");
		return"showTime";
	}
	public String delTicket(){
		if(dao.delTicket(Tic_id))
			System.out.println("ÍËÆ±³É¹¦");
		String username=(String )session.get("user");
		List<Ticket> allTicket=dao.showTicket(username);
		List <SE> SE=new ArrayList<SE>();
		List <Seat>Seat=new ArrayList<Seat>();
		List <TT>tt=new ArrayList<TT>();
		List <Time>sTime=new ArrayList<Time>();
		List <Time>eTime=new ArrayList<Time>();
		int i=0;
		int length=allTicket.size();
		while(i<length){
			SE se=dao.findSE(allTicket.get(i).getSE_id());
			SE.add(se);
			Seat s =dao.findSeat(allTicket.get(i).getSeat_id());
			Seat.add(dao.findSeat(allTicket.get(i).getSeat_id()));
			tt.add(u_dao.searchTT(s.getTT_id()));
			sTime.add(u_dao.findTime(se.getTim_id_start()));
			eTime.add(u_dao.findTime(se.getTim_id_end()));
			i++;
		}
		session.put("SE", SE);
		session.put("Seat",Seat);
		session.put("TT", tt);
		session.put("allTicket",allTicket);
		session.put("sTime", sTime);
		session.put("eTime", eTime);
		return "showTicket";
	}
	@Autowired
	mainDao dao;
	@Autowired
	updateDao u_dao;
	@Autowired
	userDao user_dao;
	Map session=ActionContext.getContext().getSession();
	private String start_sta,end_sta,time,TT_id,sId,eId,SE_id,Tic_price,Tic_id;
	public String getTic_id() {
		return Tic_id;
	}
	public void setTic_id(String tic_id) {
		Tic_id = tic_id;
	}
	
	public userDao getUser_dao() {
		return user_dao;
	}
	public void setUser_dao(userDao user_dao) {
		this.user_dao = user_dao;
	}
	public String getTic_price() {
		return Tic_price;
	}
	public void setTic_price(String tic_price) {
		Tic_price = tic_price;
	}
	public String getSE_id() {
		return SE_id;
	}
	public void setSE_id(String sE_id) {
		SE_id = sE_id;
	}
	public String getTT_id() {
		return TT_id;
	}
	public void setTT_id(String tT_id) {
		TT_id = tT_id;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public updateDao getU_dao() {
		return u_dao;
	}
	public void setU_dao(updateDao u_dao) {
		this.u_dao = u_dao;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public mainDao getDao() {
		return dao;
	}
	public void setDao(mainDao dao) {
		this.dao = dao;
	}
	public String getStart_sta() {
		return start_sta;
	}
	public void setStart_sta(String start_sta) {
		this.start_sta = start_sta;
	}
	public String getEnd_sta() {
		return end_sta;
	}
	public void setEnd_sta(String end_sta) {
		this.end_sta = end_sta;
	}
}
