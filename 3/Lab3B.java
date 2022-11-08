package Jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;


public class Lab3B {
			Connection con;
			public Connection setConnection() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					return DriverManager.getConnection("jdbc:mysql://172.16.34.105:3306/1rv21mc044","1rv21mc044","1rv21mc044");
	
				}
				catch(Exception e){ 
					System.out.println(e);
					return null;
				}
			}
			
			public int insertData(String usn, String name, String addr, int age) {
				try {
					Connection con = setConnection();
					PreparedStatement st = con.prepareStatement("insert into emp values(?,?,?,?)");
					if(usn.isBlank())
						throw new UsnEmptyException("Usn cannot be empty");
					else if(name.isBlank())
						throw new UsnEmptyException("Name cannot be empty");
					else {
						st.setString(1,usn);
						st.setString(2,name);
						st.setString(3,addr);
						st.setInt(4,age);
						int n = st.executeUpdate();
						con.close();
						return n;
					}
				}
				catch(Exception e) {
//					System.out.println(e);
					e.printStackTrace();
					return -1;
				}
			}
			public int deleteData(String usn) {
				try {
					Connection con = setConnection();
					PreparedStatement st = con.prepareStatement("delete from emp where id = ?");
					if(usn.isBlank())
						throw new UsnEmptyException("Usn cannot be empty");
					else {
						st.setString(1,usn);
						int n = st.executeUpdate();
						con.close();
						return n;
					}
				}
				catch(Exception e) {
					System.out.println(e);
					return -1;
				}
			}
			public int updateData(String usn, String name) {
				try {
						Connection con = setConnection();
						PreparedStatement st = con.prepareStatement("update emp set name = ? where id = ?");
						if(usn.isBlank())
							throw new UsnEmptyException("Usn cannot be empty");
						else {
							st.setString(1, name);
							st.setString(2,usn);
							int n = st.executeUpdate();
							con.close();
							return n;
						}
					}
					catch(Exception e) {
						System.out.println(e);
						return -1;
					}
				}
			public ResultSet searchDataById(String usn) {
				try {
					String query = "select * from emp where id = ?";
					con = setConnection();
					PreparedStatement st = con.prepareStatement(query);
					if(usn.isBlank())
						throw new UsnEmptyException("Usn cannot be empty");
					else {
						st.setString(1,usn);
						ResultSet n = st.executeQuery();
						return n;
					}
				}
				catch(Exception e) {
					System.out.println(e);
					return null;
				}
			}
			public ResultSet searchDataByName(String name) {
				try {
					String query = "select * from emp where name = ?";
					con = setConnection();
					PreparedStatement st = con.prepareStatement(query);
					if(name.isBlank())
						throw new UsnEmptyException("Name cannot be empty");
					else {
						st.setString(1,name);
						ResultSet n = st.executeQuery();
						return n;
					}
				}
				catch(Exception e) {
					System.out.println(e);
					return null;
				}
			}
			public ResultSet displayData() {
				try {
					String query = "select * from emp";
					con = setConnection();
					PreparedStatement st = con.prepareStatement(query);
					ResultSet n = st.executeQuery();
					return n;
				}
				catch(Exception e) {
					System.out.println(e);
					return null;
				}
			}
			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Lab3B obj = new Lab3B();
				obj.setConnection();
				while(true) {
					System.out.println("Enter 1 to insert value \n Enter 2 to update name \n Enter 3 to delete value \n Enter 4 to search data \n Enter 5 to search data by name \n Enter 6 to display data \n Enter 7 to exit");
					int ch = sc.nextInt();
					if(ch==1) {
						System.out.println("Enter Usn");
						String usn = br.readLine();
						System.out.println("Enter name");
						String name = sc.next();
						System.out.println("Enter addr");
						String addr = sc.next();
						System.out.println("Enter age");
						int age = sc.nextInt();
						int n = obj.insertData(usn, name, addr, age);
						if(n>0)
							System.out.println("Successfully inserted");
						else
							System.out.println("Insertion Unsuccessfull");
					}
					else if(ch==2) {
						System.out.println("Enter usn");
						String usn = sc.next();
						System.out.println("Enter name");
						String name = sc.next();
						int n = obj.updateData(usn, name);
						if(n>0)
							System.out.println("Successfully updated");
						else
							System.out.println("Updation Unsuccessfull");
					}
					else if(ch==3) {
						System.out.println("Enter usn");
						String usn = sc.next();
						int n = obj.deleteData(usn);
						if(n>0)
							System.out.println("Successfully Deleted");
						else
							System.out.println("Deletion Unsuccessfull");
					}
					else if(ch==4) {
						try {
							System.out.println("Enter usn");
							String usn = sc.next();
							ResultSet rs = obj.searchDataById(usn);
							while(rs.next()) {  
								System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));  
							}
							obj.con.close();
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
							obj.con.close();
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
							obj.con.close();
						}
						catch(Exception e) {
							System.out.println(e);
						}
					}
					else if(ch==7) {
						break;
					}
				}
			}
		}


