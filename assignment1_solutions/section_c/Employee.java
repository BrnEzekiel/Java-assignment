
public class Employee implements Payable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
