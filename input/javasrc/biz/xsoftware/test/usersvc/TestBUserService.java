package biz.xsoftware.test.usersvc;

import junit.framework.TestCase;
import biz.xsoftware.api.usersvc.User;
import biz.xsoftware.api.usersvc.UserListener;
import biz.xsoftware.api.usersvc.UserService;
import biz.xsoftware.api.usersvc.UserServiceFactory;
import biz.xsoftware.mock.MockObject;
import biz.xsoftware.mock.MockObjectFactory;

public class TestBUserService extends TestCase {

	protected UserService userSvc;
	protected int id1 = 4;
	protected int id2 = 5;
	protected String name1 = "dean";
	protected MockObject mockUserListener;

	public TestBUserService(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		mockUserListener = MockObjectFactory.createMock(UserListener.class);
		
		
		UserServiceFactory factory = UserServiceFactory.createFactory(null);
		userSvc = factory.createService();
		
		userSvc.addUserListener((UserListener) mockUserListener);
	}

	@Override
	protected void tearDown() throws Exception {
		
	}
	
	public void testAddUser() {
		String name2 = "Yun";
		
		userSvc.createUser(id1, name1, "hiller");
		
		mockUserListener.expect("userCreated");
		
		userSvc.createUser(id2, name2, "Xu");
		
		mockUserListener.expect("userCreated");
		
		User employeeRes = userSvc.getUser(id1);
		assertEquals(id1, employeeRes.getId());
		assertEquals(name1, employeeRes.getFirstName());
		
		User employeeRes2 = userSvc.getUser(id2);
		assertEquals(id2, employeeRes2.getId());
		assertEquals(name2, employeeRes2.getFirstName());
	}
}
