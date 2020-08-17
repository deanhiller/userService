package biz.xsoftware.api.usersvc;

import java.util.EventListener;

public interface UserListener extends EventListener {

	public void userCreated(User user);
	public void userRemoved(User user);
}
