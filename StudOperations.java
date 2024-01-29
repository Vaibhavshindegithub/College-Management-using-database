package Student_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudOperations {
	
	static Scanner sc=new Scanner(System.in);
public static void 	updatestudent() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
			"Vaibhav#0079");

	System.out.println("\nStudents Can Update There Profile Only other rights are not preserved");
	System.out.println("\nEnter What you want to change Type for \nname=name \nbranch=branch"
			+ "\naddress=address \nbirth_date=birth_date \nadhar_no=adhar_no" + "\nAll=All\n");
	System.out.print("Type Here :");
	String change = sc.next();

	if (change.equalsIgnoreCase("name")) {
		System.out.print("Enter New Name :");
		String nName = sc.next();

		System.out.print("Enter id which basis you make change :");
		int id = sc.nextInt();

		String query1 = "update student_data set name='" + nName + "' where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(query1);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Name Updated Successfully");
		} else {
			System.out.println("\n Name Not Updated");
		}
	} else if (change.equalsIgnoreCase("branch")) {
		System.out.print("Enter New branch :");
		String nbranch = sc.next();

		System.out.print("Enter id which basis you make change :");
		int id = sc.nextInt();

		String query2 = "update student_data set branch='" + nbranch + "' where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(query2);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Branch Updated Successfully");
		} else {
			System.out.println("\n Branch Not Updated");
		}
	} else if (change.equalsIgnoreCase("address")) {
		System.out.print("Enter New Address :");
		String naddress = sc.next();

		System.out.print("Enter id which basis you make change :");
		int id = sc.nextInt();

		String query3 = "update student_data set address='" + naddress + "' where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(query3);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Address Updated Successfully");
		} else {
			System.out.println("\n Address Not Updated");
		}
	} else if (change.equalsIgnoreCase("birth_date")) {
		System.out.print("Enter New Birth_Date :");
		String nbirth_date = sc.next();

		System.out.print("Enter id which basis you make change :");
		int id = sc.nextInt();

		String query4 = "update student_data set birth_date='" + nbirth_date + "' where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(query4);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Birth_date Updated Successfully");
		} else {
			System.out.println("\n Birth_date Not Updated");
		}
	} else if (change.equalsIgnoreCase("adhar_no")) {
		System.out.print("Enter New Adhar_no :");
		int nadhar_no = sc.nextInt();

		System.out.print("Enter id which basis you make change :");
		int id = sc.nextInt();

		String query5 = "update student_data set birth_date='" + nadhar_no + "' where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(query5);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Adhar_no Updated Successfully");
		} else {
			System.out.println("\n Adhar_no Not Updated");
		}
	} else if (change.equalsIgnoreCase("All :")) {

		System.out.print("Enter Id For Updation:");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Student Name:");
		String name = sc.nextLine();

		System.out.print("Enter Branch:");
		String branch = sc.nextLine();

		System.out.print("Enter Student Address:");
		String address = sc.nextLine();
		
		System.out.print("Enter Student Birth_Date :");
		String birth_date = sc.nextLine();
		
		System.out.print("Enter Student Address:");
		int adhar=sc.nextInt();

		String Query = "update student_data set name='" + name + "',branch='" + branch + 
				"',address='" + address+ "',birth_date='"+birth_date+"' where id='" + id + "' ";

		PreparedStatement stmt = Con.prepareStatement(Query);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Data Updated Successfully");
		} else {
			System.out.println("\n Data Not Updated");
		}
	} else {
		System.out.println("Wrong Input");
	}
	}

}
