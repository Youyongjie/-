package table;

import java.sql.Date;
import javax.persistence.*;
@Entity
@Table(name="Train", catalog="keshe",schema="dbo")
public class Train {
	@Id
	private String Tra_id;
	private int Tra_max;
	private String Tra_type;
	public String getTra_id() {
		return Tra_id;
	}
	public void setTra_id(String tra_id) {
		Tra_id = tra_id;
	}
	public int getTra_max() {
		return Tra_max;
	}
	public void setTra_max(int tra_max) {
		Tra_max = tra_max;
	}
	public String getTra_type() {
		return Tra_type;
	}
	public void setTra_type(String tra_type) {
		Tra_type = tra_type;
	}
	
}
