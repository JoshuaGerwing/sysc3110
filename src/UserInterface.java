import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UserInterface {
	private static JFrame frame;
	private JMenuItem addBuddy;
	private JMenuItem editBuddy;
	private JMenuItem removeBuddy;
	private JMenuItem saveAddr;
	private JMenuItem readAddr;
	private JMenuItem dispAddr;
	private JMenuItem createAddr;
	private JScrollPane listScroll;
	
	private static DefaultListModel<BuddyInfo> listModel; 
	private static BuddyInfo selectedBuddyInfo;

	public static final String ADD_BUDDY = "Add Buddy";
	public static final String REMOVE_BUDDY = "Remove Buddy";
	public static final String EDIT_BUDDY = "Edit Buddy";
	public static final String SAVE_ADDR = "Save Addr";
	public static final String DISP_ADDR = "Disp Addr";
	public static final String CREATE_ADDR = "Create Addr";
	public static final String READ_ADDR = "Read Addr";
	
	public UserInterface(BuddyController controller) {
		JMenuBar menuBar;
		JMenu addrMenu;
		JMenu buddyMenu;
		JList<BuddyInfo> list;
		
		frame = new JFrame("AddressBook UI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		buddyMenu = new JMenu("BuddyInfo Options");
		
		addBuddy = new JMenuItem("Add a BuddyInfo to the AddressBook");
		addBuddy.addActionListener(controller);
		addBuddy.setEnabled(false);
		addBuddy.setActionCommand(ADD_BUDDY);
		
		editBuddy = new JMenuItem("Edit a BuddyInfo in the AddressBook");
		editBuddy.addActionListener(controller);
		editBuddy.setEnabled(false);
		editBuddy.setActionCommand(EDIT_BUDDY);
		
		removeBuddy = new JMenuItem("Remove a BuddyInfo in the AddressBook");
		removeBuddy.addActionListener(controller);
		removeBuddy.setEnabled(false);
		removeBuddy.setActionCommand(REMOVE_BUDDY);
		
		buddyMenu.add(addBuddy);
		buddyMenu.add(editBuddy);
		buddyMenu.add(removeBuddy);
		
		addrMenu = new JMenu("AddressBook Options");
		
		saveAddr = new JMenuItem("Save Address Book");
		saveAddr.addActionListener(controller);
		saveAddr.setEnabled(false);
		saveAddr.setActionCommand(SAVE_ADDR);
		
		readAddr = new JMenuItem("Read Address Book");
		readAddr.addActionListener(controller);
		readAddr.setEnabled(true);
		readAddr.setActionCommand(READ_ADDR);
		
		dispAddr = new JMenuItem("Display BuddyInfos in Address Book");
		dispAddr.addActionListener(controller);
		dispAddr.setEnabled(false);
		dispAddr.setActionCommand(DISP_ADDR);
		
		createAddr = new JMenuItem("Create Address Book");
		createAddr.addActionListener(controller);
		createAddr.setActionCommand(CREATE_ADDR);
		
		addrMenu.add(createAddr);
		addrMenu.add(saveAddr);
		addrMenu.add(readAddr);
		addrMenu.add(dispAddr);
		menuBar.add(addrMenu);
		menuBar.add(buddyMenu);
		
		listModel = new DefaultListModel<BuddyInfo>();
		list = new JList<BuddyInfo>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selectedBuddyInfo = list.getSelectedValue();
				editBuddy.setEnabled(true);
				removeBuddy.setEnabled(true);
			}
		});
		listScroll = new JScrollPane(list);
		
		frame.add(getListScroll());
		
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JMenuItem getRemove() {
		return removeBuddy;
	}
	
	public JMenuItem getEdit() {
		return editBuddy;
	}
	
	public JMenuItem getAdd() {
		return addBuddy;
	}
	
	public JMenuItem getSave() {
		return saveAddr;
	}
	
	public JMenuItem getDisp() {
		return dispAddr;
	}
	
	public JMenuItem getCreate() {
		return createAddr;
	}
	
	public DefaultListModel<BuddyInfo> getListModel() {
		return listModel;
	}
	
	public BuddyInfo getSelectedBuddy() {
		return selectedBuddyInfo;
	}

	public JScrollPane getListScroll() {
		return listScroll;
	}
}
