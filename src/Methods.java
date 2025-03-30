import java.util.Scanner;
public class Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/*Reverse a String*/
		
		StringBuilder rev = new StringBuilder("Hexaware");
		
		System.out.println("reversed text: " + rev.reverse());
		
		/*Check if a String is a Palindrome */
		
		
		
		for(int i = 0; i < 2; i++) {
			
			System.out.print("Enter a string: ");
			
			
			
			String p1 = sc.nextLine();
	        StringBuilder pal = new StringBuilder(p1);
	        
	        // Convert StringBuilder to String after reversing
	        String p2 = pal.reverse().toString();
	        
	        // Correct comparison using equals()
	        System.out.println("Is palindrome or not? " + p1.equals(p2));
			
		}
		
		/* Count the Number of Vowels and Consonants */
		
		 System.out.print("Enter a string: ");
	     String str = sc.nextLine().toLowerCase(); // Convert to lowercase for case insensitivity

	     int vowelCount = 0, consonantCount = 0;
	     
	  // Iterate through each character
	     for (char ch : str.toCharArray()) {
	    	 if ("aeiou".indexOf(ch) != -1) {
                 vowelCount++;  // Vowel found
             } else {
                 consonantCount++;  // Consonant found
             }
	     }

	     // Display result
	     System.out.println("Vowels: " + vowelCount);
	     System.out.println("Consonants: " + consonantCount);
		
	}

}
