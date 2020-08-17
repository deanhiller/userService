package biz.xsoftware.test.usersvc;

import biz.xsoftware.api.usersvc.State;
import biz.xsoftware.api.usersvc.StateMachine;
import biz.xsoftware.api.usersvc.StateMachineBuilder;
import biz.xsoftware.api.usersvc.Transition;
import biz.xsoftware.test.usersvc.mock.MockTransitionListener;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestBPhoneSm extends TestCase {

	private StateMachineBuilder builder;

	public TestBPhoneSm(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		builder = StateMachineBuilder.createFactory();
	}

	@Override
	protected void tearDown() throws Exception {
	}
	
	public void testOnOffMachine() {
		String incomingCall = "incomingCall";
		String answerCall = "answerCall";
		String hangup = "hangup";

		State idle = builder.createState("IDLE");
		State ringing = builder.createState("RINGING");
		State onACall = builder.createState("ON-A-CALL");

		builder.createTransition(idle, ringing, incomingCall);
		builder.createTransition(ringing, onACall, answerCall);
		builder.createTransition(onACall, idle, hangup);

		builder.setInitialState(idle);
		StateMachine stateMachine = builder.build();

		//should start in idle
		Assert.assertEquals(idle, stateMachine.getCurrentState());

		stateMachine.fireEvent(incomingCall);
		Assert.assertEquals(ringing, stateMachine.getCurrentState());

		stateMachine.fireEvent(answerCall);
		Assert.assertEquals(onACall, stateMachine.getCurrentState());

		stateMachine.fireEvent(hangup);
		Assert.assertEquals(idle, stateMachine.getCurrentState());
	}

}
