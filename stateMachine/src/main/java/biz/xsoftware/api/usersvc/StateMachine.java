package biz.xsoftware.api.usersvc;


public interface StateMachine
{
	State getCurrentState();

	void fireEvent(String onEvent);
}
