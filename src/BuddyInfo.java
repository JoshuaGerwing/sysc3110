import java.util.Scanner;


public class BuddyInfo {
	
	private String name;
	private String address;
	private String phone;
	private int age;
	
	public BuddyInfo(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public BuddyInfo(BuddyInfo buddy) {
		super();
		this.name = buddy.getName();
		this.address = buddy.getAddress();
		this.phone = buddy.getPhone();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String greeting() {
		return "Hello " + name;
	}
	
	public boolean setAge(int age) {
		this.age = age;
		return (this.age == age);
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isOver18() {
		return age > 18;
	}
	
	@Override
	public String toString() {
		return new String(this.name + "/" + this.address + "/" + this.phone);
	}
	
	public static BuddyInfo importBuddy(String s) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(s).useDelimiter("/");
		BuddyInfo newBuddy = new BuddyInfo(sc.next(), sc.next(), sc.next());
		sc.close();
		return newBuddy;
	}

}
