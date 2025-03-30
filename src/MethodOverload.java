class Cars{
	void CarModel(String a) {
		System.out.println(a);
	}
	
	void CarModel(int a) {
		System.out.println(a);
		
	}
}

class A{
	void add(int a, int b) {
		System.out.println(a+b);
	}
}

class B extends A{
	void add(int a, int b) {
		System.out.println(a-b);
	}
}




public class MethodOverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cars myCar = new Cars();
		myCar.CarModel("Lambo");
		myCar.CarModel(1);
		
		
		A obj = new B();
		obj.add(1, 3);
		
		
	}

}
