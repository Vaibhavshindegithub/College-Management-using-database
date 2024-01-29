package Student_Data;

import java.sql.SQLException;


import java.util.Scanner;

public class Main_Class {
	
	public static void dd() throws InterruptedException, ClassNotFoundException, SQLException
	{
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println();
			System.out.println("\t\t\t\t\tCollege Management System");
			System.out.println("######################################################################################");
			System.out.println("Press \n1.College Login  \n2.Student Login");
			System.out.print("Enter Your Chioce :");
			int choice1=sc.nextInt();
			if(choice1==1)
			{
				System.out.println(" \nWelcome College Portal");
		            Thread.sleep(1000);
				//System.out.println();
	               LoginOption.Loginclg();
			}
			else if(choice1==2)
			{
				LoginOption.studLogin();
			}
			else
			{
				System.out.println("Please Enter Valid Choice ");
			}
			}while(true);

		}
	

	public static void main(String[] args) {
		try {
			Main_Class.dd();
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}
