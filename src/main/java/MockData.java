import java.util.Arrays;

public class MockData {
    public static Order getSampleOrder() {
        Customer customer = new Customer("Ahmed", true);
        Item item1 = new Item("Book", 50, 2);
        Item item2 = new Item("Pen", 5, 5);
        return new Order(customer, Arrays.asList(item1, item2));
    }
}
