package test1;
import java.util.*;
public class Stud_lab1A {

	private String name;
	private String addr;
	private String email;
	private String branch;
	public double fees;
	public static double mca=80000;
	public static double mtech=75000;
	public static double bca=50000;
	
	Scanner sc=new Scanner(System.in);
	
	
	Stud_lab1A(String name,String addr,String email,String branch)
	{
		this.name=name;
		this.addr=addr;
		this.email=email;
		this.branch=branch;
		this.fees=branch(branch);
		
	}
	Stud_lab1A() {
		// TODO Auto-generated constructor stub
	}
	
	public void studentdetails()
	{
		System.out.println("\nEnter the Name :");
		name=sc.next();
		System.out.println("\nEnter the Address :");
		addr=sc.next();
		System.out.println("\nEnter the Email Id :");
		email=sc.next();
		System.out.println("\nEnter the Branch :");
		branch=sc.next();
		
	}
	public double branch(String branch)
	{
		if(branch.equalsIgnoreCase("mca"))
		{
			return mca;
		}
		else if(branch.equalsIgnoreCase("mtech"))
		{
			return mtech;
		}
		else if(branch.equalsIgnoreCase("bca"))
		{
			return bca;
		}
		else
		{
			System.out.println("Enter the Valid course !!!");
			
		}
		return 0;
		
	}
	
	public void studentdisplay()
	{
		System.out.println("Name=" +this.name);
		System.out.println("Address=" +this.addr);
		System.out.println("Email id =" +this.email);
		System.out.println("Branch=" +this.branch);
				
		if(branch.equalsIgnoreCase("mca"))
		{
			
			System.out.println("Fees= rs 80000");
		}
		else if(branch.equalsIgnoreCase("mtech"))
		{
			System.out.println("Fees= rs 75000");
		}
		else if(branch.equalsIgnoreCase("bca"))
		{
			System.out.println("Fees= rs 50000");
		}
		else
		{
			System.out.println("Invalid course !!!");
			
		}
		
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stud_lab1A s=new Stud_lab1A();
		System.out.println("\nMenu\n1.Add Student Details \n2.Display Details \n3.Exit");
		
				s.studentdetails();
			
				s.studentdisplay();
			
		}
}
