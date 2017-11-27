import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private BuddyInfo buddy, buddy2;
	private AddressBook addrBook;

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("testName", "123 hi", "5435342");
		buddy2 = new BuddyInfo("testName2", "456 hi", "79885467");
		addrBook = new AddressBook();
	}

	@Test
	public void testAddressBook() {
		assertTrue(addrBook.getSize() == 0);
	}

	@Test
	public void testAddBuddy() {
		addrBook.addBuddy(buddy);
		assertTrue(addrBook.getSize() == 1);
		addrBook.addBuddy(buddy2);
		assertTrue(addrBook.getSize() == 2);
	}

	@Test
	public void testRemoveBuddy() {
		addrBook.addBuddy(buddy);
		addrBook.addBuddy(buddy2);
		addrBook.removeBuddy(buddy2);
		assertTrue(addrBook.getSize() == 1);
		addrBook.removeBuddy(buddy);
		assertTrue(addrBook.getSize() == 0);
	}

	@Test
	public void testToString() {
		addrBook.addBuddy(buddy);
		addrBook.addBuddy(buddy2);
		String expectedOutput = buddy2.toString() + "\n" + buddy.toString() + "\n";
		assertTrue(addrBook.toString().equals(expectedOutput));
	}
	
	@Test
	public void testGetSize() {
		assertTrue(addrBook.getSize() == 0);
		addrBook.addBuddy(buddy);
		assertTrue(addrBook.getSize() == 1);
		addrBook.addBuddy(buddy2);
		assertTrue(addrBook.getSize() == 2);
	}
	
	@Test
	public void testClear() {
		addrBook.addBuddy(buddy);
		addrBook.addBuddy(buddy2);
		addrBook.clear();
		assertTrue(addrBook.getSize() == 0);
	}

}
