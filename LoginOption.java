package Student_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginOption {
   static Scanner sc=new Scanner(System.in);
    
	public static  void Loginclg() throws ClassNotFoundException, SQLException
	{
		
		try {
			System.out.println();
			System.out.print("Enter College Registration Id :");
			int clgid=sc.nextInt();
	         sc.nextLine();
			
			
			System.out.print("Enter College Name :");
			String  clgName=sc.nextLine();
			
		    System.out.print("Enter Password :");
		    String pass=sc.next();
		//sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
				"Vaibhav#0079");
		String query1 = "select Clgname from College_info";
		String query2 = "select  registration_id from College_info";
		String query3 = "select password from College_info";
		PreparedStatement stmt1 = Con.prepareStatement(query1);
		PreparedStatement stmt2 = Con.prepareStatement(query2);
		PreparedStatement stmt3 = Con.prepareStatement(query3);
		ResultSet rs1 = stmt1.executeQuery();
		ResultSet rs2 = stmt2.executeQuery();
		ResultSet rs3 = stmt3.executeQuery();
		
		

		int count = 0;

		while (rs1.next() && rs2.next() && rs3.next()) {

			if (clgName.equalsIgnoreCase(rs1.getString(1)) && clgid==(rs2.getInt(1)) &&  pass.equals(rs3.getString(1))) {
				System.out.println("\nWelcome "+clgName);
				Thread.sleep(2000);
				ClgChoice.clgchoice();
				
				count++;
			}

		}
		if (count == 0) {
			System.out.println("Data Not Found");
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void studLogin() throws ClassNotFoundException, SQLException, InterruptedException
	{
		try {
		System.out.println("Welcome Student Login Portal");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
				"Vaibhav#0079");
		String query1 = "select name from student_data";
		//String query2 = "select Birth_date from student_data";
		String query3 = "select adhar_no from student_data";
		PreparedStatement stmt1 = Con.prepareStatement(query1);
		//PreparedStatement stmt2 = Con.prepareStatement(query2);
		PreparedStatement stmt3 = Con.prepareStatement(query3);
		{
			ResultSet rs1 = stmt1.executeQuery();
			//ResultSet rs2 = stmt2.executeQuery();
			ResultSet rs3 = stmt3.executeQuery();
			System.out.print("Enter Name :");
			String name = sc.next();
			System.out.print("Enter Adhar_no :");
			int adhar=sc.nextInt();

			int count = 0;

			while (rs1.next() && rs3.next()) {

				if (name.equals(rs1.getString(1)) && adhar==(rs3.getInt(1))) {
					System.out.println("Welcome "+name);
					Thread.sleep(2000);
					StudOperations.updatestudent();
					System.out.println();
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Data Not Found");
			}
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
