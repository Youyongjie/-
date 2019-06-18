package lib;
import table.*;
public interface userDao {
	public boolean register(User user);
	public User Finduserbyname(String name);
}
