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

### Eliminating Duplicate Code 

#### 1. Extract Method

One of the most common ways to eliminate duplicate code is to extract the repeated logic into a separate method.

**Before Refactoring**

```java
public class OrderProcessor {
    public void processOrder(Order order) {
        // Validate order
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        // Process order
        System.out.println("Processing order for customer: " + order.getCustomer().getName());

        // Validate payment
        if (order.getPayment() == null) {
            throw new IllegalArgumentException("Order must have a payment method");
        }
        if (order.getPayment().getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }

        // Process payment
        System.out.println("Processing payment of $" + order.getPayment().getAmount());
    }

    public void processRefund(Order order) {
        // Validate order
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        // Process refund
        System.out.println("Processing refund for customer: " + order.getCustomer().getName());

        // Validate payment
        if (order.getPayment() == null) {
            throw new IllegalArgumentException("Order must have a payment method");
        }
        if (order.getPayment().getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }

        // Process refund payment
        System.out.println("Refunding payment of $" + order.getPayment().getAmount());
    }
}
```

**Problem**
The validation logic for order and payment is duplicated in both processOrder and processRefund.

**After Refactoring (Extract Method)**

```java
public class OrderProcessor {
    public void processOrder(Order order) {
        validateOrder(order);
        System.out.println("Processing order for customer: " + order.getCustomer().getName());

        validatePayment(order.getPayment());
        System.out.println("Processing payment of $" + order.getPayment().getAmount());
    }

    public void processRefund(Order order) {
        validateOrder(order);
        System.out.println("Processing refund for customer: " + order.getCustomer().getName());

        validatePayment(order.getPayment());
        System.out.println("Refunding payment of $" + order.getPayment().getAmount());
    }

    private void validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }
    }

    private void validatePayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Order must have a payment method");
        }
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
    }
}
```

**Benefits**
- Eliminates duplicate validation logic.
- Improves readability and maintainability.
- Makes it easier to update validation rules in one place.

#### 2. Use Inheritance

If duplicate code exists across multiple classes, you can use inheritance to share common behavior.

**Before Refactoring**

```java
class Dog {
    public void eat() {
        System.out.println("Dog is eating");
    }

    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

class Cat {
    public void eat() {
        System.out.println("Cat is eating");
    }

    public void sleep() {
        System.out.println("Cat is sleeping");
    }
}
```

**Problem**

The eat and sleep methods are duplicated in both Dog and Cat classes.

**After Refactoring (Using Inheritance)**

```java
abstract class Animal {
    public void eat() {
        System.out.println(getClass().getSimpleName() + " is eating");
    }

    public void sleep() {
        System.out.println(getClass().getSimpleName() + " is sleeping");
    }
}

class Dog extends Animal {}

class Cat extends Animal {}
```

**Benefits**

- Eliminates duplicate code by moving common behavior to a base class.
- Makes it easier to add new animal types in the future.

#### 3. Using Utility Classes

For reusable logic that doesn’t belong to a specific class, you can create a utility class.

**Before Refactoring**

```java
class OrderProcessor {
    public double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

class InvoiceGenerator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
```

**Problem**

The calculateTotal method is duplicated in both OrderProcessor and InvoiceGenerator.

**After Refactoring (Using Utility Class)**

```java
class OrderUtils {
    public static double calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

class OrderProcessor {
    public double calculateTotal(Order order) {
        return OrderUtils.calculateTotal(order);
    }
}

class InvoiceGenerator {
    public double calculateTotal(Order order) {
        return OrderUtils.calculateTotal(order);
    }
}
```

**Benefits**

- Eliminates duplicate logic by centralizing it in a utility class.
- Improves reusability and maintainability.

#### 4. Using Composition

Imagine you have a system with two classes: OrderCalculator and DiscountCalculator. Both classes perform similar calculations, such as calculating totals and applying taxes. The calculation logic is duplicated across both classes.

**Before Refactoring**

```java
class OrderCalculator {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

class DiscountCalculator {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}
```

**Problem**

- The calculateTotal and applyDiscount methods are duplicated in both OrderCalculator and DiscountCalculator.
- If the calculation logic changes, you’ll need to update it in multiple places.

**After Refactoring (Using Composition)**

**Step 1:** Create a Shared Calculation Component. Create a new class, CalculationService, to encapsulate the shared calculation logic.

```java
class CalculationService {
    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}
```

**Step 2:** Compose Classes with the Shared Component. Include an instance of CalculationService in the classes that need it.

```java
class OrderCalculator {
    private final CalculationService calculationService;

    public OrderCalculator(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateOrderTotal(double subtotal, double taxRate) {
        return calculationService.calculateTotal(subtotal, taxRate);
    }

    public double applyOrderDiscount(double total, double discountRate) {
        return calculationService.applyDiscount(total, discountRate);
    }
}

class DiscountCalculator {
    private final CalculationService calculationService;

    public DiscountCalculator(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateDiscountedTotal(double subtotal, double taxRate, double discountRate) {
        double total = calculationService.calculateTotal(subtotal, taxRate);
        return calculationService.applyDiscount(total, discountRate);
    }
}
```

Example usage

```java
public class Main {
    public static void main(String[] args) {
        // Create the shared calculation service
        CalculationService calculationService = new CalculationService();

        // Create calculators with the shared service
        OrderCalculator orderCalculator = new OrderCalculator(calculationService);
        DiscountCalculator discountCalculator = new DiscountCalculator(calculationService);

        // Use the calculators
        double orderTotal = orderCalculator.calculateOrderTotal(100.0, 0.1); // 10% tax
        System.out.println("Order Total: " + orderTotal);

        double discountedTotal = discountCalculator.calculateDiscountedTotal(100.0, 0.1, 0.2); // 10% tax, 20% discount
        System.out.println("Discounted Total: " + discountedTotal);
    }
}
```

Output

```sh
Order Total: 110.0
Discounted Total: 88.0
```

**Benefits of Using Composition**

- Eliminates Duplicate Code: The calculation logic is centralized in the CalculationService class.
- Flexibility: You can easily change the calculation logic by modifying the CalculationService class.
- Reusability: The CalculationService class can be reused across multiple classes.
- Testability: You can mock the CalculationService class for unit testing.

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
