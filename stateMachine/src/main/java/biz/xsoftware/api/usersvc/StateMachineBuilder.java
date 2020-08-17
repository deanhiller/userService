package biz.xsoftware.api.usersvc;

import biz.xsoftware.impl.usersvc.StateMachineBuilderImpl;

public abstract class StateMachineBuilder
{
    public static StateMachineBuilder createFactory() {
        return new StateMachineBuilderImpl();
    }

    public abstract State createState(String name);

    public abstract Transition createTransition(State startState, State endState, String event);

    public abstract void setInitialState(State initialState);

    public abstract StateMachine build();
}
