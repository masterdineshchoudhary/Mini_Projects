
import java.util.*;
import java.lang.String;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Info {
	Info() {
		System.out.print("\t ** WELCOME TO E-HEALTH CARE MANAGEMENT SYSTEM ** ");
	}

//Declaring variales to be used
	Scanner scan = new Scanner(System.in);
	String name, address, bg, sex, disease, dadm;
	long contact, id;
	int age;

//To take a pause
	private void pressAnyKeyToContinue() {
		System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
			System.out.println("Press 'Enter' key to continue!");
		}
	}

	// Taking multiple words
	String readString() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

//Log in Module
	void login() {
		int a;
		String pass;
		System.out.println("\n\t\t-- HEALTH CARE MANAGEMENT SYSTEM -- ");
		System.out.println("LOGIN");
		System.out.print("Enter the Password: ");
		pass = scan.next();
		if (pass.equals("password")) {
			System.out.print("\nAccess Granted! \n");
			pressAnyKeyToContinue();
		} else {
			System.out.println("Access Aborted... \n\t 1.Try Again \t2.Exit");
			System.out.println("\t Enter the option: ");
			try {
				a = scan.nextInt();
				if (a == 1)
					login();
				else if (a == 2)
					System.exit(0);
				else {
					System.out.print("\n\n\t Invalid Choice \n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\n\n\t *Enter the correct option!* \n\n");
				login();
			}
		}
	}

//To get Date
	public void getCurrentTimeUsingDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		dadm = dtf.format(now);

	}

	void menu() {
		char k;
//giving option to the user for their choice
		System.out.println("\t~ HEALTHCARE MANAGEMENT SYSTEM MENU ~\n");
		System.out.println("Please, Choose from following Options:");
		System.out.println("\t 1  >> Add New Patient Record");
		System.out.println("\t 2  >> Add Diagnosis Information");
		System.out.println("\t 3  >> History of the Patient");
		System.out.println("\t 4  >> Bill of the patient");
		System.out.println("\t 5  >> Help");
		System.out.println("\t 6  >> Exit");
		System.out.print("Enter your choice: ");
		k = scan.next().charAt(0);
//if inputed choice is other than given choice
		switch (k) {
		case '1':
			patient();
			break;
		case '2':
			diagnos();
			break;
		case '3':
			history();
			break;
		case '4':
			bill();
			break;
		case '5':
			info();
			break;
		case '6':
			exit();
			break;
		default:
			System.out.print("\n\tInvalid Choice\n");
			System.out.print("\tTry again...........\n\n");
			menu();
		}
		menu();
	}

	void patient() {
		System.out.print("\nEnter the patient's file name: ");
		String fileName = scan.next();
		getCurrentTimeUsingDate();

		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName + ".txt");

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.
			System.out.print("********************************************************************");
			bufferedWriter.write("Date of admission: " + dadm);
			bufferedWriter.newLine();
			System.out.print("\nName : ");
			name = readString();
			bufferedWriter.write("Name : " + name);
			bufferedWriter.newLine();
			System.out.print("Address : ");
			address = readString();
			bufferedWriter.write("Address : " + address);
			bufferedWriter.newLine();
			System.out.print("Contact Number : ");
			contact = scan.nextLong();
			bufferedWriter.write("Contact Number : " + contact);
			bufferedWriter.newLine();
			System.out.print("Age : ");
			age = scan.nextInt();
			bufferedWriter.write("Age : " + age);
			bufferedWriter.newLine();
			System.out.print("Sex : ");
			sex = scan.next();
			bufferedWriter.write("Sex : " + sex);
			bufferedWriter.newLine();
			System.out.print("Blood Group : ");
			bg = scan.next();
			bufferedWriter.write("Blood Group : " + bg);
			bufferedWriter.newLine();
			System.out.print("Any Major disease suffered earlier : ");
			disease = readString();
			bufferedWriter.write("Any Major disease suffered earlier : " + disease);
			bufferedWriter.newLine();
			System.out.print("Patient ID : ");
			id = scan.nextLong();
			bufferedWriter.write("Patient ID : " + id);
			bufferedWriter.newLine();
			System.out.print("\n________________________________________________________________________\n");
			bufferedWriter.write("\n********************************************************************\n");
			bufferedWriter.newLine();
			System.out.print("Information Saved Successfully\n");
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
		pressAnyKeyToContinue();
	}

	void diagnos() {
		String symptom, diagnosis, medicine, addmission, ward, doctor;
		getCurrentTimeUsingDate();
		System.out.print("\n\nEnter the patient's file name to be opened : ");
		String fileName = scan.next();
		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName + ".txt");

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			System.out.println("\n\n\n\n\t\t\t\t........................................ Information about '" + fileName
					+ "' ........................................\n\n\n\n");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			// Always close files.
			bufferedReader.close();
			// Appending data in file
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)));
			System.out.print("Adding more information in patient's file................on : " + dadm);
			System.out.println("Description of the day:" + dadm);
			System.out.print("\nDoctor appointed:");
			doctor = readString();
			out.println("Doctor appointed: " + doctor);
			System.out.print("\nSymptoms : ");
			symptom = readString();
			out.println("Symptoms : " + symptom);
			System.out.print("\nDiagnosis : ");
			diagnosis = readString();
			out.println("Diagnosis : " + diagnosis);
			System.out.print("\nMedicines : ");
			medicine = readString();
			out.println("Medicines : " + medicine);
			System.out.print("\nAddmission Required? : ");
			addmission = readString();
			out.println("Addmission Required? : " + addmission);
			if (addmission.equals("Yes") || addmission.equals("Y")) {
				System.out.print("\nType of ward : ");
				ward = readString();
				out.println("Type of ward : " + ward);
				out.println("\n*************************************************************************\n");
				System.out.print(ward + " ward is alloted Successfully\n");
			} else {
				out.println("*************************************************************************\n");
			}
			out.close();
			pressAnyKeyToContinue();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException e) {
			System.out.println("Error writing or Reading to file '" + fileName + "'");
		}
	}

	void history() {
		System.out.print("\n\nEnter the patient's file name to be opened : ");
		String fileName = scan.next();
		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName + ".txt");
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			System.out.print("\n\n\n\n\t.................. Full Medical History of '" + fileName
					+ "' .........................\n\n\n\n");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			pressAnyKeyToContinue();
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

	void bill() {
		getCurrentTimeUsingDate();
		int days;
		double wcharge;
		double doc;
		double ser;
		System.out.println("_________________________________________________________________ ");
		System.out.print("n\t E-HEALTH CARE MANAGEMENT SYSTEM \n\n");
		System.out.println("_________________________________________________________________ ");
		System.out.print("Enter the patient's file name to get the Bill: ");
		String fileName = scan.next();
		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName + ".txt");
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)));
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			System.out.print("Date: " + dadm);
			System.out.println("\n\n\n\n\t\t\t\tDetails of the patient:\n\n\n\n");
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.print(" _____________________________________________________________");
			System.out.println("\n\tBill of the patient:");
			System.out.print("\t\t\t ___________________________________________________\n\n");
			System.out.print("No.of days patient stayed:");
			days = scan.nextInt();
			System.out.print("Ward charges/day:");
			wcharge = scan.nextDouble();
			System.out.print("Total ward charges:" + (wcharge * days));
			System.out.print("Doctor's fee:");
			doc = scan.nextDouble();
			System.out.print("Service charges:");
			ser = scan.nextDouble();
			System.out.print("TOTAL AMOUNT:" + ((wcharge * days) + doc + ser));
			System.out.println("Total Bill:" + ((wcharge * days) + doc + ser));
			System.out.print(" ___________________________________________________________\n");
			// Always close files.
			out.close();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		pressAnyKeyToContinue();
	}

	void exit() {
		System.out.println("                            THANK YOU FOR USING                            ");
		System.out.println("                        HEALTHCARE MANAGEMENT SYSTEM                   ");
		System.exit(0);
	}

	void info() {
		System.out.println("\n\nHealthCare Management System is command-driven application that helps to manage the record of the patient's as well as generate their hospital bills.");
		System.out.print("\t\t\t__________________________________________________________________________________________________________________________________\n");
		System.out.print("\n\t\t\t\tOptions		             | Description\n");
		System.out.print("\t\t\t__________________________________________________________________________________________________________________________________\n");
		System.out.println("\t\t\t 1 >> Add New Patient Record         | A new patient file can be created by using this module.");
		System.out.println("\t\t\t 2 >> Add Diagnosis Information      | Adding day-to-day evaluation of the patient or the diagnosis report in the existing file.");
		System.out.println("\t\t\t 3 >> History of the Patient         | Check the previous or existing details of particular patient by using their file name.");
		System.out.println("\t\t\t 4 >> Bill of the patient            | Generates the bill of the patient with displaying the details.");
		System.out.println("\t\t\t 5 >> Help			     | Provide the help documentation.");
		System.out.println("\t\t\t 6 >> Exit		             | Exits the application.");
		pressAnyKeyToContinue();
	}
}

public class HealthManagement {
	public static void main(String[] args) {
		Info i = new Info();
		i.login();
		i.menu();
	}
}