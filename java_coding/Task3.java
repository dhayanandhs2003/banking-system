import java.util.Scanner;

public class Task3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of customers: ");
        int cus_nos = sc.nextInt();

        for(int i = 1; i <= cus_nos; i++){
            System.out.println("customer: "+i);

            System.out.print("Enter crrent balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter annual interest rate %: ");
            double interest_rate = sc.nextDouble();

            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            double future_balance = balance * Math.pow((1 + interest_rate / 100), years);
            System.out.printf("Future balance after %d years: %.2f\n", years, future_balance);
        }
    }
}