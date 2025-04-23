package refactoring;


import java.util.List;

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

