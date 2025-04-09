package main;

import entity.*;
import repository.*;
import java.util.*;





public class OrderManagement {

    public static void main(String[] args) {
    	
    	

        Scanner scanner = new Scanner(System.in);
        OrderProcessor repository = new OrderProcessor();
        while (true) {
            System.out.println("\n===== Order Management System =====");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Cancel Order");
            System.out.println("4. Get All Products");
            System.out.println("5. Get Order by User");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create User
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Role (Admin/User): ");
                    String role = scanner.nextLine();

                    User user = new User(userId, username, password, role);
                    repository.createUser(user);
                    break;

                case 2: // Create Product
                    System.out.print("Enter User ID (Admin only): ");
                    int adminId = scanner.nextInt();
                    scanner.nextLine();
                    User admin = new User(adminId, "", "", "Admin"); // Simulated admin

                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity In Stock: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Type (Electronics/Clothing): ");
                    String type = scanner.nextLine();

                    Product product;
                    if (type.equalsIgnoreCase("Electronics")) {
                        System.out.print("Enter Brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter Warranty Period: ");
                        int warranty = scanner.nextInt();
                        scanner.nextLine();
                        product = new Electronics(productId, productName, description, price, qty, type, brand, warranty);
                    } else {
                        System.out.print("Enter Size: ");
                        String size = scanner.nextLine();
                        System.out.print("Enter Color: ");
                        String color = scanner.nextLine();
                        product = new Clothing(productId, productName, description, price, qty, type, size, color);
                    }

                    repository.createProduct(admin, product);
                    break;

                case 3: // Cancel Order
                    System.out.print("Enter User ID: ");
                    int uId = scanner.nextInt();
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    repository.cancelOrder(uId, orderId);
                    break;

                case 4: // Get All Products
                    List<Product> products = repository.getAllProducts();
                    System.out.println("All Products:");
                    for (Product p : products) {
                        System.out.println(p.getProductName());
                    }
                    break;

                case 5: // Get Order by User
                    System.out.print("Enter User ID: ");
                    int orderUserId = scanner.nextInt();
                    scanner.nextLine();
                    User orderUser = new User(orderUserId, "", "", "User");
                    List<Product> userOrders = repository.getOrderByUser(orderUser);
                    System.out.println("User's Orders:");
                    for (Product p : userOrders) {
                        System.out.println(p.getProductName());
                    }
                    break;

                case 6:
                    System.out.println("✅ Exiting Order Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
