package xsoftware.test.usersvc.mock;

import biz.xsoftware.api.usersvc.User;
import biz.xsoftware.api.usersvc.UserListener;

import java.util.ArrayList;
import java.util.List;

public class MockUserListener implements UserListener {

    public List<User> userCreatedRequestList = new ArrayList<>();
    public List<User> userRemovedRequestList = new ArrayList<>();

    @Override
    public void userCreated(User user) {
        userCreatedRequestList.add(user);
    }

    @Override
    public void userRemoved(User user) {
        userRemovedRequestList.add(user);
    }
}
