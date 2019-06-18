package lib;

import java.util.List;

import table.SE;
import table.Seat;
import table.Ticket;

public interface mainDao {
	public List<SE> search(String time,String start_sta,String end_sta); 
	public SE findSE(int SE_id);
	public Seat findSeat(int Seat_id);
	public boolean buyTicket(String SE_id,String TT_id,String user,String Tic_price);
	public List<Ticket> showTicket(String username);
	public boolean delTicket(String Tic_id);
}
