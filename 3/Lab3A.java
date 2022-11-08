package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	
	Connection connection;
	Statement statement;
	public Statement setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://172.16.34.105:3306/1rv21mc044","1rv21mc044","1rv21mc044");
			statement= connection.createStatement();
			return statement;
		}
		catch(Exception e){ 
			System.out.println(e);
			return null;
		}
	}
	
	public int insertData(String id, String name, String addr, int age) {
		try {
			String query = "insert into emp values('"+id+"','"+name+"','"+addr+"',"+age+")";
			return statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	public int deleteData(String id) {
		try {
			String query = "delete from emp where id = '"+id+"'";
			return statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	public int updateData(String id, String name) {
		try {
			String query = "update emp set name = '"+name+"' where id = '"+id+"'";
			return statement.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	public ResultSet searchDataById(String id) {
		try {
			String query = "select * from emp where id = '"+id+"'";
			return statement.executeQuery(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public ResultSet searchDataByName(String name) {
		try {
			String query = "select * from emp where name = '"+name+"'";
			return statement.executeQuery(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public ResultSet displayData() {
		try {
			String query = "select * from emp";
			return statement.executeQuery(query);
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Test obj = new Test();
		obj.setConnection();
		while(true) {
			System.out.println("Enter 1 to insert value \n Enter 2 to update name \n Enter 3 to delete value \n Enter 4 to search data \n Enter 5 to search data by name \n Enter 6 to display data \n Enter 7 to exit");
			int ch = sc.nextInt();
			if(ch==1) {
				System.out.println("Enter id");
				String id = sc.next();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter addr");
				String addr = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				int n = obj.insertData(id, name, addr, age);
				if(n>0)
					System.out.println("Successfully inserted");
				else
					System.out.println("Insertion Unsuccessfull");
			}
			else if(ch==2) {
				System.out.println("Enter id");
				String id = sc.next();
				System.out.println("Enter name");
				String name = sc.next();
				int n = obj.updateData(id, name);
				if(n>0)
					System.out.println("Successfully updated");
				else
					System.out.println("Updation Unsuccessfull");
			}
			else if(ch==3) {
				System.out.println("Enter id");
				String id = sc.next();
				int n = obj.deleteData(id);
				if(n>0)
					System.out.println("Successfully Deleted");
				else
					System.out.println("Deletion Unsuccessfull");
			}
			else if(ch==4) {
				try {
					System.out.println("Enter id");
					String id = sc.next();
					ResultSet rs = obj.searchDataById(id);
					while(rs.next()) {  
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));  
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(ch==5) {
				try {
					System.out.println("Enter name");
					String name = sc.next();
					ResultSet rs = obj.searchDataByName(name);
					while(rs.next()) {  
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));  
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(ch==6) {
				try {
					ResultSet rs = obj.displayData();
					while(rs.next()) {  
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));  
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(ch==7) {
				break;
			}
		}
		try {
			obj.connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
