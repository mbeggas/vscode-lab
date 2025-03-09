# Refactoring lab

* Create a Java project using Gradle
* Add the code example to the code
* Write and run the necessary tests, ensuring that all tests pass.
* Refactor the code using VS Code’s refactoring features.
* Rerun the tests after refactoring to validate that the refactoring did not change the code’s behavior.
* For more details, see the lecture notes on the refactoring course [refactoring course lecture notes](../refactoring.md).
### 1. Rename Variables/Methods Refactoring Example in Java

**Before refactoring**

```java
public class Calculator {
    public double calc(double a, double b) {
        double x = a + b;
        double y = a * b;
        return x / y;
    }

    public void prtRes(double res) {
        System.out.println("Result: " + res);
    }
}
```

### 2. Extract Method Refactoring Example in Java

**Supporting classes (to be used in the example below)**
```java
class Order {
    private Customer customer;
    private List<Item> items;

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}

class Customer {
    private String name;
    private boolean isMember;

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return isMember;
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
```

**Code before Refactoring**
```java
public class OrderProcessor {
    public void printOrderSummary(Order order) {
        // Calculate total price
        double totalPrice = 0;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }

        // Apply discount
        if (order.getCustomer().isMember()) {
            totalPrice *= 0.9; // 10% discount for members
        }

        // Print summary
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Items:");
        for (Item item : order.getItems()) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
        }
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
```
