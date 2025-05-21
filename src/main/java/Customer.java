public class Customer {
    private String name;
    private boolean isMember;

    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return isMember;
    }
}
