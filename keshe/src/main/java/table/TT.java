package table;
import java.sql.Date;
import java.sql.*;
import javax.persistence.*;
@Entity
@Table(name="TT", catalog="keshe",schema="dbo")
public class TT {
	@Id
	private int TT_id;
	private String Tra_id;
	private String TT_time;
	private int TT_leftSeat;
	public int getTT_leftSeat() {
		return TT_leftSeat;
	}
	public void setTT_leftSeat(int tT_leftSeat) {
		TT_leftSeat = tT_leftSeat;
	}
	public int getTT_id() {
		return TT_id;
	}
	public void setTT_id(int tT_id) {
		TT_id = tT_id;
	}
	public String getTra_id() {
		return Tra_id;
	}
	public void setTra_id(String tra_id) {
		Tra_id = tra_id;
	}
	public String getTT_time() {
		return TT_time;
	}
	public void setTT_time(String  tT_time) {
		TT_time = tT_time;
	}
}
