package biz.xsoftware.api.usersvc;


public interface UserService
{

	User createUser(int id, String firstName, String lastName);
	User removeUser(int id);
	User getUser(int id);
	
	void addUserListener(UserListener listener);
}
