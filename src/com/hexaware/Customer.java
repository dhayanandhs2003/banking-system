package com.hexaware;
public class Customer {
private static int custid=100; 
private static String custname="rk";

@Override
public String toString()
{
	return custid + " " + custname;
}

public static void main(String[] args) { 
	Customer customer = new Customer();
System.out.println (customer);
//com.hexaware.cfw.Customer@4517d9a3

}
}