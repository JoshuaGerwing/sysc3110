import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	private BuddyInfo buddy;

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("testName", "123 hi", "5435342");
	}

	@Test
	public void testBuddyInfo() {
		assertTrue(buddy.getName() == "testName");
		assertTrue(buddy.getAddress() == "123 hi");
		assertTrue(buddy.getPhone() == "5435342");
	}
	
	@Test
	public void testBuddyInfoCopy() {
		BuddyInfo buddy2 = new BuddyInfo(buddy);
		assertTrue(buddy2.getName() == "testName");
		assertTrue(buddy2.getAddress() == "123 hi");
		assertTrue(buddy2.getPhone() == "5435342");
	}
	
	@Test
	public void testGreeting() {
		assertTrue(buddy.greeting().equals("Hello " + buddy.getName()));
	}
	
	@Test
	public void testSetAge() {
		assertTrue(buddy.setAge(16));
	}
	
	@Test
	public void testGetAge() {
		buddy.setAge(16);
		assertTrue(buddy.getAge() == 16);
	}
	
	@Test
	public void testOver18() {
		buddy.setAge(16);
		assertTrue(!buddy.isOver18());
		buddy.setAge(19);
		assertTrue(buddy.isOver18());
	}

	@Test
	public void testGetName() {
		assertTrue(buddy.getName().equals("testName"));
	}

	@Test
	public void testSetName() {
		buddy.setName("Fred");
		assertTrue(buddy.getName().equals("Fred"));
	}

	@Test
	public void testGetAddress() {
		assertTrue(buddy.getAddress().equals("123 hi"));
	}

	@Test
	public void testSetAddress() {
		buddy.setAddress("45 Wallaby Way");
		assertTrue(buddy.getAddress().equals("45 Wallaby Way"));
	}

	@Test
	public void testGetPhone() {
		assertTrue(buddy.getPhone().equals("5435342"));
	}

	@Test
	public void testSetPhone() {
		buddy.setPhone("98898098");
		assertTrue(buddy.getPhone().equals("98898098"));
	}

	@Test
	public void testToString() {
		assertTrue(buddy.toString().equals(buddy.getName() + " " + buddy.getAddress() + " " + buddy.getPhone()));
	}

}
