package Student_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class OperationsCLg {

	static Scanner sc = new Scanner(System.in);

	static Student_Pojo sp = new Student_Pojo();

	// Add Student

	public static void addStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
					"Vaibhav#0079");
			String Query = "insert into student_data(name,branch,address,birth_date,adhar_no) values(?,?,?,?,?)";

			  // Student_Pojo sp=new Student_Pojo();
             //System.out.print("Enter Student Id :");
            //int id=sc.nextInt();
		   //sc.nextLine();
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter Student Name :");
			String name = sc.nextLine();

			System.out.print("Enter Student Branch :");
			String branch = sc.nextLine();

			System.out.print("Enter Student Address :");
			String address = sc.nextLine();

			System.out.print("Enter Student Birth_Date :");
			String birth_date = sc.nextLine();
			sc.nextLine();

			System.out.print("Enter Student Adhar :");
			int adhar = sc.nextInt();

			sp.setName(name);
			sp.setBranch(branch);
			sp.setAddress(address);
			sp.setBirthDate(birth_date);
			sp.setAdharNo(adhar);
			PreparedStatement stmt = Con.prepareStatement(Query);
			// stmt.setInt(1, sp.getId());
			stmt.setString(1, sp.getName());
			stmt.setString(2, sp.getBranch());
			stmt.setString(3, sp.getAddress());
			stmt.setString(4, sp.getBirthDate());
			stmt.setInt(5, sp.getAdharNo());
			int s = stmt.executeUpdate();
			if (s > 0) {
				System.out.println("Data Inserted Successfully");
			} else {
				System.out.println("Data Not Inserted");
			}
		} catch (Exception e) {
			System.out.println("Something going wrong :" + e);
		}
	}

	public static void displayStudents(List<Student_Pojo> students) throws ClassNotFoundException, SQLException {
		System.out.println();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
				"Vaibhav#0079");
		String Query = "select * from student_data";
		PreparedStatement stmt = Con.prepareStatement(Query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			// System.out.println(rs.getInt(1)+" "+rs.getString(2)+"
			// "+rs.getString(3)+rs.getString(4));
			Student_Pojo sp = new Student_Pojo();
			sp.setId(rs.getInt(1));
			sp.setName(rs.getString(2));
			sp.setBranch(rs.getString(3));
			sp.setAddress(rs.getString(4));
			sp.setBirthDate(rs.getString(5));
			sp.setAdharNo(rs.getInt(6));
			students.add(sp);
		}
		Iterator<Student_Pojo> itr = students.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	public static void updatestudent() throws ClassNotFoundException, SQLException {
		// sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
				"Vaibhav#0079");

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

	public static void deletestudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_class", "root",
				"Vaibhav#0079");

		System.out.print("Enter id which basis you want to delete data:");
		int id = sc.nextInt();
		String Query = "delete from student_data where id='" + id + "'";
		PreparedStatement stmt = Con.prepareStatement(Query);
		int result = stmt.executeUpdate();
		if (result > 0) {
			System.out.println("\nStudent Data Deleted Successfully");
		} else {
			System.out.println("\nData Not Deleted");
		}

	}

}
