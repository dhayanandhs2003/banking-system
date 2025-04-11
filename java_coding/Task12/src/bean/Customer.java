package Task12.src.bean;


public class Customer {
    private String name;
    private String address;
    private String phone;

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }

    public String toString() {
        return "Customer: " + name + ", Address: " + address + ", Phone: " + phone;
    }
}