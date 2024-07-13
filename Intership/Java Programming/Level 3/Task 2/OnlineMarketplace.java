import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public boolean purchase(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + ", Quantity=" + quantity + "]";
    }
}

public class OnlineMarketplace {
    private static List<User> users = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static User loggedInUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeProducts();
        
        while (true) {
            if (loggedInUser == null) {
                System.out.println("\n1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        register(scanner);
                        break;
                    case 2:
                        login(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("\nWelcome, " + loggedInUser.getUsername());
                System.out.println("1. View Products");
                System.out.println("2. Add Balance");
                System.out.println("3. Purchase Product");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewProducts();
                        break;
                    case 2:
                        addBalance(scanner);
                        break;
                    case 3:
                        purchaseProduct(scanner);
                        break;
                    case 4:
                        loggedInUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.add(new User(username, password, 0));
        System.out.println("User registered successfully.");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful.");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private static void viewProducts() {
        System.out.println("\nProduct List:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addBalance(Scanner scanner) {
        System.out.print("Enter amount to add: ");
        double amount = scanner.nextDouble();
        loggedInUser.addBalance(amount);
        System.out.println("Balance added successfully. Current balance: " + loggedInUser.getBalance());
    }

    private static void purchaseProduct(Scanner scanner) {
        System.out.print("Enter product ID to purchase: ");
        String productId = scanner.nextLine();

        for (Product product : products) {
            if (product.getId().equals(productId)) {
                if (product.getQuantity() > 0) {
                    if (loggedInUser.purchase(product.getPrice())) {
                        product.setQuantity(product.getQuantity() - 1);
                        System.out.println("Purchase successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } else {
                    System.out.println("Product out of stock.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void initializeProducts() {
        products.add(new Product("1", "Laptop", 1000.00, 10));
        products.add(new Product("2", "Smartphone", 500.00, 20));
        products.add(new Product("3", "Tablet", 300.00, 15));
        products.add(new Product("4", "Headphones", 50.00, 50));
    }
}

