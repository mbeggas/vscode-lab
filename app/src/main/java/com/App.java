public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        int sum = calculator.add(10, 5);
        int product = calculator.multiply(10, 5);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
