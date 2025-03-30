# Bank class to manage customer accounts
class Bank:
    def __init__(self):
        # Dictionary to store account numbers and balances
        self.accounts = {
            "1001": 5000.0,
            "1002": 10000.5,
            "1003": 7500.75,
            "1004": 3200.0,
            "1005": 8900.25
        }
    
    # Method to check the balance of a given account number
    def check_balance(self, account_number):
        return self.accounts.get(account_number, None)  # Return balance if account exists, otherwise None

# Main function to execute the program
def main():
    bank = Bank()  # Create an instance of the Bank class
    
    while True:  # Infinite loop to keep asking for account number until valid input is given
        account_number = input("Enter your account number: ")  # Prompt user to enter account number
        
        if account_number in bank.accounts:  # Check if account number exists
            balance = bank.check_balance(account_number)  # Retrieve balance
            print(f"Your account balance is: ${balance:.2f}")  # Display account balance
            break  # Exit loop after showing balance
        else:  # If account number is invalid, prompt user again
            print("Invalid account number. Please try again.")

# Ensure the script runs only when executed directly
if __name__ == "__main__":
    main()
