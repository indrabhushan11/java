package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class employee{

	Connection con;
	ResultSet result=null;
	PreparedStatement pst=null;
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
			e.printStackTrace();
		}
		
	}
//	public void creation()
//	{
//		try
//		{
//			
//			Statement st=con.createStatement();
//			pst=con.prepareStatement(null);
//			System.out.println("\n Enter the Name ");
//			String name=sc.next();
//			System.out.println("\n Enter the USN ");
//			String usn=sc.next();
//			String sql="insert into student values(usn=?,name=?)";
//			pst.setString(1,usn);
//			pst.setString(2,name);
//			
//			int res=st.executeUpdate(sql);
//			System.out.println("Successfully Inserted !!");
//			con.close();
//			st.close();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	
	public void insertion()
	{
		try
		{
			pst=con.prepareStatement("insert into student values(usn=?,name=?)");
			
			
			System.out.println("\n Enter the Name ");
			String name=sc.next();
			System.out.println("\n Enter the USN ");
			String usn=sc.next();
		//	String sql="insert into student values('"+usn+"','"+name+"')";
			
			System.out.println(name.length());
			
			if(name.equalsIgnoreCase("1"))
			{
				throw new myException("USN is Empty");
			}
			else
			{
//				String sql="insert into student values(usn=?,name=?)";
				pst.setString(1,usn);
				pst.setString(2,name);	
				System.out.println("Successfully Inserted !!");
				int res=pst.executeUpdate();
			}
//			String sql="insert into student values(usn=?,name=?)";
//			pst.setString(1,usn);
//			pst.setString(2,name);
//			System.out.println("Successfully Inserted !!");
//			int res=st.executeUpdate(sql);
			con.close();
//			st.close();
		}
		catch(myException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}

	}
	
	
	public void Deletion() throws Exception
	{
		try {
			
			Statement st=con.createStatement();
			pst=con.prepareStatement(null);
			
			System.out.println("Enter the USN ");
			String usn=sc.next();

			
			if(usn.equalsIgnoreCase(" "))
			{
				throw new myException("USN is Empty");
			}
			String sql="delete from student where usn = ?";
			
			pst.setString(1, usn);
			
			int res=st.executeUpdate(sql);
			System.out.println("Successfully Deleted !!");
			
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
			e.printStackTrace();
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

//			String sql=("update students set name='name' where usn='usn' ");
			
			String sql="update students set name='name' where usn=?";
			pst.setString(1,usn);
			
			int res=st.executeUpdate(sql);
			con.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		employee st =new employee();
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
			//st.Deletion();
		}
		else if(n==4)
		{
			st.connection();
			st.update();
		}
		else if(n==5)
		{
			st.connection();
			st.Display();
		}
		else
		{
			System.out.println("\n Invalid Input !!! ");			
			
		}
			
	}
}
