import java.util.*;
import java.io.*;

public class Members {
	private String name;
	private int nsuId;
	private String departmentName;
	private String emailId;
	private String group;

	public Members() {
		this.name = null;
		this.nsuId = 0;
		this.departmentName = null;
		this.emailId = null;
		this.group = null;
	}

	public Members(String name, int nsuId, String departmentName, String emailId, String group) {
		this.name = name;
		this.nsuId = nsuId;
		this.departmentName = departmentName;
		this.emailId = emailId;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNsuId() {
		return nsuId;
	}

	public void setNsuId(int nsuId) {
		this.nsuId = nsuId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void membersGrpChatMethod() {
		Scanner memberClassScanner = new Scanner(System.in);
		File chatFile = new File("grpChatHistory.txt");
		if (!chatFile.exists()) {
			try {
				chatFile.createNewFile();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		System.out.println("Welcome to ACM chatting group!!!");
		System.out.println("Enter 'exit' to stop group chatting...");
		//memberClassScanner.nextLine();
		try {
			Scanner inputFromFile = new Scanner(chatFile);
			while (inputFromFile.hasNextLine()) {
				System.out.println(inputFromFile.nextLine());
			}
			//inputFromFile.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		while (true) {
			try {

				PrintWriter writeInFile = new PrintWriter(new FileWriter(chatFile, true));

				System.out.print("Your text:: ");
				String membersChat = memberClassScanner.nextLine();
				// myScanner.nextLine();

				if (membersChat.equals("exit")) {
					System.out.println("Group Chatting stopped");
					writeInFile.close();
					break;
				} else {
					writeInFile.println(getName()+" : " + membersChat);
					writeInFile.close();
				}
				try {
					Scanner inputFromFile = new Scanner(chatFile);
					while (inputFromFile.hasNextLine()) {
						System.out.println(inputFromFile.nextLine());
					}
					//inputFromFile.close();

				} catch (Exception e) {
					System.out.println("Exception: " + e);
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Override
	public String toString() {
		return "Members [Name=" + name + ", NSU ID=" + nsuId + ", Department Name=" + departmentName + ", Email Id="
				+ emailId + ", Group=" + group + "]";
	}

}
