import java.util.*;

public class AddressBook {
	
	private Map<String, BuddyInfo> buddyCollection;
	
	public AddressBook() {
		buddyCollection = new HashMap<String, BuddyInfo>();
	}
	
    public void addBuddy(BuddyInfo bud) {
    	buddyCollection.put(bud.getName(), bud);
    }
    
    public void removeBuddy(BuddyInfo bud) {
		for(String s: buddyCollection.keySet()) {
			if(buddyCollection.get(s) == bud) {
				buddyCollection.remove(s);
				return;
			}
		}
    }
    
    public int getSize() {
    	return buddyCollection.size();
    }
    
    public boolean clear() {
    	buddyCollection = new HashMap<String, BuddyInfo>();
    	return (buddyCollection.size() == 0);
    }
    
    @Override
    public String toString() {
    	StringBuilder toReturn = new StringBuilder();
    	for(String s: buddyCollection.keySet()) {
    		toReturn.append(buddyCollection.get(s).toString() + "\n");
    	}
    	return toReturn.toString();
    }
}
