package table;
import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="Seat", catalog="keshe",schema="dbo")
public class Seat {
	@Id
	private int Seat_id;
	private int TT_id,Seat_no;
	private String Seat_stat;
	public int getSeat_id() {
		return Seat_id;
	}
	public void setSeat_id(int seat_id) {
		Seat_id = seat_id;
	}
	public int getTT_id() {
		return TT_id;
	}
	public void setTT_id(int tT_id) {
		TT_id = tT_id;
	}
	public int getSeat_no() {
		return Seat_no;
	}
	public void setSeat_no(int seat_no) {
		Seat_no = seat_no;
	}
	public String getSeat_stat() {
		return Seat_stat;
	}
	public void setSeat_stat(String seat_stat) {
		Seat_stat = seat_stat;
	}
	
}
