import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

interface Product {
    int getProductId();
    String getName();
    double getPrice();
}

class ConcreteProduct implements Product {
    private int productId;
    private String name;
    private double price;

    public ConcreteProduct(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

interface Cart {
    void addItem(Product product);
    void removeItem(Product product);
    double calculateTotal();
}

class ConcreteCart implements Cart {
    private List<Product> items;

    public ConcreteCart() {
        this.items = new ArrayList<>();
    }

    @Override
    public synchronized void addItem(Product product) {
        items.add(product);
    }

    @Override
    public synchronized void removeItem(Product product) {
        items.remove(product);
    }

    @Override
    public synchronized double calculateTotal() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
}

class User {
    private int userId;
    private String name;
    private Cart cart;

    public User(int userId, String name, Cart cart) {
        this.userId = userId;
        this.name = name;
        this.cart = cart;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void removeFromCart(Product product) {
        cart.removeItem(product);
    }

    public double checkout() {
        double total;
        synchronized (cart) {
            total = cart.calculateTotal();
            // Implement payment processing and order placement logic here
            cart = new ConcreteCart(); // Reset cart
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create some sample products
        Product product1 = new ConcreteProduct(1, "Product 1", 10.99);
        Product product2 = new ConcreteProduct(2, "Product 2", 19.99);
        Product product3 = new ConcreteProduct(3, "Product 3", 14.99);
        Product product4 = new ConcreteProduct(4, "Product 4", 7.99);

        // Create a cart
        Cart cart = new ConcreteCart();

        // Create a user with the cart
        User user = new User(1, "John Doe", cart);

        // Create a list of products to add to the cart
        List<Product> productsToAdd = List.of(product1, product2, product3, product4);

        // Create a thread pool with the desired number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(productsToAdd.size());

        // Create a list to hold the Future objects
        List<Future<?>> futures = new ArrayList<>();

        // Submit tasks to the executor service and store the Future objects
        for (Product product : productsToAdd) {
            Callable<Void> task = () -> {
                user.addToCart(product);
                return null;
            };
            futures.add(executorService.submit(task));
        }

        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            future.get(); // Blocking call until the task is complete
        }

        // Shutdown the executor service
        executorService.shutdown();

        // Calculate the total and checkout
        double total = user.checkout();
        System.out.println("Total: $" + total);
    }
}
