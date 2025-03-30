public class Test1 {
	// variable declaration
	int stid;
	String stname;
	String staddress;
 
	//parameterized  default constructor
	public Test1(int x, String y) {
		
		
		stid=x;
		stname=y;
	}
	
	//default constructor
	public Test1()
	{
		//call current class parameterized constructor
		
		this(100,"rk");
		staddress="hyd";
	}
 
	public void display() {
		// displaying the values
		System.out.println("student id is: " + stid);
		System.out.println("student name is: " + stname);
		System.out.println("student address is: " + staddress);
	}
 
	public static void main(String[] args) {
		// create the object
 
		Test1 obj = new Test1();
		
		
		obj.display();
 
	}
 
}