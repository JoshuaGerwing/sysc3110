import java.util.*;

public class AddressBook {
	
	private Map<String, BuddyInfo> buddyCollection;
	
	public AddressBook() {
		this.buddyCollection = new HashMap<String, BuddyInfo>();
	}
    
    
	public static void main(String[] args) {
		System.out.println("Address Book");
		BuddyInfo buddy = new BuddyInfo("Tom", "Carleston", "123");
		AddressBook addressbook = new AddressBook();
		addressbook.addBuddy(buddy);
		addressbook.removeBuddy(buddy);
	}
	
    public void addBuddy(BuddyInfo bud) {
    	buddyCollection.put(bud.getName(), bud);
    	
    }
    
    public void removeBuddy(BuddyInfo bud) {
    	buddyCollection.remove(bud.getName());
    }

}
