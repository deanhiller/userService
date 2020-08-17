package biz.xsoftware.test.usersvc;

import biz.xsoftware.api.usersvc.State;
import biz.xsoftware.api.usersvc.StateMachine;
import biz.xsoftware.api.usersvc.StateMachineBuilder;
import biz.xsoftware.api.usersvc.Transition;
import biz.xsoftware.test.usersvc.mock.MockTransitionListener;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestAOnOffSm extends TestCase {

	private StateMachineBuilder builder;

	public TestAOnOffSm(String name) {
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
		String onEvent = "flipOn";
		String offEvent = "flipOff";

		State on = builder.createState("on");
		State off = builder.createState("off");

		Transition transition1 = builder.createTransition(on, off, offEvent);
		Transition transition2 = builder.createTransition(off, on, onEvent);
		MockTransitionListener mock = new MockTransitionListener();
		transition1.addTransitionListener(mock);

		builder.setInitialState(on);

		StateMachine stateMachine = builder.build();

		//assert initial state is the one we set
		Assert.assertEquals(on, stateMachine.getCurrentState());

		stateMachine.fireEvent(onEvent); //should do nothing.  we are already on

		Assert.assertEquals(on, stateMachine.getCurrentState());

		stateMachine.fireEvent(offEvent);

		Assert.assertEquals(off, stateMachine.getCurrentState());

		Assert.assertEquals(1, mock.requestList.size());
		Assert.assertEquals(offEvent, mock.requestList.get(0));
	}

}
