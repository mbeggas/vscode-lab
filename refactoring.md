# Lecture Notes: Refactoring in Software Development

## 1. Introduction to Refactoring
- **Definition**: Refactoring is the process of improving the internal structure of existing code without changing its external behavior.
- **Goal**: Enhance code readability, maintainability, and extensibility while reducing technical debt.
- **Importance**:
  - Makes code easier to understand and modify.
  - Reduces the risk of introducing bugs.
  - Prepares code for future features or changes.

---

## 2. Principles of Refactoring
- **Rule of Three**:
  - Refactor when you see the same pattern repeated three times.
- **Boy Scout Rule**:
  - Leave the code cleaner than you found it.
- **Small Steps**:
  - Refactor in small, incremental changes to avoid breaking the code.
- **Tests First**:
  - Ensure you have a solid suite of tests before refactoring to catch regressions.

---

## 3. When to Refactor
- **Code Smells**:
  - Indicators of potential issues in the codebase.
  - Examples:
    - Long methods or classes.
    - Duplicated code.
    - Complex conditional logic.
    - Poor naming conventions.
- **Before Adding Features**:
  - Clean up the code to make it easier to implement new functionality.
- **During Code Reviews**:
  - Identify and address refactoring opportunities.
- **When Fixing Bugs**:
  - Improve the code to prevent similar issues in the future.

## 4. Common Refactoring Techniques (with examples)

### Rename Variables/Methods Refactoring Example in Java

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

**Problems with the Original Code**
1. Unclear Variable Names: a, b, x, and y do not convey their purpose.
2. Unclear Method Names: calc and prtRes are cryptic and do not describe what the methods do.
3. Poor Readability: The code is hard to understand at a glance.

**After Refactoring (Using Rename Variables/Methods)**

```java
public class Calculator {
    public double calculateSumProductRatio(double num1, double num2) {
        double sum = num1 + num2;
        double product = num1 * num2;
        return sum / product;
    }

    public void printResult(double result) {
        System.out.println("Result: " + result);
    }
}
```

**Benefits of Refactoring**

1. Improved Readability: The purpose of variables (sum, product) and methods (calculateSumProductRatio, printResult) is now clear.
2. Better Maintainability: Future developers (or even yourself) will find it easier to understand and modify the code.
3. Consistency: Meaningful names make the codebase more consistent and professional.

   
### Extract Method Refactoring Example in Java

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
**Problems with the Original Code**

- The method is doing too much (calculating total price, applying discounts, and printing the summary).
- It’s hard to reuse parts of the logic (e.g., calculating the total price).
- The code is harder to read and maintain.

**After Refactoring (Using Extract Method)**
```java
public class OrderProcessor {

    public void printOrderSummary(Order order) {
        // Calculate total price
        double totalPrice = calculateTotalPrice(order.getItems());

        // Apply discount
        totalPrice = applyDiscount(totalPrice, order.getCustomer().isMember());

        // Print summary
        printSummary(order, totalPrice);
    }

    private double calculateTotalPrice(List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    private double applyDiscount(double totalPrice, boolean isMember) {
        if (isMember) {
            return totalPrice * 0.9; // 10% discount for members
        }
        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    private void printItems(List<Item> items) {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
        }
    }
}
```

**Benefits of Refactoring**

- Readability: The printOrderSummary method is now shorter and easier to understand.
- Reusability: The calculateTotalPrice and applyDiscount methods can be reused in other parts of the code.
- Maintainability: If the logic for calculating the total price or applying discounts changes, you only need to update one place.
- Testability: Smaller methods are easier to test in isolation.

**Steps to Perform Extract Method**

1. Identify the Code to Extract: Look for a block of code that performs a single, well-defined task (e.g., calculating the total price).
2. Create a New Method: Move the identified code into a new method with a descriptive name.
3. Replace the Original Code: Replace the extracted code with a call to the new method.
4. Test: Ensure the behavior of the code remains unchanged.

**When to Use Extract Method**
- When a method is too long or doing too much.
- When you notice duplicated code that can be reused.
- When you want to improve readability and maintainability.

### Replace Nested Conditional with Polymorphism

Refactoring by grouping related parameters into an object.

**Before refactoring**

```java
public class Employee {
    public double calculateBonus(String type) {
        if (type.equals("Manager")) {
            return 5000;
        } else if (type.equals("Developer")) {
            return 3000;
        } else {
            return 1000;
        }
    }
}
}

```

**Problems with the Original Code**
- Complex Conditional Logic: The getSound method uses nested conditionals to determine the sound based on the bird type.
- Low Extensibility: Adding a new bird type requires modifying the getSound method, violating the Open/Closed Principle.
- Poor Readability: The code is harder to read and maintain as the number of bird types grows.

**After Refactoring (Using Polymorphism)**

```java
abstract class Employee {
    abstract double calculateBonus();
}

class Manager extends Employee {
    double calculateBonus() { return 5000; }
}

class Developer extends Employee {
    double calculateBonus() { return 3000; }
}

class Intern extends Employee {
    double calculateBonus() { return 1000; }
}

```

### Simplify Conditionals using Guard Clauses

Guard clauses are used to handle exceptional cases early in a method, reducing the need for nested conditionals.

**Before Refactoring**
```java
public double calculateDiscount(Order order) {
    double discount = 0.0;
    if (order.getTotalAmount() > 100) {
        if (order.getCustomer().isPremium()) {
            discount = 0.2; // 20% discount for premium customers
        } else {
            discount = 0.1; // 10% discount for regular customers
        }
    }
    return discount;
}
```

**After Refactoring (Using Guard Clauses)**

```java
public double calculateDiscount(Order order) {
    if (order.getTotalAmount() <= 100) {
        return 0.0; // Early return for orders below $100
    }

    if (order.getCustomer().isPremium()) {
        return 0.2; // 20% discount for premium customers
    }

    return 0.1; // 10% discount for regular customers
}
```

**Benefits**
- Reduces nesting and improves readability.
- Makes the code flow more linear and easier to follow.

###  Simplify Conditionals using Strategy Pattern

The strategy pattern encapsulates algorithms or behaviors into separate classes, allowing them to be interchangeable.

**Before Refactoring**

```java
public class PaymentProcessor {
    public void processPayment(String paymentMethod, double amount) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment of $" + amount);
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else if (paymentMethod.equals("Bitcoin")) {
            System.out.println("Processing Bitcoin payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Unknown payment method");
        }
    }
}
```

**After Refactoring (Using Strategy Pattern)**
```java
// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }
}

// Context class
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
```

Example usage

```java
// Strategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete strategies
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
    }
}

// Context class
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
```
Output
```sh
Processing credit card payment of $100.0
Processing PayPal payment of $50.0
Processing Bitcoin payment of $200.0
```
---

## 4. Common Refactoring Techniques
- **Extract Method**:
  - Break down long methods into smaller, reusable ones.
- **Rename Variables/Methods**:
  - Use meaningful and consistent names.
- **Replace Magic Numbers with Constants**:
  - Improve readability and maintainability.
- **Remove Dead Code**:
  - Delete unused code to reduce clutter.
- **Simplify Conditionals**:
  - Use guard clauses, polymorphism, or strategy patterns.
- **Move Method/Field**:
  - Relocate methods or fields to more appropriate classes.
- **Introduce Design Patterns**:
  - Apply patterns like Factory, Singleton, or Observer where applicable.

### Eliminating Duplicate Code

#### 1. Extract Method
One of the most common ways to eliminate duplicate code is to extract the repeated logic into a separate method.




---

## 5. Tools for Refactoring
- **Integrated Development Environments (IDEs)**:
  - Most modern IDEs (e.g., IntelliJ, Visual Studio, Eclipse) have built-in refactoring tools.
- **Static Analysis Tools**:
  - Tools like SonarQube, ESLint, or Pylint can identify refactoring opportunities.
- **Version Control Systems**:
  - Use Git to track changes and revert if necessary.

---

## 6. Best Practices
- **Write Tests First**:
  - Ensure you have a safety net before refactoring.
- **Refactor Regularly**:
  - Make refactoring a part of your development workflow.
- **Communicate with the Team**:
  - Ensure everyone understands the changes being made.
- **Document Changes**:
  - Use comments or commit messages to explain the purpose of refactoring.

---

## 7. Challenges and Pitfalls
- **Over-Refactoring**:
  - Avoid refactoring for the sake of refactoring; focus on tangible improvements.
- **Lack of Tests**:
  - Refactoring without tests increases the risk of introducing bugs.
- **Time Constraints**:
  - Balance refactoring with delivering features on time.
- **Resistance to Change**:
  - Some team members may resist refactoring due to fear of breaking the code.

---

## 8. Real-World Examples
- **Case Study 1**:
  - Refactoring a monolithic application into microservices.
- **Case Study 2**:
  - Simplifying a legacy codebase with complex conditional logic.
- **Case Study 3**:
  - Improving performance by refactoring inefficient algorithms.

---

## 9. Key Takeaways
- Refactoring is a continuous process, not a one-time task.
- Focus on improving code quality while preserving functionality.
- Use tools and best practices to make refactoring efficient and safe.

---

## 10. Further Reading
- **Books**:
  - *Refactoring: Improving the Design of Existing Code* by Martin Fowler.
  - *Clean Code: A Handbook of Agile Software Craftsmanship* by Robert C. Martin.
- **Online Resources**:
  - [Refactoring.com](https://refactoring.com) (Martin Fowler’s website).
  - Articles and tutorials on refactoring patterns.
