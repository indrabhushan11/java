package database;
import java.sql.*;
import java.util.*;
public class Student {
	
	Connection con;
	ResultSet result=null;
	Scanner sc=new Scanner(System.in);
	public void connection()
	{
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://172.16.34.105/1rv21mc043","1rv21mc043","1rv21mc043");
//			Statement st=con.createStatement();

			System.out.println("Successfully Connected !!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void creation()
	{
		try
		{
			Statement st=con.createStatement();
			System.out.println("\n Enter the Name ");
			String name=sc.next();
			System.out.println("\n Enter the USN ");
			String usn=sc.next();
			String sql="insert into student values('"+usn+"','"+name+"')";
			int res=st.executeUpdate(sql);
			System.out.println("Successfully Inserted !!");
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void insertion()
	{
		try
		{
			Statement st=con.createStatement();
			System.out.println("\n Enter the Name ");
			String name=sc.next();
			System.out.println("\n Enter the USN ");
			String usn=sc.next();
			String sql="insert into student values('"+usn+"','"+name+"')";
			System.out.println("Successfully Inserted !!");
			int res=st.executeUpdate(sql);
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void Deletion()
	{
		try {
			Statement st=con.createStatement();
			System.out.println("Enter the USN ");
			String usn=sc.next();
			String sql=("delete *from student where usn = '+'");
			ResultSet res=st.executeQuery(sql);
			System.out.println("Successfully Deleted !!");
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void Display()
	{
		try 
		{
			Statement st=con.createStatement();
			String sql="select *from student ";
			ResultSet res=st.executeQuery(sql);
			while(res.next())
			{
				System.out.println(res.getString(1));
				System.out.println(res.getString(2));
			}
				con.close();
				st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}

	public void update()
	{
		try
		{
			Statement st=con.createStatement();
			System.out.println("\n Enter the USN to be updated !!");
			String usn=sc.next();
			System.out.println("\n Enter the Name ");
			String name=sc.next();

			String sql=("update students set name='name' where usn='usn' ");
			int res=st.executeUpdate(sql);
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		Student st =new Student();
		System.out.println("\n1.Connection \n2.Insertion \n3.Deletion \n4.update \n5.Display \n6.Exit ");
		System.out.print("Enter the Choice ");
		int n=s.nextInt();
	
		if(n==1)
		{
			st.connection();
		}
		else if(n==2)
		{
			st.connection();
			st.insertion();
		}
		else if(n==3)
		{
			st.connection();
			st.Deletion();
		}
		else if(n==4)
		{
			st.connection();
			st.update();
		}
		else if(n==5)
		{
			st.connection();
			st.update();
		}
		else
		{
			System.out.println("\n Invalid Input !!! ");			
			
		}
		
			
	}

}
