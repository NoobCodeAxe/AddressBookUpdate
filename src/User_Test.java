import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class User_Test {
	User user;
	User user1;
	User user2;
	@Before
	public void setUp() throws Exception {
		user = new User("Mark","Jacobs","954388222","3939 oak wood", "mark@gmail.com");
		user1 = new User("Jeff","Jacobs","3432321234");
		user2 = new User("Allan","Jacobs");
	}

	@Test
	public void testFullname() {
		Assert.assertEquals(user.getFullName(), "Mark_Jacobs");
		Assert.assertEquals(user1.getFullName(), "Jeff_Jacobs");
		Assert.assertEquals(user2.getFullName(), "Allan_Jacobs");
	}
	
	@Test
	public void testUser1Missing() {
		Assert.assertEquals(user1.getAddress(), "No Address Provided");
		Assert.assertEquals(user1.getEmail(), "N/A");
	}
	
	@Test
	public void testUser2Missing() {
		Assert.assertEquals(user2.getAddress(), "No Address Provided");
		Assert.assertEquals(user2.getPhoneNumber(), "N/A");
		Assert.assertEquals(user2.getEmail(), "N/A");
	}
	
	

}
