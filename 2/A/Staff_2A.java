package test1;

public class Staff_2A extends Person implements Itstaff{
	
	String empid,designation,salary;
	
	public Staff_2A(String name,String add,String email,String pno,String empid,String designation) 
	{
		// TODO Auto-generated constructor stub
		super(name,add,email,pno);
		this.empid=empid;
		this.designation=designation;
		
	}
		
	@Override
	public void salary() {
		// TODO Auto-generated method stub
		this.salary="100000";
		System.out.println("Name of an Employee : "+this.name);
		System.out.println("Employee Id : "+this.empid);
		System.out.println("Address : "+this.add);
		System.out.println("Email Id : "+this.email);
		System.out.println("Phone Number : "+this.pno);
		System.out.println("Designation : "+this.designation);
		System.out.println("Annual Income : "+this.salary);
	}

}
