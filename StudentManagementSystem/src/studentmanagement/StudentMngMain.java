package studentmanagement;

import java.util.Scanner;

public class StudentMngMain {
	public static void main(String[] args) {
//		Student student = new Student();
//		student.enroll();
//		student.payTuition();
//		System.out.println(student.toString());
		
		System.out.print("Enter number of students to enroll : ");
		Scanner in = new Scanner(System.in);
		int noOfStudents = in.nextInt();
		Student[] students = new Student[noOfStudents];
		
		for (int i=0; i<students.length; i++) {
			System.out.println("\nEnter details of student "+(i+1));
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
		}
		
		System.out.println("\n DETAIL INFORMATION : ");
		for (int n=0; n<noOfStudents; n++) {
			System.out.println(students[n].toString());
		}
//		in.close();
	}
}
