import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BuddyController implements ActionListener {
	private UserInterface gui;
	private AddressBook addrBook;
	
	public BuddyController() {
		addrBook = new AddressBook();
		gui = new UserInterface(this);
	}
	
	public static void main(String[] args){
		new BuddyController();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command.equals(UserInterface.ADD_BUDDY)) {
			String buddyName = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's name?");
			String buddyAddr = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's address?");
			String buddyPhone = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's phone number?");
			BuddyInfo newBuddy = new BuddyInfo(buddyName, buddyAddr, buddyPhone);
			addrBook.addBuddy(newBuddy);
			gui.getListModel().addElement(newBuddy);
		}
		else if(command.equals(UserInterface.EDIT_BUDDY)) {
			if(gui.getSelectedBuddy() != null) {
				String buddyName = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's name?", gui.getSelectedBuddy().getName());
				String buddyAddr = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's address?", gui.getSelectedBuddy().getAddress());
				String buddyPhone = JOptionPane.showInputDialog(gui.getFrame(), "What's your buddy's phone number?", gui.getSelectedBuddy().getPhone());
				BuddyInfo newBuddy = new BuddyInfo(buddyName, buddyAddr, buddyPhone);
				addrBook.removeBuddy(gui.getSelectedBuddy());
				addrBook.addBuddy(newBuddy);
				gui.getListModel().removeElement(gui.getSelectedBuddy());
				gui.getListModel().addElement(newBuddy);
			}
		}
		else if(command.equals(UserInterface.REMOVE_BUDDY)) {
			addrBook.removeBuddy(gui.getSelectedBuddy());
			gui.getListModel().removeElement(gui.getSelectedBuddy());
			gui.getRemove().setEnabled(false);
			gui.getEdit().setEnabled(false);
		}
		else if(command.equals(UserInterface.SAVE_ADDR)) {
			String s = addrBook.toString();
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter("savedAddr.txt"));
				out.write(s);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(command.equals(UserInterface.READ_ADDR)) {
			BufferedReader in = null;
			String line;
			addrBook.clear();
			try {
				in = new BufferedReader(new FileReader("savedAddr.txt"));
				while ((line = in.readLine()) != null) {
					addrBook.addBuddy(BuddyInfo.importBuddy(line));
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			};
			JLabel label = new JLabel(addrBook.toString());
			gui.getListScroll().setViewportView(label);
			System.out.println(addrBook.toString());
		}
		else if(command.equals(UserInterface.DISP_ADDR)) {
			/*JLabel label = new JLabel(addrBook.toString());
			gui.getListScroll().removeAll();
			gui.getListScroll().add(label);*/
		}
		else if(command.equals(UserInterface.CREATE_ADDR)){
			gui.getCreate().setEnabled(false);
			gui.getSave().setEnabled(true);
			gui.getDisp().setEnabled(true);
			gui.getAdd().setEnabled(true);
		}
	}
}
