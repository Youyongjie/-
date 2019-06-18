package lib;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


import table.*;
@Transactional
public interface updateDao {
	 public Train findTrain(String Tra_id);
	 public boolean addTrain(Train train);
	 public List<Train> allTrain();
	 public boolean deleteTrain(String Tra_id);
	 public boolean findTT(int TT_id);
	 public TT searchTT(int TT_id);
	 public boolean addTT(TT tt);
	 public List<TT> allTT();
	 public boolean deleteTT(int  i);
	 public boolean addTime(Time time);
	 public Time findTime(int Tim_id);
	 public List<Time> searchTim(String TT_id,String sId,String eId);
	 public List<Time> findSE_Time(int TT_id,int seq);
	 public List<Time> findTimebyTT_id(int TT_id);
}
