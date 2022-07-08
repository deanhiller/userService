package biz.xsoftware.test.usersvc;

import org.junit.Assert;

import biz.xsoftware.api.usersvc.User;


public class TestCRemoveUser extends TestBUserService {

	public TestCRemoveUser(String name) {
		super(name);
	}
	
	public void testRemove() {
		
		super.testAddUser();
		
		User employee = userSvc.removeUser(id1);
		assertEquals(id1, employee.getId());
		assertEquals(name1, employee.getFirstName());

		Assert.assertEquals(1, mockUserListener.userRemovedRequestList.size());
		User removedEmployee = mockUserListener.userRemovedRequestList.get(0);
		assertEquals(id1, employee.getId());
		assertEquals(name1, removedEmployee.getFirstName());
	}
}
