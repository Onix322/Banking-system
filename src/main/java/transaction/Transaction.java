package transaction;

import bankAccount.BankAccount;

import java.time.LocalDateTime;

public class Transaction {

    private BankAccount account;
    private double amount;
    private String type;
    private LocalDateTime createOn;

    public Transaction(BankAccount account, double amount, String type) {
        this.account = account;
        this.createOn = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    public BankAccount getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", createOn=" + createOn +
                ", account=" + account +
                '}';
    }
}
