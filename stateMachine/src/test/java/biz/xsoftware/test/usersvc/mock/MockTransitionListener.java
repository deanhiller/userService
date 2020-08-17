package biz.xsoftware.test.usersvc.mock;

import biz.xsoftware.api.usersvc.TransitionListener;

import java.util.ArrayList;
import java.util.List;

public class MockTransitionListener implements TransitionListener {

    public List<String> requestList = new ArrayList<>();

    @Override
    public void onTransition(String event) {
        requestList.add(event);
    }
}
