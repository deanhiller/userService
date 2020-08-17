package biz.xsoftware.impl.usersvc;

import biz.xsoftware.api.usersvc.State;
import biz.xsoftware.api.usersvc.StateMachine;
import biz.xsoftware.api.usersvc.StateMachineBuilder;
import biz.xsoftware.api.usersvc.Transition;

public class StateMachineBuilderImpl extends StateMachineBuilder {

	@Override
	public State createState(String name) {
		throw new UnsupportedOperationException("you need to implement");
	}

	@Override
	public Transition createTransition(State state1, State state2, String event) {
		throw new UnsupportedOperationException("you need to implement");
	}

	@Override
	public void setInitialState(State initialState) {
		throw new UnsupportedOperationException("you need to implement");
	}

	@Override
	public StateMachine build() {
		throw new UnsupportedOperationException("you need to implement");
	}
}
