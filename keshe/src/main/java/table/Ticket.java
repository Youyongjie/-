package table;
import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="Ticket", catalog="keshe",schema="dbo")
public class Ticket {
	@Id
	private int Tic_id;
	private int SE_id,Seat_id;
	private String User_name;
	private float Tic_price;
	public int getTic_id() {
		return Tic_id;
	}
	public void setTic_id(int tic_id) {
		Tic_id = tic_id;
	}
	public int getSE_id() {
		return SE_id;
	}
	public void setSE_id(int sE_id) {
		SE_id = sE_id;
	}
	public int getSeat_id() {
		return Seat_id;
	}
	public void setSeat_id(int seat_id) {
		Seat_id = seat_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public float getTic_price() {
		return Tic_price;
	}
	public void setTic_price(float tic_price) {
		Tic_price = tic_price;
	}
}
