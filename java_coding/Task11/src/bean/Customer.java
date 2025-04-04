package Task11.src.bean;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber;
    }
}
