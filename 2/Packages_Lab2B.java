package test1;
import java.util.*;
import shapes.*;
//public class Packages_Lab2B extends cir{ // protected cir
public class Packages_Lab2B extends Square{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in); // Creating the Scanner object
		System.out.println("Find the Areas \n1.Triangle \n2.Circle \n3.Square \n4.Exit");
		int ch=sc.nextInt();
			
		
//		Packages_Lab2B n=new Packages_Lab2B();
//		n.area(4);				//  Calling the Protected Method from another Class by creating main child class object
//		
		
//		cir n=new cir();			//creating in same package
//		n.area(4);
		
		
		while(true)
		{
			if(ch==1)
			{
				Triangle t=new Triangle();  // Creating the Triangle object
				System.out.print("Enter the Base :");
				double b=sc.nextDouble();
				System.out.print("Enter the Height :");
				double h=sc.nextDouble();
				System.out.println("Area of the Triangle is "+t.area(b,h));break;
				
			}
			else if(ch==2)
			{
				Circle c=new Circle();    // Creating the Circle object
				System.out.print("Enter the Radius :");
				double r=sc.nextDouble();
				System.out.println("Area of the Circle is "+c.area(r));break;
				
			}
			else if(ch==3)
			{
				Square sq=new Square();   // Creating the Square object
				System.out.print("Enter the Sides :");
				double s=sc.nextDouble();
				System.out.println("Area of the Square is "+sq.area(s));break;
				
			}
			else if(ch==4)
			{
				break;
			}
			else
			{
				System.out.println("Invalid Input !!!");
			}
			
		}
	}
}

