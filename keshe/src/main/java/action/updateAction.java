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

import lib.updateDao;
import table.*;
@ParentPackage("basicstruts2")
@Namespace("/")
@Results({ 	
    @Result(name = "showTrain",type="redirect", location = "/show.jsp?table=Train"),
    @Result(name = "showTT",type="redirect", location = "/show.jsp?table=TT"),
    @Result(name = "show_detailTime",type="redirect", location = "/showTime.jsp"),
    @Result(name = "showTime",type="redirect", location = "/show.jsp?table=Time"),
    @Result(name = "reshowTime",type="redirectAction", location = "updateAction!updateTime?operation=reshowTime"),
    @Result(name = "Manager",type="redirect", location = "/manager.jsp")
   
})
@AllowedMethods("regex:.*")
public class updateAction extends ActionSupport {
	@Action(value="updateAction")
	public String updateTrain(){
		if(operation.equals("增加列车")){
			if(dao.findTrain(train.getTra_id())!=null)
				System.out.println("增加列车时主键重复");
			else
				dao.addTrain(train);
		}
		else if(operation.equals("显示所有列车")){
			List<Train>allTrain=dao.allTrain();
			session.put("allTrain",allTrain);
			return"showTrain";
		}
		else if(operation.equals("删除列车")){
			dao.deleteTrain(Tra_id);
			List<Train>allTrain=dao.allTrain();
			session.put("allTrain",allTrain);
			return "showTrain";
		}
		return "Manager";
	}
	public String updateTT(){
		if(operation.equals("增加车次")){
			TT tt =new TT();
			tt.setTra_id(Tra_id);
			tt.setTT_time(TT_time);
			Train train=dao.findTrain(Tra_id);
			if(train!=null){
				tt.setTT_leftSeat(train.getTra_max());
				dao.addTT(tt);
			}
			else
				System.out.println("增加列车时外键不存在");
		}
		else if(operation.equals("显示所有车次")){
			List<TT>allTT=dao.allTT();
			session.put("allTT",allTT);
			return"showTT";
		}
		else if(operation.equals("删除车次")){
			dao.deleteTT(Integer.parseInt(TT_id));
			System.out.println("delTT");
			List<TT>allTT=dao.allTT();
			session.put("allTT",allTT);
			return "showTT";
		}
		return "Manager";
	}
	public String updateTime(){
		if(operation.equals("增加时刻表")){
			int TT_id=time1.getTT_id();
			TT t1=dao.searchTT(TT_id);
			String date=t1.getTT_time().substring(0,11);
			if(dao.findTT(TT_id)){
				if(time1.getTim_seq()!=0){
					time1.setTim_start(date+time1.getTim_start());
					time1.setTim_end(date+time1.getTim_end());
					dao.addTime(time1);
				}
				if(time2.getTim_seq()!=0){
					time2.setTT_id(TT_id);
					time2.setTim_start(date+time2.getTim_start());
					time2.setTim_end(date+time2.getTim_end());
					dao.addTime(time2);
				}
				if(time3.getTim_seq()!=0){
					time3.setTT_id(TT_id);
					time3.setTim_start(date+time3.getTim_start());
					time3.setTim_end(date+time3.getTim_end());
					dao.addTime(time3);
				}
				if(time4.getTim_seq()!=0){
					time4.setTT_id(TT_id);
					time4.setTim_start(date+time4.getTim_start());
					time4.setTim_end(date+time4.getTim_end());
					dao.addTime(time4);
				}
				if(time5.getTim_seq()!=0){
					time5.setTT_id(TT_id);
					time5.setTim_start(date+time5.getTim_start());
					time5.setTim_end(date+time5.getTim_end());
					dao.addTime(time5);
				}
			}else
				System.out.println("未找到该车次");
			return "Manager";
		}else if(operation.equals("显示所有时刻车次表")||operation.equals("reshowTime")){
			System.out.println("Time 显示所有");
			List<TT> allTT=dao.allTT();
			int length=allTT.size();
			List <Time> SE=new ArrayList<Time>(); //用于存放车次的开始与结尾
			List<Time> left_Time=new ArrayList<Time>();//用于存放未构成开始结尾的
			while(length--!=0){
				int TT_id=allTT.get(length).getTT_id();
				List<Time> timeS=dao.findSE_Time(TT_id,1);
				List<Time> timeE=dao.findSE_Time(TT_id,999);
				if(timeS.size()!=0&&timeE.size()!=0){
					SE.add(timeS.get(0));
					SE.add(timeE.get(0));
				}
				else{
					left_Time.addAll(dao.findTimebyTT_id(TT_id));
				}
			}
//			length=SE.size();
//			int i=0;
//			System.out.println(length);
//			while(i<length){
//				System.out.println("起点"+SE.get(i++).getTim_sta_name());
//				System.out.println("终点"+SE.get(i++).getTim_sta_name());
//			}
//			length=left_Time.size();
//			while(length--!=0){
//				System.out.println("剩余的time:"+left_Time.get(length).getTim_sta_name());
//			}
			session.put("SE", SE);
			session.put("left_Time", left_Time);
			
			return "showTime";
		}else if(operation.equals("删除车次")){
			dao.deleteTT(Integer.parseInt(TT_id));
			return "reshowTime";
		}
		System.out.println("other");
		return "Manager";
	}
	public String Time_showTime(){
		System.out.println("TT_id"+TT_id+"eId"+eId+"sId"+sId );
		session.put("Time",dao.searchTim(TT_id, sId, eId));
		session.put("back", "show.jsp?table=Time");
		return "show_detailTime";
	}
	@Autowired
	updateDao dao;
	Map session=ActionContext.getContext().getSession();
	private Train train;
	private String operation,Tra_id,TT_time,TT_id,sId,eId;
	private Time time1,time2,time3,time4,time5;
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
	public Time getTime2() {
		return time2;
	}
	public void setTime2(Time time2) {
		this.time2 = time2;
	}
	public Time getTime3() {
		return time3;
	}
	public void setTime3(Time time3) {
		this.time3 = time3;
	}
	public Time getTime4() {
		return time4;
	}
	public void setTime4(Time time4) {
		this.time4 = time4;
	}
	public Time getTime5() {
		return time5;
	}
	public void setTime5(Time time5) {
		this.time5 = time5;
	}
	public Time getTime1() {
		return time1;
	}
	public void setTime1(Time time) {
		this.time1 = time;
	}
	
	public String getTT_id() {
		return TT_id;
	}
	public void setTT_id(String tT_id) {
		TT_id = tT_id;
	}
	public String getTra_id() {
		return Tra_id;
	}
	public String getTT_time() {
		return TT_time;
	}
	public void setTT_time(String tT_time) {
		TT_time = tT_time;
	}
	public void setTra_id(String tra_id) {
		Tra_id = tra_id;
	}
	public updateDao getDao() {
		return dao;
	}
	public void setDao(updateDao dao) {
		this.dao = dao;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	
}
