package biz.xsoftware.test.usersvc;

import biz.xsoftware.api.usersvc.User;
import biz.xsoftware.mock.CalledMethod;


public class TestCRemoveUser extends TestBUserService {

	public TestCRemoveUser(String name) {
		super(name);
	}
	
	public void testRemove() {
		
		super.testAddUser();
		
		User employee = userSvc.removeUser(id1);
		assertEquals(id1, employee.getId());
		assertEquals(name1, employee.getFirstName());
		
		CalledMethod m = mockUserListener.expect("userRemoved");
		User removedEmployee = (User) m.getAllParams()[0];
		assertEquals(id1, employee.getId());
		assertEquals(name1, removedEmployee.getFirstName());
	}
}
