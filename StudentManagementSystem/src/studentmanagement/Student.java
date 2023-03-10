package studentmanagement;
import java.util.Scanner;

public class Student {
	private String firstName, lastName, courses, studentID;
	private int gradeYear, tuitionBalance;
	private static int costOfCourse = 500, id = 1000;
	
	public Student() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first Name :");
		this.firstName = sc.nextLine();
		System.out.print("Enter last Name :");
		this.lastName = sc.nextLine();
		System.out.println("1.First Year 2.Second Year 3.Third Year \n Enter from above choice : ");
		this.gradeYear = sc.nextInt();
		
		setStudentID();
		
		System.out.println(firstName + " " + lastName +" -> "+gradeYear + " -> " + studentID);
//		sc.close();
	}
	
	// GENERATE ID
	private void setStudentID() {
		id++;
		this.studentID = gradeYear+""+id;
	}
	
	// ENROLL IN COURSE
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (q for exit) : ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("q")) {
				courses = course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				System.out.println("BREAK");
				break;
			} 
//			in.close();
		} while (1!=0);
	}
	
	// VIEW BALANCE
	public void viewBalance() {
		System.out.println("Your Balance is Rs."+tuitionBalance);
	}
	
	// PAY TUITION FEES
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: Rs.");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of Rs."+payment);
		viewBalance();
//		in.close();
	}
	
	// SHOW STATUS
	public String toString() {
		return "\nName: "+firstName+" "+lastName+
				"\nGrade level: "+ gradeYear+
				"\nStudent ID: "+studentID+
				"\nCourses Enrolled: "+courses+
				"\nBalance: Rs."+tuitionBalance;
	}
	
}
