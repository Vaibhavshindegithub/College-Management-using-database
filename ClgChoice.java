package Student_Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ClgChoice {
	public static void clgchoice() throws ClassNotFoundException, SQLException, InterruptedException
	{
		do {
		List<Student_Pojo> studentList=new ArrayList<Student_Pojo>();
		Scanner sc=new Scanner(System.in);
	//	System.out.println("Welcome "+LoginOption.clgName);
	
		System.out.println("\n");
		System.out.println("Press "
				            + "\n1.Add Student  "
				            + "\n2.Display Details of Student"
				            + "\n3.Delete Student Record "
				            + "\n4.Update Student Details "
				            + "\n5.Main Page");
		System.out.print("Enter Your Choice :");
		int choice =sc.nextInt();
		
		switch(choice)
		{
		   case 1:
			        OperationsCLg.addStudent();
			        break;
			        
		   case 2:
			        OperationsCLg.displayStudents(studentList);
			        break;
			        
		   case 3:
			        OperationsCLg.deletestudent();
		            break; 
			       
		   case 4:
			       OperationsCLg.updatestudent();
			       break;
			
		   case 5 :
			        Main_Class.dd();
			        break;
			        
		   default :
				       System.out.println("Invalid Choice");
			       
		}
		}while(true);
		
	}

}
