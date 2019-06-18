package table;
import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="Time", catalog="keshe",schema="dbo")
public class Time {
	@Id
	private int Tim_id;
	private int TT_id,Tim_seq,Tim_distance;
	private String Tim_start,Tim_end;
	private String Tim_sta_name;
	public int getTim_id() {
		return Tim_id;
	}
	public void setTim_id(int tim_id) {
		Tim_id = tim_id;
	}
	public int getTT_id() {
		return TT_id;
	}
	public void setTT_id(int tT_id) {
		TT_id = tT_id;
	}
	public int getTim_seq() {
		return Tim_seq;
	}
	public void setTim_seq(int tim_seq) {
		Tim_seq = tim_seq;
	}
	public int getTim_distance() {
		return Tim_distance;
	}
	public void setTim_distance(int tim_distance) {
		Tim_distance = tim_distance;
	}
	public String getTim_start() {
		return Tim_start;
	}
	public void setTim_start(String tim_start) {
		Tim_start = tim_start;
	}
	public String getTim_end() {
		return Tim_end;
	}
	public void setTim_end(String tim_end) {
		Tim_end = tim_end;
	}
	public String getTim_sta_name() {
		return Tim_sta_name;
	}
	public void setTim_sta_name(String tim_sta_name) {
		Tim_sta_name = tim_sta_name;
	}
}
