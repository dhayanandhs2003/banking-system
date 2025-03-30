// Task 5: Password Validation 

import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the password to create: ");
            String s = sc.nextLine();
            int len = s.length();

            // Check if password length is at least 8 characters
            if (len < 8) {
                System.out.println("The password is invalid. It must be at least 8 characters long.");
                continue;
            }

            boolean hasUpper = false;
            boolean hasDigit = false;

            // Check for at least one uppercase letter and one digit
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (Character.isUpperCase(ch)) {
                    hasUpper = true;
                }
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
            }

            // validate password
            if (hasUpper && hasDigit) {
                System.out.println("The password is valid.");
                break; // exit loop if password is valid
            } else {
                System.out.println("The password is invalid. It must contain at least one uppercase letter and one digit.");
            }
        }
    }
}
