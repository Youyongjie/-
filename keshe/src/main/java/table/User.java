package table;

import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="User", catalog="keshe",schema="dbo")
public class User {
	@Id
	private String User_name;
	private Date User_ct;
	private String User_sex;
	private String User_email;
	private String User_idcard,User_pass,User_su,User_telenum;
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getUser_telenum() {
		return User_telenum;
	}
	public void setUser_telenum(String user_telenum) {
		User_telenum = user_telenum;
	}
	public String getUser_pass() {
		return User_pass;
	}
	public void setUser_pass(String user_pass) {
		User_pass = user_pass;
	}
	public String getUser_su() {
		return User_su;
	}
	public void setUser_su(String user_su) {
		User_su = user_su;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public Date getUser_ct() {
		return User_ct;
	}
	public void setUser_ct(Date user_ct) {
		User_ct = user_ct;
	}
	public String getUser_sex() {
		return User_sex;
	}
	public void setUser_sex(String user_sex) {
		User_sex = user_sex;
	}
	public String getUser_email() {
		return User_email;
	}
	public void setUser_email(String user_email) {
		User_email = user_email;
	}
	public String getUser_idcard() {
		return User_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		User_idcard = user_idcard;
	}
	
}
