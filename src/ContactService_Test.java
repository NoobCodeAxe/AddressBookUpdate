import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactService_Test {
ContactService contacts;
	
	@Before
	public void setUp() throws Exception {
		contacts = new ContactService();
	}

	@Test
	public void testAddUser() {
		User user = new User("Mark","Jacobs","954388222","3939 oak wood", "mark@gmail.com");
		contacts.newUser(user);
		contacts.newUser("Jeff", "J");
		contacts.newUser("Adam", "A", "8493020001");
		contacts.newUser("Sarah", "S", "7478398090", "3939 oak wood", "mark@gmail.com");
		
		Assert.assertEquals(contacts.userExist("Mark_Jacobs"), true);
		Assert.assertEquals(contacts.userExist("Jeff_J"), true);
		Assert.assertEquals(contacts.userExist("Adam_A"), true);
		Assert.assertEquals(contacts.userExist("Sarah_S"), true);
	}
	
	@Test
	public void testRemoveUser() {
		User user = new User("Mark","Jacobs","954388222","3939 oak wood", "mark@gmail.com");
		contacts.newUser(user);
		Assert.assertEquals(contacts.userExist("Mark_Jacobs"), true);
		contacts.deleteUser("Mark_Jacobs");
		Assert.assertEquals(contacts.userExist("Mark_Jacobs"), false);
	}
}
