import java.util.Scanner;
class Task1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Credit Score: ");
        int credit_score = sc.nextInt();
        System.out.println("Enter Annual Income: ");
        int annual_income = sc.nextInt();
        if(credit_score > 700 && annual_income >= 50000){
            System.out.println("Congratulations! You are eligible for applying loan.");
        }
        else{
            System.out.println("Sorry! You are not eligible for applying loan.");
        }
    }
}
