package test1;
import java.util.*;
public class Stud_1labB {
	
	 String name, addr,email,pno,branch;
	 double tfees,adfees,tutfees,ufees;

	static String nam,add,emai;
	static {					// Static Keyword !!!
		nam="rvce";
		add="kengeri";
		emai="person@rv.in";		
	}
	 Stud_1labB(String name,String addr,String branch,String pno,String email) // Constructor Overloading !!!
	 {
		this.name=name;
		this.addr=addr;
		this.pno=pno;
		this.email=email;
		this.branch=branch;
	 }
	 
	 Stud_1labB(String name,String addr,String branch)
	 {
		this.name=name;
		this.addr=addr;
		this.branch=branch;
		this.email=""+"rvce.person2@rvce.edu";
		this.pno="8542163541";
		this.tfees=tfees(branch);
	 }
	public double tfees(String branch)
	{
		this.adfees=50000;
		this.tfees=42000;
		this.ufees=33000;
		this.tfees=adfees+tfees+ufees;
		if(branch.equalsIgnoreCase("mca"))
		{
			tfees+=25000;
		}
		else if(branch.equalsIgnoreCase("mtech"))
		{
			tfees+=15000;
		}
		else if(branch.equalsIgnoreCase("mba"))
		{
			tfees+=35000;
		}
		else if(branch.equalsIgnoreCase("bca"))
		{
			tfees+=20000;
		}
		else
		{
			tfees+=45000;
		}
		return tfees;	
	}
	public void display()   //Method Overloading !!!
	{
		System.out.println("\nName :" +name +"\nAddress :"+addr+"\nBranch :"+branch+"\nPhone number :"+pno+
				"\nEmail Address"+email);
		
	}
	
	public void display(int fields) //Method Overloading !!!
	{
		if(fields==3)
		{
			System.out.println("\nName :" +name +"\nAddress :"+addr+"\nBranch :"+branch);
		}
		else
		{
			System.out.println("\nName :" +name +"\nAddress :"+addr+"\nBranch :"+branch+"\nPhone number :"+pno+
					"\nEmail Address"+email);
		}
	}
	public void display(String branch) //Method Overloading !!!
	{
		this.tfees=tfees(branch);
		System.out.println("\nBranch :" +branch+"\nTotal fees :"+tfees);
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stud_1labB s;
		Scanner sc=new Scanner(System.in);
		int flag=1;
		while(flag==1)
		{
			System.out.print("Student Details\n");
			System.out.print("Enter the Name of the student :");
			String name=sc.next();
			System.out.print("Enter the Address :");
			String addr=sc.next();
			System.out.print("Enter the Branch :");
			String branch=sc.next();
			System.out.print("Do you want to Add Phone number and Email ID (Yes=1 | No=2) :" );
			int ch=sc.nextInt();
			if(ch==1)
			{
				System.out.print("Enter the Phone Number :");
				//int pno=Integer.parseInt(sc.next());	
				String pno=sc.next();
				System.out.print("Enter the Email Address :");
				String email=sc.next();
				s=new Stud_1labB(name,addr,branch,pno,email);
			}
			else
			{
				s=new Stud_1labB(name,addr,branch);
			}
			System.out.println("\nMenu to Display \n1.All details \n2.[Only 3 / 5 Fields ] \n3.Student fees \n0.Exit \n");
			ch=sc.nextInt();
			if(ch==1)
			{
				s.display();
			}
			else if(ch==2)
			{
				System.out.print(" Enter the [3 / 5] :");
				int f=sc.nextInt();
				s.display(f);
			}
			else if(ch==3)
			{
				System.out.print("Enter the Branch to Calculate Fees :");
				String br=sc.next();
				s.display(br);
			}
			else
			{
				System.out.println("Enter the Valid Input !!! ");
			}
			System.out.println("Do You Want to continue !! \n Enter (Yes=1 | Exit=2) :");
			int n=sc.nextInt();
			if(n==1)
			{
				flag=1;
			}
			else
			{
				System.out.println("Exiting !!! ");
				flag=0;
			}	
			if(flag==0)
			{
				break;
			}
		}
	}

}
