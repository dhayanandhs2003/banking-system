package main;

import entity.*;
import repository.OrderProcessor;
import repository.IOrderManagementRepository;

import java.util.ArrayList;
import java.util.List;

public class MainModule {

    public static void main(String[] args) throws Exception {

        IOrderManagementRepository repo = new OrderProcessor();

        // 1. Create users
        User admin = new User(1, "adminUser", "adminPass", "Admin");
        User user1 = new User(2, "regularUser", "userPass", "User");

        repo.createUser(admin);
        repo.createUser(user1);

        // 2. Create products
        Product p1 = new entity.Electronics(101, "Smartphone", "Latest 5G phone", 50000, 10, "Electronics", "Samsung", 24);
        Product p2 = new entity.Clothing(102, "T-Shirt", "Cotton T-shirt", 999, 50, "Clothing", "L", "Red");

        repo.createProduct(admin, p1); // should succeed
        repo.createProduct(user1, p2); // should fail (user is not admin)

        // 3. Create order for user1
        List<Product> orderProducts = new ArrayList<>();
        orderProducts.add(p1);

        repo.createOrder(user1, orderProducts);

        // 4. View all products
        System.out.println("All Products:");
        for (Product p : repo.getAllProducts()) {
            System.out.println(p.getProductName());
        }

        // 5. View user1's orders
        System.out.println("User1's Orders:");
        for (Product p : repo.getOrderByUser(user1)) {
            System.out.println(p.getProductName());
        }

        // 6. Cancel order
        repo.cancelOrder(user1.getUserId(), 1); // assuming order ID was 1
    }
}
