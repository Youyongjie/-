package table;
import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="SE", catalog="keshe",schema="dbo")
public class SE {
	@Id
	private int SE_id;
	private int Tim_id_start,Tim_id_end,SE_total;
	private String selected;
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public int getSE_id() {
		return SE_id;
	}
	public void setSE_id(int sE_id) {
		SE_id = sE_id;
	}
	public int getTim_id_start() {
		return Tim_id_start;
	}
	public void setTim_id_start(int tim_id_start) {
		Tim_id_start = tim_id_start;
	}
	public int getTim_id_end() {
		return Tim_id_end;
	}
	public void setTim_id_end(int tim_id_end) {
		Tim_id_end = tim_id_end;
	}
	public int getSE_total() {
		return SE_total;
	}
	public void setSE_total(int sE_total) {
		SE_total = sE_total;
	}
}
