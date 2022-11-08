package test1;

public class Student_2A extends Person implements Itstudent
{
	String usn,branch;String fees;

	public Student_2A(String name,String add,String email,String pno,String usn) 
	{
		// TODO Auto-generated constructor stub
		super(name,add,email,pno);
		this.usn=usn;
	}

	@Override
	public void fees(String n)
	{
		// TODO Auto-generated method stub
		if(n=="1")
		{
			this.fees="500000";
			this.branch="MCA";
		}
		else if(n=="2")
		{
			this.fees="255000";
			this.branch="MTECH";
		}
		else if(n=="3")
		{
			this.fees="100000";
			this.branch="BCA";
		}
		else
		{
			this.fees="240000";
			this.branch="others";
		}
		
		System.out.println("Name of an Employee : "+this.name);
		System.out.println("Address : "+this.add);
		System.out.println("Email Id : "+this.email);
		System.out.println("Phone Number : "+this.pno);
		System.out.println("USN : "+this.usn);
		System.out.println("Branch : " +this.branch);
		System.out.println("Fees of "+this.branch+" is : " +this.fees);
		
	}
}
