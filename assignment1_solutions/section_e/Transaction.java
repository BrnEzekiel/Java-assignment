
public class Transaction implements Auditable {
    private String transactionId;
    private double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void process() {
        System.out.println("Processing transaction " + transactionId + " with amount " + amount);
    }
}
