package test1;

import java.util.Scanner;

public class Inheritance 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name,email,pno,add;
		int ch;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the name :");
		name=sc.next();
		System.out.print("Enter the Address :");
		add=sc.next();
		System.out.print("Enter the Email :");
		email=sc.next();
		System.out.print("Enter the Phone No :");
		pno=sc.next();
		
		System.out.println("You're \n1.Staff ? \n2.Student ? ");
		System.out.print("Enter the choice :");
		ch=sc.nextInt();
		
		if(ch==1)
		{
			System.out.print("Enter the Emplyee Id :");
			String empid=sc.next();
			System.out.print("Enter the Emplyee Designation:");
			String designation=sc.next();
			Staff_2A st=new Staff_2A(name,add,email,pno,empid,designation);
			st.salary();
			
		}
		else if(ch==2)
		{
			System.out.print("Enter the Student USN :");
			String usn=sc.next();
			System.out.print("Which Branch ? \n1.M.C.A \n2.M.tech \n3.B.C.A \n4. others :");
			System.out.println("Enter the Choice ");
			String n=sc.next();
			
			Student_2A s=new Student_2A(name,add,email,pno,usn);
			s.fees(n);
		}
		else
		{
			System.out.println("Enter the Valid Choice !!!");
		}
		
	}

}
