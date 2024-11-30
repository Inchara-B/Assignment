import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Customer {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + id +
                ", Balance=" + balance +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                '}';
    }
}

public class CustomerManager {
    public static void main(String[] args) {
        // List of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, 1000.50, "Ram", "Sam"));
        customers.add(new Customer(2, 1500.75, "Ram", "kiran"));
        customers.add(new Customer(3, 900.00, "San", " lily"));
        customers.add(new Customer(4, 1200.25, "Boby", "Gagana"));
        customers.add(new Customer(5, 800.00, "Charlie", "Davis"));

        System.out.println("Before Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sorting the customers based on criteria
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
                if (firstNameComparison != 0) {
                    return firstNameComparison;
                }
                int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
                if (lastNameComparison != 0) {
                    return lastNameComparison;
                }
                int idComparison = Integer.compare(c1.getId(), c2.getId());
                if (idComparison != 0) {
                    return idComparison;
                }
                return Double.compare(c1.getBalance(), c2.getBalance());
            }
        });

        System.out.println("\nAfter Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}