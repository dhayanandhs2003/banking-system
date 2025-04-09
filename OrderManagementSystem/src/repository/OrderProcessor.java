package repository;

import entity.User;
import entity.Product;
import entity.Order;
import exception.UserNotFoundException;
import util.DBUtil;
import exception.OrderNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessor implements IOrderManagementRepository {

    private List<User> userList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private int orderCounter = 1;

    @Override
    public void createUser(User user) {
        try (Connection conn = DBUtil.getDBConn()) {
            String sql = "INSERT INTO user (userId, username, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.executeUpdate();
            conn.commit();

            System.out.println("User created: " + user.getUsername());
        } catch (SQLException e) {
            System.out.println("❌ Error inserting user into DB.");
            e.printStackTrace();
        }
    }
    
    public User getUserById(int userId) {
        try (Connection conn = DBUtil.getDBConn()) {
            String sql = "SELECT * FROM user WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                return new User(userId, username, password, role);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user from DB.");
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void createProduct(User user, Product product) {
        User existingUser = getUserById(user.getUserId());
        if (existingUser != null) {
            if ("Admin".equalsIgnoreCase(existingUser.getRole())) {
                try (Connection conn = DBUtil.getDBConn()) {
                    String sql = "INSERT INTO product (productId, productName, description, price, quantityInStock, type, brand, warrantyPeriod) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, product.getProductId());
                    stmt.setString(2, product.getProductName());
                    stmt.setString(3, product.getDescription());
                    stmt.setDouble(4, product.getPrice());
                    stmt.setInt(5, product.getQuantityInStock());
                    stmt.setString(6, product.getType());
                    stmt.setString(7, product.getBrand());
                    stmt.setInt(8, product.getWarrantyPeriod());

                    stmt.executeUpdate();
                    System.out.println("✅ DB Connected!");
                    System.out.println("Product created: " + product.getProductName());
                } catch (SQLException e) {
                    System.out.println("❌ Error inserting product into DB.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("❌ Only Admins can create products.");
            }
        } else {
            System.out.println("❌ User not found.");
        }
    }



    @Override
    public void createOrder(User user, List<Product> products) {
        boolean userExists = false;

        for (User u : userList) {
            if (u.getUserId() == user.getUserId()) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            createUser(user);
        }

        Order order = new Order(orderCounter++, user, products);
        orderList.add(order);
        System.out.println("Order created for user: " + user.getUsername());
    }

    @Override
    public void cancelOrder(int userId, int orderId) {
        boolean userExists = false;

        for (User user : userList) {
            if (user.getUserId() == userId) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }

        Order toRemove = null;

        for (Order order : orderList) {
            if (order.getOrderId() == orderId && order.getUser().getUserId() == userId) {
                toRemove = order;
                break;
            }
        }

        if (toRemove == null) {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found for user ID " + userId);
        }

        orderList.remove(toRemove);
        System.out.println("Order canceled with ID: " + orderId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public List<Product> getOrderByUser(User user) {
        List<Product> userOrders = new ArrayList<>();

        for (Order order : orderList) {
            if (order.getUser().getUserId() == user.getUserId()) {
                userOrders.addAll(order.getProducts());
            }
        }

        return userOrders;
    }
}
