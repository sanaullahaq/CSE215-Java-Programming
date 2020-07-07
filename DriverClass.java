import java.util.*;
import java.io.*;

public class DriverClass {
	
	/*
	 * 
	 * Project Purpose Club Management
	 * 
	 */
	
	static Scanner myScanner = new Scanner(System.in);
	static ArrayList<Members> members = new ArrayList<>();
	static ArrayList<EventClass> eventClasses = new ArrayList<>();

	public static void main(String[] args) {
		System.out.print("   **         * * *      **        **\n");
		System.out.print("  *  *      *            *  *    *  *\n");
		System.out.print(" *    *     *            *    **    *\n");
		System.out.print(" ******     *            *          *\n");
		System.out.print(" *    *     *            *          *\n");
		System.out.print(" *    *       * * *      *          *\n");
		
		System.out.println("\nWelcome to the ACM Club Management System.......\n");

		while (true) {
			System.out.println("1.Admin\n2.General Member\n3.Stop Program");
			int adminOrmember = myScanner.nextInt();
			if (adminOrmember == 1) {
				admin();
			} else if (adminOrmember == 2) {
				generalMember();

			} else if (adminOrmember == 3) {
				System.out.println("Program stopped");
				return;
			} else {
				System.out.print("Enter a valid input:: ");
			}
		}
	}

	public static void admin() {
		String userName;
		String passWord;
		System.out.print("Enter username:: ");
		userName = myScanner.next();
		System.out.print("Enter password:: ");
		passWord = myScanner.next();
		if (userName.equals("admin") && passWord.equals("admin")) {
			adminPanel();
		} else {
			System.out.println("Wrong username or password\nEnter a valid input:: ");
			admin();
		}
	}

	public static void adminPanel() {
		boolean conditon = true;
		System.out.println("Welcome Admin!!!");
		while (conditon) {
			System.out.println("1.Add member");
			System.out.println("2.Remove member");
			System.out.println("3.Show all members");
			System.out.println("4.Update members info");
			System.out.println("5.Group chat");
			System.out.println("6.Set a event");
			System.out.println("0.Main menu(Admin/G.member)");
			int option = myScanner.nextInt();

			switch (option) {
			case 1:
				membersAdder();
				break;
			case 2:
				removeMember();
				break;
			case 3:
				showAllMembers();
				break;
			case 4:
				updateInfo();
				break;
			case 5:
				grpChatAdmin();
				break;
			case 6:
				event();
				break;
			case 0:
				conditon = false;
				break;
			default:
				System.out.println("Enter valid input:: ");
				break;
			}
		}

	}

	public static void membersAdder() {
		String name;
		int nsuId;
		String departmentName;
		String emailId;
		String group;

		int number;

		System.out.print("Enter the members number you want to add:: ");
		number = myScanner.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Ente details of member " + i + "...");
			System.out.print("Name:: ");
			myScanner.nextLine();
			name = myScanner.nextLine();

			System.out.print("NSU ID:: ");
			nsuId = myScanner.nextInt();
			System.out.print("Department name:: ");
			departmentName = myScanner.next();
			System.out.print("Email ID:: ");
			emailId = myScanner.next();
			System.out.print("Group:: ");
			group = myScanner.next();

			members.add(new Members(name, nsuId, departmentName, emailId, group));
		}
		System.out.println("All " + number + " Members added succesfully");
	}

	public static void removeMember() {
		System.out.print("Enter the id of the member you want to remove:: ");
		int idRemove = myScanner.nextInt();
		boolean memberRemoved = false;
		for (Members obj : members) {
			if (obj.getNsuId() == idRemove) {
				members.remove(obj);
				System.out.println("Found and removed");
				memberRemoved = true;
				break;
			}
		}
		if (memberRemoved == false) {
			System.out.println("Not found!!!");
		}
	}

	public static void showAllMembers() {
		// Sorting members objects

		Collections.sort(members, new Comparator<Members>() {

			public int compare(Members m1, Members m2) {
				return Integer.compare(m1.getNsuId(), m2.getNsuId());
			}

		});
		int i = 0;
		for (Members obj : members) {
			i++;
			System.out.println("[" + i + "]" + obj);

		}
		if (i == 0) {
			System.out.println("Members list is empty");
		} else {
			System.out.println("Total " + i + " members");
		}
	}

	public static void updateInfo() {
		System.out.print("Enter the id of the member who's info you want to update:: ");
		int updateId = myScanner.nextInt();

		boolean memberRemoved = false;
		for (Members obj : members) {
			if (obj.getNsuId() == updateId) {
				memberRemoved = true;
				System.out.println("Member found...");
				System.out.println("Current info's are below....");
				System.out.println(obj.toString());
				while (true) {
					System.out.println("1.Update Name");
					System.out.println("2.Update NSU ID");
					System.out.println("3.Update Department Name");
					System.out.println("4.Update Email Id");
					System.out.println("5.Update Group");
					System.out.println("0.Stop Update");

					int updateOption = myScanner.nextInt();
					if (updateOption == 1) {
						System.out.print("Enter new name:: ");
						myScanner.nextLine();
						obj.setName(myScanner.nextLine());
						System.out.println("Name Updated");
					} else if (updateOption == 2) {
						System.out.print("Enter new ID:: ");
						obj.setNsuId(myScanner.nextInt());
						System.out.println("ID Updated");
					} else if (updateOption == 3) {
						System.out.print("Enter new Department Name:: ");
						obj.setDepartmentName(myScanner.next());
						System.out.println("Department Name Updated");
					} else if (updateOption == 4) {
						System.out.print("Enter new Email Id:: ");
						obj.setEmailId(myScanner.next());
						System.out.println("Email ID Updated");
					} else if (updateOption == 5) {
						System.out.print("Enter new Group:: ");
						obj.setGroup(myScanner.next());
						System.out.println("Group Updated");
					} else if (updateOption == 0) {
						System.out.println("Updating Stopped");
						break;
					} else {
						System.out.println("Enter valid input:: ");
					}
				}
			}
		}
		if (memberRemoved == false) {
			System.out.println("Not found!!!");
		}
	}

	public static void grpChatAdmin() {
		File chatFile = new File("grpChatHistory.txt");

		if (!chatFile.exists()) {
			try {
				chatFile.createNewFile();
			} catch (Exception e) {
				System.out.println("Exception " + e);
			}
		}
		System.out.println("Welcome to ACM chatting group!!!");
		System.out.println("Enter 'exit' to stop group chatting...");
		myScanner.nextLine();
		try {
			Scanner inputFromFile = new Scanner(chatFile);
			while (inputFromFile.hasNextLine()) {
				System.out.println(inputFromFile.nextLine());
			}
			// inputFromFile.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		while (true) {
			try {

				PrintWriter writeInFile = new PrintWriter(new FileWriter(chatFile, true));

				System.out.print("Your text:: ");
				String adminChat = myScanner.nextLine();
				// myScanner.nextLine();

				if (adminChat.equals("exit")) {
					System.out.println("Group Chatting stopped");
					writeInFile.close();
					break;
				} else {
					writeInFile.println("Admin : " + adminChat);
					writeInFile.close();
				}
				try {
					Scanner inputFromFile = new Scanner(chatFile);
					while (inputFromFile.hasNextLine()) {
						System.out.println(inputFromFile.nextLine());
					}
					// inputFromFile.close();

				} catch (Exception e) {
					System.out.println("Exception: " + e);
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	public static void event() {

		while (true) {
			System.out.println("1.Creat Event\n2.Show up Coming Events\n3.go back");
			int eventOption = myScanner.nextInt();
			if (eventOption == 1) {
				System.out.print("Enter event's date: ");
				myScanner.nextLine();
				String eventDate = myScanner.nextLine();
				System.out.print("Put Event's name: ");
				String eventName = myScanner.nextLine();
				System.out.print("Enter event's decription: ");
				String eventDescription = myScanner.nextLine();

				eventClasses.add(new EventClass(eventDate, eventName, eventDescription));
				System.out.println("Event created succesfully\nMembers can watch it.....");
			} else if (eventOption == 2) {
				int i = 0;
				for (EventClass allEvents : eventClasses) {
					i++;
					System.out.println("Event number " + i);
					System.out.println(allEvents + "\n");
				}
				if (i == 0) {
					System.out.println("No upcoming events");
				} else {
					System.out.println("Total " + i + " up coming events");
				}
			} else if (eventOption == 3) {
				break;
			} else {
				System.out.println("Enter a valid input:: ");
			}
		}

	}

	public static void generalMember() {
		System.out.print("Enter your Name: ");
		myScanner.nextLine();
		String generalMemberName = myScanner.nextLine();

		boolean flag = true;
		System.out.print("Enter your ID: ");
		int generalMemberId = myScanner.nextInt();
		if (!members.isEmpty()) {
			for (Members obj : members) {
				if (obj.getName().toLowerCase().equals(generalMemberName.toLowerCase())
						&& generalMemberId == obj.getNsuId()) {
					flag = false;
					generalMemberPanel(obj);
				}
			}
		} else {
			System.out.println("Admin did not add any member");
		}
		if (flag) {
			System.out.println("You are not a valid member\nEnter a valid input:: ");
			generalMember();
		}

	}

	public static void generalMemberPanel(Members object) {

		System.out.println("Welcome " + object.getName());

		boolean condition = true;
		while (condition) {
			System.out.println(
					"1.Group Chat\n2.Show Events\n3.Show Members\n4.Show Your Info's\n5.Main menu(Admin/G. member)");
			int key = myScanner.nextInt();
			switch (key) {
			case 1:
				object.membersGrpChatMethod();
				break;
			case 2:
				int i = 0;
				for (EventClass allEvents : eventClasses) {
					i++;
					System.out.println("Event number " + i);
					System.out.println(allEvents + "\n");
				}
				if (i == 0) {
					System.out.println("No upcoming events");
				} else {
					System.out.println("Total " + i + " up coming events");
				}
				break;
			case 3:

				// Sorting members objects

				Collections.sort(members, new Comparator<Members>() {

					public int compare(Members m1, Members m2) {
						return Integer.compare(m1.getNsuId(), m2.getNsuId());
					}

				});
				int j = 0;
				for (Members objForMem : members) {
					j++;
					System.out.println(j + " ) Name: " + objForMem.getName() + "   Group: " + objForMem.getGroup());

				}
				if (j == 0) {
					System.out.println("Admin did not add any member..Members list is empty");
				} else {
					System.out.println("Total " + j + " members");
				}

				break;
			case 4:
				System.out.println(object);
				break;
			case 5:
				condition = false;
				break;
			default:
				System.out.println("Enter valid input:: ");
				break;
			}
		}

	}
}
