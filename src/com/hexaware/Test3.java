// LinkedList

package com.hexaware;

import java.util.LinkedList;
import java.util.List;

public class Test3 {
	public static void main(String args[]) {
		List l = new LinkedList();
		
		l.add(1);
		l.add(null);
		l.add("Kumar");
		l.add("abinesh");
		l.addFirst("manoj");
		l.addLast("null");
		
		System.out.println(l);
		
	
	}
}
