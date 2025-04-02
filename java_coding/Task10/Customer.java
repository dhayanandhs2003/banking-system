package Task10;

import java.util.regex.Pattern;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public Customer(String customerID, String firstName, String lastName, String email, String phone, String address) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email);
        setPhone(phone);
        this.address = address;
    }

    // Email validation
    public void setEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (Pattern.matches(emailRegex, email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    // Phone number validation (10-digit)
    public void setPhone(String phone) {
        if (phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");
        }
    }

    public String getCustomerID() { return customerID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void printCustomerDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
}
