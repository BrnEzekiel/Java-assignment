public class PayableTest {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 5000);
        Contractor contractor = new Contractor("Jane Smith", 50, 160);

        System.out.println("Employee: " + employee.getName());
        System.out.println("Pay: $" + employee.calculatePay());

        System.out.println("\nContractor: " + contractor.getName());
        System.out.println("Pay: $" + contractor.calculatePay());
    }
}
