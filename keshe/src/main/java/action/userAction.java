package action;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lib.userDao;
import table.*;
@ParentPackage("basicstruts2")
@Namespace("/")
@Results({ 	
    @Result(name = "Index",type="redirect", location = "/index.jsp"),
    @Result(name = "Main", type="redirect",location = "/main.jsp"),
    @Result(name = "Manager",type="redirect", location = "/manager.jsp")
   
})
@AllowedMethods("regex:.*")
public class userAction extends ActionSupport {
	@Action(value="userAction")
	public String register(){
		System.out.println("register");
		user.setUser_ct(new Date(new java.util.Date().getTime()));
		dao.register(user);
		return "Index";
	}
	public String test(){
		System.out.println("test");
		return "Index";
	}
	public String login(){
		System.out.println("login");
		User u=dao.Finduserbyname(user.getUser_name());
		String rCode=(String)session.get("rCode");
		if(code!=null&&code.equals(rCode)){//验证码对
			if(u!=null&&u.getUser_pass().equals(user.getUser_pass())){//账号密码对
				if(su!=null&&su.equals("on")){
					if("on".equals(u.getUser_su())){
						session.put("user",user.getUser_name());
						return"Manager";
					}
					else{
						session.put("petmitM", "no");
						return"Index";
					}
					
				}
				else{
					session.put("user",user.getUser_name());
					return "Main";
				}
			}
			else
				session.put("permit", "No");
		}else
			session.put("permitC","No");
		return "Index";
	}
	@Autowired
	userDao dao;
	User user;
	Map session=ActionContext.getContext().getSession();
	private Date ct;
	private String code,su;
	public String getSu() {
		return su;
	}
	public void setSu(String su) {
		this.su = su;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCt() {
		return ct;
	}
	public void setCt(Date ct) {
		this.ct = ct;
	}
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public userDao getDao() {
		return dao;
	}
	public void setDao(userDao dao) {
		this.dao = dao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
